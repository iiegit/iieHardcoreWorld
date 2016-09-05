package iie;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {
	
	HelloWorldPlugin plugin;
	public JoinListener(HelloWorldPlugin plugin){
		this.plugin = plugin;
	}
	
	@EventHandler(priority = EventPriority.MONITOR)
	public void onPlayerJoin(PlayerJoinEvent JoinEvent){
		
		
		Player player = JoinEvent.getPlayer();
		String playername = (String) player.getName();
				
		
		if (HelloWorldPlugin.hardcoreTimeDead.getScore(playername) == null)       //null check 
			HelloWorldPlugin.hardcoreTimeDead.getScore(playername).setScore(0);   //convert null to 0
		
		
		//HelloWorldPlugin.deathMap.put(playername, String.valueOf(HelloWorldPlugin.hardcoreTimeDead.getScore(playername).getScore()));
		
		
	}
	
}
