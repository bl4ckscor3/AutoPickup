package bl4ckscor3.plugin.secutilities.features.listener.timedisplayer;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import bl4ckscor3.plugin.secutilities.features.TimeDisplayer;

public class TDPlayerQuitListener implements Listener
{
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event)
	{
		TimeDisplayer.stop(event.getPlayer());
	}
}
