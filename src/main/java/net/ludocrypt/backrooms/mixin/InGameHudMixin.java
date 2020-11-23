package net.ludocrypt.backrooms.mixin;

import java.util.Random;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.ludocrypt.backrooms.Backrooms;
import net.ludocrypt.backrooms.access.SanityManagerAccess;
import net.ludocrypt.backrooms.sanity.SanityManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
@Mixin(InGameHud.class)
public class InGameHudMixin extends DrawableHelper {

	@Shadow
	private int scaledWidth;
	@Shadow
	private int scaledHeight;
	@Shadow
	private MinecraftClient client;
	@Shadow
	private final Random random = new Random();
	@Shadow
	private int ticks;
	@Unique
	private final Identifier GUI_EYES_TEXTURE = Backrooms.id("textures/gui/eye_icons.png");

	@Inject(method = "renderStatusBars", at = @At(value = "TAIL"))
	private void BACKROOMS_renderStatusBars(MatrixStack matrices, CallbackInfo ci) {
		PlayerEntity playerEntity = this.getCameraPlayer();
		if (playerEntity != null) {
//			this.client.getTextureManager().bindTexture(GUI_EYES_TEXTURE);
//			this.random.setSeed((long) (this.ticks * 312871));
//			int width = this.scaledWidth;
//			int height = this.scaledHeight;
//			int drawX = (width / 2) - 8;
//			int drawY = height - 46;

			SanityManager sanityManager = ((SanityManagerAccess) playerEntity).getSanityManager();

			playerEntity.sendMessage(new LiteralText(sanityManager.toString()), true);
//			int sanityLevel = sanityManager.getSanityLevel() - 10;
//			int sanityCrunched = sanityLevel >= 15 ? 0 : sanityLevel >= 10 ? 1 : sanityLevel >= 5 ? 2 : sanityLevel >= 1 ? 3 : 4;
//			int uvX = 0 * 16;
//			int uvY = sanityCrunched * 16;
//
//			this.drawTexture(matrices, drawX, drawY, uvX, uvY, 16, 16);
//
//			this.client.getTextureManager().bindTexture(GUI_ICONS_TEXTURE);
//			int n = this.scaledWidth / 2 + 91;
//			int ah;
//			int al;
//			int k = sanityLevel;
//
//			for (ah = 0; ah < 10; ++ah) {
//
//				int ad = 16;
//				int ak = 0;
//				int drawrand = drawY;
//				if (playerEntity.hasStatusEffect(StatusEffects.HUNGER)) {
//					ad += 36;
//					ak = 13;
//				}
//
//				if (sanityManager.getsanitySpeed() <= 0.0F && this.ticks % (k * 3 + 1) == 0) {
//					drawrand = drawY + (this.random.nextInt(3) - 1);
//				}
//
//				al = n - ah * 8 - 9;
//				this.drawTexture(matrices, al, drawrand, 16 + ak * 9, 27, 9, 9);
//				if (ah * 2 + 1 < k) {
//					this.drawTexture(matrices, al, drawrand, ad + 36, 27, 9, 9);
//				}
//
//				if (ah * 2 + 1 == k) {
//					this.drawTexture(matrices, al, drawrand, ad + 45, 27, 9, 9);
//				}
//			}

		}
	}

	@Shadow
	private PlayerEntity getCameraPlayer() {
		return null;
	}

}
