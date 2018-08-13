package de.jeffclan.JeffFurnaceAlarm;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class JeffFurnaceAlarmListener implements Listener {

	JeffFurnaceAlarmPlugin plugin;

	JeffFurnaceAlarmListener(JeffFurnaceAlarmPlugin plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onFurnaceSmelt(FurnaceSmeltEvent event) {
		Location furnaceLocation = event.getBlock().getLocation();
		Block furnaceBlock = event.getBlock();

		if (furnaceBlock.getState() instanceof InventoryHolder) {
			InventoryHolder invholder = (InventoryHolder) furnaceBlock.getState();
			Inventory inventory = invholder.getInventory();

			if (inventory.getItem(0).getAmount() == 1) {

				for (Player p : plugin.getServer().getOnlinePlayers()) {
					if (p.getLocation().distance(furnaceLocation) < plugin.getConfig().getInt("max-distance", 20))
						;
					{
						p.sendMessage(
								String.format(plugin.messages.MSG_FURNACE_READY, event.getSource().getType().name()));
					}
				}
			}
		}
	}
}
