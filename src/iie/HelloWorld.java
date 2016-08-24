package iie;

import org.bukkit.Location;
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
		// TODO Auto-generated method stub

		sender.sendMessage("WELL, AT LEAST THIS WORKS");
		if (sender instanceof Player){
			
			sender.sendMessage("sender IS instanceof Player");
			
			long currentTime = System.currentTimeMillis();
			String playername = sender.getName();
			long deathTime = 0;
			
			if (plugin.deathMap.get(playername) != null){
				
				deathTime = Long.parseLong(plugin.deathMap.get(playername));
			
			}else{
				
				sender.sendMessage("you have never died in hardcore");
				
				Player player = (Player) sender;
				World hardcoreWorld = player.getServer().getWorld("hardcore");
				Location location = new Location(hardcoreWorld, 1280, 71, -179);
				player.teleport(location);				
			}
					
			sender.sendMessage(playername);
			sender.sendMessage(String.valueOf(deathTime));
			sender.sendMessage(String.valueOf(currentTime));
			
			if (currentTime - deathTime >= 86400000){
				
				sender.sendMessage("more than 24 hours have passed since you died in hardcore last");
				
				Player player = (Player) sender;
				World hardcoreWorld = player.getServer().getWorld("hardcore");
				Location location = new Location(hardcoreWorld, 1280, 71, -179);
				player.teleport(location);

			}else{
				sender.sendMessage("you are dead for the next " + (86400000 - (currentTime - deathTime) ) /3600000 + " hours");
			}
			
		}else{
			
			sender.sendMessage("You must be a player to use this command!");
			
		}
		return false;
	}
	
}
