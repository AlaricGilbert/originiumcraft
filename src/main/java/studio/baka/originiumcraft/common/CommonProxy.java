package studio.baka.originiumcraft.common;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import studio.baka.originiumcraft.common.block.OCBlocks;
import studio.baka.originiumcraft.common.item.OCItems;

public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
        OCItems.init();
        OCBlocks.init();
    }

    public void init(FMLInitializationEvent event) {

    }
}
