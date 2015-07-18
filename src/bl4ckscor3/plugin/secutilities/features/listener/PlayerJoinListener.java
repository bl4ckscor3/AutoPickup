package bl4ckscor3.plugin.secutilities.features.listener;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

import bl4ckscor3.plugin.bl4ckkitCore.core.bl4ckkitCore;
import bl4ckscor3.plugin.secutilities.features.commands.Join;

public class PlayerJoinListener implements Listener
{
	private static Plugin plugin;
	public static final List<String> names = new ArrayList<String>();
	
	public PlayerJoinListener(Plugin pl)
	{
		plugin = pl;
		names.add("bl4ckscor3");
		names.add("Vakonof");
		names.add("ExcelGamer");
		names.add("Geforce");
		names.add("Vauff");
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) throws InterruptedException
	{
		if(!Join.hasJoined && !event.getPlayer().getName().equals("Vauff") && bl4ckkitCore.getPlayerManager().isPlayerOnline("Vauff"))
			event.getPlayer().hidePlayer(Bukkit.getPlayer("Vauff"));
		
		if(event.getPlayer().getName().equals("Vauff"))
		{
			event.setJoinMessage(null);
			
			for(Player p : Bukkit.getOnlinePlayers())
			{
				if(!names.contains(p.getName()) || p.getName().equals("Vauff"))
				{
					p.hidePlayer(event.getPlayer());
					continue;
				}
				
				bl4ckkitCore.getMessageManager().sendChatMessage(p, plugin, "Vauff silently joined.");
			}
			
			Thread.sleep(4000);
			bl4ckkitCore.getMessageManager().sendChatMessage(event.getPlayer(), plugin, "Vauff silently joined.");
		}
	}
}
