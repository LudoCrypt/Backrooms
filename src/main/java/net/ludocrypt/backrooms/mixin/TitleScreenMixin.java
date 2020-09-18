package net.ludocrypt.backrooms.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.ludocrypt.backrooms.BackroomsClient;
import net.ludocrypt.backrooms.config.BackroomsConfig;
import net.minecraft.client.gui.CubeMapRenderer;
import net.minecraft.client.gui.RotatingCubeMapRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
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
	private static CubeMapRenderer LEVEL3_CUBE_MAP = new CubeMapRenderer(
			new Identifier("backrooms:textures/gui/title/background/level3"));
	@Shadow
	private RotatingCubeMapRenderer backgroundRenderer = new RotatingCubeMapRenderer(NORMAL_CUBE_MAP);

	protected TitleScreenMixin(Text title) {
		super(title);
	}

	@Inject(method = "initWidgetsNormal", at = @At(value = "RETURN"), cancellable = false)

	private void addCustomButton(int y, int spacingY, CallbackInfo ci) {

		this.addButton(new ButtonWidget(this.width / 2 - 100 + 228, this.height / 4 + 48 + 72 + 12, 40, 20,
				new TranslatableText("menu.switch"), (buttonWidget) -> {

					if (BackroomsConfig.getInstance().ForceNormal) {
						this.backgroundRenderer = new RotatingCubeMapRenderer(NORMAL_CUBE_MAP);
					} else if (BackroomsConfig.getInstance().ForceLevel0) {
						this.backgroundRenderer = new RotatingCubeMapRenderer(LEVEL0_CUBE_MAP);
					} else if (BackroomsConfig.getInstance().ForceLevel1) {
						this.backgroundRenderer = new RotatingCubeMapRenderer(LEVEL1_CUBE_MAP);
					} else if (BackroomsConfig.getInstance().ForceLevel2) {
						this.backgroundRenderer = new RotatingCubeMapRenderer(LEVEL2_CUBE_MAP);
					} else if (BackroomsConfig.getInstance().ForceLevel3) {
						this.backgroundRenderer = new RotatingCubeMapRenderer(LEVEL3_CUBE_MAP);
					} else if (!BackroomsClient.Display) {
						BackroomsClient.Display = true;
						this.backgroundRenderer = new RotatingCubeMapRenderer(LEVEL0_CUBE_MAP);
					} else if (BackroomsClient.Display && BackroomsClient.DisplayLevel == 0) {
						BackroomsClient.DisplayLevel = 1;
						this.backgroundRenderer = new RotatingCubeMapRenderer(LEVEL1_CUBE_MAP);
					} else if (BackroomsClient.Display && BackroomsClient.DisplayLevel == 1) {
						BackroomsClient.DisplayLevel = 2;
						this.backgroundRenderer = new RotatingCubeMapRenderer(LEVEL2_CUBE_MAP);
					} else if (BackroomsClient.Display && BackroomsClient.DisplayLevel == 2) {
						BackroomsClient.DisplayLevel = 3;
						this.backgroundRenderer = new RotatingCubeMapRenderer(LEVEL3_CUBE_MAP);
					} else if (BackroomsClient.Display && BackroomsClient.DisplayLevel == 3) {
						BackroomsClient.DisplayLevel = 0;
						BackroomsClient.Display = false;
						this.backgroundRenderer = new RotatingCubeMapRenderer(NORMAL_CUBE_MAP);
					}

				}));
		if (BackroomsConfig.getInstance().ForceNormal) {
			BackroomsClient.Display = false;
			this.backgroundRenderer = new RotatingCubeMapRenderer(NORMAL_CUBE_MAP);
		} else if (BackroomsConfig.getInstance().ForceLevel0) {
			BackroomsClient.Display = true;
			BackroomsClient.DisplayLevel = 0;
			this.backgroundRenderer = new RotatingCubeMapRenderer(LEVEL0_CUBE_MAP);
		} else if (BackroomsConfig.getInstance().ForceLevel1) {
			BackroomsClient.Display = true;
			BackroomsClient.DisplayLevel = 1;
			this.backgroundRenderer = new RotatingCubeMapRenderer(LEVEL1_CUBE_MAP);
		} else if (BackroomsConfig.getInstance().ForceLevel2) {
			BackroomsClient.Display = true;
			BackroomsClient.DisplayLevel = 2;
			this.backgroundRenderer = new RotatingCubeMapRenderer(LEVEL2_CUBE_MAP);
		} else if (BackroomsConfig.getInstance().ForceLevel3) {
			BackroomsClient.Display = true;
			BackroomsClient.DisplayLevel = 3;
			this.backgroundRenderer = new RotatingCubeMapRenderer(LEVEL3_CUBE_MAP);
		} else if (!BackroomsClient.Display) {
			this.backgroundRenderer = new RotatingCubeMapRenderer(NORMAL_CUBE_MAP);
		} else if (BackroomsClient.Display && BackroomsClient.DisplayLevel == 0) {
			this.backgroundRenderer = new RotatingCubeMapRenderer(LEVEL0_CUBE_MAP);
		} else if (BackroomsClient.Display && BackroomsClient.DisplayLevel == 1) {
			this.backgroundRenderer = new RotatingCubeMapRenderer(LEVEL1_CUBE_MAP);
		} else if (BackroomsClient.Display && BackroomsClient.DisplayLevel == 2) {
			this.backgroundRenderer = new RotatingCubeMapRenderer(LEVEL2_CUBE_MAP);
		} else if (BackroomsClient.Display && BackroomsClient.DisplayLevel == 3) {
			this.backgroundRenderer = new RotatingCubeMapRenderer(LEVEL3_CUBE_MAP);
		}
	}
}
