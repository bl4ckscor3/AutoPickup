package bl4ckscor3.plugin.secutilities.features.listener;

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
			
			for(final Player player : Bukkit.getOnlinePlayers())
			{
				if(!player.getName().equals("bl4ckscor3") || !player.getName().equals("Geforce") || !player.getName().equals("Vauff"))
					player.hidePlayer(event.getPlayer());
				
				if(player.getName().equals("bl4ckscor3") || player.getName().equals("Geforce"))
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
