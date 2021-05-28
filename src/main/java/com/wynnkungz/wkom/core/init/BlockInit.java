package com.wynnkungz.wkom.core.init;

import com.wynnkungz.wkom.WynnkungzOresMod;
import com.wynnkungz.wkom.common.block.AlloySmelterBlock;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			WynnkungzOresMod.MOD_ID);

	public static final RegistryObject<Block> COPPER_ORE = BLOCKS.register("copper_ore",
			() -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.ORANGE_TERRACOTTA)
					.hardnessAndResistance(3f, 3f).harvestTool(ToolType.PICKAXE).harvestLevel(1)
					.sound(SoundType.STONE)));
	public static final RegistryObject<Block> RUBY_ORE = BLOCKS.register("ruby_ore",
			() -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.RED)
					.hardnessAndResistance(3f, 3f).harvestTool(ToolType.PICKAXE).harvestLevel(2)
					.sound(SoundType.STONE)));
	public static final RegistryObject<Block> URANIUM_ORE = BLOCKS.register("uranium_ore",
			() -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.GREEN)
					.hardnessAndResistance(3f, 3f).harvestTool(ToolType.PICKAXE).harvestLevel(2)
					.sound(SoundType.STONE)));
	public static final RegistryObject<Block> COPPER_BLOCK = BLOCKS.register("copper_block",
			() -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.ORANGE_TERRACOTTA)
					.hardnessAndResistance(5f, 6f).harvestTool(ToolType.PICKAXE).harvestLevel(1)
					.sound(SoundType.METAL)));
	public static final RegistryObject<Block> ENDERIUM_ORE = BLOCKS.register("enderium_ore", 
			() -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.GREEN)
					.hardnessAndResistance(3f, 9f).harvestTool(ToolType.PICKAXE).harvestLevel(2)
					.sound(SoundType.STONE)));
	public static final RegistryObject<Block> TIN_ORE = BLOCKS.register("tin_ore", 
			() -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.WHITE_TERRACOTTA)
					.hardnessAndResistance(3f, 3f).harvestTool(ToolType.PICKAXE).harvestLevel(1)
					.sound(SoundType.STONE)));
	public static final RegistryObject<Block> ALLOY_SMELTER = BLOCKS.register("alloy_smelter", 
			() -> new AlloySmelterBlock());
	public static final RegistryObject<Block> TUNGSTEN_ORE = BLOCKS.register("tungsten_ore", 
			() -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.GRAY)
					.hardnessAndResistance(3f, 3f).harvestTool(ToolType.PICKAXE).harvestLevel(1)
					.sound(SoundType.STONE)));
	public static final RegistryObject<Block> ARDITE_ORE = BLOCKS.register("ardite_ore", 
			() -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.RED)
					.hardnessAndResistance(40f, 1200f).harvestTool(ToolType.PICKAXE).harvestLevel(3)
					.sound(SoundType.NETHER_ORE)));
	public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("ruby_block", 
			() -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.RED)
					.hardnessAndResistance(5f, 6f).harvestTool(ToolType.PICKAXE).harvestLevel(2)
					.sound(SoundType.METAL)));
	public static final RegistryObject<Block> COBALT_ORE = BLOCKS.register("cobalt_ore", 
			() -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.BLUE)
					.hardnessAndResistance(40f, 1200f).harvestTool(ToolType.PICKAXE).harvestLevel(3)
					.sound(SoundType.NETHER_ORE)));
	public static final RegistryObject<Block> SAPPHIRE_ORE = BLOCKS.register("sapphire_ore", 
			() -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.BLUE)
					.hardnessAndResistance(3f, 3f).harvestTool(ToolType.PICKAXE).harvestLevel(2)
					.sound(SoundType.STONE)));
}