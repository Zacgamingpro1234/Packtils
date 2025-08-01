package com.github.zacgamingpro1234.packtils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;

import static com.github.zacgamingpro1234.packtils.config.PacktilsConfig.ignui;

public class UIHandler extends GuiScreen {
    final String line1 = "Seems Like You Don't Have Optifine Installed";
    final String line2 = "The Creator Of This Modpack Wants You To Install Optifine";
    final int clr = 0x7F000000;

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        ScaledResolution sr = new ScaledResolution(mc);
        int screenWidth = sr.getScaledWidth();
        int screenHeight = sr.getScaledHeight();
        int boxWidth = (int) (screenWidth / 1.3f);
        int boxHeight = (int) (screenHeight / 1.3f);
        int boxX = (screenWidth - boxWidth) / 2;
        int boxY = (screenHeight - boxHeight) / 2;
        drawGradientRect(boxX, boxY, boxX + boxWidth, boxY + boxHeight,
                clr, clr); // semi-transparent black
        FontRenderer fr = mc.fontRendererObj;
        drawCenteredString(fr, line1, screenWidth / 2, boxY + 10, 0xFFFFFF);
        drawCenteredString(fr, line2, screenWidth / 2, boxY + 30, 0xCCCCCC);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public void initGui(){
        createbut();
    }

    @Override
    public void onResize(Minecraft mcIn, int w, int h) {
        this.setWorldAndResolution(mcIn, w, h);
        this.buttonList.clear();
        createbut();
    }

    private void createbut(){
        this.buttonList.add(new GuiButton(
                1,               // ID
                (int) ((this.width / 2.4) - ((double) 100 / 2)),   // X position
                (int) (this.height/1.8),   // Y position
                100, 20,              // Width, Height
                "Nah, I Don't need it, my gaming chair gives me enough fps"       // Text
        ));
        this.buttonList.add(new GuiButton(
                2,               // ID
                (int) ((this.width / 1.6) - ((double) 100 / 2)),   // X position
                (int) (this.height/1.8),   // Y position
                100, 20,              // Width, Height
                "Yes ples my pc is ass"       // Text
        ));
    }

    @Override
    protected void actionPerformed(GuiButton button){
        if (button.id == 1) {
            Minecraft.getMinecraft().displayGuiScreen(null);
            ignui = true;
        }
        if (button.id == 2) {
            new OptiInstaller();
        }
    }
}