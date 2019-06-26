package studio.baka.originiumcraft.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import studio.baka.originiumcraft.OriginiumCraft;
import studio.baka.originiumcraft.item.OCItems;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import studio.baka.originiumcraft.util.OCCreativeTabs;
import studio.baka.originiumcraft.util.IHasModel;
import studio.baka.originiumcraft.util.ReferenceConsts;

import javax.annotation.Nonnull;
import java.util.Random;

public class BlockOriginiumOre extends Block implements IHasModel {

    public BlockOriginiumOre(){

        super(Material.IRON);
        setTranslationKey("originium_ore");
        setRegistryName(ReferenceConsts.MODID,"originium_ore");
        setCreativeTab(OCCreativeTabs.ArknightsDecorations);

        OCBlocks.BLOCKS.add(this);
        OCItems.ITEMS.add(new ItemBlock(this).setRegistryName("originium_ore"));

        this.setSoundType(SoundType.STONE);
        this.setHardness(5.0f);
        this.setResistance(15.0f);
        this.setHarvestLevel("pickaxe", 2);

    }

    /* Register models for the block which derived from this or just a instance of this. */
    @Override
    public void registerModels() {
        OriginiumCraft.proxy.registerItemRenderer(Item.getItemFromBlock(this),0,"inventory");
    }

    /* Drops {@see cn.alaricxu.arknights.item.Originium} when harvested. */
    @Nonnull
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return OCItems.ORIGINIUM;
    }

    /* Only drops one {@see cn.alaricxu.arknights.item.Originium} per ore. */
    @Override
    public int quantityDropped(Random random) {
        return 1;
    }

    @Override
    public int quantityDroppedWithBonus(int fortune, Random random) {
        if (fortune > 0) {
            int bonusFactor = Math.max(random.nextInt(fortune + 2) - 1, 0);
            return this.quantityDropped(random) * (bonusFactor + 1);
        } else {
            return this.quantityDropped(random);
        }
    }


    /* Drops an amount of xp after having been harvested. */
    @Override
    public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
        Random random = world instanceof World ? ((World) world).rand : new Random();
        return 3+random.nextInt(4);
    }


    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
        return new ItemStack(this);
    }
}
