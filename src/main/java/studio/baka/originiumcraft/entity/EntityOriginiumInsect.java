package studio.baka.originiumcraft.entity;


import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.world.World;

public class EntityOriginiumInsect extends EntityZombie {
    public static final EntityRegistryProperties REGISTRY_PROPERTIES = new EntityRegistryProperties("originum_insect","originium_insect",80,3,0xfcffe4,0xe5f462,true);
    public EntityOriginiumInsect(World worldIn){
        super(worldIn);
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
    }
}
