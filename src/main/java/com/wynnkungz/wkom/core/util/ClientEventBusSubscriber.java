package com.wynnkungz.wkom.core.util;

import com.wynnkungz.wkom.WynnKunGzOresMod;
import com.wynnkungz.wkom.client.screen.AlloySmelterScreen;
import com.wynnkungz.wkom.core.init.ContainerTypesInit;

import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = WynnKunGzOresMod.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

	@SubscribeEvent
	public static void clientSetup(final FMLClientSetupEvent event) {
		ScreenManager.registerFactory(ContainerTypesInit.DISPLAY_CASE_CONTAINER_TYPE.get(), AlloySmelterScreen::new);
	}
}
