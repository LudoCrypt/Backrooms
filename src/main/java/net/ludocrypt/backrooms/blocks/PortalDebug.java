package net.ludocrypt.backrooms.blocks;

import java.util.Random;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.ludocrypt.backrooms.Backrooms;
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

	public PortalDebug() {
		super(FabricBlockSettings.of(Material.AIR).hardness(1).resistance(1).dropsNothing());
	}

	public static BlockPattern northSouth() {
		if (DOOR == null) {
			DOOR = BlockPatternBuilder.start().aisle("waaw", "waaw", "waaw", "wwww")
					.where('w',
							CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(Backrooms.WALLPAPER)))
					.where('a', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(Blocks.AIR)))
					.build();
		}

		return DOOR;
	}

	@Override
	public void onBlockRemoved(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
		BlockPattern.Result pattern = PortalDebug.northSouth().searchAround(world, pos);
		BlockPattern.Result pattern2 = PortalDebug.northSouth().searchAround(world, pos.add(0, 0, -1));
		if (pattern != null && pattern2 != null) {
			OverworldPortalEntity.northSouth(((ServerWorld) world), pos, pattern);
		}

	}

	@Override
	public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
		world.getWorld().setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
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
