package com.wynnkungz.wkom.core.init;

import com.wynnkungz.wkom.WynnKunGzOresMod;
import com.wynnkungz.wkom.common.material.CustomArmorMaterial;
import com.wynnkungz.wkom.core.itemgroup.WKOMArmorsItemGroup;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ArmorInit {
	
	public static final DeferredRegister<Item> ARMORS = DeferredRegister.create(ForgeRegistries.ITEMS, WynnKunGzOresMod.MOD_ID);
	
	//Copper
	
	public static final RegistryObject<Item> COPPER_HELMET = ARMORS.register("copper_helmet",
			() -> new ArmorItem(CustomArmorMaterial.COPPER_ARMOR, EquipmentSlotType.HEAD,
					new Item.Properties().group(WKOMArmorsItemGroup.ARMORS)));

	public static final RegistryObject<Item> COPPER_CHESTPLATE = ARMORS.register("copper_chestplate",
			() -> new ArmorItem(CustomArmorMaterial.COPPER_ARMOR, EquipmentSlotType.CHEST,
					new Item.Properties().group(WKOMArmorsItemGroup.ARMORS)));

	public static final RegistryObject<Item> COPPER_LEGGINGS = ARMORS.register("copper_leggings",
			() -> new ArmorItem(CustomArmorMaterial.COPPER_ARMOR, EquipmentSlotType.LEGS,
					new Item.Properties().group(WKOMArmorsItemGroup.ARMORS)));

	public static final RegistryObject<Item> COPPER_BOOTS = ARMORS.register("copper_boots",
			() -> new ArmorItem(CustomArmorMaterial.COPPER_ARMOR, EquipmentSlotType.FEET,
					new Item.Properties().group(WKOMArmorsItemGroup.ARMORS)));
	
}
