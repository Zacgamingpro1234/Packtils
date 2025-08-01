package com.github.zacgamingpro1234.packtils;

import cc.polyfrost.oneconfig.events.EventManager;
import cc.polyfrost.oneconfig.events.event.InitializationEvent;
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe;
import com.github.zacgamingpro1234.packtils.config.PacktilsConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventBus;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static com.github.zacgamingpro1234.packtils.config.PacktilsConfig.Optiwarn;
import static com.github.zacgamingpro1234.packtils.config.PacktilsConfig.ignui;

@Mod(modid = Packtils.MODID, name = Packtils.NAME, version = Packtils.VERSION)
public class Packtils {
    public static final String MODID = "@ID@";
    public static final String NAME = "@NAME@";
    public static final String VERSION = "@VER@";
    public PacktilsConfig config;
    public static volatile boolean hasopti = false;
    private static final EventBus TheBus = MinecraftForge.EVENT_BUS;
    public static final Logger LOGGER = LogManager.getLogger("packtils");

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        TheBus.register(new Object(){
            @SubscribeEvent
            public void onClientTick(TickEvent.ClientTickEvent event) {
                if (!hasopti && !ignui && Optiwarn){
                    if (Minecraft.getMinecraft().currentScreen instanceof GuiMainMenu) {
                        Minecraft.getMinecraft().displayGuiScreen(new UIHandler());
                        TheBus.unregister(this);
                    }
                }else{
                    TheBus.unregister(this);
                }
            }
        });
        EventManager.INSTANCE.register(this); //Registers Us To The EventBus
    }

    @Subscribe
    public void onInit(InitializationEvent event) {
        config = new PacktilsConfig(); //Makes The Config Work In-Game
        if (Optiwarn){
            new Thread(() -> {
                try {
                    Class.forName("optifine.OptiFineForgeTweaker");
                    hasopti = true;
                } catch (ClassNotFoundException e) {
                    hasopti = false;
                }
            }).start();
        }
    }
}