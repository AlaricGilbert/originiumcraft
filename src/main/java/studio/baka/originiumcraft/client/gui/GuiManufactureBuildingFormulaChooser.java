package studio.baka.originiumcraft.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import studio.baka.originiumcraft.OriginiumCraft;

import java.io.IOException;

public class GuiManufactureBuildingFormulaChooser extends GuiScreen {
    private ItemStack formula;
    private EntityPlayer player;
    private GuiButton returnButton;
    private int guiWidth = 206;
    private int guiHeight = 111;


    int getStartX(){
        return (width-guiWidth)/2;
    }
    int getStartY(){ return (height-guiHeight)/2; }
    public GuiManufactureBuildingFormulaChooser(ItemStack foreFormula,EntityPlayer player){
        formula = foreFormula;
        this.player = player;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
        drawDefaultBackground();
        GlStateManager.pushMatrix();
        {

            GlStateManager.color(1, 1, 1, 1);
            Minecraft.getMinecraft().renderEngine.bindTexture(OCGuiResources.GUI_MANU);
            drawTexturedModalRect(getStartX(), getStartY(), 0, 145, guiWidth, guiHeight);
            returnButton.draw(mouseX,mouseY);
        }
        GlStateManager.popMatrix();
    }


    @Override
    public void initGui() {
        super.initGui();
        returnButton = new GuiReturnButton(this,getStartX(),getStartY(),()->{
            int id = GuiElementManager.registerGuiInteractResourceObject(formula);
            player.openGui(OriginiumCraft.instance, GuiElementManager.GUI_MANUFACTURE_BUILDING,player.world, GuiElementManager.OPEN_GUI_INTERACT,id,0);
        });
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        super.mouseClicked(mouseX, mouseY, mouseButton);
        returnButton.parentClicked(mouseX,mouseY);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}
