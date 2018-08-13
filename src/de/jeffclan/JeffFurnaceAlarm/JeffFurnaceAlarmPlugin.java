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
	}

}
