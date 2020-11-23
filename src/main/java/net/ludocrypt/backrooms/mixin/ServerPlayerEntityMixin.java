package net.ludocrypt.backrooms.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.mojang.authlib.GameProfile;

import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.network.ServerSidePacketRegistry;
import net.ludocrypt.backrooms.access.SanityManagerAccess;
import net.ludocrypt.backrooms.network.SanityUpdateS2CPacket;
import net.ludocrypt.backrooms.sanity.SanityManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@Mixin(ServerPlayerEntity.class)
public abstract class ServerPlayerEntityMixin extends PlayerEntity {
	@Unique
	private SanityManager sanityManager = ((SanityManagerAccess) this).getSanityManager();;
	@Unique
	private int syncedSanityLevel = -99999999;
	@Unique
	private float syncedSanitySpeed = -99999999;
	@Unique
	private float syncedSanitySpeedExhaustion = -99999999;
	@Unique
	private int syncedSanityTickTimer = -99999999;

	public ServerPlayerEntityMixin(World world, BlockPos pos, float yaw, GameProfile profile) {
		super(world, pos, yaw, profile);
	}

	@Inject(method = "playerTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;tick()V", shift = Shift.AFTER))
	public void BACKROOMS_playerTickMixin(CallbackInfo info) {
		if (this.syncedSanityLevel != this.sanityManager.getSanityLevel()) {
			PacketByteBuf data = new PacketByteBuf(Unpooled.buffer());
			data.writeIntArray(new int[] { this.getEntityId(), sanityManager.getSanityLevel() });
			ServerSidePacketRegistry.INSTANCE.sendToPlayer(this, SanityUpdateS2CPacket.SANITY_LEVEL_UPDATE, data);
			this.syncedSanityLevel = sanityManager.getSanityLevel();
		}
		if (this.syncedSanitySpeed != this.sanityManager.getSanitySpeed()) {
			PacketByteBuf data = new PacketByteBuf(Unpooled.buffer());
			data.writeInt(this.getEntityId());
			data.writeFloat(sanityManager.getSanitySpeed());
			ServerSidePacketRegistry.INSTANCE.sendToPlayer(this, SanityUpdateS2CPacket.SANITY_SPEED_UPDATE, data);
			this.syncedSanitySpeed = sanityManager.getSanitySpeed();
		}
		if (this.syncedSanitySpeedExhaustion != this.sanityManager.getSanitySpeedExhaustion()) {
			PacketByteBuf data = new PacketByteBuf(Unpooled.buffer());
			data.writeInt(this.getEntityId());
			data.writeFloat(sanityManager.getSanitySpeedExhaustion());
			ServerSidePacketRegistry.INSTANCE.sendToPlayer(this, SanityUpdateS2CPacket.SANITY_EXHAUSTION_UPDATE, data);
			this.syncedSanitySpeedExhaustion = sanityManager.getSanitySpeedExhaustion();
		}
		if (this.syncedSanityTickTimer != this.sanityManager.getSanityTickTimer()) {
			PacketByteBuf data = new PacketByteBuf(Unpooled.buffer());
			data.writeIntArray(new int[] { this.getEntityId(), sanityManager.getSanityTickTimer() });
			ServerSidePacketRegistry.INSTANCE.sendToPlayer(this, SanityUpdateS2CPacket.SANITY_TICK_TIMER_UPDATE, data);
			this.syncedSanityTickTimer = sanityManager.getSanityTickTimer();
		}
	}

	@Inject(method = "Lnet/minecraft/server/network/ServerPlayerEntity;copyFrom(Lnet/minecraft/server/network/ServerPlayerEntity;Z)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerInventory;clone(Lnet/minecraft/entity/player/PlayerInventory;)V", shift = Shift.AFTER))
	public void BACKROOMS_copyFromMixinOne(ServerPlayerEntity oldPlayer, boolean alive, CallbackInfo info) {
		this.sanityManager = ((SanityManagerAccess) oldPlayer).getSanityManager();
	}

	@Inject(method = "Lnet/minecraft/server/network/ServerPlayerEntity;copyFrom(Lnet/minecraft/server/network/ServerPlayerEntity;Z)V", at = @At(value = "TAIL"))
	public void BACKROOMS_copyFromMixinTwo(ServerPlayerEntity oldPlayer, boolean alive, CallbackInfo info) {
		this.syncedSanityLevel = -1;
		this.syncedSanitySpeed = -1;
		this.syncedSanitySpeedExhaustion = -1;
		this.syncedSanityTickTimer = -1;
	}

}
