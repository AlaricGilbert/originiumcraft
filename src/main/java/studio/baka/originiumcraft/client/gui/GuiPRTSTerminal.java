package studio.baka.originiumcraft.client.gui;

import net.minecraft.client.renderer.GlStateManager;
import studio.baka.originiumcraft.util.ReferenceConsts;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

import java.io.IOException;

public class GuiPRTSTerminal extends GuiScreen {
    final ResourceLocation PRTSTexture = new ResourceLocation(ReferenceConsts.MODID,"textures/gui/prts_gui.png");
    int guiWidth = 256;
    int guiHeight = 144;
    int closeButtonSize = 8;

    @Override
    public void drawScreen(int mouthX, int mouthY, float partialTicks) {
        drawDefaultBackground();

        int guiX = (width-guiWidth)/2;
        int guiY = (height-guiHeight)/2;
        GlStateManager.pushMatrix();
        {
            GlStateManager.color(1,1,1,1);
            Minecraft.getMinecraft().renderEngine.bindTexture(PRTSTexture);
            drawTexturedModalRect(guiX,guiY,0,0,guiWidth,guiHeight);
        }
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        {
            GlStateManager.color(1,1,1,1);
            Minecraft.getMinecraft().renderEngine.bindTexture(PRTSTexture);
            int buttonXStart = guiX+guiWidth-closeButtonSize;
            int buttonXEnd = guiX+guiWidth;
            int buttonYStart = guiY;
            int buttonYEnd = guiY+closeButtonSize;
            int textureX = 0;
            int textureY = 144;
            if(mouthX>=buttonXStart&&mouthX<=buttonXEnd&&mouthY>=buttonYStart&&mouthY<=buttonYEnd)
                textureX += closeButtonSize;
            drawTexturedModalRect(buttonXStart,buttonYStart,textureX,textureY,closeButtonSize,closeButtonSize);
        }
        GlStateManager.popMatrix();

        drawCenteredString(fontRenderer,"PRTS Terminal",width/2,guiY+5,0x000000);
        super.drawScreen(mouthX, mouthY, partialTicks);
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        int guiX = (width-guiWidth)/2;
        int guiY = (height-guiHeight)/2;
        int buttonXStart = guiX+guiWidth-closeButtonSize;
        int buttonXEnd = guiX+guiWidth;
        int buttonYStart = guiY;
        int buttonYEnd = guiY+closeButtonSize;
        if(mouseX>=buttonXStart&&mouseX<=buttonXEnd&&mouseY>=buttonYStart&&mouseY<=buttonYEnd)
            Minecraft.getMinecraft().displayGuiScreen(null);
        super.mouseClicked(mouseX, mouseY, mouseButton);
    }


    @Override
    public void initGui() {
        super.initGui();
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        super.actionPerformed(button);
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        super.keyTyped(typedChar, keyCode);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    @Override
    public void onGuiClosed() {
        super.onGuiClosed();
    }
}
