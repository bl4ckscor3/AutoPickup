package bl4ckscor3.plugin.secutilities.features.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

import bl4ckscor3.plugin.bl4ckkitCore.core.bl4ckkitCore;

public class PlayerJoinListener implements Listener
{
	private static Plugin plugin;
	
	public PlayerJoinListener(Plugin pl)
	{
		plugin = pl;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) throws InterruptedException
	{
		if(event.getPlayer().getName().equals("Vauff"))
		{
			event.setJoinMessage(null);
			
			for(Player player : Bukkit.getOnlinePlayers())
			{
				if(!player.getName().equals("bl4ckscor3") || !player.getName().equals("Geforce") || !player.getName().equals("Vauff"))
					player.hidePlayer(event.getPlayer());
				
				if(player.getName().equals("bl4ckscor3") || player.getName().equals("Geforce") || player.getName().equals("Vauff"))
				{
					Thread.sleep(2000);
					bl4ckkitCore.getMessageManager().sendChatMessage(player, plugin, "Vauff silently joined.");
				}
			}
		}
	}
}
