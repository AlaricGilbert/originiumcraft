package studio.baka.originiumcraft.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import studio.baka.originiumcraft.OriginiumCraft;
import studio.baka.originiumcraft.util.OCCreativeTabs;
import studio.baka.originiumcraft.util.IHasModel;
import studio.baka.originiumcraft.util.ReferenceConsts;

/* The Originium. */
public class ItemOriginium extends Item implements IHasModel {

    public ItemOriginium(){

        setTranslationKey("originium");
        setRegistryName(ReferenceConsts.MODID,"originium");
        setCreativeTab(CreativeTabs.MATERIALS);
        setCreativeTab(OCCreativeTabs.ArknightsMaterials);
        OCItems.ITEMS.add(this);
    }

    /* Register models for the item which derived from this or just a instance of this. */
    @Override
    public void registerModels() {
        OriginiumCraft.proxy.registerItemRenderer(this,0,"inventory");
    }
    // TODO: We are going to put some interactive codes for Originium there.

}
