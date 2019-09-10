package studio.baka.originiumcraft;

import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.Logger;
import studio.baka.originiumcraft.command.CommandFreshPRTS;
import studio.baka.originiumcraft.common.CommonProxy;
import studio.baka.originiumcraft.util.ReferenceConsts;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ReferenceConsts.MODID, name = ReferenceConsts.MODNAME, version = ReferenceConsts.VERSION)
public class OriginiumCraft {
    @Mod.Instance
    public static OriginiumCraft instance;
    public static Logger logger;
    @SidedProxy(clientSide = ReferenceConsts.CLIENT_PROXY,serverSide = ReferenceConsts.COMMON_PROXY)
    public static CommonProxy proxy;
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    }

    @EventHandler
    public static void onServerStarting(FMLServerStartingEvent event){
        event.registerServerCommand(new CommandFreshPRTS());
   }
}
