package studio.baka.originiumcraft.client.gui;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import studio.baka.originiumcraft.util.ReferenceConsts;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

import java.io.IOException;

public class GuiPRTSTerminal extends GuiScreen {
    int guiWidth = 256;
    int guiHeight = 144;
    GuiButton closeButton;

    @Override
    public void drawScreen(int mouthX, int mouthY, float partialTicks) {
        drawDefaultBackground();

        int guiX = (width - guiWidth) / 2;
        int guiY = (height - guiHeight) / 2;
        GlStateManager.pushMatrix();
        {
            GlStateManager.color(1, 1, 1, 1);
            Minecraft.getMinecraft().renderEngine.bindTexture(OCGuiResources.GUI_PRTS);
            drawTexturedModalRect(guiX, guiY, 0, 0, guiWidth, guiHeight);
        }
        GlStateManager.popMatrix();

        closeButton.draw(mouthX, mouthY);

        drawCenteredString(fontRenderer, I18n.format("gui.prts_terminal.title"), width / 2, guiY + 5, 0x000000);
        super.drawScreen(mouthX, mouthY, partialTicks);
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        closeButton.parentClicked(mouseX, mouseY);
        super.mouseClicked(mouseX, mouseY, mouseButton);
    }


    @Override
    public void initGui() {
        // init buttons
        closeButton =
                new studio.baka.originiumcraft.client.gui.GuiButton(
                        this,
                        (width + guiWidth) / 2 - 8,
                        (height - guiHeight) / 2,
                        8,
                        8
                );
        closeButton.init(
                OCGuiResources.GUI_PRTS,
                0,
                144,
                8,
                144
        );
        closeButton.setClickedExecution(() -> {
            Minecraft.getMinecraft().displayGuiScreen(null);
        });

        super.initGui();
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
