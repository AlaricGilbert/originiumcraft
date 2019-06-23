package studio.baka.originiumcraft;

import studio.baka.originiumcraft.common.CommonProxy;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = OriginiumCraft.MODID, name = OriginiumCraft.NAME, version = OriginiumCraft.VERSION)
public class OriginiumCraft {
    public static final String MODID = "originiumcraft";
    public static final String NAME = "Originium Craft";
    public static final String VERSION = "0.0.1";

    @SidedProxy(clientSide = "studio.baka.originiumcraft.client.ClientProxy",
            serverSide = "studio.baka.originiumcraft.common.CommonProxy")
    public static CommonProxy proxy;

    @Mod.Instance(OriginiumCraft.MODID)
    public static OriginiumCraft instance;
    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        // some example code
        //logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
        proxy.init(event);
    }

    public Logger getLogger(){
        return logger;
    }
}
