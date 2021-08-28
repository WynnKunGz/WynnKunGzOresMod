package com.wynnkungz.wkom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wynnkungz.wkom.core.init.BlockInit;
import com.wynnkungz.wkom.core.init.ContainerTypesInit;
import com.wynnkungz.wkom.core.init.FeatureInit;
import com.wynnkungz.wkom.core.init.ItemInit;
import com.wynnkungz.wkom.core.init.RecipeInit;
import com.wynnkungz.wkom.core.init.TileEntityTypesInit;
import com.wynnkungz.wkom.core.init.ToolInit;
import com.wynnkungz.wkom.core.itemgroup.WKOMBlocksItemGroup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("wkom")
@Mod.EventBusSubscriber(modid = WynnKunGzOresMod.MOD_ID, bus = Bus.MOD)
public class WynnKunGzOresMod {

	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "wkom";

	public WynnKunGzOresMod() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		
		bus.addGenericListener(IRecipeSerializer.class, RecipeInit::registerRecipes);
		
		ItemInit.ITEMS.register(bus);
		BlockInit.BLOCKS.register(bus);
		ToolInit.TOOLS.register(bus);
		TileEntityTypesInit.TILE_ENTITY_TYPE.register(bus);
		ContainerTypesInit.CONTAINER_TYPES.register(bus);

		MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, FeatureInit::addOres);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
		BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
			event.getRegistry().register(new BlockItem(block, new Item.Properties().group(WKOMBlocksItemGroup.BLOCKS))
					.setRegistryName(block.getRegistryName()));
		});
	}
}