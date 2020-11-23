package net.ludocrypt.backrooms.init;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;

import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.ludocrypt.backrooms.access.SanityManagerAccess;
import net.ludocrypt.backrooms.util.PlayerUtil;
import net.ludocrypt.backrooms.world.Level0;
import net.ludocrypt.backrooms.world.Level1;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;

public class BackroomsCommands {

	public static void init() {
		CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
			setSanityCommand(dispatcher);
			addSanityCommand(dispatcher);
			addSanityExhaustionCommand(dispatcher);
			level0Command(dispatcher);
			level1Command(dispatcher);
		});
	}

	private static void setSanityCommand(CommandDispatcher<ServerCommandSource> dispatcher) {
		dispatcher.register(CommandManager.literal("backrooms").requires(source -> source.hasPermissionLevel(2)).then(CommandManager.literal("setsanity").then(CommandManager.argument("newsanity", IntegerArgumentType.integer()).then(CommandManager.argument("players", EntityArgumentType.players()).executes((context) -> {
			EntityArgumentType.getPlayers(context, "players").forEach((player) -> {
				((SanityManagerAccess) player).getSanityManager().setSanityLevel(IntegerArgumentType.getInteger(context, "newsanity"));
			});
			return 1;
		})))));
	}

	private static void addSanityCommand(CommandDispatcher<ServerCommandSource> dispatcher) {
		dispatcher.register(CommandManager.literal("backrooms").requires(source -> source.hasPermissionLevel(2)).then(CommandManager.literal("addsanity").then(CommandManager.argument("newsanity", IntegerArgumentType.integer()).then(CommandManager.argument("players", EntityArgumentType.players()).executes((context) -> {
			EntityArgumentType.getPlayers(context, "players").forEach((player) -> {
				((SanityManagerAccess) player).getSanityManager().add(IntegerArgumentType.getInteger(context, "newsanity"), 0.0F);
			});
			return 1;
		})))));
	}

	private static void addSanityExhaustionCommand(CommandDispatcher<ServerCommandSource> dispatcher) {
		dispatcher.register(CommandManager.literal("backrooms").requires(source -> source.hasPermissionLevel(2)).then(CommandManager.literal("addsanityexhaust").then(CommandManager.argument("addedexhaust", FloatArgumentType.floatArg()).then(CommandManager.argument("players", EntityArgumentType.players()).executes((context) -> {
			EntityArgumentType.getPlayers(context, "players").forEach((player) -> {
				((SanityManagerAccess) player).getSanityManager().addsanitySpeedExhaustion(FloatArgumentType.getFloat(context, "addedexhaust"));
			});
			return 1;
		})))));
	}

	private static void level0Command(CommandDispatcher<ServerCommandSource> dispatcher) {
		dispatcher.register(CommandManager.literal("backrooms").requires(source -> source.hasPermissionLevel(2)).then(CommandManager.literal("level").then(CommandManager.literal("0").executes((context) -> {
			PlayerUtil.teleportToLevel(Level0.LEVEL_0_WORLD, context.getSource().getPlayer(), null);
			return 1;
		}).then(CommandManager.argument("players", EntityArgumentType.players()).executes((context) -> {
			EntityArgumentType.getPlayers(context, "players").forEach((player) -> {
				PlayerUtil.teleportToLevel(Level0.LEVEL_0_WORLD, player, null);
			});
			return 1;
		})))));
	}

	private static void level1Command(CommandDispatcher<ServerCommandSource> dispatcher) {
		dispatcher.register(CommandManager.literal("backrooms").requires(source -> source.hasPermissionLevel(2)).then(CommandManager.literal("level").then(CommandManager.literal("1").executes((context) -> {
			PlayerUtil.teleportToLevel(Level1.LEVEL_1_WORLD, context.getSource().getPlayer(), null);
			return 1;
		}).then(CommandManager.argument("players", EntityArgumentType.players()).executes((context) -> {
			EntityArgumentType.getPlayers(context, "players").forEach((player) -> {
				PlayerUtil.teleportToLevel(Level1.LEVEL_1_WORLD, player, null);
			});
			return 1;
		})))));
	}

}
