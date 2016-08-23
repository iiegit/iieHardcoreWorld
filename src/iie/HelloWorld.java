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
			
			String playername = sender.getName(); 
			int deathtime = Integer.parseInt(plugin.deathMap.get(playername));
			long currentTime = System.currentTimeMillis();
			int timeInt = (int) currentTime;
			
			if (timeInt - deathtime >= 86400000){
				Player player = (Player) sender;
				World hardcoreWorld = player.getServer().getWorld("hardcore");
				Location location = new Location(hardcoreWorld, 1280, 71, -179);
				player.teleport(location);
			}else{
				sender.sendMessage("you are dead for the next" + ((86400000 - (timeInt - deathtime))/3600000) + "hours");
			}
			
		}else{
			
			sender.sendMessage("You must be a player to use this command!");
			
		}
		return false;
	}
	
}
