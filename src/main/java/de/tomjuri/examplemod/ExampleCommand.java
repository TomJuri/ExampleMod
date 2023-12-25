package de.tomjuri.examplemod;

import cc.polyfrost.oneconfig.utils.commands.annotations.Command;
import cc.polyfrost.oneconfig.utils.commands.annotations.Main;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;

@Command(value = "examplecommand")
public class ExampleCommand {

    @Main
    private void main() {
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§c" + ExampleModConfig.exampleText));
    }
}
