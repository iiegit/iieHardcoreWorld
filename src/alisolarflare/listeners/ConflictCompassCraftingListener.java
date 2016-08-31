package alisolarflare.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;

public class ConflictCompassCraftingListener implements Listener{
	
	@EventHandler
	public boolean onConflictCompassCraft(CraftItemEvent event){
		
		return false;
	}
}
