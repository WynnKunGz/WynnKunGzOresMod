package com.wynnkungz.wkom.core.init;

import net.minecraft.block.BlockState;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class FeatureInit {

	public static void addOres(final BiomeLoadingEvent event) {
		addOre(event, OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
				BlockInit.COPPER_ORE.get().getDefaultState(), 8, 0, 32, 10);
		addOre(event, OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, 
				BlockInit.RUBY_ORE.get().getDefaultState(), 4, 0, 48, 6);
		addOre(event, OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
				BlockInit.URANIUM_ORE.get().getDefaultState(), 4, 0, 32, 4);
		addOre(event, OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, 
				BlockInit.TIN_ORE.get().getDefaultState(), 8, 0, 48, 8);
		addOre(event, OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
				BlockInit.TUNGSTEN_ORE.get().getDefaultState(), 6, 0, 48, 8);
		addOre(event, OreFeatureConfig.FillerBlockType.NETHERRACK, 
				BlockInit.ARDITE_ORE.get().getDefaultState(), 3, 0, 32, 4);
		addOre(event, OreFeatureConfig.FillerBlockType.NETHERRACK, 
				BlockInit.COBALT_ORE.get().getDefaultState(), 3, 0, 32, 4);
		addOre(event, OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
				BlockInit.SAPPHIRE_ORE.get().getDefaultState(), 4, 0, 48, 6);
	}

	public static void addOre(final BiomeLoadingEvent event, RuleTest rule, BlockState state, int veinSize,
			int minHeight, int maxHeight, int amount) {
		event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
				Feature.ORE.withConfiguration(new OreFeatureConfig(rule, state, veinSize))
						.withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(minHeight, 0, maxHeight)))
						.square().func_242731_b(amount));
	}
}
