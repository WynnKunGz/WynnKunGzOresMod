package com.wynnkungz.wkom.core.itemgroup;

import com.wynnkungz.wkom.core.init.ItemInit;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class WKOMItemGroup extends ItemGroup {
	
	public static final WKOMItemGroup WKOM = new WKOMItemGroup(ItemGroup.GROUPS.length, "wkom");

	public WKOMItemGroup(int index, String label) {
		super(index, label);
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(ItemInit.RUBY.get());
	}

}
