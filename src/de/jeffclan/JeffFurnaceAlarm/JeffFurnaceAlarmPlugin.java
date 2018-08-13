package de.jeffclan.JeffFurnaceAlarm;

import org.bukkit.plugin.java.JavaPlugin;

public class JeffFurnaceAlarmPlugin extends JavaPlugin {

	JeffFurnaceAlarmMessages messages;

	@Override
	public void onEnable() {
		createConfig();
		messages = new JeffFurnaceAlarmMessages(this);
		getServer().getPluginManager().registerEvents(new JeffFurnaceAlarmListener(this), this);
		
		@SuppressWarnings("unused")
		Metrics metrics = new Metrics(this);
		
	}
	
	void createConfig() {
		this.saveDefaultConfig();
		
		getConfig().addDefault("message-when-using-chest","&7Hint: Type &6/chestsort&7 to enable automatic chest sorting.");
		getConfig().addDefault("message-when-using-chest2","&7Hint: Type &6/chestsort&7 to disable automatic chest sorting.");
		getConfig().addDefault("message-sorting-disabled","&7Automatic chest sorting has been &cdisabled&7.&r");
		getConfig().addDefault("message-sorting-enabled","&7Automatic chest sorting has been &aenabled&7.&r");
		getConfig().addDefault("message-error-players-only","&cError: This command can only be run by players.&r");
	}

}
