package org.ctp.crashapi.nms.hotbar;

import org.bukkit.craftbukkit.v1_13_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_13_R2.ChatMessage;
import net.minecraft.server.v1_13_R2.ChatMessageType;
import net.minecraft.server.v1_13_R2.PacketPlayOutChat;
import net.minecraft.server.v1_13_R2.PlayerConnection;

public class Hotbar_v1_13_R2 {
	public static void sendHotBarMessage(Player player, String message) {
		try {
			// This creates the IChatComponentBase instance
			ChatMessage chatMessage = new ChatMessage(message, new Object[0]);
			// This creates the packet

			ChatMessageType type = ChatMessageType.values()[2];

			PacketPlayOutChat packet = new PacketPlayOutChat(chatMessage, type);
			// This casts the player to a craftplayer
			CraftPlayer cPlayer = (CraftPlayer) player;

			// This invokes the method above.

			PlayerConnection playerConnection = cPlayer.getHandle().playerConnection;
			// This gets the player's connection
			// This sends the packet.
			playerConnection.sendPacket(packet);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
