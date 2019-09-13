package studio.baka.originiumcraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
import studio.baka.originiumcraft.OriginiumCraft;
import studio.baka.originiumcraft.inventory.processing.OCProcess;
import studio.baka.originiumcraft.inventory.processing.OCProcessManager;
import studio.baka.originiumcraft.item.OCItems;

import javax.annotation.Nonnull;
import java.util.Hashtable;
import java.util.Random;

public class ProcessBuildingContainer extends Container {

    public boolean ProcessReady = false;

    private ItemStackHandler inItems = new ItemStackHandler(3);
    private ItemStackHandler outItem = new ItemStackHandler(1);
    private Random random = new Random();

    protected Slot outSlot;

    public ProcessBuildingContainer(EntityPlayer player) {
        super();
        this.addSlotToContainer(new SlotItemHandler(inItems, 0, 98, -1));
        this.addSlotToContainer(new SlotItemHandler(inItems, 1, 68, 50));
        this.addSlotToContainer(new SlotItemHandler(inItems, 2, 129, 50));
        this.addSlotToContainer(this.outSlot = new SlotItemHandler(outItem, 0, 98, 33) {
            @Override
            public boolean isItemValid(@Nonnull ItemStack stack) {
                return false;
            }
        });

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot(player.inventory, j + i * 9 + 9, j * 18 + 8, 94 + i * 18));
            }
        }

        for (int i = 0; i < 9; ++i) {
            this.addSlotToContainer(new Slot(player.inventory, i, i * 18 + 8, 152));
        }

    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return true;
    }

    @Override
    public ItemStack slotClick(int slotId, int dragType, ClickType clickTypeIn, EntityPlayer player) {

        ItemStack stack = super.slotClick(slotId, dragType, clickTypeIn, player);

        OCProcess process = OCProcessManager.tryMatch(inItems);
        if (process != null) {
            ProcessReady = true;
            outItem.setStackInSlot(0, new ItemStack(Item.REGISTRY.getObject(new ResourceLocation(process.Result))));
        } else {
            ProcessReady = false;
            outItem.setStackInSlot(0, ItemStack.EMPTY);
        }
        if (slotId == 3) {
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
                if (OCProcessManager.tryMatch(inItems) == null) {
                    outItem.setStackInSlot(0, ItemStack.EMPTY);
                    ProcessReady = false;
                }
            }
        }

        return stack;
    }
}