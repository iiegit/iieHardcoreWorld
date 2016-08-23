package iie;

import java.util.AbstractMap;
import java.util.HashMap;

import org.bukkit.plugin.java.JavaPlugin;

public class HelloWorldPlugin extends JavaPlugin {
	public AbstractMap<String,String> deathMap = new HashMap<String,String>();
	public void onEnable(){
		registerCommands();
		getServer().getPluginManager().registerEvents(new DeathListener(this), this);
	}
	public void registerCommands(){
		getCommand("HelloWorld").setExecutor(new HelloWorld(this));
	}

}
