package com.wynnkungz.wkom.core.itemgroup;

import com.wynnkungz.wkom.core.init.ToolInit;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class WKOMToolsItemGroup extends ItemGroup {

	public static final WKOMToolsItemGroup TOOLS = new WKOMToolsItemGroup(ItemGroup.GROUPS.length, "tools");
	
	public WKOMToolsItemGroup(int index, String label) {
		super(index, label);
	}
	
	@Override
	public ItemStack createIcon() {
		return new ItemStack(ToolInit.COPPER_SWORD.get());
	}
	
}
