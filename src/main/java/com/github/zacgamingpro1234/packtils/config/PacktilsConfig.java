package com.github.zacgamingpro1234.packtils.config;


import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;

public class PacktilsConfig extends Config {

    public PacktilsConfig() {
        // Available mod types: PVP, HUD, UTIL_QOL, HYPIXEL, SKYBLOCK
        super(new Mod("Packtils", ModType.UTIL_QOL, "/Assets/logo.png"), "PacktilsConfig.json");
        initialize();
    }
}