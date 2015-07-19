package bl4ckscor3.plugin.secutilities.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener
{
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event)
	{
		if(AsyncPlayerChatListener.messages.containsKey(event.getPlayer().getName()))
			AsyncPlayerChatListener.messages.remove(event.getPlayer().getName());
	}
}
