package net.ludocrypt.backrooms.blocks.entity;

import java.util.List;
import java.util.Random;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.ludocrypt.backrooms.access.BackroomsWorldAccess;
import net.ludocrypt.backrooms.init.BackroomsBlocks;
import net.ludocrypt.backrooms.util.PlayerUtil;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Tickable;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;

public class VoidBlockEntity extends BlockEntity implements Tickable {

	public int teleportCooldown;
	public long age;

	public VoidBlockEntity() {
		super(BackroomsBlocks.VOID_BLOCK_ENTITY);
	}

	@Environment(EnvType.CLIENT)
	public boolean shouldDrawSide(Direction direction) {
		return direction == Direction.UP;
	}

	@Override
	public CompoundTag toTag(CompoundTag tag) {
		super.toTag(tag);
		tag.putLong("Age", this.age);
		return tag;
	}

	@Override
	public void fromTag(BlockState state, CompoundTag tag) {
		super.fromTag(state, tag);
		this.age = tag.getLong("Age");
	}

	@Override
	public void tick() {
		boolean bl2 = this.needsCooldownBeforeTeleporting();
		++this.age;
		if (bl2) {
			--this.teleportCooldown;
		} else if (!this.world.isClient) {
			List<Entity> list = this.world.getEntitiesByClass(Entity.class, new Box(this.getPos()), VoidBlockEntity::spectator);
			if (!list.isEmpty()) {
				this.tryTeleportingEntity((Entity) list.get(this.world.random.nextInt(list.size())));
			}

			if (this.age % 2400L == 0L) {
				this.startTeleportCooldown();
			}
		}
	}

	public void tryTeleportingEntity(Entity entity) {
		if (this.world instanceof ServerWorld && !this.needsCooldownBeforeTeleporting()) {
			this.teleportCooldown = 100;

			if (entity instanceof ServerPlayerEntity) {
				ServerPlayerEntity player = (ServerPlayerEntity) entity;
				ServerWorld serverWorld = world.getServer().getWorld(world.getRegistryKey());
				Random rand = new Random(serverWorld.getSeed() * pos.getX() * pos.getY() * pos.getZ());

				PlayerUtil.teleportToLevel(((BackroomsWorldAccess) serverWorld).calculateNextLevel(rand), player, rand);
			}
			this.startTeleportCooldown();
		}
	}

	public boolean needsCooldownBeforeTeleporting() {
		return this.teleportCooldown > 0;
	}

	public void startTeleportCooldown() {
		if (!this.world.isClient) {
			this.teleportCooldown = 40;
			this.world.addSyncedBlockEvent(this.getPos(), this.getCachedState().getBlock(), 1, 0);
			this.markDirty();
		}

	}

	public boolean onSyncedBlockEvent(int type, int data) {
		if (type == 1) {
			this.teleportCooldown = 40;
			return true;
		} else {
			return super.onSyncedBlockEvent(type, data);
		}
	}

	public static boolean spectator(Entity entity) {
		return EntityPredicates.EXCEPT_SPECTATOR.test(entity) && !entity.getRootVehicle().hasNetherPortalCooldown();
	}
}
