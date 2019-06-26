package studio.baka.originiumcraft.item;

import studio.baka.originiumcraft.OriginiumCraft;
import studio.baka.originiumcraft.util.OCCreativeTabs;
import studio.baka.originiumcraft.util.IHasModel;
import studio.baka.originiumcraft.util.ReferenceConsts;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/* A class simply warps Item which provides a simple way to register items with no interaction. */
public class ItemBase extends Item implements IHasModel {
    public ItemBase(String name){
        setTranslationKey(name);
        setRegistryName(ReferenceConsts.MODID,name);
        setCreativeTab(CreativeTabs.MATERIALS);
        setCreativeTab(OCCreativeTabs.ArknightsMaterials);
        OCItems.ITEMS.add(this);

    }
    /* Register models for the item which derived from this or just a instance of this. */
    @Override
    public void registerModels() {
        OriginiumCraft.proxy.registerItemRenderer(this,0,"inventory");
    }
}
