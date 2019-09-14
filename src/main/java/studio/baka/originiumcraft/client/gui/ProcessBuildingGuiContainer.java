package studio.baka.originiumcraft.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import studio.baka.originiumcraft.inventory.ProcessBuildingContainer;
import studio.baka.originiumcraft.sounds.OCSounds;
import studio.baka.originiumcraft.util.ReferenceConsts;

import java.io.IOException;

@SideOnly(Side.CLIENT)
public class ProcessBuildingGuiContainer extends GuiContainer {


    final ResourceLocation ProcessGuiTexture = new ResourceLocation(ReferenceConsts.MODID,"textures/gui/process_gui.png");
    int guiWidth = 197;
    int guiHeight = 200;
    GuiButton closeButton;

    ProcessBuildingContainer container;

    int getStartX(){
        return (width-guiWidth)/2;
    }
    int getStartY(){
        return (height-guiHeight)/2 - 12;
    }
    public ProcessBuildingGuiContainer(Container inventorySlotsIn) {
        super(inventorySlotsIn);
        container=(ProcessBuildingContainer) inventorySlotsIn;
    }
    @Override
    public void initGui() {
        // init buttons
        closeButton =
                new GuiButton(
                        this,
                        getStartX() + 4,
                        getStartY() + 4,
                        32,
                        8
                );
        closeButton.init(
                ProcessGuiTexture,
                0,
                214,
                32,
                214
        );
        closeButton.setClickedExecution(() -> {
            Minecraft.getMinecraft().player.playSound(OCSounds.BTN_BACK, 0.5F, 1.0F);
            Minecraft.getMinecraft().displayGuiScreen(null);
        });

        super.initGui();
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.pushMatrix();
        {
            GlStateManager.color(1, 1, 1, 1);
            Minecraft.getMinecraft().renderEngine.bindTexture(ProcessGuiTexture);
            drawTexturedModalRect(getStartX(), getStartY(), 0, 0, guiWidth, guiHeight);

            // draw close button
            closeButton.draw(mouseX, mouseY);
            drawCenteredString(fontRenderer, "←", getStartX() + 10, getStartY() + 4, 0xffffff);

            // draw percentage
            if(!container.ProcessReady){
                drawCenteredString(fontRenderer, "0%", getStartX() + 172, getStartY() + 30, 0xffffff);
            }else{
                drawCenteredString(fontRenderer, "10%", getStartX() + 170, getStartY() + 30, 0xffffff);
            }

        }
        GlStateManager.popMatrix();
    }
    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {

    }
    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        closeButton.parentClicked(mouseX, mouseY);
        super.mouseClicked(mouseX, mouseY, mouseButton);
    }
}
