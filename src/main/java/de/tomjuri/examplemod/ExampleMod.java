package de.tomjuri.examplemod;

import cc.polyfrost.oneconfig.utils.commands.CommandManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = "examplemod", name = "Example Mod", version = "%%VERSION%%")
public class ExampleMod {

    private static ExampleMod instance;

    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event) {
        new ExampleModConfig();
        instance = this;
        CommandManager.register(new ExampleCommand());
        System.out.println("Hello from ExampleMod!");
    }

    public static ExampleMod getInstance() {
        return instance;
    }
}
