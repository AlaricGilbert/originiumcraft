package studio.baka.originiumcraft.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import studio.baka.originiumcraft.common.creativetab.CreativeTabsOC;

public class BlockOriginiumOre extends Block{
    public BlockOriginiumOre(){
        super(Material.ROCK, MapColor.STONE);
        this.setSoundType(SoundType.STONE);
        this.setHardness(2.5F);
        this.setHarvestLevel("pickaxe", 2);
        this.setCreativeTab(CreativeTabsOC.tabOC);
    }
}
