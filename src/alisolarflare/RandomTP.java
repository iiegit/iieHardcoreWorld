package alisolarflare;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;


public class RandomTP{
	//Randomly teleports a player, into the hardcore world
	public void rtp(Player player, World world, Location minLocation, Location maxLocation){
		
		
		//INIT - xDifference, xAverage
		int xdifference = minLocation.getBlockX() - maxLocation.getBlockX();
		int xAverage = (int) Math.floor(minLocation.getBlockX() + maxLocation.getBlockX() / 2);
		
		//INIT - zDifference, zAverage
		int zdifference = minLocation.getBlockX() - maxLocation.getBlockY();
		int zAverage = (int) Math.floor(minLocation.getBlockZ() + maxLocation.getBlockZ());
		
		//TELEPORTS - Tries 20 times to find a location
		for(int i = 0; i < 20; i ++){
			
			//INIT - attemptedX, attemptedZ
			int attemptedX = (int) Math.floor((Math.random()-0.5)*xdifference) + xAverage;
			int attemptedZ = (int) Math.floor((Math.random()-0.5)*zdifference) + zAverage;
			
			//CHECKS - if ground is safe
			boolean groundisSafe = world.getHighestBlockAt(attemptedX, attemptedZ).getType() != Material.WATER;
			if (groundisSafe){
				player.teleport(world.getHighestBlockAt(attemptedX, attemptedZ).getLocation());
				return;
			}
			
			//player.teleport(arg0)
		}
	}
}
