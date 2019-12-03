package fr.marcjus.room;

import java.util.ArrayList;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.marcjus.room.listeners.Listeners;

public class Main extends JavaPlugin {

	private ArrayList<String> personnel = new ArrayList<>();

	@Override
	public void onEnable() {
		saveDefaultConfig();

		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new Listeners(this), this);

		for (String name : getConfig().getStringList("personnel")) {
			System.out.println(name);
			personnel.add(name);
		}
	}

	public ArrayList<String> getPersonnel() {
		return personnel;
	}
}
