package fr.marcjus.room.listeners;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import fr.marcjus.room.Room;

public class Listeners implements Listener {

	private Room main;

	public Listeners(Room main) {
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

	@EventHandler
	public void onPressurePlate(PlayerInteractEvent e) {
		Player player = e.getPlayer();
		Action action = e.getAction();
		if (action.equals(Action.PHYSICAL)) {
			if (e.getClickedBlock().getType().equals(Material.STONE_PLATE)) {
				Block block = e.getClickedBlock();
				World world = Bukkit.getWorld("world");
				ArrayList<Location> locs = new ArrayList<>();
				locs.add(new Location(world, -380, 69, 389));
				locs.add(new Location(world, -373, 64, 373));
				locs.add(new Location(world, -373, 64, 372));
				locs.add(new Location(world, -382, 60, 398));
				Location blockLoc = block.getLocation();
				for (Location loc : locs) {
					if (blockLoc.getX() == loc.getX() && blockLoc.getY() == loc.getY()
							&& blockLoc.getZ() == loc.getZ()) {
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

}
