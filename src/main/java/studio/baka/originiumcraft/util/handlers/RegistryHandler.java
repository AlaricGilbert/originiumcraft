package studio.baka.originiumcraft.util.handlers;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Tuple;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import studio.baka.originiumcraft.entity.EntityRegistryProperties;
import studio.baka.originiumcraft.entity.OCEntities;
import studio.baka.originiumcraft.item.OCItems;
import studio.baka.originiumcraft.block.OCBlocks;
import studio.baka.originiumcraft.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import studio.baka.originiumcraft.util.ReferenceConsts;


/* The registry event subscriber for OriginiumCraft mod. */
@Mod.EventBusSubscriber
public class RegistryHandler {
    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event){
        event.getRegistry().registerAll(OCItems.ITEMS.toArray(new Item[0]));
    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event){
        event.getRegistry().registerAll(OCBlocks.BLOCKS.toArray(new Block[0]));
    }

    @SubscribeEvent
    public static void onEntityRegiter(RegistryEvent.Register<EntityEntry> event){
        int id =0x0;
        for(Tuple<Class<? extends  Entity>, EntityRegistryProperties> tuple: OCEntities.ENTITIYCLASSES){
            Class<? extends Entity> entityClass = tuple.getFirst();
            EntityRegistryProperties properties = tuple.getSecond();
            event.getRegistry().register(
                    EntityEntryBuilder.create()
                    .entity(entityClass)
                    .id(new ResourceLocation(ReferenceConsts.MODID,properties.getEntityId()),id++)
                    .name(properties.getEntityName())
                    .tracker(properties.getRange(),properties.getUpdateFrequency(),properties.getSendVelocityUpdates())
                    .egg(properties.getPrimaryEggColor(),properties.getSecondaryEggColor())
                    .build()
            );
        }
    }

    @SubscribeEvent
    public static void onEggRegister(RegistryEvent.Register event){

    }

    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event){
        for(Item item: OCItems.ITEMS){
            if(item instanceof IHasModel){
                ((IHasModel)item).registerModels();
            }
        }
        for(Block block: OCBlocks.BLOCKS){
            if(block instanceof IHasModel){
                ((IHasModel)block).registerModels();
            }
        }
    }

}
