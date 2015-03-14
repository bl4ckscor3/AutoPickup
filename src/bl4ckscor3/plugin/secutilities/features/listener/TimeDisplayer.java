package bl4ckscor3.plugin.secutilities.features.listener;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class TimeDisplayer implements Listener
{
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerJoin(PlayerJoinEvent event) 
	{
		Bukkit.dispatchCommand(event.getPlayer(), "playtimetop 10");
	}
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onCommandPreprocess(PlayerCommandPreprocessEvent event) 
	{
		if (event.getMessage().equalsIgnoreCase("/playtimetop")) 
		{
			event.setCancelled(true);
			Bukkit.dispatchCommand(event.getPlayer(), "playtimetop 10");
		}
	}
}