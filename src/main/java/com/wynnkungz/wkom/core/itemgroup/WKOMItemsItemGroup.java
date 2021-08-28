package com.wynnkungz.wkom.core.itemgroup;

import com.wynnkungz.wkom.core.init.ItemInit;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class WKOMItemsItemGroup extends ItemGroup {
	
	public static final WKOMItemsItemGroup ITEMS = new WKOMItemsItemGroup(ItemGroup.GROUPS.length, "items");

	public WKOMItemsItemGroup(int index, String label) {
		super(index, label);
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(ItemInit.COPPER_INGOT.get());
	}

}
