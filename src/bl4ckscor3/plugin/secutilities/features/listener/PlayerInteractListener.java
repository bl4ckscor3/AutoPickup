package bl4ckscor3.plugin.secutilities.features.listener;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import bl4ckscor3.plugin.bl4ckkitCore.core.bl4ckkitCore;

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

			if(hand.getType() == Material.PAPER && hand.getItemMeta().getLore().get(0).equals("Location Tool"))
			{
				Location l = event.getClickedBlock().getLocation();
				
				bl4ckkitCore.getMessageManager().sendChatMessage(event.getPlayer(), plugin, "x: " + l.getBlockX() + " y: " + l.getBlockY() + " z: " + l.getBlockZ());
				event.setCancelled(true);
			}
		}
	}
}
