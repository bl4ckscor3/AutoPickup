package bl4ckscor3.plugin.secutilities.features.pvplimit.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import bl4ckscor3.plugin.secutilities.features.pvplimit.PvPLimit;

public class PlayerQuitListener implements Listener
{
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event)
	{
		if(PvPLimit.getPlayersWithinPvP().contains(event.getPlayer().getName()))
			PvPLimit.removePlayer(event.getPlayer().getName());
	}
}
