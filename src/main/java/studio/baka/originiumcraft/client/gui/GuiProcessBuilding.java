package studio.baka.originiumcraft.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import studio.baka.originiumcraft.sounds.OCSounds;
import studio.baka.originiumcraft.util.ReferenceConsts;

import java.io.IOException;

public class GuiProcessBuilding extends GuiScreen {
    final ResourceLocation ProcessGuiTexture = new ResourceLocation(ReferenceConsts.MODID,"textures/gui/process_gui.png");
    int guiWidth = 256;
    int guiHeight = 172;
    GuiButton closeButton;
    @Override
    public void drawScreen(int mouthX, int mouthY, float partialTicks) {
        drawDefaultBackground();

        int guiX = (width - guiWidth) / 2;
        int guiY = (height - guiHeight) / 2;
        GlStateManager.pushMatrix();
        {
            GlStateManager.color(1, 1, 1, 1);
            Minecraft.getMinecraft().renderEngine.bindTexture(ProcessGuiTexture);
            drawTexturedModalRect(guiX, guiY, 0, 0, guiWidth, guiHeight);
        }
        GlStateManager.popMatrix();

        // draw close button
        closeButton.draw(mouthX, mouthY);
        drawCenteredString(fontRenderer, "←", (width-guiWidth) / 2 + 12, guiY + 4, 0xffffff);


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
                        (width - guiWidth) / 2 + 6,
                        (height - guiHeight) / 2 + 4,
                        28,
                        8
                );
        closeButton.init(
                ProcessGuiTexture,
                0,
                172,
                30,
                172
        );
        closeButton.setClickedExecution(() -> {
            Minecraft.getMinecraft().player.playSound(OCSounds.BTN_BACK, 0.5F, 1.0F);
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
