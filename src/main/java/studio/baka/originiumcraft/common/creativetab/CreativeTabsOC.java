package studio.baka.originiumcraft.common.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import studio.baka.originiumcraft.common.item.OCItems;

public class CreativeTabsOC extends CreativeTabs {
    public static CreativeTabsOC tabOC = new CreativeTabsOC();

    public CreativeTabsOC()
    {
        super("originiumcraft");
    }

    public ItemStack createIcon()
    {
        return new ItemStack(OCItems.itemPureOriginium);
    }
}
