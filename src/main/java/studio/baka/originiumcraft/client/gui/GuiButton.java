package studio.baka.originiumcraft.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.ResourceLocation;
import studio.baka.originiumcraft.OriginiumCraft;

public class GuiButton {
    private GuiScreen parent;
    private int startX, startY, width, height;
    private ResourceLocation resourceLocation;
    private int textureStartX, textureStartY, firedTextureStartX, firedTextureStartY;
    private boolean initialized = false;
    private Runnable clickedExecution;

    public GuiButton(GuiScreen parent, int startX, int startY, int width, int height) {
        this.parent = parent;
        this.startX = startX;
        this.startY = startY;
        this.width = width;
        this.height = height;
    }

    public void init(ResourceLocation resourceLocation, int textureStartX, int textureStartY) {
        init(resourceLocation, textureStartX, textureStartY, textureStartX, textureStartY);
    }

    public void init(ResourceLocation resourceLocation, int textureStartX, int textureStartY, int firedTextureStartX, int firedTextureStartY) {
        this.resourceLocation = resourceLocation;
        this.textureStartX = textureStartX;
        this.textureStartY = textureStartY;
        this.firedTextureStartX = firedTextureStartX;
        this.firedTextureStartY = firedTextureStartY;
        this.initialized = true;
    }

    public void setClickedExecution(Runnable execution) {
        clickedExecution = execution;
    }

    public void draw(int mouthX, int mouthY) {

        if (!initialized) {
            // just warn and do nothing with drawing
            OriginiumCraft.logger.warn("There's a button that is not initialized. It will not appear on the screen.");
            return;
        }
        GlStateManager.pushMatrix();
        {
            GlStateManager.color(1, 1, 1, 1);
            Minecraft.getMinecraft().renderEngine.bindTexture(resourceLocation);
            if (mouthX >= startX && mouthX <= startX + width && mouthY >= startY && mouthY <= startY + height)
                parent.drawTexturedModalRect(startX, startY, firedTextureStartX, firedTextureStartY, width, height);
            else
                parent.drawTexturedModalRect(startX, startY, textureStartX, textureStartY, width, height);
        }
        GlStateManager.popMatrix();
    }

    public void parentClicked(int mouthX, int mouthY) {
        if (mouthX >= startX && mouthX <= startX + width && mouthY >= startY && mouthY <= startY + height)
            clickedExecution.run();
    }

}
