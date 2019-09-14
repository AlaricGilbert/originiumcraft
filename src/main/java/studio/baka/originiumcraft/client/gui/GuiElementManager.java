package studio.baka.originiumcraft.client.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import studio.baka.originiumcraft.OriginiumCraft;
import studio.baka.originiumcraft.client.gui.inventory.GuiContainerProcessBuilding;
import studio.baka.originiumcraft.client.gui.inventory.GuiContainerManufactureBuilding;
import studio.baka.originiumcraft.inventory.ContainerManufactureBuilding;
import studio.baka.originiumcraft.inventory.ContainerProcessBuilding;

import java.util.Hashtable;

public class GuiElementManager implements IGuiHandler {
    public static final int OPEN_GUI_NON_INTERACT = 0xdeadbeef;
    public static final int OPEN_GUI_INTERACT = 0xbeefcace;
    public static final int GUI_PROCESS_BUILDING = 1;
    public static final int GUI_MANUFACTURE_BUILDING = 2;
    private static final Hashtable<String,Object> resourceTable = new Hashtable<>();

    public GuiElementManager()
    {
        NetworkRegistry.INSTANCE.registerGuiHandler(OriginiumCraft.instance, this);
    }

    public static int registerGuiInteractResourceObject(Object resource){
        resourceTable.put(String.valueOf(resourceTable.size()),resource);
        return resourceTable.size()-1;
    }
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int guiOpenMode, int interactResourceId, int z)
    {
        switch (ID)
        {
            case GUI_PROCESS_BUILDING:
                return new ContainerProcessBuilding(player);
            case GUI_MANUFACTURE_BUILDING:
                if(guiOpenMode==OPEN_GUI_INTERACT){
                    ItemStack resource = (ItemStack) resourceTable.get(String.valueOf(interactResourceId));
                    return new ContainerManufactureBuilding(player,resource);
                }
                return new ContainerManufactureBuilding(player);
            default:
                return null;
        }
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int guiOpenMode, int interactResourceId, int z)
    {
        switch (ID)
        {
            case GUI_PROCESS_BUILDING:
                return new GuiContainerProcessBuilding(new ContainerProcessBuilding(player));
            case GUI_MANUFACTURE_BUILDING:
                if(guiOpenMode==OPEN_GUI_INTERACT){
                    ItemStack resource = (ItemStack) resourceTable.get(String.valueOf(interactResourceId));
                    resourceTable.remove(String.valueOf(interactResourceId));
                    return new GuiContainerManufactureBuilding(new ContainerManufactureBuilding(player,resource));
                }
                return new GuiContainerManufactureBuilding(new ContainerManufactureBuilding(player));
            default:
                return null;
        }
    }
}
