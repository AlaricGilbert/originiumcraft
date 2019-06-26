package studio.baka.originiumcraft.client.gui;

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

    @Override
    public void drawScreen(int mouthX, int mouthY, float partialTicks) {
        drawDefaultBackground();

        int x = (width-guiWidth)/2;
        int y = (height-guiHeight)/2;

        Minecraft.getMinecraft().renderEngine.bindTexture(PRTSTexture);
        drawTexturedModalRect(x,y,0,0,guiWidth,guiHeight);
        drawCenteredString(fontRenderer,"PRTS Terminal",width/2,y+5,0x000000);
        super.drawScreen(mouthX, mouthY, partialTicks);
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
