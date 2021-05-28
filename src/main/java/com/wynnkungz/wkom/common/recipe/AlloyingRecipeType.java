package com.wynnkungz.wkom.common.recipe;

import com.wynnkungz.wkom.WynnkungzOresMod;

import net.minecraft.item.crafting.IRecipeType;

public class AlloyingRecipeType implements IRecipeType<AlloyingRecipe> {

	@Override
	public String toString() {
		return WynnkungzOresMod.MOD_ID + ":alloying_recipe";
	}
	
}
