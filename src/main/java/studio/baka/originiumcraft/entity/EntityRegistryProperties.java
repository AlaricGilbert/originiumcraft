package studio.baka.originiumcraft.entity;

import net.minecraft.client.renderer.entity.RenderLiving;

public class EntityRegistryProperties {
    private String entityId;
    private String entityName;
    private int range;
    private int updateFrequency;
    private int primaryEggColor;
    private int secondaryEggColor;
    private boolean sendVelocityUpdates;
    private Class<? extends RenderLiving> renderClass;
    public String getEntityId(){return entityId;}
    public String getEntityName(){return entityName;}
    public int getRange(){return range;}
    public int getUpdateFrequency(){return updateFrequency;}
    public int getPrimaryEggColor(){return primaryEggColor;}
    public int getSecondaryEggColor(){return secondaryEggColor;}
    public boolean getSendVelocityUpdates(){return sendVelocityUpdates;}
    public Class<? extends RenderLiving> getRenderClass(){return renderClass;}
    public EntityRegistryProperties(String entityId, String entityName, int range, int updateFrequency, int primaryEggColor, int secondaryEggColor, boolean sendVelocityUpdates, Class<? extends RenderLiving> renderClass){
        this.entityId=entityId;
        this.entityName=entityName;
        this.range=range;
        this.updateFrequency=updateFrequency;
        this.primaryEggColor=primaryEggColor;
        this.secondaryEggColor=secondaryEggColor;
        this.sendVelocityUpdates=sendVelocityUpdates;
        this.renderClass = renderClass;
    }
}
