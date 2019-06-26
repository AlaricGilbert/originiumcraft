package studio.baka.originiumcraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import studio.baka.originiumcraft.OriginiumCraft;
import studio.baka.originiumcraft.client.gui.GuiPRTSTerminal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import studio.baka.originiumcraft.item.OCItems;
import studio.baka.originiumcraft.util.OCCreativeTabs;
import studio.baka.originiumcraft.util.IHasModel;
import studio.baka.originiumcraft.util.ReferenceConsts;

import static net.minecraft.block.BlockHorizontal.FACING;

public class BlockPRTSTerminal extends BlockHorizontal implements IHasModel {
    public BlockPRTSTerminal(){
        super(Material.IRON);
        setTranslationKey("prts_terminal");
        setRegistryName(ReferenceConsts.MODID,"prts_terminal");
        setCreativeTab(OCCreativeTabs.ArknightsDecorations);

        OCBlocks.BLOCKS.add(this);
        OCItems.ITEMS.add(new ItemBlock(this).setRegistryName("prts_terminal"));

        this.setSoundType(SoundType.STONE);
        this.setHardness(5.0f);
        this.setResistance(15.0f);
        this.setHarvestLevel("pickaxe", 2);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING,EnumFacing.NORTH));
    }

    @Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY,
                                            float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
        return super.getStateForPlacement(world, pos, facing, hitX, hitY, hitZ, meta, placer, hand).withProperty(FACING, placer.getHorizontalFacing());
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(FACING).getHorizontalIndex();
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(FACING,EnumFacing.byHorizontalIndex(meta));
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this,FACING);
    }

    /* Register models for the block which derived from this or just a instance of this. */
    @Override
    public void registerModels() {
        OriginiumCraft.proxy.registerItemRenderer(Item.getItemFromBlock(this),0,"inventory");
    }

    /* PRTS terminal is designed NOT to be flammable. */
    @Override
    public boolean isFlammable(IBlockAccess world, BlockPos pos, EnumFacing face) {
        return false;
    }

    /* PRTS terminal is designed NOT to be an opaque cube to make render proper. */
    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    /* Activate the PRTS gui after clicked. */
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if(!worldIn.isRemote) {

        }else {
            Minecraft.getMinecraft().displayGuiScreen(new GuiPRTSTerminal());
        }
        return super.onBlockActivated(worldIn,pos,state,playerIn,hand,facing,hitX,hitY,hitZ);
    }
}
