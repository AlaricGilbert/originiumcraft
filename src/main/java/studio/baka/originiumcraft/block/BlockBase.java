package studio.baka.originiumcraft.block;

import studio.baka.originiumcraft.OriginiumCraft;
import studio.baka.originiumcraft.item.OCItems;
import studio.baka.originiumcraft.util.OCCreativeTabs;
import studio.baka.originiumcraft.util.IHasModel;
import studio.baka.originiumcraft.util.ReferenceConsts;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

/* A class simply warps Block which provides a simple way to register blocks with no interaction. */
public class BlockBase extends Block implements IHasModel {

    public BlockBase(String name, Material material){
        super(material);
        setTranslationKey(name);
        setRegistryName(ReferenceConsts.MODID,name);
        setCreativeTab(OCCreativeTabs.ArknightsDecorations);

        OCBlocks.BLOCKS.add(this);
        OCItems.ITEMS.add(new ItemBlock(this).setRegistryName(name));

    }
    /* Register models for the block which derived from this or just a instance of this. */
    @Override
    public void registerModels() {
        OriginiumCraft.proxy.registerItemRenderer(Item.getItemFromBlock(this),0,"inventory");
    }
}
