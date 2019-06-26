package studio.baka.originiumcraft.client;

import studio.baka.originiumcraft.common.CommonProxy;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

    /* The preInit events called ONLY in client.*/
    public void preInit(FMLPreInitializationEvent event){
        super.preInit(event);
    }
    /* The init events called ONLY in client.*/
    public void init(FMLInitializationEvent event){
        super.init(event);
    }
    /* We should actually put the item renderer there.*/
    public void registerItemRenderer(Item item, int meta, String id){
        ModelLoader.setCustomModelResourceLocation(item,meta,new ModelResourceLocation(item.getRegistryName(),id));
    }
}
