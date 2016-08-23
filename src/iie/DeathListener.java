package iie;

import java.time.Clock;
import java.time.LocalDateTime;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathListener implements Listener {
	
	HelloWorldPlugin plugin;
	public DeathListener(HelloWorldPlugin plugin){
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onHardcoreDeath(PlayerDeathEvent deathEvent){
		
		
		LocalDateTime currentTime = LocalDateTime.now(Clock.systemUTC());
		String timeString = currentTime.toString();
		Player player = deathEvent.getEntity();
		String playerString = (String) player.getName();
		Location location = player.getLocation();
		String worldString = (String) location.getWorld().getName();
		
		
		if (worldString == "hardcore"){
				plugin.deathMap.put(playerString, timeString);
		}
		
	}
	
}
