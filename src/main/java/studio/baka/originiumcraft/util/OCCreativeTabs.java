package studio.baka.originiumcraft.util;

import studio.baka.originiumcraft.item.OCItems;
import studio.baka.originiumcraft.block.OCBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

/* All creative tabs of OriginiumCraft mod is registered here. */
public class OCCreativeTabs {
    public static final CreativeTabs ArknightsMaterials = new CreativeTabs("arknights_materials"){
        @Override
        public ItemStack createIcon() {
            return new ItemStack(OCItems.LONGMEN_COIN);
        }
    };
    public static final CreativeTabs ArknightsDecorations= new CreativeTabs("arknights_decorations") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(OCBlocks.ORIGINIUM_ORE);
        }
    };
}
