package com.wynnkungz.wkom.core.init;

import com.wynnkungz.wkom.WynnKunGzOresMod;
import com.wynnkungz.wkom.common.material.CustomArmorMaterial;
import com.wynnkungz.wkom.core.itemgroup.WKOMItemsItemGroup;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			WynnKunGzOresMod.MOD_ID);

	//Ingot
	
	public static final RegistryObject<Item> COPPER_INGOT = ITEMS.register("copper_ingot",
			() -> new Item(new Item.Properties().group(WKOMItemsItemGroup.ITEMS)));


	public static final RegistryObject<Item> URANIUM_INGOT = ITEMS.register("uranium_ingot",
			() -> new Item(new Item.Properties().group(WKOMItemsItemGroup.ITEMS)));

	public static final RegistryObject<Item> ENDERIUM_INGOT = ITEMS.register("enderium_ingot",
			() -> new Item(new Item.Properties().group(WKOMItemsItemGroup.ITEMS)));

	public static final RegistryObject<Item> TIN_INGOT = ITEMS.register("tin_ingot",
			() -> new Item(new Item.Properties().group(WKOMItemsItemGroup.ITEMS)));

	public static final RegistryObject<Item> TUNGSTEN_INGOT = ITEMS.register("tungsten_ingot",
			() -> new Item(new Item.Properties().group(WKOMItemsItemGroup.ITEMS)));

	public static final RegistryObject<Item> ARDITE_INGOT = ITEMS.register("ardite_ingot",
			() -> new Item(new Item.Properties().group(WKOMItemsItemGroup.ITEMS)));

	public static final RegistryObject<Item> COBALT_INGOT = ITEMS.register("cobalt_ingot",
			() -> new Item(new Item.Properties().group(WKOMItemsItemGroup.ITEMS)));


	public static final RegistryObject<Item> MANYULLYN_INGOT = ITEMS.register("manyullyn_ingot",
			() -> new Item(new Item.Properties().group(WKOMItemsItemGroup.ITEMS)));
	
	//Gems
	
	public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
			() -> new Item(new Item.Properties().group(WKOMItemsItemGroup.ITEMS)));
	
	public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
			() -> new Item(new Item.Properties().group(WKOMItemsItemGroup.ITEMS)));
	

	//Armor
	
	public static final RegistryObject<Item> COPPER_HELMET = ITEMS.register("copper_helmet",
			() -> new ArmorItem(CustomArmorMaterial.COPPER_ARMOR, EquipmentSlotType.HEAD,
					new Item.Properties().group(WKOMItemsItemGroup.ITEMS)));

	public static final RegistryObject<Item> COPPER_CHESTPLATE = ITEMS.register("copper_chestplate",
			() -> new ArmorItem(CustomArmorMaterial.COPPER_ARMOR, EquipmentSlotType.CHEST,
					new Item.Properties().group(WKOMItemsItemGroup.ITEMS)));

	public static final RegistryObject<Item> COPPER_LEGGINGS = ITEMS.register("copper_leggings",
			() -> new ArmorItem(CustomArmorMaterial.COPPER_ARMOR, EquipmentSlotType.LEGS,
					new Item.Properties().group(WKOMItemsItemGroup.ITEMS)));

	public static final RegistryObject<Item> COPPER_BOOTS = ITEMS.register("copper_boots",
			() -> new ArmorItem(CustomArmorMaterial.COPPER_ARMOR, EquipmentSlotType.FEET,
					new Item.Properties().group(WKOMItemsItemGroup.ITEMS)));
}