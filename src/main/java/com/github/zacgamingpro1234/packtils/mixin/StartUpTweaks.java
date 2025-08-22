package com.github.zacgamingpro1234.packtils.mixin;

import com.github.zacgamingpro1234.packtils.config.PacktilsConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.DefaultResourcePack;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.opengl.Display;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import static com.github.zacgamingpro1234.packtils.config.PacktilsConfig.title;

@Mixin(Minecraft.class)
public class StartUpTweaks {
    @Unique
    public PacktilsConfig packtils$config;
    @Redirect(
            method = "createDisplay",
            at = @At(
                    value = "INVOKE",
                    target = "Lorg/lwjgl/opengl/Display;setTitle(Ljava/lang/String;)V",
                    remap = false
            )
    )
    private void afterVanillaTitle(String newTitle) {
        packtils$config = new PacktilsConfig(); // Registers Our Config
        Display.setTitle(title); // Applies Title
    }

    @Redirect(
            method = "setWindowIcon",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/resources/DefaultResourcePack;getInputStreamAssets(Lnet/minecraft/util/ResourceLocation;)Ljava/io/InputStream;"
            )
    )
    private InputStream replaceIcon(DefaultResourcePack pack, @NotNull ResourceLocation location) throws IOException {
        File gameDir = Minecraft.getMinecraft().mcDataDir; // instance root
        if (location.getResourcePath().equals("icons/icon_16x16.png")) {
            File icon16 = new File(gameDir, "resources/assets/packtils/icon_16.png");
            if (icon16.exists()) return Files.newInputStream(icon16.toPath());
        }

        if (location.getResourcePath().equals("icons/icon_32x32.png")) {
            File icon32 = new File(gameDir, "resources/assets/packtils/icon_32.png");
            if (icon32.exists()) return Files.newInputStream(icon32.toPath());
        }

        // Fallback to vanilla if custom files are missing
        return pack.getInputStreamAssets(location);
    }

}
