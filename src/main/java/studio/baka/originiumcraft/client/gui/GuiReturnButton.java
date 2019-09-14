package studio.baka.originiumcraft.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import studio.baka.originiumcraft.sounds.OCSounds;

public class GuiReturnButton extends GuiButton {
    public GuiReturnButton(GuiScreen parent, int startX, int startY, Runnable closedCallback) {
        super(parent, startX + 4, startY +4 , 32, 8);
        this.init(OCGuiResources.GUI_COMPONENTS, 0, 0, 32, 0);
        super.setClickedExecution(() -> {
            Minecraft.getMinecraft().player.playSound(OCSounds.BTN_BACK, 0.5F, 1.0F);
            closedCallback.run();
        });
    }

    @Override
    public void draw(int mouthX, int mouthY) {

        super.draw(mouthX, mouthY);
    }
}