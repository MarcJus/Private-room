package fr.marcjus.room.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class Listeners implements Listener {
	
	@EventHandler
	public void onClickButton(PlayerInteractEvent e){
		Player player = e.getPlayer();
		Action action = e.getAction();
		if(action.equals(Action.RIGHT_CLICK_BLOCK)){
			Block block = e.getClickedBlock();
			if(block.getType().equals(Material.STONE_BUTTON)){
				if(block.getLocation().equals(new Location(Bukkit.getWorld("world"), -380, 70, 388))){
					if(!player.isOp()){
						e.setCancelled(true);
						player.sendMessage(ChatColor.DARK_RED+"Vous n'avez pas accés a cette porte ! ");
					}
				}
			}
		}
		
	}

}
