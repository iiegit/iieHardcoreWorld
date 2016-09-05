package iie;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class HelloWorld implements CommandExecutor {
	
	HelloWorldPlugin plugin;
	public HelloWorld(HelloWorldPlugin plugin){
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command label, String command, String[] args) {
		
		
		
		
		if (sender instanceof Player){
			
			Player player = (Player) sender;
			String playername = sender.getName();
			
			World hardcoreWorld = player.getServer().getWorld("hardcore");
			Location location = new Location(hardcoreWorld, 1280, 71, -179);

			int currentTime = (int) ((System.currentTimeMillis())/1000);
			int deathTime = 0;
						
			if (HelloWorldPlugin.hardcoreTimeDead.getScore(playername) != null)					//null check - if score exists
				deathTime = HelloWorldPlugin.hardcoreTimeDead.getScore(playername).getScore();  //set deathTime to that score
			
			
			
							
			if (currentTime - deathTime >= 86400 && deathTime != 0){				
				sender.sendMessage("You died " + (86400 - (currentTime - deathTime)) /3600 + " hours ago. Ready to give it another shot?");				
				player.teleport(location);
				// player.getWorld().playSound(player.getLocation(), Sound.AMBIENT_CAVE,0,0); I don't think this works, fix later
			}else if(deathTime == 0){		
				sender.sendMessage("You have never died in hardcore. Good luck!");				
				player.teleport(location);
				// player.getWorld().playSound(player.getLocation(), Sound.AMBIENT_CAVE,0,0); I don't think this works, fix later
			}else{
				sender.sendMessage("you are dead for the next " + (86400 - (currentTime - deathTime) ) /3600 + " hours");
				// player.getWorld().playSound(player.getLocation(), Sound.AMBIENT_CAVE,0,0); I don't think this works, fix later
				// replace sound with some other sound
			}
			
			
			
		}else{			
			sender.sendMessage("You must be a player to use this command!");			
		}
		
		
		
		return false;
	}
	
}
