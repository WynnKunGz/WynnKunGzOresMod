package com.wynnkungz.wkom.common.te;

import java.util.Map;

import com.wynnkungz.wkom.WynnkungzOresMod;
import com.wynnkungz.wkom.common.container.AlloySmelterContainer;
import com.wynnkungz.wkom.common.recipe.AlloyingRecipe;
import com.wynnkungz.wkom.core.init.RecipeInit;
import com.wynnkungz.wkom.core.init.TileEntityTypesInit;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.util.Constants;

public class AlloySmelterTileEntity extends LockableLootTileEntity implements ITickableTileEntity {

	public static int slots = 5;
	public static int alloyingTime = 200;

	protected NonNullList<ItemStack> items;
	private int counter, smeltingTime;
	private boolean smelting;
	private AlloyingRecipe recipe;

	protected AlloySmelterTileEntity(TileEntityType<?> typeIn) {
		super(typeIn);
		items = NonNullList.withSize(slots, ItemStack.EMPTY);
		counter = 0;
		smeltingTime = 0;
		smelting = false;
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
		return new TranslationTextComponent("container." + WynnkungzOresMod.MOD_ID + ".display_case");
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
		compound.putBoolean("isSmelting", smelting);
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
		smelting = nbt.getBoolean("isSmelting");
		this.items = NonNullList.withSize(getSizeInventory(), ItemStack.EMPTY);
		if (!this.checkLootAndRead(nbt)) {
			ItemStackHelper.loadAllItems(nbt, this.items);
		}
	}

	@Override
	public void tick() {
		if (this.world == null || this.world.isRemote)
			return;
		if (!smelting) {
			Map<Item, Integer> burnTimes = AbstractFurnaceTileEntity.getBurnTimes();
			ItemStack fuel = getStackInSlot(3);
			int burnTime = 0;
			// checks whether there is fuel or not
			if (fuel != ItemStack.EMPTY && burnTimes.get(fuel.getItem()) != null) {
				recipe = getRecipe();
				int tester = 0;
				burnTime = burnTimes.get(fuel.getItem());
				if(recipe == null){
					WynnkungzOresMod.LOGGER.debug("recipe is Null, der scheiﬂ soll endlich funktionieren");
					return;
				}
				WynnkungzOresMod.LOGGER.debug(burnTime + "das sollte jetzt hoffentlich die BurnTime sein");
				//checks if every input matches, no duplicates allowed
				for (int i = 0; i < 3; i++) {
					for (Ingredient input : recipe.getInputs()) {
						ItemStack[] stacks = input.getMatchingStacks();
						if (stacks[0].getItem() == getStackInSlot(i).getItem()) {
							input = Ingredient.EMPTY;
							tester++;
						}
					}
				}
				WynnkungzOresMod.LOGGER.debug("" + tester + "ich muss die Zeilen f¸llen, damits auff‰llt");
				if (tester >= 2) {
					this.smeltingTime = burnTime;
					startSmelting(recipe);
				}
			}
		}
		if (smelting && recipe != null && checkFuel()) {
			work(recipe);
		}
		// activates it when your alloy smelter is smelting :-)
		BlockState state = world.getBlockState(getPos());
		if (state.get(BlockStateProperties.POWERED) != smelting) {
			world.setBlockState(pos, state.with(BlockStateProperties.POWERED, smelting),
					Constants.BlockFlags.NOTIFY_NEIGHBORS + Constants.BlockFlags.BLOCK_UPDATE);
		}
	}
	//updates your fuel time
	private boolean checkFuel(){
		boolean hasFuel = smeltingTime > 0;
		if(hasFuel)
			smeltingTime--;
		else if(getStackInSlot(3) != ItemStack.EMPTY && getStackInSlot(3).getBurnTime() > 0){
		smeltingTime = getStackInSlot(3).getBurnTime();
		}
		return hasFuel;
	}
	//does hte inital stuff when u want to start alloying
	private void startSmelting(AlloyingRecipe recipe) {
		WynnkungzOresMod.LOGGER.debug("the smelting has been started");
		getStackInSlot(0).shrink(1);
		getStackInSlot(1).shrink(1);
		getStackInSlot(2).shrink(1);
		getStackInSlot(3).shrink(1);

		smelting = true;
		counter = alloyingTime;

	}
	//called every tick during alloying
	private void work(AlloyingRecipe recipe) {
		WynnkungzOresMod.LOGGER.debug("it works 4 now");
		if (counter > 0 && smeltingTime > 0)
			counter--;
		else
			endSmelting(recipe);
	}
	//ends the alloying 
	private void endSmelting(AlloyingRecipe recipe) {
		WynnkungzOresMod.LOGGER.debug("and it ends");
		setInventorySlotContents(4, recipe.getRecipeOutput().copy());
		smelting = false;
	}

	private AlloyingRecipe getRecipe() {
		return this.world.getRecipeManager().getRecipe(RecipeInit.ALLOYING_RECIPE, this, this.world).orElse(null);
	}
}
