package net.ludocrypt.backrooms.blocks;

import java.util.Random;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.entity.EntityContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class LinedPipe extends Block {

	public static final IntProperty TYPE = IntProperty.of("type", 1, 2);

	public static final VoxelShape SHAPE = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D);

	public LinedPipe() {
		super(FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.STONE)
				.hardness(6).resistance(6).lightLevel(5));
		setDefaultState(getStateManager().getDefaultState().with(TYPE, 1));
	}

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, EntityContext context) {
		return SHAPE;
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
		stateManager.add(TYPE);
	}

	@Override
	@Environment(EnvType.CLIENT)
	public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
		super.randomDisplayTick(state, world, pos, random);
		if (random.nextInt(2) == 0) {
			world.addParticle(ParticleTypes.MYCELIUM, (double) pos.getX() + (double) random.nextFloat(),
					(double) pos.getY() + (double) random.nextFloat(),
					(double) pos.getZ() + (double) random.nextFloat(), 1.0D, -1.0D, 1.0D);
		}
		if (random.nextInt(10) == 0) {
			world.addParticle(ParticleTypes.DRIPPING_WATER, (double) pos.getX() + (random.nextDouble() / 4) + 0.5,
					(double) pos.getY(), (double) pos.getZ() + (random.nextDouble() / 4) + 0.5, 0.0D, 0.0D,
					0.0D);
		}
	}
}
