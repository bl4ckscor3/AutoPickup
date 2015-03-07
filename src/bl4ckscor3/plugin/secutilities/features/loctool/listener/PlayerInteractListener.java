package bl4ckscor3.plugin.secutilities.features.loctool.listener;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class PlayerInteractListener implements Listener
{
	private static Plugin plugin;
	
	public PlayerInteractListener(Plugin pl)
	{
		plugin = pl;
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event)
	{
		if(event.getAction() == Action.LEFT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_BLOCK)
		{
			ItemStack hand = event.getPlayer().getItemInHand();
			
			if(hand.getType() == Material.PAPER && hand.getItemMeta().getDisplayName().equals("Location Tool"))
			{
				Location l = event.getClickedBlock().getLocation();
				
				event.getPlayer().sendMessage("[" + ChatColor.BLUE + plugin.getDescription().getName() + ChatColor.RESET + "] x: " + l.getBlockX() + " y: " + l.getBlockY() + " z: " + l.getBlockZ());
			}
		}
	}
}
