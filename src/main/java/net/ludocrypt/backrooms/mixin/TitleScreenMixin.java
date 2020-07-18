package net.ludocrypt.backrooms.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.ludocrypt.backrooms.Backrooms;
import net.ludocrypt.backrooms.config.BackroomsConfig;
import net.minecraft.client.gui.CubeMapRenderer;
import net.minecraft.client.gui.RotatingCubeMapRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

@Mixin(TitleScreen.class)
public abstract class TitleScreenMixin extends Screen {

	private static CubeMapRenderer NORMAL_CUBE_MAP = new CubeMapRenderer(
			new Identifier("textures/gui/title/background/panorama"));
	private static CubeMapRenderer LEVEL0_CUBE_MAP = new CubeMapRenderer(
			new Identifier("backrooms:textures/gui/title/background/level0"));
	private static CubeMapRenderer LEVEL1_CUBE_MAP = new CubeMapRenderer(
			new Identifier("backrooms:textures/gui/title/background/level1"));
	private static CubeMapRenderer LEVEL2_CUBE_MAP = new CubeMapRenderer(
			new Identifier("backrooms:textures/gui/title/background/level2"));
	@Shadow
	private RotatingCubeMapRenderer backgroundRenderer = new RotatingCubeMapRenderer(NORMAL_CUBE_MAP);

	protected TitleScreenMixin(Text title) {
		super(title);
	}

	@Inject(method = "initWidgetsNormal", at = @At(value = "RETURN"), cancellable = false)

	private void addCustomButton(int y, int spacingY, CallbackInfo ci) {
		this.addButton(new ButtonWidget(this.width / 2 - 100 + 228, this.height / 4 + 48 + 72 + 12, 40, 20,
				I18n.translate("menu.switch"), (buttonWidget) -> {
					if (BackroomsConfig.getInstance().ForceNormal) {
						this.backgroundRenderer = new RotatingCubeMapRenderer(NORMAL_CUBE_MAP);
					} else if (BackroomsConfig.getInstance().ForceLevel0) {
						this.backgroundRenderer = new RotatingCubeMapRenderer(LEVEL0_CUBE_MAP);
					} else if (BackroomsConfig.getInstance().ForceLevel1) {
						this.backgroundRenderer = new RotatingCubeMapRenderer(LEVEL1_CUBE_MAP);
					} else if (BackroomsConfig.getInstance().ForceLevel2) {
						this.backgroundRenderer = new RotatingCubeMapRenderer(LEVEL2_CUBE_MAP);
					} else if (!Backrooms.Display) {
						Backrooms.Display = true;
						this.backgroundRenderer = new RotatingCubeMapRenderer(LEVEL0_CUBE_MAP);
					} else if (Backrooms.Display && Backrooms.DisplayLevel == 0) {
						Backrooms.DisplayLevel = 1;
						this.backgroundRenderer = new RotatingCubeMapRenderer(LEVEL1_CUBE_MAP);
					} else if (Backrooms.Display && Backrooms.DisplayLevel == 1) {
						Backrooms.DisplayLevel = 2;
						this.backgroundRenderer = new RotatingCubeMapRenderer(LEVEL2_CUBE_MAP);
					} else if (Backrooms.Display && Backrooms.DisplayLevel == 2) {
						Backrooms.DisplayLevel = 0;
						Backrooms.Display = false;
						this.backgroundRenderer = new RotatingCubeMapRenderer(NORMAL_CUBE_MAP);
					}

				}));
		if (BackroomsConfig.getInstance().ForceNormal) {
			Backrooms.Display = false;
			this.backgroundRenderer = new RotatingCubeMapRenderer(NORMAL_CUBE_MAP);
		} else if (BackroomsConfig.getInstance().ForceLevel0) {
			Backrooms.Display = true;
			Backrooms.DisplayLevel = 0;
			this.backgroundRenderer = new RotatingCubeMapRenderer(LEVEL0_CUBE_MAP);
		} else if (BackroomsConfig.getInstance().ForceLevel1) {
			Backrooms.Display = true;
			Backrooms.DisplayLevel = 1;
			this.backgroundRenderer = new RotatingCubeMapRenderer(LEVEL1_CUBE_MAP);
		} else if (BackroomsConfig.getInstance().ForceLevel2) {
			Backrooms.Display = true;
			Backrooms.DisplayLevel = 2;
			this.backgroundRenderer = new RotatingCubeMapRenderer(LEVEL2_CUBE_MAP);
		} else if (!Backrooms.Display) {
			this.backgroundRenderer = new RotatingCubeMapRenderer(NORMAL_CUBE_MAP);
		} else if (Backrooms.Display && Backrooms.DisplayLevel == 0) {
			this.backgroundRenderer = new RotatingCubeMapRenderer(LEVEL0_CUBE_MAP);
		} else if (Backrooms.Display && Backrooms.DisplayLevel == 1) {
			this.backgroundRenderer = new RotatingCubeMapRenderer(LEVEL1_CUBE_MAP);
		} else if (Backrooms.Display && Backrooms.DisplayLevel == 2) {
			this.backgroundRenderer = new RotatingCubeMapRenderer(LEVEL2_CUBE_MAP);
		}
	}
}
