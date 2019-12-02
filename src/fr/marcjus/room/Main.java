package fr.marcjus.room;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.marcjus.room.listeners.Listeners;

public class Main extends JavaPlugin {
	
	public static Main instance;
	
	public static Main getInstance(){
		return instance;
	}
	
	@Override
	public void onEnable() {
		saveDefaultConfig();
		
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new Listeners(), this);
		
		for (String name : getConfig().getStringList("personnel")){
			System.out.println(name);
		}
	}
}
