package studio.baka.originiumcraft.util.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import studio.baka.originiumcraft.block.OCBlocks;

@Mod.EventBusSubscriber
public class EntityJoinedHandler {
    /* Called when a entity joined the world.
    *  Used to distribute PRTS terminal to new players.
    * */
    @SubscribeEvent
    public static void onEntityJoinWorld(EntityJoinWorldEvent event){
        if (event.getEntity().getEntityWorld().isRemote)
            return; // return when it's in client side to prevent crash
        if (event.getEntity() instanceof EntityPlayer) {
            if (!event.getEntity().getTags().contains("__PRTS__GIVEN__")) {
                ((EntityPlayer) event.getEntity()).addItemStackToInventory(new ItemStack(OCBlocks.PRTS_TERMINAL));
                event.getEntity().addTag("__PRTS__GIVEN__");
            }
        }
    }
}
