package com.wynnkungz.wkom.common.container;

import java.util.Objects;

import com.wynnkungz.wkom.common.te.AlloySmelterTileEntity;
import com.wynnkungz.wkom.core.init.BlockInit;
import com.wynnkungz.wkom.core.init.ContainerTypesInit;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;

public class AlloySmelterContainer extends Container{

	protected final AlloySmelterTileEntity te;
	protected final PlayerInventory playerInteventory;
	private final IWorldPosCallable canInteractWithCallable;
	
	public AlloySmelterContainer(final int windowId, final PlayerInventory playerInv, final AlloySmelterTileEntity te) {
		super(ContainerTypesInit.DISPLAY_CASE_CONTAINER_TYPE.get(), windowId);
		this.te = te;
		this.canInteractWithCallable = IWorldPosCallable.of(te.getWorld(), te.getPos());
		this.playerInteventory = playerInv;
		//Tile Entity
		
		//Input Slots
		this.addSlot(new Slot(te, 0, 16, 17));
		this.addSlot(new Slot(te, 1, 38, 17));
		this.addSlot(new Slot(te, 2, 60, 17));

		//Fuel Slot
		this.addSlot(new Slot(te, 3, 38, 53));

		//Output Slot
		this.addSlot(new LockedSlot(te, 4, 116, 35));

		addPlayerInventory();
	}

	protected void addPlayerInventory(){
		//Main Player Inventory
		for(int row = 0; row < 3; row++) {
			for(int col = 0; col < 9; col++) {
				this.addSlot(new Slot(playerInteventory, col + row * 9 + 9, 8 + col * 18, 166 - (4 - row) * 18 - 10));
			}
		}
		
		//Player Hotbar
		for(int col = 0; col < 9; col++) {
			this.addSlot(new Slot(playerInteventory, col, 8 + col * 18, 142));
		}
	}

	public AlloySmelterContainer(final int windowId, final PlayerInventory playerInv, final PacketBuffer data) {
		this(windowId, playerInv, getTileEntity(playerInv, data));
	}
	
	private static AlloySmelterTileEntity getTileEntity(final PlayerInventory playerInv, final PacketBuffer data) {
		Objects.requireNonNull(playerInv, "Player Inventory cannot be null.");
		Objects.requireNonNull(data, "Packet Buffer cannot be null.");
		final TileEntity te = playerInv.player.world.getTileEntity(data.readBlockPos());
		if (te instanceof AlloySmelterTileEntity) {
			return (AlloySmelterTileEntity) te;
		}
		throw new IllegalStateException("Tile Entity Is Not Correct");
	}
	
	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		return isWithinUsableDistance(canInteractWithCallable, playerIn, BlockInit.ALLOY_SMELTER.get() );
	}
	/**
	*	checks whether the block is currently burning something or not
	*/
	public boolean isPowered(){
		return te.getWorld().getBlockState(te.getPos()).get(BlockStateProperties.POWERED);
	}

	@Override
	public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
		ItemStack stack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);
		if (slot != null && slot.getHasStack()) {
			ItemStack stack1 = slot.getStack();
			stack = stack1.copy();
			if (index < AlloySmelterTileEntity.slots 
					&& !this.mergeItemStack(stack1, AlloySmelterTileEntity.slots, this.inventorySlots.size(), true)) {
				return ItemStack.EMPTY;
			}
			if (!this.mergeItemStack(stack1, 0, AlloySmelterTileEntity.slots, false)) {
				return ItemStack.EMPTY;
			}
			if (stack1.isEmpty()) {
				slot.putStack(ItemStack.EMPTY);
			}
			else {
			 slot.onSlotChanged();
			}
		}
		return stack;
	}

	protected static class LockedSlot extends Slot {

		public LockedSlot(IInventory inventoryIn, int index, int xPosition, int yPosition) {
			super(inventoryIn, index, xPosition, yPosition);
		}

		@Override
		public boolean isItemValid(ItemStack stack) {
			return false;
		}

	}
}
