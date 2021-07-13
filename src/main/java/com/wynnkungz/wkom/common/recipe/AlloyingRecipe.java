package com.wynnkungz.wkom.common.recipe;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.wynnkungz.wkom.WynnkungzOresMod;
import com.wynnkungz.wkom.core.init.ItemInit;
import com.wynnkungz.wkom.core.init.RecipeInit;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipe;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class AlloyingRecipe implements IRecipe<IInventory> {

	public static final Serializer SERIALIZER = new Serializer();

	private final Ingredient input1, input2, input3;
	private final ItemStack output;
	private final ResourceLocation id;

	public AlloyingRecipe(Ingredient input1, Ingredient input2, Ingredient input3, ItemStack output,
			ResourceLocation id) {
		this.input1 = input1;
		this.input2 = input2;
		this.input3 = input3;
		this.output = output;
		this.id = id;
	}

	@Override
	public boolean matches(IInventory inv, World worldIn) {
		return true;
	}

	@Override
	public ItemStack getCraftingResult(IInventory inv) {
		return this.output.copy();
	}

	@Override
	public ItemStack getRecipeOutput() {
		return this.output;
	}

	@Override
	public ResourceLocation getId() {
		return this.id;
	}

	@Override
	public IRecipeSerializer<?> getSerializer() {
		return SERIALIZER;
	}

	@Override
	public IRecipeType<?> getType() {
		return RecipeInit.ALLOYING_RECIPE;
	}

	public Ingredient[] getInputs(){
		return new Ingredient[]{input1, input2, input3};
	}

	@Override
	public ItemStack getIcon() {
		return new ItemStack(ItemInit.COPPER_INGOT.get());
	}

	public boolean isValid(ItemStack input) {
		return input1.test(input) || input2.test(input) || input3.test(input);
	}
	public boolean isValid(ItemStack input1, ItemStack input2, ItemStack input3) {
		if(input3.isEmpty()) {
			return this.input1.test(input1) && this.input2.test(input2);
		} else {
			return this.input1.test(input1) && this.input2.test(input2) && this.input3.test(input3);
		}		
	}

	@Override
	public boolean canFit(int width, int height) {
		return false;
	}

	private static class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>>
			implements IRecipeSerializer<AlloyingRecipe> {
		Serializer() {
			this.setRegistryName(WynnkungzOresMod.MOD_ID, "alloying_recipe");
		}

		@Override
		public AlloyingRecipe read(ResourceLocation recipeId, JsonObject json) {
			final JsonElement inputEl = JSONUtils.isJsonArray(json, "input") ? JSONUtils.getJsonArray(json, "input")
					: JSONUtils.getJsonObject(json, "input");
			final Ingredient[] inputs = readInputs(inputEl);

			final ItemStack output = ShapedRecipe.deserializeItem(JSONUtils.getJsonObject(json, "output"));

			return new AlloyingRecipe(inputs[0], inputs[1], inputs[2], output, recipeId);
		}

		private Ingredient[] readInputs(JsonElement element) {
			if (!element.isJsonArray() || element.isJsonNull())
				throw new JsonIOException("error, has to have at least two inputs");
			Ingredient input1 = Ingredient.deserialize(JSONUtils.getJsonArray(element, "1"));
			Ingredient input2 = Ingredient.deserialize(JSONUtils.getJsonArray(element, "2"));
			Ingredient input3 = Ingredient.EMPTY;
			if (!JSONUtils.getJsonArray(element, "3").isJsonNull())
				input3 = Ingredient.deserialize(JSONUtils.getJsonArray(element, "3"));
			WynnkungzOresMod.LOGGER.debug(path(input1) + " | " + path(input2) + " | " + path(input3));
			return new Ingredient[] { input1, input2, input3 };
		}

		private String path(Ingredient ing){
			ItemStack[] stacks = ing.getMatchingStacks();
			return stacks[0].getItem().getRegistryName().getPath();
		}

		@Override
		public AlloyingRecipe read(ResourceLocation recipeId, PacketBuffer buffer) {
			final Ingredient input1 = Ingredient.read(buffer);
			final Ingredient input2 = Ingredient.read(buffer);
			final Ingredient input3 = Ingredient.read(buffer);
			final ItemStack output = buffer.readItemStack();

			return new AlloyingRecipe(input1, input2, input3, output, recipeId);
		}

		@Override
		public void write(PacketBuffer buffer, AlloyingRecipe recipe) {
			recipe.input1.write(buffer);
			recipe.input2.write(buffer);
			recipe.input3.write(buffer);
			buffer.writeItemStack(recipe.output);
		}
	}
}
