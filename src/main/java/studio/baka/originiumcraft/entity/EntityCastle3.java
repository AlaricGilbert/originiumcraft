package studio.baka.originiumcraft.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import studio.baka.originiumcraft.client.entity.render.RenderCastle3;

public class EntityCastle3 extends EntityCreature {
    public static final EntityRegistryProperties REGISTRY_PROPERTIES = new EntityRegistryProperties("castle_3","castle_3",80,3,0xfcffe4,0x766d5d,true, RenderCastle3.class);

    public EntityCastle3(World worldIn) {
        super(worldIn);
        this.setSize(1F, 1.2F);
    }


}
