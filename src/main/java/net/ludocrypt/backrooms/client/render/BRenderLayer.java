package net.ludocrypt.backrooms.client.render;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.google.common.collect.ImmutableList;

import it.unimi.dsi.fastutil.Hash.Strategy;
import it.unimi.dsi.fastutil.objects.ObjectOpenCustomHashSet;
import me.sargunvohra.mcmods.autoconfig1u.shadowed.blue.endless.jankson.annotation.Nullable;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderPhase;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.block.entity.EndPortalBlockEntityRenderer;

@Environment(EnvType.CLIENT)
public abstract class BRenderLayer extends RenderLayer {
	private final VertexFormat vertexFormat;
	private final int drawMode;
	private final int expectedBufferSize;
	private final boolean hasCrumbling;
	private final boolean translucent;
	private final Optional<RenderLayer> optionalThis;

	public static BRenderLayer getEndPortal(int layer) {
		RenderPhase.Transparency transparency2;
		RenderPhase.Texture texture2;
		if (layer <= 1) {
			transparency2 = NO_TRANSPARENCY;
			texture2 = new RenderPhase.Texture(EndPortalRenderer.TEXTURE, false, false);
		} else {
			transparency2 = ADDITIVE_TRANSPARENCY;
			texture2 = new RenderPhase.Texture(EndPortalBlockEntityRenderer.PORTAL_TEXTURE, false, false);
		}

		return of("end_portal", VertexFormats.POSITION_COLOR, 7, 256, false, false,
				BRenderLayer.MultiPhaseParameters.builder().transparency(transparency2).texture(texture2)
						.texturing(new RenderPhase.PortalTexturing(layer)).fog(BLACK_FOG).build(false));
	}

	public BRenderLayer(String name, VertexFormat vertexFormat, int drawMode, int expectedBufferSize,
			boolean hasCrumbling, boolean translucent, Runnable startAction, Runnable endAction) {
		super(name, vertexFormat, expectedBufferSize, expectedBufferSize, translucent, translucent, startAction,
				endAction);
		this.vertexFormat = vertexFormat;
		this.drawMode = drawMode;
		this.expectedBufferSize = expectedBufferSize;
		this.hasCrumbling = hasCrumbling;
		this.translucent = translucent;
		this.optionalThis = Optional.of(this);
	}

	public static BRenderLayer.MultiPhase of(String name, VertexFormat vertexFormat, int drawMode,
			int expectedBufferSize, boolean hasCrumbling, boolean translucent,
			BRenderLayer.MultiPhaseParameters phases) {
		return BRenderLayer.MultiPhase.of(name, vertexFormat, drawMode, expectedBufferSize, hasCrumbling, translucent,
				phases);
	}

	public void draw(BufferBuilder buffer, int cameraX, int cameraY, int cameraZ) {
		if (buffer.isBuilding()) {
			if (this.translucent) {
				buffer.sortQuads((float) cameraX, (float) cameraY, (float) cameraZ);
			}

			buffer.end();
			this.startDrawing();
			BufferRenderer.draw(buffer);
			this.endDrawing();
		}
	}

	public String toString() {
		return this.name;
	}

	public static List<RenderLayer> getBlockLayers() {
		return ImmutableList.of(getSolid(), getCutoutMipped(), getCutout(), getTranslucent(), getTripwire());
	}

	public int getExpectedBufferSize() {
		return this.expectedBufferSize;
	}

	public VertexFormat getVertexFormat() {
		return this.vertexFormat;
	}

	public int getDrawMode() {
		return this.drawMode;
	}

	public Optional<RenderLayer> getAffectedOutline() {
		return Optional.empty();
	}

	public boolean isOutline() {
		return false;
	}

	public boolean hasCrumbling() {
		return this.hasCrumbling;
	}

	public Optional<RenderLayer> asOptional() {
		return this.optionalThis;
	}

	@Environment(EnvType.CLIENT)
	static final class MultiPhase extends BRenderLayer {
		private static final ObjectOpenCustomHashSet<BRenderLayer.MultiPhase> CACHE;
		private final BRenderLayer.MultiPhaseParameters phases;
		private final int hash;
		private final Optional<RenderLayer> affectedOutline;
		private final boolean outline;

		private MultiPhase(String name, VertexFormat vertexFormat, int drawMode, int expectedBufferSize,
				boolean hasCrumbling, boolean translucent, BRenderLayer.MultiPhaseParameters phases) {
			super(name, vertexFormat, drawMode, expectedBufferSize, hasCrumbling, translucent, () -> {
				phases.phases.forEach(RenderPhase::startDrawing);
			}, () -> {
				phases.phases.forEach(RenderPhase::endDrawing);
			});
			this.phases = phases;
			this.affectedOutline = Optional.empty();
			this.outline = phases.outlineMode == BRenderLayer.OutlineMode.IS_OUTLINE;
			this.hash = Objects.hash(new Object[] { super.hashCode(), phases });
		}

		public static BRenderLayer.MultiPhase of(String name, VertexFormat vertexFormat, int drawMode,
				int expectedBufferSize, boolean hasCrumbling, boolean translucent,
				BRenderLayer.MultiPhaseParameters phases) {
			return (BRenderLayer.MultiPhase) CACHE.addOrGet(new BRenderLayer.MultiPhase(name, vertexFormat, drawMode,
					expectedBufferSize, hasCrumbling, translucent, phases));
		}

		public Optional<RenderLayer> getAffectedOutline() {
			return this.affectedOutline;
		}

		public boolean isOutline() {
			return this.outline;
		}

		public boolean equals(@Nullable Object object) {
			return this == object;
		}

		public int hashCode() {
			return this.hash;
		}

		public String toString() {
			return "RenderType[" + this.phases + ']';
		}

		static {
			CACHE = new ObjectOpenCustomHashSet<MultiPhase>(BRenderLayer.MultiPhase.HashStrategy.INSTANCE);
		}

		@Environment(EnvType.CLIENT)
		static enum HashStrategy implements Strategy<BRenderLayer.MultiPhase> {
			INSTANCE;

			public int hashCode(@Nullable BRenderLayer.MultiPhase multiPhase) {
				return multiPhase == null ? 0 : multiPhase.hash;
			}

			public boolean equals(@Nullable BRenderLayer.MultiPhase multiPhase,
					@Nullable BRenderLayer.MultiPhase multiPhase2) {
				if (multiPhase == multiPhase2) {
					return true;
				} else {
					return multiPhase != null && multiPhase2 != null
							? Objects.equals(multiPhase.phases, multiPhase2.phases)
							: false;
				}
			}
		}
	}

	@Environment(EnvType.CLIENT)
	public static final class MultiPhaseParameters {
		private final RenderPhase.Texture texture;
		private final RenderPhase.Transparency transparency;
		private final RenderPhase.DiffuseLighting diffuseLighting;
		private final RenderPhase.ShadeModel shadeModel;
		private final RenderPhase.Alpha alpha;
		private final RenderPhase.DepthTest depthTest;
		private final RenderPhase.Cull cull;
		private final RenderPhase.Lightmap lightmap;
		private final RenderPhase.Overlay overlay;
		private final RenderPhase.Fog fog;
		private final RenderPhase.Layering layering;
		private final RenderPhase.Target target;
		private final RenderPhase.Texturing texturing;
		private final RenderPhase.WriteMaskState writeMaskState;
		private final RenderPhase.LineWidth lineWidth;
		private final BRenderLayer.OutlineMode outlineMode;
		private final ImmutableList<RenderPhase> phases;

		private MultiPhaseParameters(RenderPhase.Texture texture, RenderPhase.Transparency transparency,
				RenderPhase.DiffuseLighting diffuseLighting, RenderPhase.ShadeModel shadeModel, RenderPhase.Alpha alpha,
				RenderPhase.DepthTest depthTest, RenderPhase.Cull cull, RenderPhase.Lightmap lightmap,
				RenderPhase.Overlay overlay, RenderPhase.Fog fog, RenderPhase.Layering layering,
				RenderPhase.Target target, RenderPhase.Texturing texturing, RenderPhase.WriteMaskState writeMaskState,
				RenderPhase.LineWidth lineWidth, BRenderLayer.OutlineMode outlineMode) {
			this.texture = texture;
			this.transparency = transparency;
			this.diffuseLighting = diffuseLighting;
			this.shadeModel = shadeModel;
			this.alpha = alpha;
			this.depthTest = depthTest;
			this.cull = cull;
			this.lightmap = lightmap;
			this.overlay = overlay;
			this.fog = fog;
			this.layering = layering;
			this.target = target;
			this.texturing = texturing;
			this.writeMaskState = writeMaskState;
			this.lineWidth = lineWidth;
			this.outlineMode = outlineMode;
			this.phases = ImmutableList.of(this.texture, this.transparency, this.diffuseLighting, this.shadeModel,
					this.alpha, this.depthTest, this.cull, this.lightmap, this.overlay, this.fog, this.layering,
					this.target, new RenderPhase[] { this.texturing, this.writeMaskState, this.lineWidth });
		}

		public boolean equals(Object object) {
			if (this == object) {
				return true;
			} else if (object != null && this.getClass() == object.getClass()) {
				BRenderLayer.MultiPhaseParameters multiPhaseParameters = (BRenderLayer.MultiPhaseParameters) object;
				return this.outlineMode == multiPhaseParameters.outlineMode
						&& this.phases.equals(multiPhaseParameters.phases);
			} else {
				return false;
			}
		}

		public int hashCode() {
			return Objects.hash(new Object[] { this.phases, this.outlineMode });
		}

		public String toString() {
			return "CompositeState[" + this.phases + ", outlineProperty=" + this.outlineMode + ']';
		}

		public static BRenderLayer.MultiPhaseParameters.Builder builder() {
			return new BRenderLayer.MultiPhaseParameters.Builder();
		}

		@Environment(EnvType.CLIENT)
		public static class Builder {
			private RenderPhase.Texture texture;
			private RenderPhase.Transparency transparency;
			private RenderPhase.DiffuseLighting diffuseLighting;
			private RenderPhase.ShadeModel shadeModel;
			private RenderPhase.Alpha alpha;
			private RenderPhase.DepthTest depthTest;
			private RenderPhase.Cull cull;
			private RenderPhase.Lightmap lightmap;
			private RenderPhase.Overlay overlay;
			private RenderPhase.Fog fog;
			private RenderPhase.Layering layering;
			private RenderPhase.Target target;
			private RenderPhase.Texturing texturing;
			private RenderPhase.WriteMaskState writeMaskState;
			private RenderPhase.LineWidth lineWidth;

			private Builder() {
				this.texture = RenderPhase.NO_TEXTURE;
				this.transparency = RenderPhase.NO_TRANSPARENCY;
				this.diffuseLighting = RenderPhase.DISABLE_DIFFUSE_LIGHTING;
				this.shadeModel = RenderPhase.SHADE_MODEL;
				this.alpha = RenderPhase.ZERO_ALPHA;
				this.depthTest = RenderPhase.LEQUAL_DEPTH_TEST;
				this.cull = RenderPhase.ENABLE_CULLING;
				this.lightmap = RenderPhase.DISABLE_LIGHTMAP;
				this.overlay = RenderPhase.DISABLE_OVERLAY_COLOR;
				this.fog = RenderPhase.FOG;
				this.layering = RenderPhase.NO_LAYERING;
				this.target = RenderPhase.MAIN_TARGET;
				this.texturing = RenderPhase.DEFAULT_TEXTURING;
				this.writeMaskState = RenderPhase.ALL_MASK;
				this.lineWidth = RenderPhase.FULL_LINE_WIDTH;
			}

			public BRenderLayer.MultiPhaseParameters.Builder texture(RenderPhase.Texture texture) {
				this.texture = texture;
				return this;
			}

			public BRenderLayer.MultiPhaseParameters.Builder transparency(RenderPhase.Transparency transparency) {
				this.transparency = transparency;
				return this;
			}

			public BRenderLayer.MultiPhaseParameters.Builder diffuseLighting(
					RenderPhase.DiffuseLighting diffuseLighting) {
				this.diffuseLighting = diffuseLighting;
				return this;
			}

			public BRenderLayer.MultiPhaseParameters.Builder shadeModel(RenderPhase.ShadeModel shadeModel) {
				this.shadeModel = shadeModel;
				return this;
			}

			public BRenderLayer.MultiPhaseParameters.Builder alpha(RenderPhase.Alpha alpha) {
				this.alpha = alpha;
				return this;
			}

			public BRenderLayer.MultiPhaseParameters.Builder depthTest(RenderPhase.DepthTest depthTest) {
				this.depthTest = depthTest;
				return this;
			}

			public BRenderLayer.MultiPhaseParameters.Builder cull(RenderPhase.Cull cull) {
				this.cull = cull;
				return this;
			}

			public BRenderLayer.MultiPhaseParameters.Builder lightmap(RenderPhase.Lightmap lightmap) {
				this.lightmap = lightmap;
				return this;
			}

			public BRenderLayer.MultiPhaseParameters.Builder overlay(RenderPhase.Overlay overlay) {
				this.overlay = overlay;
				return this;
			}

			public BRenderLayer.MultiPhaseParameters.Builder fog(RenderPhase.Fog fog) {
				this.fog = fog;
				return this;
			}

			public BRenderLayer.MultiPhaseParameters.Builder layering(RenderPhase.Layering layering) {
				this.layering = layering;
				return this;
			}

			public BRenderLayer.MultiPhaseParameters.Builder target(RenderPhase.Target target) {
				this.target = target;
				return this;
			}

			public BRenderLayer.MultiPhaseParameters.Builder texturing(RenderPhase.Texturing texturing) {
				this.texturing = texturing;
				return this;
			}

			public BRenderLayer.MultiPhaseParameters.Builder writeMaskState(RenderPhase.WriteMaskState writeMaskState) {
				this.writeMaskState = writeMaskState;
				return this;
			}

			public BRenderLayer.MultiPhaseParameters.Builder lineWidth(RenderPhase.LineWidth lineWidth) {
				this.lineWidth = lineWidth;
				return this;
			}

			public BRenderLayer.MultiPhaseParameters build(boolean affectsOutline) {
				return this.build(
						affectsOutline ? BRenderLayer.OutlineMode.AFFECTS_OUTLINE : BRenderLayer.OutlineMode.NONE);
			}

			public BRenderLayer.MultiPhaseParameters build(BRenderLayer.OutlineMode outlineMode) {
				return new BRenderLayer.MultiPhaseParameters(this.texture, this.transparency, this.diffuseLighting,
						this.shadeModel, this.alpha, this.depthTest, this.cull, this.lightmap, this.overlay, this.fog,
						this.layering, this.target, this.texturing, this.writeMaskState, this.lineWidth, outlineMode);
			}
		}
	}

	@Environment(EnvType.CLIENT)
	static enum OutlineMode {
		NONE("none"), IS_OUTLINE("is_outline"), AFFECTS_OUTLINE("affects_outline");

		private final String name;

		private OutlineMode(String name) {
			this.name = name;
		}

		public String toString() {
			return this.name;
		}
	}
}
