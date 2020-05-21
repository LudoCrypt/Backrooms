package net.ludocrypt.backrooms.items;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;

import blue.endless.jankson.annotation.Nullable;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.JukeboxBlock;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.sound.SoundEvent;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BackroomsMusicDiscItem extends MusicDiscItem {
	   private static final Map<SoundEvent, BackroomsMusicDiscItem> BACKROOMS_MUSIC_DISCS = Maps.newHashMap();
	   private final int comparatorOutput;
	   private final SoundEvent sound;

	   public BackroomsMusicDiscItem(int comparatorOutput, SoundEvent sound, Item.Settings settings) {
	      super(comparatorOutput, sound, settings);
	      this.comparatorOutput = comparatorOutput;
	      this.sound = sound;
	      BACKROOMS_MUSIC_DISCS.put(this.sound, this);
	      
	   }

	   public ActionResult useOnBlock(ItemUsageContext context) {
	      World world = context.getWorld();
	      BlockPos blockPos = context.getBlockPos();
	      BlockState blockState = world.getBlockState(blockPos);
	      if (blockState.getBlock() == Blocks.JUKEBOX && !(Boolean)blockState.get(JukeboxBlock.HAS_RECORD)) {
	         ItemStack itemStack = context.getStack();
	         if (!world.isClient) {
	            ((JukeboxBlock)Blocks.JUKEBOX).setRecord(world, blockPos, blockState, itemStack);
	            world.playLevelEvent((PlayerEntity)null, 1010, blockPos, Item.getRawId(this));
	            itemStack.decrement(1);
	            PlayerEntity playerEntity = context.getPlayer();
	            if (playerEntity != null) {
	               playerEntity.incrementStat(Stats.PLAY_RECORD);
	            }
	         }

	         return ActionResult.SUCCESS;
	      } else {
	         return ActionResult.PASS;
	      }
	   }

	   public int getComparatorOutput() {
	      return this.comparatorOutput;
	   }

	   @Environment(EnvType.CLIENT)
	   public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
	      tooltip.add(this.getDescription().formatted(Formatting.GRAY));
	   }

	   @Environment(EnvType.CLIENT)
	   public Text getDescription() {
	      return new TranslatableText(this.getTranslationKey() + ".desc", new Object[0]);
	   }

	   @Nullable
	   @Environment(EnvType.CLIENT)
	   public static BackroomsMusicDiscItem bySound(SoundEvent sound) {
	      return (BackroomsMusicDiscItem)BACKROOMS_MUSIC_DISCS.get(sound);
	   }

	   @Environment(EnvType.CLIENT)
	   public SoundEvent getSound() {
	      return this.sound;
	   }
	   
	}
