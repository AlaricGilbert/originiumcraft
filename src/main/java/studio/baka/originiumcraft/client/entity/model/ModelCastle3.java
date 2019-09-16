package studio.baka.originiumcraft.client.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCastle3 extends ModelBase {
    //fields
    ModelRenderer chassis;
    ModelRenderer wheel1;
    ModelRenderer wheel2;
    ModelRenderer wheel3;
    ModelRenderer wheel4;
    ModelRenderer wheel5;
    ModelRenderer wheel6;
    ModelRenderer leftCannon1;
    ModelRenderer leftCannon2;
    ModelRenderer leftCannon3;
    ModelRenderer rightCannon1;
    ModelRenderer rightCannon2;
    ModelRenderer rightCannon3;
    ModelRenderer bodyForePart;
    ModelRenderer bodyMainPart;
    ModelRenderer leftBodyAttr;
    ModelRenderer rightBodyAttr;
    ModelRenderer backTailPanel;
    ModelRenderer foreBodyAttr;
    ModelRenderer backBodyAttr;

    public ModelCastle3()
    {
        textureWidth = 128;
        textureHeight = 64;

        chassis = new ModelRenderer(this, 0, 23);
        chassis.addBox(0F, 0F, 0F, 10, 1, 13);
        chassis.setRotationPoint(-5F, 20F, -7F);
        chassis.setTextureSize(128, 64);
        chassis.mirror = true;
        setRotation(chassis, 0F, 0F, 0F);
        wheel1 = new ModelRenderer(this, 40, 0);
        wheel1.addBox(0F, 0F, 0F, 1, 3, 3);
        wheel1.setRotationPoint(-5F, 21F, -6F);
        wheel1.setTextureSize(128, 64);
        wheel1.mirror = true;
        setRotation(wheel1, 0F, 0F, 0F);
        wheel2 = new ModelRenderer(this, 40, 0);
        wheel2.addBox(0F, 0F, 0F, 1, 3, 3);
        wheel2.setRotationPoint(-5F, 21F, -1F);
        wheel2.setTextureSize(128, 64);
        wheel2.mirror = true;
        setRotation(wheel2, 0F, 0F, 0F);
        wheel3 = new ModelRenderer(this, 40, 0);
        wheel3.addBox(0F, 0F, 0F, 1, 3, 3);
        wheel3.setRotationPoint(-5F, 21F, 3F);
        wheel3.setTextureSize(128, 64);
        wheel3.mirror = true;
        setRotation(wheel3, 0F, 0F, 0F);
        wheel4 = new ModelRenderer(this, 40, 0);
        wheel4.addBox(0F, 0F, 0F, 1, 3, 3);
        wheel4.setRotationPoint(4F, 21F, -6F);
        wheel4.setTextureSize(128, 64);
        wheel4.mirror = true;
        setRotation(wheel4, 0F, 0F, 0F);
        wheel5 = new ModelRenderer(this, 40, 0);
        wheel5.addBox(0F, 0F, 0F, 1, 3, 3);
        wheel5.setRotationPoint(4F, 21F, -1F);
        wheel5.setTextureSize(128, 64);
        wheel5.mirror = true;
        setRotation(wheel5, 0F, 0F, 0F);
        wheel6 = new ModelRenderer(this, 40, 0);
        wheel6.addBox(0F, 0F, 0F, 1, 3, 3);
        wheel6.setRotationPoint(4F, 21F, 3F);
        wheel6.setTextureSize(128, 64);
        wheel6.mirror = true;
        setRotation(wheel6, 0F, 0F, 0F);
        leftCannon1 = new ModelRenderer(this, 75, 0);
        leftCannon1.addBox(0F, 0F, 0F, 1, 3, 1);
        leftCannon1.setRotationPoint(-4.5F, 18F, 3.2F);
        leftCannon1.setTextureSize(128, 64);
        leftCannon1.mirror = true;
        setRotation(leftCannon1, 0.3490659F, 0F, 0F);
        leftCannon2 = new ModelRenderer(this, 75, 0);
        leftCannon2.addBox(0F, 0F, 0F, 1, 3, 1);
        leftCannon2.setRotationPoint(2.4F, 18F, 2.466667F);
        leftCannon2.setTextureSize(128, 64);
        leftCannon2.mirror = true;
        setRotation(leftCannon2, 0.3490659F, 0F, 0F);
        leftCannon3 = new ModelRenderer(this, 75, 0);
        leftCannon3.addBox(0F, 0F, 0F, 1, 2, 1);
        leftCannon3.setRotationPoint(-4.8F, 18.62222F, 1.8F);
        leftCannon3.setTextureSize(128, 64);
        leftCannon3.mirror = true;
        setRotation(leftCannon3, 0.3490659F, 0F, 0F);
        rightCannon1 = new ModelRenderer(this, 75, 0);
        rightCannon1.addBox(0F, 0F, 0F, 1, 3, 1);
        rightCannon1.setRotationPoint(3.5F, 18F, 3.2F);
        rightCannon1.setTextureSize(128, 64);
        rightCannon1.mirror = true;
        setRotation(rightCannon1, 0.3490659F, 0F, 0F);
        rightCannon2 = new ModelRenderer(this, 75, 0);
        rightCannon2.addBox(0F, 0F, 0F, 1, 3, 1);
        rightCannon2.setRotationPoint(-3.444444F, 18F, 2.466667F);
        rightCannon2.setTextureSize(128, 64);
        rightCannon2.mirror = true;
        setRotation(rightCannon2, 0.3490659F, 0F, 0F);
        rightCannon3 = new ModelRenderer(this, 75, 0);
        rightCannon3.addBox(0F, 0F, 0F, 1, 2, 1);
        rightCannon3.setRotationPoint(3.8F, 18.62222F, 1.8F);
        rightCannon3.setTextureSize(128, 64);
        rightCannon3.mirror = true;
        setRotation(rightCannon3, 0.3490659F, 0F, 0F);
        bodyForePart = new ModelRenderer(this, 83, 0);
        bodyForePart.addBox(0F, 0F, 0F, 12, 2, 6);
        bodyForePart.setRotationPoint(-6F, 18F, -7F);
        bodyForePart.setTextureSize(128, 64);
        bodyForePart.mirror = true;
        setRotation(bodyForePart, 0F, 0F, 0F);
        bodyMainPart = new ModelRenderer(this, 0, 0);
        bodyMainPart.addBox(0F, 0F, 0F, 4, 15, 7);
        bodyMainPart.setRotationPoint(-2F, 5F, -5F);
        bodyMainPart.setTextureSize(128, 64);
        bodyMainPart.mirror = true;
        setRotation(bodyMainPart, 0F, 0F, 0F);
        leftBodyAttr = new ModelRenderer(this, 50, 24);
        leftBodyAttr.addBox(0F, 0F, 0F, 3, 3, 2);
        leftBodyAttr.setRotationPoint(-4F, 15F, -4F);
        leftBodyAttr.setTextureSize(128, 64);
        leftBodyAttr.mirror = true;
        setRotation(leftBodyAttr, 0F, 0F, 0F);
        rightBodyAttr = new ModelRenderer(this, 50, 24);
        rightBodyAttr.addBox(0F, 0F, 0F, 3, 3, 2);
        rightBodyAttr.setRotationPoint(1F, 15F, -4F);
        rightBodyAttr.setTextureSize(128, 64);
        rightBodyAttr.mirror = true;
        setRotation(rightBodyAttr, 0F, 0F, 0F);
        backTailPanel = new ModelRenderer(this, 52, 8);
        backTailPanel.addBox(0F, 0F, 0F, 4, 1, 7);
        backTailPanel.setRotationPoint(-2F, 19F, 1F);
        backTailPanel.setTextureSize(128, 64);
        backTailPanel.mirror = true;
        setRotation(backTailPanel, 0F, 0F, 0F);
        foreBodyAttr = new ModelRenderer(this, 67, 24);
        foreBodyAttr.addBox(0F, 0F, 0F, 6, 1, 2);
        foreBodyAttr.setRotationPoint(-3F, 17F, -6F);
        foreBodyAttr.setTextureSize(128, 64);
        foreBodyAttr.mirror = true;
        setRotation(foreBodyAttr, 0F, 0F, 0F);
        backBodyAttr = new ModelRenderer(this, 60, 0);
        backBodyAttr.addBox(0F, 0F, 0F, 4, 4, 2);
        backBodyAttr.setRotationPoint(-2F, 16F, 2F);
        backBodyAttr.setTextureSize(128, 64);
        backBodyAttr.mirror = true;
        setRotation(backBodyAttr, 0F, 0F, 0F);
    }

    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
        super.render( entityIn,limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale,entityIn);
        chassis.render(scale);
        wheel1.render(scale);
        wheel2.render(scale);
        wheel3.render(scale);
        wheel4.render(scale);
        wheel5.render(scale);
        wheel6.render(scale);
        leftCannon1.render(scale);
        leftCannon2.render(scale);
        leftCannon3.render(scale);
        rightCannon1.render(scale);
        rightCannon2.render(scale);
        rightCannon3.render(scale);
        bodyForePart.render(scale);
        bodyMainPart.render(scale);
        leftBodyAttr.render(scale);
        rightBodyAttr.render(scale);
        backTailPanel.render(scale);
        foreBodyAttr.render(scale);
        backBodyAttr.render(scale);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
    {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
    }

}
