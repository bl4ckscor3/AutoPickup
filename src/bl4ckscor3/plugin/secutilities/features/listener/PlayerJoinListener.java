package bl4ckscor3.plugin.secutilities.features.listener;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener
{
	public void onPlayerJoin(PlayerJoinEvent event)
	{
		Bukkit.dispatchCommand(event.getPlayer(), "players");
	}
}
