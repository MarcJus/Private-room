package fr.marcjus.room;

import java.util.ArrayList;
import java.util.Iterator;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.marcjus.room.listeners.Listeners;

public class Main extends JavaPlugin {
	
	public static Main instance;
	public ArrayList<String> personnel = new ArrayList<>();
	
	public static Main getInstance(){
		return instance;
	}
	
	@Override
	public void onEnable() {
		saveDefaultConfig();
		
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new Listeners(), this);
		
		for (String name : getConfig().getStringList("personnel")){
			personnel.add(name);
			Iterator<String> it = personnel.iterator();
			while(it.hasNext()){
				System.out.println(it.next());
			}
		}
	}
	
	public ArrayList<String> getPersonnel(){
		return personnel;
	}

}
