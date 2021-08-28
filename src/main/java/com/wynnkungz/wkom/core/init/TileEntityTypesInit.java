package com.wynnkungz.wkom.core.init;

import com.wynnkungz.wkom.WynnKunGzOresMod;
import com.wynnkungz.wkom.common.te.AlloySmelterTileEntity;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityTypesInit {

	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPE = DeferredRegister
			.create(ForgeRegistries.TILE_ENTITIES, WynnKunGzOresMod.MOD_ID);
	public static final RegistryObject<TileEntityType<AlloySmelterTileEntity>> ALLOY_SMELTER_TILE_ENTITY_TYPE = TILE_ENTITY_TYPE
			.register("alloy_smelter", 
					() -> TileEntityType.Builder.create(AlloySmelterTileEntity::new, BlockInit.ALLOY_SMELTER.get()).build(null));
}
