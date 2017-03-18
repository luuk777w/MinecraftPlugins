package com.luuk777w;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class RandomTP extends JavaPlugin {
	
	@Override
	public void onEnable() {
		
	}
	
	@Override
    public void onDisable() {
		
	}
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("randomtp") && sender instanceof Player) {
			Player player = (Player) sender;
			
			
			
			Location originalLocation = player.getLocation();
			
			Random random = new Random();
			
			Location teleportlocation = null;
			
			int x = random.nextInt(5000) + 100;
			int y = 150;
			int z = random.nextInt(5000) + 100;
			
			boolean isOnland = false;
			
			while (isOnland == false) {
			
				teleportlocation = new Location(player.getWorld(), x, y, z);
				
				if (teleportlocation.getBlock().getType() != Material.AIR) {
					    isOnland = true;
				} else y--;
			}
			
			
			
			player.teleport(new Location(player.getWorld(), teleportlocation.getX(), teleportlocation.getY() + 1, teleportlocation.getZ()));
			
			player.sendMessage(ChatColor.GREEN + "You have been teleported " + (int)teleportlocation.distance(originalLocation) + " blocks away!");
			
			
				}
	
			
		{
			
			
			return true;
		}
	}
	

}
