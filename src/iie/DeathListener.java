package iie;

import java.util.Objects;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.Score;

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
		
		//player.sendMessage(timeString);
		//player.sendMessage(playerString);
		//player.sendMessage(worldString);
		
		if (Objects.equals(worldString, "hardcore")){
				HelloWorldPlugin.deathMap.put(playerString, timeString);
				Score score = HelloWorldPlugin.hardcoreTimeDead.getScore(playerString);
				score.setScore((int) (System.currentTimeMillis()/1000));
				
				//player.sendMessage(HelloWorldPlugin.deathMap.toString());
				//player.sendMessage("Key saved: " + playerString);
				//player.sendMessage("Data saved: " + HelloWorldPlugin.deathMap.get(playerString));
		}
		
	}
	
	@EventHandler(priority = EventPriority.MONITOR)
	public void onPlayerLogin(PlayerJoinEvent joinEvent){
		
		
		
		Player player = joinEvent.getPlayer();
		String playerString = (String) player.getName();
		Score score = null;
		
		
		
		try{
			score = HelloWorldPlugin.hardcoreTimeDead.getScore(playerString);
		}catch(IllegalArgumentException throwable){
			score.setScore(0);
		}
		
		
		
		if (HelloWorldPlugin.deathMap.get(playerString) == null && score.getScore() != 0){
			HelloWorldPlugin.deathMap.put(playerString, String.valueOf((score.getScore()) * 1000));
		}
		
	}
	
}
