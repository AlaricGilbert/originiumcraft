package studio.baka.originiumcraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
import studio.baka.originiumcraft.inventory.processing.OCProcess;
import studio.baka.originiumcraft.inventory.processing.OCProcessManager;

import javax.annotation.Nonnull;
import java.util.Hashtable;
import java.util.Random;

public class ProcessBuildingContainer extends Container {

    public boolean ProcessReady = false;

    private Random random = new Random();
    private World world;
    private ItemStackHandler inItems = new ItemStackHandler(3);
    private ItemStackHandler outItem = new ItemStackHandler(1);

    private OCProcess process;

    protected Slot outSlot;

    public ProcessBuildingContainer(EntityPlayer player) {
        super();
        this.world = player.world;

        this.addSlotToContainer(this.outSlot = new SlotItemHandler(outItem, 0, 99, 32) {

            @Override
            public boolean isItemValid(@Nonnull ItemStack stack) {
                return false;
            }
        });
        this.addSlotToContainer(new SlotItemHandler(inItems, 0, 98, -1));
        this.addSlotToContainer(new SlotItemHandler(inItems, 1, 68, 50));
        this.addSlotToContainer(new SlotItemHandler(inItems, 2, 129, 50));

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot(player.inventory, j + i * 9 + 9, j * 18 + 8, 95 + i * 18));
            }
        }

        for (int i = 0; i < 9; ++i) {
            this.addSlotToContainer(new Slot(player.inventory, i, i * 18 + 8, 153));
        }

    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return true;
    }

    @Override
    public ItemStack slotClick(int slotId, int dragType, ClickType clickTypeIn, EntityPlayer player) {

        // We should detect the TAKING behaviour whether valid or not BEFORE taking event happens.
        if (slotId == 0) {
            if (process != null && OCProcessManager.canExactMatch(inItems, process)) {
                Hashtable<String, Integer> materialQuantityTable = process.getMaterialQuantityTable();
                for (int i = 0; i < 3; i++) {
                    if (inItems.getStackInSlot(i).isEmpty())
                        continue;
                    String name = inItems.getStackInSlot(i).getItem().getRegistryName().toString();
                    Integer quantity = materialQuantityTable.get(name);
                    inItems.getStackInSlot(i).setCount(inItems.getStackInSlot(i).getCount() - quantity);

                }
                if (random.nextInt(100) < 10) {
                    String byproductName = process.Byproducts.get(random.nextInt(process.Byproducts.size()));
                    player.dropItem(new ItemStack(Item.REGISTRY.getObject(new ResourceLocation(byproductName))), false);
                }
            } else {
                // return empty when taking behaviour is NOT valid.
                return ItemStack.EMPTY;
            }
        }

        ItemStack stack = super.slotClick(slotId, dragType, clickTypeIn, player);

        process = OCProcessManager.tryMatch(inItems);
        if (process != null) {
            ProcessReady = true;
            outItem.setStackInSlot(0, new ItemStack(Item.REGISTRY.getObject(new ResourceLocation(process.Result))));
        } else {
            ProcessReady = false;
            outItem.setStackInSlot(0, ItemStack.EMPTY);
        }

        return stack;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {

        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index == 0) {
                itemstack1.getItem().onCreated(itemstack1, this.world, playerIn);

                if (!this.mergeItemStack(itemstack1, 4, 40, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onSlotChange(itemstack1, itemstack);
            } else if (index >= 4 && index < 31) {
                if (!this.mergeItemStack(itemstack1, 31, 40, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (index >= 31 && index < 40) {
                if (!this.mergeItemStack(itemstack1, 4, 31, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(itemstack1, 4, 40, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            ItemStack itemstack2 = slot.onTake(playerIn, itemstack1);

            if (index == 0) {
                playerIn.dropItem(itemstack2, false);
            }
        }

        return itemstack;
    }

    @Override
    public void onContainerClosed(EntityPlayer playerIn)
    {
        super.onContainerClosed(playerIn);

        if (!this.world.isRemote)
        {
            for(int i = 0; i < 3; i++){
                ItemStack stack = this.inItems.getStackInSlot(i);
                if(stack!=null){
                    playerIn.dropItem(stack,false);
                    this.inItems.setStackInSlot(i,ItemStack.EMPTY);
                }
            }
            ItemStack outStack = outItem.getStackInSlot(0);
            if (outStack!=null){
                playerIn.dropItem(outStack,false);
                this.outItem.setStackInSlot(0,ItemStack.EMPTY);
            }
        }
    }
}