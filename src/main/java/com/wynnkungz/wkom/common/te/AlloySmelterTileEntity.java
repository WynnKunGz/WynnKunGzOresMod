package com.wynnkungz.wkom.common.te;

import com.wynnkungz.wkom.WynnKunGzOresMod;
import com.wynnkungz.wkom.common.container.AlloySmelterContainer;
import com.wynnkungz.wkom.common.recipe.AlloyingRecipe;
import com.wynnkungz.wkom.core.init.RecipeInit;
import com.wynnkungz.wkom.core.init.TileEntityTypesInit;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.util.Constants;

public class AlloySmelterTileEntity extends LockableLootTileEntity implements ITickableTileEntity {

	public static int slots = 5;
	public static int alloyingTime = 200;

	protected NonNullList<ItemStack> items;
	private int counter, smeltingTime;
	private AlloyingRecipe recipe;

	protected AlloySmelterTileEntity(TileEntityType<?> typeIn) {
		super(typeIn);
		items = NonNullList.withSize(slots, ItemStack.EMPTY);
		counter = 0;
		smeltingTime = 0;
		recipe = null;
	}

	public AlloySmelterTileEntity() {
		this(TileEntityTypesInit.ALLOY_SMELTER_TILE_ENTITY_TYPE.get());
	}

	@Override
	public int getSizeInventory() {
		return slots;
	}

	@Override
	protected NonNullList<ItemStack> getItems() {
		return this.items;
	}

	@Override
	protected void setItems(NonNullList<ItemStack> itemsIn) {
		this.items = itemsIn;
	}

	@Override
	protected ITextComponent getDefaultName() {
		return new TranslationTextComponent("container." + WynnKunGzOresMod.MOD_ID + ".display_case");
	}

	@Override
	protected Container createMenu(int id, PlayerInventory player) {
		return new AlloySmelterContainer(id, player, this);
	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		super.write(compound);
		compound.putInt("counter", counter);
		compound.putInt("smeltingTime", smeltingTime);
		if (!this.checkLootAndWrite(compound)) {
			ItemStackHelper.saveAllItems(compound, this.items);
		}

		return compound;
	}

	@Override
	public void read(BlockState state, CompoundNBT nbt) {
		super.read(state, nbt);
		counter = nbt.getInt("counter");
		smeltingTime = nbt.getInt("smeltingTime");
		this.items = NonNullList.withSize(getSizeInventory(), ItemStack.EMPTY);
		if (!this.checkLootAndRead(nbt)) {
			ItemStackHelper.loadAllItems(nbt, this.items);
		}
	}

	@Override
	public void tick() {
		if (this.world == null || this.world.isRemote || RecipeInit.getRecipes(RecipeInit.ALLOYING_RECIPE, world.getRecipeManager()) == null)
			return;
		if (RecipeInit.getRecipes(RecipeInit.ALLOYING_RECIPE, world.getRecipeManager()).values().size() == 0)
			return;
		ItemStack input1 = getStackInSlot(0);
		ItemStack input2 = getStackInSlot(1);
		ItemStack input3 = getStackInSlot(2);
		ItemStack fuel = getStackInSlot(3);
		ItemStack output = getStackInSlot(4);
		for (final IRecipe<?> recipe : RecipeInit.getRecipes(RecipeInit.ALLOYING_RECIPE, world.getRecipeManager())
				.values()) {
			AlloyingRecipe currRecipe = (AlloyingRecipe) recipe;
			if (counter <= 0 && currRecipe.isValid(input1, input2, input3) && checkOutput(output) && checkFuel(fuel)) {
				this.recipe = currRecipe;
				counter = 200;
				input1.shrink(1);
				input2.shrink(1);
				input3.shrink(1);
			}
		}
		// activates it when your alloy smelter is doing its job.
		BlockState state = world.getBlockState(getPos());
		if (state.get(BlockStateProperties.POWERED) != smeltingTime > 0) {
			world.setBlockState(pos, state.with(BlockStateProperties.POWERED, smeltingTime > 0),
					Constants.BlockFlags.NOTIFY_NEIGHBORS + Constants.BlockFlags.BLOCK_UPDATE);
		}
		if (counter > 0 && smeltingTime > 0) {
			counter--;
			smeltingTime--;
			if (counter == 0) {
				if (output.isEmpty()) {
					setInventorySlotContents(4, this.recipe.getRecipeOutput().copy());
				} else {
					output.grow(this.recipe.getRecipeOutput().getCount());
				}
			} else {
				checkFuel(fuel);
			}
		}
	}

	protected boolean checkFuel(ItemStack fuel) {
		if (this.smeltingTime > 0)
			return true;
		if (ForgeHooks.getBurnTime(fuel) > 0) {
			fuel.shrink(1);
			smeltingTime = ForgeHooks.getBurnTime(fuel);
			return true;
		}
		return false;
	}

	private boolean checkOutput(ItemStack output) {
		if (output.isEmpty())
			return true;
		if (output.getItem() == recipe.getRecipeOutput().getItem()
				&& output.getCount() + recipe.getRecipeOutput().getCount() <= output.getMaxStackSize())
			return true;
		return false;
	}
}