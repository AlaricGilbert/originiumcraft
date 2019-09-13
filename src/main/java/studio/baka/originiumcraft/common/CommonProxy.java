package studio.baka.originiumcraft.common;

import studio.baka.originiumcraft.inventory.GuiElementLoader;
import studio.baka.originiumcraft.inventory.processing.OCProcessManager;
import studio.baka.originiumcraft.util.ReferenceConsts;
import studio.baka.originiumcraft.world.OreGenerator;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {
    /* The preInit events called in BOTH server and client.*/
    public void preInit(FMLPreInitializationEvent event){
        GameRegistry.registerWorldGenerator(new OreGenerator(),3);
    }

    /* The init events called in BOTH server and client.*/
    public void init(FMLInitializationEvent event){
        new GuiElementLoader();
        OCProcessManager.register(ReferenceConsts.MODID);
    }
    /* We should do NOTHING with items render in the server proxy so in CommonProxy it should be a method with no content.*/
    public void registerItemRenderer(Item item, int meta, String id){

    }
}
