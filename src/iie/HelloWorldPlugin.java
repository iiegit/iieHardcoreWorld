package iie;

import java.util.AbstractMap;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import alisolarflare.RandomTP;

public class HelloWorldPlugin extends JavaPlugin {

	public static Scoreboard board;
	public static Objective hardcoreTimeDead;
	public static AbstractMap<String, String> deathMap = new HashMap<String, String>();

	public void onEnable() {
		registerCommands();
		getServer().getPluginManager().registerEvents(new DeathListener(this), this);
		board = Bukkit.getServer().getScoreboardManager().getMainScoreboard();
		if (board.getObjective("hardcoreTimeDead") == null)
			hardcoreTimeDead = board.registerNewObjective("hardcoreTimeDead", "dummy");
	}

	public void registerCommands() {
		getCommand("HelloWorld").setExecutor(new HelloWorld(this));
		getCommand("debugRTP").setExecutor(new RandomTP(this));
	}

}
