package net.ludocrypt.backrooms.network;

import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.ludocrypt.backrooms.Backrooms;
import net.ludocrypt.backrooms.access.SanityManagerAccess;
import net.ludocrypt.backrooms.sanity.SanityManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;

public class SanityUpdateS2CPacket {
	public static final Identifier SANITY_LEVEL_UPDATE = Backrooms.id("sanity_level_update");
	public static final Identifier SANITY_SPEED_UPDATE = Backrooms.id("sanity_speed_update");
	public static final Identifier SANITY_EXHAUSTION_UPDATE = Backrooms.id("sanity_exhaustion_update");
	public static final Identifier SANITY_TICK_TIMER_UPDATE = Backrooms.id("sanity_tick_timer_update");

	public static void init() {
		ClientSidePacketRegistry.INSTANCE.register(SANITY_LEVEL_UPDATE, (context, buffer) -> {
			int[] bufferArray = buffer.readIntArray();
			int entityId = bufferArray[0];
			int sanityLevel = bufferArray[1];
			context.getTaskQueue().execute(() -> {
				if (context.getPlayer().world.getEntityById(entityId) != null) {
					PlayerEntity player = (PlayerEntity) context.getPlayer().world.getEntityById(entityId);
					SanityManager sanityManager = ((SanityManagerAccess) player).getSanityManager();
					sanityManager.setSanityLevel(sanityLevel);
				}
			});
		});

		ClientSidePacketRegistry.INSTANCE.register(SANITY_SPEED_UPDATE, (context, buffer) -> {
			int entityId = buffer.readInt();
			float sanitySpeed = buffer.readFloat();
			context.getTaskQueue().execute(() -> {
				if (context.getPlayer().world.getEntityById(entityId) != null) {
					PlayerEntity player = (PlayerEntity) context.getPlayer().world.getEntityById(entityId);
					SanityManager sanityManager = ((SanityManagerAccess) player).getSanityManager();
					sanityManager.setSanitySpeed(sanitySpeed);
				}
			});
		});

		ClientSidePacketRegistry.INSTANCE.register(SANITY_EXHAUSTION_UPDATE, (context, buffer) -> {
			int entityId = buffer.readInt();
			float sanitySpeedExhaustion = buffer.readFloat();
			context.getTaskQueue().execute(() -> {
				if (context.getPlayer().world.getEntityById(entityId) != null) {
					PlayerEntity player = (PlayerEntity) context.getPlayer().world.getEntityById(entityId);
					SanityManager sanityManager = ((SanityManagerAccess) player).getSanityManager();
					sanityManager.setSanitySpeedExhaustion(sanitySpeedExhaustion);
				}
			});
		});

		ClientSidePacketRegistry.INSTANCE.register(SANITY_TICK_TIMER_UPDATE, (context, buffer) -> {
			int[] bufferArray = buffer.readIntArray();
			int entityId = bufferArray[0];
			int sanityTickTimer = bufferArray[1];
			context.getTaskQueue().execute(() -> {
				if (context.getPlayer().world.getEntityById(entityId) != null) {
					PlayerEntity player = (PlayerEntity) context.getPlayer().world.getEntityById(entityId);
					SanityManager sanityManager = ((SanityManagerAccess) player).getSanityManager();
					sanityManager.setSanityTickTimer(sanityTickTimer);
				}
			});
		});
	}

}
