package com.github.zacgamingpro1234.packtils.config;

import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.annotations.Button;
import cc.polyfrost.oneconfig.config.annotations.Switch;
import cc.polyfrost.oneconfig.config.annotations.Text;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;
import org.lwjgl.opengl.Display;

public class PacktilsConfig extends Config {
    @Switch(
            name = "Warn The User If Optifine Is NOT Installed"
    )
    public static boolean Optiwarn = true;

    @Switch(
            name = "Ignore All UI Pop-ups"
    )
    public static boolean ignui = false;

    @Text(
            name = "Custom Title",
            placeholder = "Minecraft 1.8.9"        // optional, text to display when there is nothing written there
    )
    public static String title = "Minecraft 1.8.9";

    @Button(
            name = "Update Title",    // name beside the button
            text = "Update"        // text on the button itself
    )
    Runnable runnable = () -> Display.setTitle(title);

    public PacktilsConfig() {
        // Available mod types: PVP, HUD, UTIL_QOL, HYPIXEL, SKYBLOCK
        super(new Mod("Packtils", ModType.UTIL_QOL, "/Assets/logo.png"), "PacktilsConfig.json");
        initialize();
    }
}