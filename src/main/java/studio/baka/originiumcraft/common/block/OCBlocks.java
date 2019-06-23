package studio.baka.originiumcraft.common.block;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import studio.baka.originiumcraft.common.creativetab.CreativeTabsOC;

public class OCBlocks {
    public static Block blockOriginiumOre = new BlockOriginiumOre().setTranslationKey("originiumOre");
    public static void init(){
        ForgeRegistries.BLOCKS.register(blockOriginiumOre.setRegistryName("originium_ore"));
        ForgeRegistries.ITEMS.register(new ItemBlock(blockOriginiumOre).setRegistryName(blockOriginiumOre.getRegistryName()).setCreativeTab(CreativeTabsOC.tabOC));
    }

    @SideOnly(Side.CLIENT)
    public static void clientInit(){
        try {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(blockOriginiumOre), 0,
                    new ModelResourceLocation(blockOriginiumOre.getRegistryName(), "inventory"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
