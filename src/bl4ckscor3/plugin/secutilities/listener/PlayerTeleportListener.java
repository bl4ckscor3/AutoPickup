package bl4ckscor3.plugin.secutilities.listener;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

import bl4ckscor3.plugin.secutilities.event.WorldJoinEvent;

public class PlayerTeleportListener implements Listener
{
	@EventHandler
	public void onPlayerTeleport(PlayerTeleportEvent event)
	{
		if(!event.getFrom().getWorld().getName().equals(event.getTo().getWorld().getName()))
			Bukkit.getServer().getPluginManager().callEvent(new WorldJoinEvent(event.getPlayer(), event.getTo().getWorld()));
	}
}
