package com.github.zacgamingpro1234.packtils.config;

import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.annotations.Switch;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;
import cc.polyfrost.oneconfig.config.data.OptionSize;

public class PacktilsConfig extends Config {
    @Switch(
            name = "Warn The User If Optifine Is NOT Installed",
            size = OptionSize.SINGLE
    )
    public static boolean Optiwarn = true;

    @Switch(
            name = "Ignore All UI Pop-ups",
            size = OptionSize.SINGLE
    )
    public static boolean ignui = false;

    public PacktilsConfig() {
        // Available mod types: PVP, HUD, UTIL_QOL, HYPIXEL, SKYBLOCK
        super(new Mod("Packtils", ModType.UTIL_QOL, "/Assets/logo.png"), "PacktilsConfig.json");
        initialize();
    }
}