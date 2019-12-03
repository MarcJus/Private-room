package fr.marcjus.room.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import fr.marcjus.room.Main;

public class Listeners implements Listener {

	private Main main;

	public Listeners(Main main) {
		this.main = main;
	}

	@EventHandler
	public void onClickButton(PlayerInteractEvent e) {
		Player player = e.getPlayer();
		Action action = e.getAction();
		if (action.equals(Action.RIGHT_CLICK_BLOCK)) {
			Block block = e.getClickedBlock();
			if (block.getType().equals(Material.STONE_BUTTON)) {
				if (block.getLocation().equals(new Location(Bukkit.getWorld("world"), -380, 70, 388))) {
					if (main.getPersonnel().contains(player.getName())) {
						player.sendMessage(main.getConfig().getString("messages.allow").replace('&', '§'));
					} else {
						e.setCancelled(true);
						player.sendMessage(main.getConfig().getString("messages.deny").replace('&', '§'));
					}
				}
			}
		}

	}

}
