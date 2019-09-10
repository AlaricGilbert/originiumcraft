package studio.baka.originiumcraft.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import studio.baka.originiumcraft.OriginiumCraft;
import studio.baka.originiumcraft.block.OCBlocks;

public class CommandFreshPRTS extends CommandBase {
    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        // return true in all times means we can use freshprts in non-cheat mode.
        return true;
    }
    @Override
    public String getName() {
        return "freshprts";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return null;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if(sender.getCommandSenderEntity() instanceof EntityPlayer){
            EntityPlayer player = (EntityPlayer) sender.getCommandSenderEntity();
            ItemStack prts = new ItemStack(OCBlocks.PRTS_TERMINAL);
            if(!player.inventory.hasItemStack(prts)){
                player.inventory.addItemStackToInventory(prts);
            }
        }
        else {
            OriginiumCraft.logger.warn("No freshprts command should be executed without a sender entity, nothing will happen.");
        }
    }
}
