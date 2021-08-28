package com.wynnkungz.wkom.core.itemgroup;

import com.wynnkungz.wkom.core.init.ArmorInit;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class WKOMArmorsItemGroup extends ItemGroup {

	public static final WKOMArmorsItemGroup ARMORS = new WKOMArmorsItemGroup(ItemGroup.GROUPS.length, "armors");
	
	public WKOMArmorsItemGroup(int index, String label) {
		super(index, label);
	}


	@Override
	public ItemStack createIcon() {
		return new ItemStack(ArmorInit.COPPER_CHESTPLATE.get());
	}
	
}
