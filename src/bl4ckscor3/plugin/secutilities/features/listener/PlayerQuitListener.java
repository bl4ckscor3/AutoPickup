package bl4ckscor3.plugin.secutilities.features.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;

import bl4ckscor3.plugin.bl4ckkitCore.core.bl4ckkitCore;
import bl4ckscor3.plugin.secutilities.features.commands.Join;

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
		if(AsyncPlayerChatListener.messages.containsKey(event.getPlayer().getName()))
			AsyncPlayerChatListener.messages.remove(event.getPlayer().getName());
		
		if(event.getPlayer().getName().equals("Vauff"))
		{
			if(!Join.hasJoined)
			{
				event.setQuitMessage(null);
				
				for(Player p : Bukkit.getOnlinePlayers())
				{
					if(PlayerJoinListener.names.contains(p.getName()))
						bl4ckkitCore.getMessageManager().sendChatMessage(p, plugin, "Vauff silently left.");
				}
			}
			else
				Join.hasJoined = false;
		}
	}
}
