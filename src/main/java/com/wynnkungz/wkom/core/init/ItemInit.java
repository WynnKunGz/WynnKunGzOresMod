package com.wynnkungz.wkom.core.init;

import com.wynnkungz.wkom.WynnkungzOresMod;
import com.wynnkungz.wkom.core.itemgroup.WKOMItemGroup;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			WynnkungzOresMod.MOD_ID);

	public static final RegistryObject<Item> COPPER_INGOT = ITEMS.register("copper_ingot",
			() -> new Item(new Item.Properties().group(WKOMItemGroup.WKOM)));
	public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
			() -> new Item(new Item.Properties().group(WKOMItemGroup.WKOM)));
	public static final RegistryObject<Item> URANIUM_INGOT = ITEMS.register("uranium_ingot",
			() -> new Item(new Item.Properties().group(WKOMItemGroup.WKOM)));
	public static final RegistryObject<Item> ENDERIUM_INGOT = ITEMS.register("enderium_ingot", 
			() -> new Item(new Item.Properties().group(WKOMItemGroup.WKOM)));
	public static final RegistryObject<Item> TIN_INGOT = ITEMS.register("tin_ingot", 
			() -> new Item(new Item.Properties().group(WKOMItemGroup.WKOM)));
	public static final RegistryObject<Item> TUNGSTEN_INGOT = ITEMS.register("tungsten_ingot", 
			() -> new Item(new Item.Properties().group(WKOMItemGroup.WKOM)));
	public static final RegistryObject<Item> ARDITE_INGOT = ITEMS.register("ardite_ingot", 
			() -> new Item(new Item.Properties().group(WKOMItemGroup.WKOM)));
	public static final RegistryObject<Item> COBALT_INGOT = ITEMS.register("cobalt_ingot", 
			() -> new Item(new Item.Properties().group(WKOMItemGroup.WKOM)));
	public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire", 
			() -> new Item(new Item.Properties().group(WKOMItemGroup.WKOM)));
	public static final RegistryObject<Item> MANYULLYN_INGOT = ITEMS.register("manyullyn_ingot", 
			() -> new Item(new Item.Properties().group(WKOMItemGroup.WKOM)));
}