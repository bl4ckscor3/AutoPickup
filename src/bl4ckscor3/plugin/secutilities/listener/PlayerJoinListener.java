package bl4ckscor3.plugin.secutilities.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

import bl4ckscor3.plugin.bl4ckkitCore.core.bl4ckkitCore;
import bl4ckscor3.plugin.secutilities.commands.MaxPlayers;

public class PlayerJoinListener implements Listener
{
	private static Plugin plugin;

	public PlayerJoinListener(Plugin pl)
	{
		plugin = pl;
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event)
	{
		MaxPlayers.increase(plugin);
		
		if(event.getPlayer().getName().equals("Vauff"))
		{
			for(Player p : Bukkit.getOnlinePlayers())
			{
				if(p.hasPermission("secutil.showSJ"))
					bl4ckkitCore.getMessageManager().sendChatMessage(p, plugin, "Vauff silently joined.");
			}
		}
	}
}
