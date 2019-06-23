package studio.baka.originiumcraft.client;

import studio.baka.originiumcraft.common.CommonProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import studio.baka.originiumcraft.common.block.OCBlocks;
import studio.baka.originiumcraft.common.item.OCItems;

public class ClientProxy extends CommonProxy
{
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        OCItems.clientInit();
        OCBlocks.clientInit();
    }

    public void init(FMLInitializationEvent event) {
        super.init(event);
    }
}