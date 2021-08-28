package com.wynnkungz.wkom.core.itemgroup;

import com.wynnkungz.wkom.core.init.BlockInit;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class WKOMBlocksItemGroup extends ItemGroup {

	public static final WKOMBlocksItemGroup BLOCKS = new WKOMBlocksItemGroup(ItemGroup.GROUPS.length, "blocks");
	
	public WKOMBlocksItemGroup(int index, String label) {
		super(index, label);
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(BlockInit.COPPER_ORE.get());
	}
	
}
