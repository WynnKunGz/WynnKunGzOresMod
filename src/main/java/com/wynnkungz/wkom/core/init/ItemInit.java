package com.wynnkungz.wkom.core.init;

import com.wynnkungz.wkom.WynnkungzOresMod;
import com.wynnkungz.wkom.common.material.CustomArmorMaterial;
import com.wynnkungz.wkom.common.material.CustomToolMaterial;
import com.wynnkungz.wkom.core.itemgroup.WKOMItemGroup;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
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

	public static final RegistryObject<Item> COPPER_SWORD = ITEMS.register("copper_sword",
			() -> new SwordItem(CustomToolMaterial.COPPER_TOOL, 3, -2.4f,
					new Item.Properties().group(WKOMItemGroup.WKOM)));

	public static final RegistryObject<Item> COPPER_PICKAXE = ITEMS.register("copper_pickaxe",
			() -> new PickaxeItem(CustomToolMaterial.COPPER_TOOL, 1, -2.8f,
					new Item.Properties().group(WKOMItemGroup.WKOM)));

	public static final RegistryObject<Item> COPPER_AXE = ITEMS.register("copper_axe",
			() -> new AxeItem(CustomToolMaterial.COPPER_TOOL, 6, -3.1f,
					new Item.Properties().group(WKOMItemGroup.WKOM)));

	public static final RegistryObject<Item> COPPER_SHOVEL = ITEMS.register("copper_shovel",
			() -> new ShovelItem(CustomToolMaterial.COPPER_TOOL, 1, -3f,
					new Item.Properties().group(WKOMItemGroup.WKOM)));

	public static final RegistryObject<Item> COPPER_HOE = ITEMS.register("copper_hoe",
			() -> new HoeItem(CustomToolMaterial.COPPER_TOOL, -2, -1f, 
					new Item.Properties().group(WKOMItemGroup.WKOM)));

	public static final RegistryObject<Item> COPPER_HELMET = ITEMS.register("copper_helmet",
			() -> new ArmorItem(CustomArmorMaterial.COPPER_ARMOR, EquipmentSlotType.HEAD,
					new Item.Properties().group(WKOMItemGroup.WKOM)));

	public static final RegistryObject<Item> COPPER_CHESTPLATE = ITEMS.register("copper_chestplate",
			() -> new ArmorItem(CustomArmorMaterial.COPPER_ARMOR, EquipmentSlotType.CHEST,
					new Item.Properties().group(WKOMItemGroup.WKOM)));

	public static final RegistryObject<Item> COPPER_LEGGINGS = ITEMS.register("copper_leggings",
			() -> new ArmorItem(CustomArmorMaterial.COPPER_ARMOR, EquipmentSlotType.LEGS,
					new Item.Properties().group(WKOMItemGroup.WKOM)));

	public static final RegistryObject<Item> COPPER_BOOTS = ITEMS.register("copper_boots",
			() -> new ArmorItem(CustomArmorMaterial.COPPER_ARMOR, EquipmentSlotType.FEET,
					new Item.Properties().group(WKOMItemGroup.WKOM)));
}