package iie;

import java.util.Objects;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathListener implements Listener {
	
	HelloWorldPlugin plugin;
	public DeathListener(HelloWorldPlugin plugin){
		this.plugin = plugin;
	}
	
	@EventHandler(priority = EventPriority.MONITOR)
	public void onHardcoreDeath(PlayerDeathEvent deathEvent){
		
		
		String timeString = String.valueOf(System.currentTimeMillis());
		Player player = deathEvent.getEntity();
		String playerString = (String) player.getName();
		Location location = player.getLocation();
		String worldString = (String) location.getWorld().getName();
		
		player.sendMessage(timeString);
		player.sendMessage(playerString);
		player.sendMessage(worldString);
		
		if (Objects.equals(worldString, "hardcore")){
				HelloWorldPlugin.deathMap.put(playerString, timeString);
				player.sendMessage(HelloWorldPlugin.deathMap.toString());
				
				player.sendMessage("Key saved: " + playerString);
				player.sendMessage("Data saved: " + HelloWorldPlugin.deathMap.get(playerString));
		}
		
	}
	
}
