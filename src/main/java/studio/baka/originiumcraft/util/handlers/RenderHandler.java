package studio.baka.originiumcraft.util.handlers;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.Tuple;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import studio.baka.originiumcraft.entity.EntityRegistryProperties;
import studio.baka.originiumcraft.entity.OCEntities;

public class RenderHandler {
    public static void registerEntityRenders(){
        for (Tuple<Class<? extends  Entity>, EntityRegistryProperties> tuple: OCEntities.ENTITIYCLASSES
             ) {
            RenderingRegistry.registerEntityRenderingHandler(tuple.getFirst(),manager -> {
                try {
                    return  (Render<Entity>) tuple.getSecond().getRenderClass().getConstructor(RenderManager.class).newInstance(manager);
                }catch (Exception e){
                    e.printStackTrace();
                }
                return null;
            });
        }
    }
}
