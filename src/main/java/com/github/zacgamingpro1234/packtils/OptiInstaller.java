package com.github.zacgamingpro1234.packtils;

import net.minecraft.client.Minecraft;
import static com.github.zacgamingpro1234.packtils.Packtils.*;
import java.awt.*;
import java.io.File;
import java.net.URI;
import java.nio.file.Path;

public class OptiInstaller {
    Minecraft getmc = Minecraft.getMinecraft();
    OptiInstaller() {
        try {
            Path mcDir = getmc.mcDataDir.toPath();
            Path modsPath = mcDir.resolve("mods");
            File modsFolder = modsPath.toFile();
            URI optifineLink = new URI("http://optifine.net/adloadx?f=OptiFine_1.8.9_HD_U_M5.jar");
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(optifineLink);
                if (modsFolder.exists()){
                    Desktop.getDesktop().open(modsFolder);
                }
            }
            getmc.shutdown();
        } catch (Exception e) {
           LOGGER.info(e);
        }
    }
}
