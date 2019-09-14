package studio.baka.originiumcraft.client.gui.inventory;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.Container;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import studio.baka.originiumcraft.client.gui.GuiButton;
import studio.baka.originiumcraft.client.gui.GuiReturnButton;
import studio.baka.originiumcraft.client.gui.OCGuiResources;
import studio.baka.originiumcraft.inventory.ContainerProcessBuilding;

import java.io.IOException;

@SideOnly(Side.CLIENT)
public class GuiContainerProcessBuilding extends GuiContainer {
    int guiWidth = 197;
    int guiHeight = 200;
    GuiButton returnButton;

    ContainerProcessBuilding container;

    int getStartX(){
        return (width-guiWidth)/2;
    }
    int getStartY(){ return (height-guiHeight)/2; }
    public GuiContainerProcessBuilding(Container inventorySlotsIn) {
        super(inventorySlotsIn);
        container=(ContainerProcessBuilding) inventorySlotsIn;
    }
    @Override
    public void initGui() {
        returnButton = new GuiReturnButton(this,
                getStartX(),
                getStartY(),
                ()->{
                    Minecraft.getMinecraft().displayGuiScreen(null);
                });

        super.initGui();
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.pushMatrix();
        {
            GlStateManager.color(1, 1, 1, 1);
            Minecraft.getMinecraft().renderEngine.bindTexture(OCGuiResources.GUI_PROCESS);
            drawTexturedModalRect(getStartX(), getStartY(), 0, 0, guiWidth, guiHeight);

            // draw close button
            returnButton.draw(mouseX, mouseY);

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
        returnButton.parentClicked(mouseX, mouseY);
        super.mouseClicked(mouseX, mouseY, mouseButton);
    }
}
