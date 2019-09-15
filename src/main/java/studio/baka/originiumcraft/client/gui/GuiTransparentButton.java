package studio.baka.originiumcraft.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class GuiTransparentButton extends GuiButton {
    public GuiTransparentButton(GuiScreen parent, int startX, int startY, int width, int height) {
        super(parent, startX, startY, width, height);
        init(null,0,0,0,0);
    }

    @Override
    public void draw(int mouthX, int mouthY) {
    }

    public void drawPureColor(int mouthX, int mouthY){
        GlStateManager.pushMatrix();
        {
            GlStateManager.color(1, 1, 1, 1);
            if (mouthX >= startX && mouthX <= startX + width && mouthY >= startY && mouthY <= startY + height)
                Minecraft.getMinecraft().renderEngine.bindTexture(OCGuiResources.GUI_PURE_GREY);
            else
                Minecraft.getMinecraft().renderEngine.bindTexture(OCGuiResources.GUI_PURE_BLACK);
            parent.drawTexturedModalRect(startX, startY, 0, 0, width, height);
        }
        GlStateManager.popMatrix();
    }
}
