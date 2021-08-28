package com.wynnkungz.wkom.core.init;

import com.wynnkungz.wkom.WynnKunGzOresMod;
import com.wynnkungz.wkom.common.container.AlloySmelterContainer;

import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ContainerTypesInit {
	public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = DeferredRegister
			.create(ForgeRegistries.CONTAINERS, WynnKunGzOresMod.MOD_ID);
	public static final RegistryObject<ContainerType<AlloySmelterContainer>> DISPLAY_CASE_CONTAINER_TYPE = CONTAINER_TYPES
			.register("display_case", () -> IForgeContainerType.create(AlloySmelterContainer::new));
}
