package bl4ckscor3.plugin.secutilities.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;

import bl4ckscor3.plugin.secutilities.commands.MaxPlayers;

public class PlayerQuitListener implements Listener
{
	private static Plugin plugin;

	public PlayerQuitListener(Plugin pl)
	{
		plugin = pl;
	}
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event)
	{
		MaxPlayers.decrease(plugin);
		
		if(AsyncPlayerChatListener.messages.containsKey(event.getPlayer().getName()))
			AsyncPlayerChatListener.messages.remove(event.getPlayer().getName());
	}
}
