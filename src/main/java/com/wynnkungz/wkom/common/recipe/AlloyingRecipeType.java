package com.wynnkungz.wkom.common.recipe;

import com.wynnkungz.wkom.WynnKunGzOresMod;

import net.minecraft.item.crafting.IRecipeType;

public class AlloyingRecipeType implements IRecipeType<AlloyingRecipe> {

	@Override
	public String toString() {
		return WynnKunGzOresMod.MOD_ID + ":alloying_recipe";
	}
	
}
