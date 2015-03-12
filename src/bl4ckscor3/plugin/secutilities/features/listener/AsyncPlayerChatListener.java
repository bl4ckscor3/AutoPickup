package bl4ckscor3.plugin.secutilities.features.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class AsyncPlayerChatListener implements Listener
{
	@EventHandler
	public void onAsyncPlayerChat(AsyncPlayerChatEvent event)
	{
		if(event.getMessage().startsWith("./"))
			event.setMessage(event.getMessage().substring(1));
	}
}
