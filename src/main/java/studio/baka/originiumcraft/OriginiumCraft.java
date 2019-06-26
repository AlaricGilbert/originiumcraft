package studio.baka.originiumcraft;

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

    @SidedProxy(clientSide = ReferenceConsts.CLIENT_PROXY,serverSide = ReferenceConsts.COMMON_PROXY)
    public static CommonProxy proxy;
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    }

}
