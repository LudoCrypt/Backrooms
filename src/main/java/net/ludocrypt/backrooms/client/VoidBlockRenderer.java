package net.ludocrypt.backrooms.client;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import com.google.common.collect.ImmutableList;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.ludocrypt.backrooms.blocks.entity.VoidBlockEntity;
import net.ludocrypt.backrooms.init.BackroomsBlocks;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderLayer.MultiPhase;
import net.minecraft.client.render.RenderPhase;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.EndPortalBlockEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Matrix4f;

@Environment(EnvType.CLIENT)
public class VoidBlockRenderer<T extends VoidBlockEntity> extends BlockEntityRenderer<T> {
	private static final Random RANDOM = new Random(9500L);
	public static final Identifier TEXTURE = new Identifier("backrooms", "textures/block/void_block.png");

	private static final List<RenderLayer> renderLayers = IntStream.range(0, 16).mapToObj(i -> getVoidBlock(i + 1)).collect(ImmutableList.toImmutableList());

	public VoidBlockRenderer(BlockEntityRenderDispatcher dispatcher) {
		super(dispatcher);
	}

	@Override
	public void render(T blockEntity, float tickDelta, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int light, int overlay) {
		double d = blockEntity.getPos().getSquaredDistance(this.dispatcher.camera.getPos(), true);
		RANDOM.setSeed(9500L);
		int iterations = renderIterations(d);
		Matrix4f matrix = matrixStack.peek().getModel();
		renderLayer(blockEntity, matrix, vertexConsumerProvider.getBuffer(renderLayers.get(0)), 1.0F);
		for (int i = 1; i < iterations; ++i) {
			renderLayer(blockEntity, matrix, vertexConsumerProvider.getBuffer(renderLayers.get(i)), 1.0F);
		}

	}

	private static void renderLayer(VoidBlockEntity blockEntity, Matrix4f matrix, VertexConsumer vertexConsumer, float colourScalar) {
		float red = (1.0F) * colourScalar;
		float green = (1.0F) * colourScalar;
		float blue = (1.0F) * colourScalar;

		for (Direction direction : Direction.values()) {
			if (!blockEntity.getWorld().getBlockState(blockEntity.getPos().mutableCopy().move(direction)).isOf(BackroomsBlocks.VOID_BLOCK) && !blockEntity.getWorld().getBlockState(blockEntity.getPos().mutableCopy().move(direction)).isOpaqueFullCube(blockEntity.getWorld(), blockEntity.getPos().mutableCopy().move(direction))) {
				switch (direction) {
				case DOWN:
					renderFace(matrix, vertexConsumer, 0, 1, 0, 0, 0, 0, 1, 1, red, green, blue); // Direction.DOWN
					break;
				case EAST:
					renderFace(matrix, vertexConsumer, 1, 1, 1, 0, 0, 1, 1, 0, red, green, blue); // Direction.EAST
					break;
				case NORTH:
					renderFace(matrix, vertexConsumer, 0, 1, 1, 0, 0, 0, 0, 0, red, green, blue); // Direction.NORTH
					break;
				case SOUTH:
					renderFace(matrix, vertexConsumer, 0, 1, 0, 1, 1, 1, 1, 1, red, green, blue); // Direction.SOUTH
					break;
				case UP:
					renderFace(matrix, vertexConsumer, 0, 1, 1, 1, 1, 1, 0, 0, red, green, blue); // Direction.UP
					break;
				case WEST:
					renderFace(matrix, vertexConsumer, 0, 0, 0, 1, 0, 1, 1, 0, red, green, blue); // Direction.WEST
					break;
				}
			}
		}

	}

	private static void renderFace(Matrix4f matrix, VertexConsumer vertexConsumer, float x1, float x2, float y1, float y2, float z1, float z2, float z3, float z4, float red, float green, float blue) {
		vertexConsumer.vertex(matrix, x1, y1, z1).color(red, green, blue, 1).next();
		vertexConsumer.vertex(matrix, x2, y1, z2).color(red, green, blue, 1).next();
		vertexConsumer.vertex(matrix, x2, y2, z3).color(red, green, blue, 1).next();
		vertexConsumer.vertex(matrix, x1, y2, z4).color(red, green, blue, 1).next();
	}

	protected static int renderIterations(double cameraDistance) {
		if (cameraDistance > 36864)
			return 1;
		if (cameraDistance > 25600)
			return 3;
		if (cameraDistance > 16384)
			return 5;
		if (cameraDistance > 9216)
			return 7;
		if (cameraDistance > 4096)
			return 9;
		if (cameraDistance > 1024)
			return 11;
		if (cameraDistance > 576)
			return 13;
		return (cameraDistance > 256) ? 14 : 15;
	}

	protected float method_3594() {
		return 0.75F;
	}

	public static RenderLayer getVoidBlock(int layer) {
		RenderPhase.Transparency transparency2;
		RenderPhase.Texture texture2;
		if (layer <= 1) {
			transparency2 = RenderLayer.NO_TRANSPARENCY;
			texture2 = new RenderPhase.Texture(TEXTURE, false, false);
		} else {
			transparency2 = RenderLayer.ADDITIVE_TRANSPARENCY;
			texture2 = new RenderPhase.Texture(EndPortalBlockEntityRenderer.PORTAL_TEXTURE, false, false);
		}
		return MultiPhase.of("void_block", VertexFormats.POSITION_COLOR, 7, 256, false, true, RenderLayer.MultiPhaseParameters.builder().transparency(transparency2).texture(texture2).texturing(new RenderPhase.PortalTexturing(layer)).fog(RenderPhase.BLACK_FOG).build(false));
	}

}
