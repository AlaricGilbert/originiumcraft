package studio.baka.originiumcraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import studio.baka.originiumcraft.OriginiumCraft;
import studio.baka.originiumcraft.client.gui.ProcessBuildingGuiContainer;

public class GuiElementLoader implements IGuiHandler {
    public static final int GUI_PROCESS_BUILDING = 1;

    public GuiElementLoader()
    {
        NetworkRegistry.INSTANCE.registerGuiHandler(OriginiumCraft.instance, this);
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        switch (ID)
        {
            case GUI_PROCESS_BUILDING:
                return new ProcessBuildingContainer(player);
            default:
                return null;
        }
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        switch (ID)
        {
            case GUI_PROCESS_BUILDING:
                return new ProcessBuildingGuiContainer(new ProcessBuildingContainer(player));
            default:
                return null;
        }
    }
}
