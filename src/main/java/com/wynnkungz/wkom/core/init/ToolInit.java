package com.wynnkungz.wkom.core.init;

import com.wynnkungz.wkom.WynnKunGzOresMod;
import com.wynnkungz.wkom.common.material.CustomToolMaterial;
import com.wynnkungz.wkom.core.itemgroup.WKOMItemsItemGroup;

import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ToolInit {

	public static final DeferredRegister<Item> TOOLS = DeferredRegister.create(ForgeRegistries.ITEMS,
			WynnKunGzOresMod.MOD_ID);
	
	//Copper
	
	public static final RegistryObject<Item> COPPER_SWORD = TOOLS.register("copper_sword",
			() -> new SwordItem(CustomToolMaterial.COPPER_TOOL, 3, -2.4f,
					new Item.Properties().group(WKOMItemsItemGroup.ITEMS)));

	public static final RegistryObject<Item> COPPER_PICKAXE = TOOLS.register("copper_pickaxe",
			() -> new PickaxeItem(CustomToolMaterial.COPPER_TOOL, 1, -2.8f,
					new Item.Properties().group(WKOMItemsItemGroup.ITEMS)));

	public static final RegistryObject<Item> COPPER_AXE = TOOLS.register("copper_axe",
			() -> new AxeItem(CustomToolMaterial.COPPER_TOOL, 6, -3.1f,
					new Item.Properties().group(WKOMItemsItemGroup.ITEMS)));

	public static final RegistryObject<Item> COPPER_SHOVEL = TOOLS.register("copper_shovel",
			() -> new ShovelItem(CustomToolMaterial.COPPER_TOOL, 1, -3f,
					new Item.Properties().group(WKOMItemsItemGroup.ITEMS)));

	public static final RegistryObject<Item> COPPER_HOE = TOOLS.register("copper_hoe",
			() -> new HoeItem(CustomToolMaterial.COPPER_TOOL, -2, -1f, 
					new Item.Properties().group(WKOMItemsItemGroup.ITEMS)));

}
