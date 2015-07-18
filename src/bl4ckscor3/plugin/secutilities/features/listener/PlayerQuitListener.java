package bl4ckscor3.plugin.secutilities.features.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import bl4ckscor3.plugin.secutilities.features.commands.Join;

public class PlayerQuitListener implements Listener
{
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event)
	{
		if(AsyncPlayerChatListener.messages.containsKey(event.getPlayer().getName()))
			AsyncPlayerChatListener.messages.remove(event.getPlayer().getName());
		
		if(event.getPlayer().getName().equals("Vauff"))
		{
			if(!Join.hasJoined)
				event.setQuitMessage(null);
			else
				Join.hasJoined = false;
		}
	}
}
