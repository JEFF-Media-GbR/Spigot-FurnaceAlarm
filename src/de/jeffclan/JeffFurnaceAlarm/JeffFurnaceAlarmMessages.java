package de.jeffclan.JeffFurnaceAlarm;

import org.bukkit.ChatColor;

public class JeffFurnaceAlarmMessages {

	JeffFurnaceAlarmPlugin plugin;

	final String MSG_FURNACE_READY;

	JeffFurnaceAlarmMessages(JeffFurnaceAlarmPlugin plugin) {
		this.plugin = plugin;

		MSG_FURNACE_READY = ChatColor.translateAlternateColorCodes('&',
				plugin.getConfig().getString("message-furnace-ready"));
	}

}
