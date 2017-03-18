package com.luuk777w;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class AntiBlock extends JavaPlugin {
	
	public Permission playerPermission = new Permission("Build.Allowed");
	
	@Override
	public void onEnable() {
		new BlockListner(this);
		PluginManager pm = getServer().getPluginManager();
		pm.addPermission(playerPermission);
		
		
	}
	
	@Override
    public void onDisable() {
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("stuff") && sender instanceof Player) {
			
			Player player = (Player) sender;
			
			if(player.hasPermission("Build.Allowed")) {
				player.setItemInHand(new ItemStack(Material.DIAMOND));
			}
			
			return true;
		}
		
		return false;
	}
	

}
