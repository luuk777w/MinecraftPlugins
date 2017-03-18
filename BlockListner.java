package com.luuk777w;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockListner implements Listener{
	public BlockListner(AntiBlock plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event){
		
		Player player = event.getPlayer();
		
		if (!player.hasPermission("Build.Allowed")) {
			event.setCancelled(true);
			player.sendMessage(ChatColor.RED + "You are not allowed to place blocks" );
		}
	}
		
		
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event){
			
		Player player = event.getPlayer();
			
		if (!player.hasPermission("Build.Allowed")) {
				event.setCancelled(true);
				player.sendMessage(ChatColor.RED + "You are not allowed to mine block" );
		}	

		
	}
	
	

}
