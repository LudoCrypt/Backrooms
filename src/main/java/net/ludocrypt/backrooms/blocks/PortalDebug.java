package net.ludocrypt.backrooms.blocks;

import java.util.Random;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.ludocrypt.backrooms.Backrooms;
import net.ludocrypt.backrooms.config.BackroomsConfig;
import net.ludocrypt.backrooms.misc.OverworldPortalEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.block.pattern.BlockPatternBuilder;
import net.minecraft.block.pattern.CachedBlockPosition;
import net.minecraft.entity.EntityContext;
import net.minecraft.predicate.block.BlockStatePredicate;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class PortalDebug extends Block {
	private static BlockPattern DOOR;
	private static BlockPattern DOOR2;

	public PortalDebug() {
		super(FabricBlockSettings.of(Material.AIR).hardness(1).resistance(1).dropsNothing());
	}

	public static BlockPattern shortDoor() {
		if (DOOR == null) {
			DOOR = BlockPatternBuilder.start().aisle("waaw", "waaw", "waaw", "wwww")
					.where('w',
							CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(Backrooms.WALLPAPER))
									.or(CachedBlockPosition
											.matchesBlockState(BlockStatePredicate.forBlock(Backrooms.CEMENT_BRICKS))))
					.where('a', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(Blocks.AIR)))
					.build();
		}

		return DOOR;
	}

	public static BlockPattern tallDoor() {
		if (DOOR2 == null) {
			DOOR2 = BlockPatternBuilder.start().aisle("waaw", "waaw", "waaw", "waaw")
					.where('w',
							CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(Backrooms.WALLPAPER))
									.or(CachedBlockPosition
											.matchesBlockState(BlockStatePredicate.forBlock(Backrooms.CEMENT_BRICKS))))
					.where('a', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(Blocks.AIR)))
					.build();
		}

		return DOOR2;
	}

//	@Override
//	public void onBlockRemoved(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
//		Backrooms.makePortalFromBlock(world.getServer().getWorld(world.dimension.getType()), pos);
//
//	}

	@Override
	public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
		Backrooms.makePortalFromBlock(world, pos);
	}

	@Override
	public BlockRenderType getRenderType(BlockState state) {
		return BlockRenderType.INVISIBLE;
	}

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, EntityContext context) {
		return VoxelShapes.empty();
	}

}
