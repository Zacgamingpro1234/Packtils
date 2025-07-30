package com.github.zacgamingpro1234.packtils;

import cc.polyfrost.oneconfig.events.EventManager;
import cc.polyfrost.oneconfig.events.event.InitializationEvent;
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe;
import com.github.zacgamingpro1234.packtils.config.PacktilsConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = Packtils.MODID, name = Packtils.NAME, version = Packtils.VERSION)
public class Packtils {
    public static final String MODID = "@ID@";
    public static final String NAME = "@NAME@";
    public static final String VERSION = "@VER@";
    public PacktilsConfig config;

    /// /////////////////////////////////////////MISC////////////////////////////////////////
    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        EventManager.INSTANCE.register(this); //Registers Us To The EventBus
    }

    @Subscribe
    public void onInit(InitializationEvent event) {
        config = new PacktilsConfig(); //Makes The Config Work In-Game
    }

}