package studio.baka.originiumcraft.common.item;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class OCItems {
    public static Item itemPureOriginium = new ItemPureOriginium().setTranslationKey("pureOriginium");
    public static void init(){
        ForgeRegistries.ITEMS.register(itemPureOriginium.setRegistryName("pure_originium"));
    }
    @SideOnly(Side.CLIENT)
    public static void clientInit(){
        ModelLoader.setCustomModelResourceLocation(itemPureOriginium, 0,
                new ModelResourceLocation(itemPureOriginium.getRegistryName(), "inventory"));
    }
}
