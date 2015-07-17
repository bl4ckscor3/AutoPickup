package bl4ckscor3.plugin.secutilities.features.listener;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

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
	public static List<String> names = new ArrayList<String>();
	
	public PlayerJoinListener(Plugin pl)
	{
		plugin = pl;
		names.add("bl4ckscor3");
		names.add("Geforce");
		names.add("Vauff");
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) throws InterruptedException
	{
		if(event.getPlayer().getName().equals("Vauff"))
		{
			event.setJoinMessage(null);
			
			for(final Player player : Bukkit.getOnlinePlayers())
			{
				if(!names.contains(event.getPlayer().getName()))
					player.hidePlayer(event.getPlayer());
				
				if(names.contains(event.getPlayer().getName()))
					bl4ckkitCore.getMessageManager().sendChatMessage(player, plugin, "Vauff silently joined.");
				
				if(player.getName().equals("Vauff"))
				{
					SwingUtilities.invokeLater(new Runnable()
					{
						@Override
						public void run()
						{
							try
							{
								Thread.sleep(4000);
							}
							catch (InterruptedException e)
							{
								e.printStackTrace();
							}
							
							bl4ckkitCore.getMessageManager().sendChatMessage(player, plugin, "Vauff silently joined.");
						}
					});
				}
			}
		}
	}
}
