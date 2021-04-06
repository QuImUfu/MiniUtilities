package onelemonyboi.miniutilities.misc;

import net.minecraftforge.event.TickEvent;
import onelemonyboi.miniutilities.packets.KeyPressUpdate;
import onelemonyboi.miniutilities.packets.Packet;

public class KeyBindingsHandler {
    public static Boolean keyBindingPressed = false;
    public static void keybinds(TickEvent.PlayerTickEvent event) {
        if (event.player.world.isRemote && KeyBindings.blockInfo.isKeyDown()) {
            keyBindingPressed = true;
            Packet.INSTANCE.sendToServer(new KeyPressUpdate(keyBindingPressed));
        }
        else if (event.player.world.isRemote && !KeyBindings.blockInfo.isKeyDown()) {
            keyBindingPressed = false;
            Packet.INSTANCE.sendToServer(new KeyPressUpdate(keyBindingPressed));
        }
    }
}