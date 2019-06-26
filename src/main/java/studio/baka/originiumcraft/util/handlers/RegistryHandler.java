package studio.baka.originiumcraft.util.handlers;

import studio.baka.originiumcraft.item.OCItems;
import studio.baka.originiumcraft.block.OCBlocks;
import studio.baka.originiumcraft.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

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
