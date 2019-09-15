package studio.baka.originiumcraft.client.gui.inventory;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.Container;
import studio.baka.originiumcraft.OriginiumCraft;
import studio.baka.originiumcraft.client.gui.GuiButton;
import studio.baka.originiumcraft.client.gui.GuiReturnButton;
import studio.baka.originiumcraft.client.gui.GuiTransparentButton;
import studio.baka.originiumcraft.client.gui.OCGuiResources;
import studio.baka.originiumcraft.inventory.ContainerManufactureBuilding;
import studio.baka.originiumcraft.sounds.OCSounds;

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
    private GuiTransparentButton plusButton;
    private GuiTransparentButton minusButton;
    private GuiTransparentButton maximumButton;
    private GuiTransparentButton minimumButton;
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
            drawItemLeftNumber(container.RemainingWorkNumber);
            drawInputNotAvailableCircles();
            drawTimeLeftString(-1);
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
        plusButton = new GuiTransparentButton(this,getStartX()+108,getStartY()+16,21,6);
        plusButton.setClickedExecution(()->{
            Minecraft.getMinecraft().player.playSound(OCSounds.BTN_BACK, 0.5F, 1.0F);
            if(container.RemainingWorkNumber<99)
                container.RemainingWorkNumber++;
        });
        minusButton = new GuiTransparentButton(this,getStartX()+108,getStartY()+63,21,6);
        minusButton.setClickedExecution(()->{
            Minecraft.getMinecraft().player.playSound(OCSounds.BTN_BACK, 0.5F, 1.0F);
            if(container.RemainingWorkNumber>1)
                container.RemainingWorkNumber--;
        });
        maximumButton = new GuiTransparentButton(this,getStartX()+130,getStartY()+16,12,6);
        maximumButton.setClickedExecution(()->{
            Minecraft.getMinecraft().player.playSound(OCSounds.BTN_BACK, 0.5F, 1.0F);
            container.RemainingWorkNumber=99;
        });
        minimumButton = new GuiTransparentButton(this,getStartX()+130,getStartY()+63,12,6);
        minimumButton.setClickedExecution(()->{
            Minecraft.getMinecraft().player.playSound(OCSounds.BTN_BACK, 0.5F, 1.0F);
            container.RemainingWorkNumber=1;
        });
    }
    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        super.mouseClicked(mouseX, mouseY, mouseButton);
        returnButton.parentClicked(mouseX,mouseY);
        plusButton.parentClicked(mouseX,mouseY);
        minusButton.parentClicked(mouseX,mouseY);
        maximumButton.parentClicked(mouseX,mouseY);
        minimumButton.parentClicked(mouseX,mouseY);
        OriginiumCraft.logger.warn(container.RemainingWorkNumber);
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
        if(container.InStackBanned[0])
            drawTexturedModalRect(getStartX()+24,getStartY()+30,180,111,20,20);
        if(container.InStackBanned[1])
            drawTexturedModalRect(getStartX()+51,getStartY()+30,180,111,20,20);
        if(container.InStackBanned[2])
            drawTexturedModalRect(getStartX()+79,getStartY()+30,180,111,20,20);
    }
    private void drawItemLeftNumber(int number){
        if(number<0||number>100)
            return;
        drawSingleNumber(number/10,0);
        drawSingleNumber(number%10,7);
    }
    private void drawSingleNumber(int number,int offset){
        if(number<0||number>9)
            return;
        int[] xOffsets = {0,3,1,0,0,0,0,0,0,0};
        int[] textureXOffsets = {220,229,232,239,245,220,227,234,241,248};
        int[] widths = {7,3,6,6,6,6,6,6,7,7};
        int textureYOffset = 0;
        int height = 9;
        if(number >= 5)
            textureYOffset = 21;
        drawTexturedModalRect(getStartX()+118+offset+xOffsets[number],getStartY()+32,textureXOffsets[number],textureYOffset,widths[number],height);

    }

    private void drawTimeLeftString(int seconds){
        if(seconds<0){
            drawCenteredString(fontRenderer, "--:--:--", getStartX() + 171, getStartY() + 58, 0xffffff);
            return;
        }
        int hour = seconds/3600;
        int minute = (seconds%3600) / 60;
        int second = (seconds%60);
        drawCenteredString(fontRenderer, String.format("%02d:%02d:%02d",hour,minute,second), getStartX() + 171, getStartY() + 58, 0xffffff);
    }

}
