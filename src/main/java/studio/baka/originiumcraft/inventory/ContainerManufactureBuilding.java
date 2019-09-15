package studio.baka.originiumcraft.inventory;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
import studio.baka.originiumcraft.client.gui.GuiManufactureBuildingFormulaChooser;
import studio.baka.originiumcraft.item.OCItems;

import javax.annotation.Nonnull;

public class ContainerManufactureBuilding extends Container {
    private final SlotItemHandler outSlot;
    private ItemStackHandler inItems = new ItemStackHandler(3);
    private ItemStackHandler outItem = new ItemStackHandler(1);
    public int RemainingWorkNumber = 1;
    public boolean[] InStackBanned = new boolean[3];
    public ContainerManufactureBuilding(EntityPlayer player, ItemStack formula){
        super();
        this.addSlotToContainer(this.outSlot = new SlotItemHandler(outItem, 0, 147, 60) {
            @Override
            public boolean isItemValid(@Nonnull ItemStack stack) {
                return false;
            }
        });
        this.addSlotToContainer(new SlotItemHandler(inItems, 0, 11, 60));
        this.addSlotToContainer(new SlotItemHandler(inItems, 1, 39, 60));
        this.addSlotToContainer(new SlotItemHandler(inItems, 2, 66, 60));
        this.outItem.setStackInSlot(0, formula);
        if(formula.isItemEqual(new ItemStack(OCItems.PURE_GOLD))){
            for (int i = 0; i < 3; i++)
                InStackBanned[i] = true;
        }

    }
    public ContainerManufactureBuilding(EntityPlayer player){
        super();
        this.addSlotToContainer(this.outSlot = new SlotItemHandler(outItem, 0, 147, 60) {
            @Override
            public boolean isItemValid(@Nonnull ItemStack stack) {
                return false;
            }
        });
        this.addSlotToContainer(new SlotItemHandler(inItems, 0, 11, 60));
        this.addSlotToContainer(new SlotItemHandler(inItems, 1, 39, 60));
        this.addSlotToContainer(new SlotItemHandler(inItems, 2, 66, 60));
        for (int i = 0; i < 3; i++)
            InStackBanned[i] = true;
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return true;
    }

    @Override
    public ItemStack slotClick(int slotId, int dragType, ClickType clickTypeIn, EntityPlayer player) {
        if(slotId == 0){
            Minecraft.getMinecraft().displayGuiScreen(new GuiManufactureBuildingFormulaChooser(ItemStack.EMPTY,player));
            return ItemStack.EMPTY;
        }
        return super.slotClick(slotId, dragType, clickTypeIn, player);
    }
}
