
package net.mcreator.playzmod.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import net.mcreator.playzmod.itemgroup.PlayzModItemGroup;
import net.mcreator.playzmod.PlayzModModElements;

import java.util.List;

@PlayzModModElements.ModElement.Tag
public class PlayzGemItem extends PlayzModModElements.ModElement {
	@ObjectHolder("playz_mod:playz_gem")
	public static final Item block = null;
	public PlayzGemItem(PlayzModModElements instance) {
		super(instance, 9);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(PlayzModItemGroup.tab).maxStackSize(64));
			setRegistryName("playz_gem");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("This is Used to craft the Playz Apple"));
			list.add(new StringTextComponent("Armor"));
			list.add(new StringTextComponent("and sword!"));
		}
	}
}
