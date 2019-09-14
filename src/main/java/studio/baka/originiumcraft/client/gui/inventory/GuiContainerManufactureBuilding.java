package studio.baka.originiumcraft.client.gui.inventory;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.Container;
import studio.baka.originiumcraft.client.gui.GuiButton;
import studio.baka.originiumcraft.client.gui.GuiReturnButton;
import studio.baka.originiumcraft.client.gui.OCGuiResources;
import studio.baka.originiumcraft.inventory.ContainerManufactureBuilding;

import java.io.IOException;

public class GuiContainerManufactureBuilding extends GuiContainer {
    private int guiWidth = 206;
    private int guiHeight = 111;
    private int getStartX(){
        return (width-guiWidth)/2;
    }
    private int getStartY(){
        return (height-guiHeight)/2;
    }
    private ContainerManufactureBuilding container;
    private GuiButton returnButton;
    public GuiContainerManufactureBuilding(Container inventorySlotsIn) {
        super(inventorySlotsIn);
        container = (ContainerManufactureBuilding) inventorySlotsIn;
    }


    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.pushMatrix();
        {

            drawDefaultBackground();
            GlStateManager.color(1, 1, 1, 1);
            Minecraft.getMinecraft().renderEngine.bindTexture(OCGuiResources.GUI_MANU);
            drawTexturedModalRect(getStartX(), getStartY(), 0, 0, guiWidth, guiHeight);

            returnButton.draw(mouseX,mouseY);

        }
        GlStateManager.popMatrix();

    }

    @Override
    public void initGui() {
        super.initGui();
        returnButton = new GuiReturnButton(this,getStartX(),getStartY(),()->{
            Minecraft.getMinecraft().displayGuiScreen(null);
        });
    }
    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        super.mouseClicked(mouseX, mouseY, mouseButton);
        returnButton.parentClicked(mouseX,mouseY);
    }

    private void drawWorkPercentageLoadingCircle(int percentage){
        if(percentage<0||percentage>100)
            return;
        int positionX = 20 * ((100-percentage)/10);
        if(positionX==180)
            return;
        drawTexturedModalRect(getStartX()+115,getStartY()+27,positionX,111,20,20);
    }
    private void drawInputNotAvailableCircles(){
        drawTexturedModalRect(getStartX()+24,getStartY()+30,180,111,20,20);
        drawTexturedModalRect(getStartX()+51,getStartY()+30,180,111,20,20);
        drawTexturedModalRect(getStartX()+79,getStartY()+30,180,111,20,20);
    }
    private void drawItemLeftNumber(int number){
        if(number<0||number>100)
            return;
        drawSingleNumber(number/10,0);
        drawSingleNumber(number%10,6);
    }
    private void drawSingleNumber(int number,int offset){
        if(number<0||number>9)
            return;
        int[] textureXOffset = {222,229,236,243,249,222,229,236,242,249};
        int locationY = 0;
        if(number >= 5)
            locationY = 21;
        drawTexturedModalRect(getStartX()+119+offset+((number==3)?1:0),getStartY()+33,textureXOffset[number],locationY,6,9);

    }

    private void drawTimeLeftString(int seconds){
        int hour = seconds/3600;
        int minute = (seconds%3600) / 60;
        int second = (seconds%60);
        drawCenteredString(fontRenderer, String.format("%02d:%02d:%02d",hour,minute,second), getStartX() + 171, getStartY() + 58, 0xffffff);
    }

}
