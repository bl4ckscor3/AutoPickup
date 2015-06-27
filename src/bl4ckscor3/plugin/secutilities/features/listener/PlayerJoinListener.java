package bl4ckscor3.plugin.secutilities.features.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener
{
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event)
	{
		if(event.getPlayer().getUniqueId().equals("09a3a2b3-77d3-408f-bff2-9a54e76733a9"))
			event.setJoinMessage("");
	}
}
