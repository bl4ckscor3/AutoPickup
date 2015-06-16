package bl4ckscor3.plugin.secutilities.listener;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

import bl4ckscor3.plugin.bl4ckkitCore.core.bl4ckkitCore;

import com.mewin.WGRegionEvents.events.RegionEnterEvent;

public class RegionEnterListener implements Listener
{
	private static Plugin plugin;
	private static final String[] messages =
		{
			"You are not allowed to enter the mall!",
			"No entry!",
			"You are not welcome here!",
			"Leave!",
			"This building is not accessible for you, you know that!",
			"GO AWAY!!"
		};

	public RegionEnterListener(Plugin pl)
	{
		plugin = pl;
	}

	@EventHandler
	public void onRegionEnter(RegionEnterEvent event)
	{
		if(event.getRegion().getId().equalsIgnoreCase("comedymall") && event.getPlayer().getUniqueId().equals("c644dea8-88b0-4cdb-97dc-37665c93edfe"))
		{
			Random r = new Random();

			event.setCancelled(true);
			bl4ckkitCore.getMessageManager().sendChatMessage(event.getPlayer(), plugin, "[" + ChatColor.AQUA + "ComedyKing" + ChatColor.WHITE + "]: " + messages[r.nextInt(messages.length)]);
		}
	}
}
