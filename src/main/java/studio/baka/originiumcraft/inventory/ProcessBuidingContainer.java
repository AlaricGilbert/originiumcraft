package studio.baka.originiumcraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;

import javax.annotation.Nonnull;

public class ProcessBuidingContainer extends Container {

    private ItemStackHandler inItems = new ItemStackHandler(3);
    private ItemStackHandler outItem = new ItemStackHandler(1);

    protected Slot outSlot;

    public ProcessBuidingContainer(EntityPlayer player) {
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
}