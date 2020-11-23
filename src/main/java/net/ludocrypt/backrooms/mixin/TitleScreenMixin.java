package net.ludocrypt.backrooms.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
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

	@Unique
	private static CubeMapRenderer NORMAL_CUBE_MAP = new CubeMapRenderer(new Identifier("textures/gui/title/background/panorama"));
	@Unique
	private static CubeMapRenderer LEVEL0_CUBE_MAP = new CubeMapRenderer(new Identifier("backrooms:textures/gui/title/background/level0"));
	@Unique
	private static CubeMapRenderer LEVEL1_CUBE_MAP = new CubeMapRenderer(new Identifier("backrooms:textures/gui/title/background/level1"));
	@Unique
	private static CubeMapRenderer LEVEL2_CUBE_MAP = new CubeMapRenderer(new Identifier("backrooms:textures/gui/title/background/level2"));
	@Unique
	private static CubeMapRenderer LEVEL3_CUBE_MAP = new CubeMapRenderer(new Identifier("backrooms:textures/gui/title/background/level3"));
	@Shadow
	private RotatingCubeMapRenderer backgroundRenderer = new RotatingCubeMapRenderer(NORMAL_CUBE_MAP);

	protected TitleScreenMixin(Text title) {
		super(title);
	}

	@Inject(method = "initWidgetsNormal", at = @At(value = "RETURN"))
	private void BACKROOMS_addCustomButton(int y, int spacingY, CallbackInfo ci) {

		this.addButton(new ButtonWidget(this.width / 2 - 100 + 228, this.height / 4 + 48 + 72 + 12, 40, 20, new TranslatableText("menu.switch"), (buttonWidget) -> {

			BackroomsConfig.INSTANCE().BackgroundLevel++;

			if (BackroomsConfig.INSTANCE().BackgroundLevel > 3) {
				BackroomsConfig.INSTANCE().BackgroundLevel = -1;
			}

			updateScreen(BackroomsConfig.INSTANCE().BackgroundLevel);

		}));

		updateScreen(BackroomsConfig.INSTANCE().BackgroundLevel);

	}

	private void updateScreen(int displevel) {
		switch (displevel) {
		case -1:
			this.backgroundRenderer = new RotatingCubeMapRenderer(NORMAL_CUBE_MAP);
			break;
		case 0:
			this.backgroundRenderer = new RotatingCubeMapRenderer(LEVEL0_CUBE_MAP);
			break;
		case 1:
			this.backgroundRenderer = new RotatingCubeMapRenderer(LEVEL1_CUBE_MAP);
			break;
		case 2:
			this.backgroundRenderer = new RotatingCubeMapRenderer(LEVEL2_CUBE_MAP);
			break;
		case 3:
			this.backgroundRenderer = new RotatingCubeMapRenderer(LEVEL3_CUBE_MAP);
			break;
		}
	}
}
