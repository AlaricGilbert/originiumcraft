package studio.baka.originiumcraft.client.entity.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.util.ResourceLocation;
import studio.baka.originiumcraft.client.entity.model.ModelCastle3;
import studio.baka.originiumcraft.entity.EntityCastle3;
import studio.baka.originiumcraft.util.ReferenceConsts;

import javax.annotation.Nullable;

public class RenderCastle3 extends RenderLiving<EntityCastle3> {
    public RenderCastle3(RenderManager renderManagerIn) {
        super(renderManagerIn,new ModelCastle3(),0.5f);
    }


    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityCastle3 entity) {
        return new ResourceLocation(ReferenceConsts.MODID,"textures/entity/castle_3.png");
    }
}
