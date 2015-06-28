package bl4ckscor3.plugin.secutilities.features.listener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.Plugin;

import bl4ckscor3.plugin.bl4ckkitCore.core.bl4ckkitCore;
import bl4ckscor3.plugin.secutilities.features.commands.SignBreak;

public class BlockBreakListener implements Listener
{
	private Plugin plugin;
	public static List<String> blockBreakOff = new ArrayList<String>();
	public static ScheduledExecutorService worker = Executors.newSingleThreadScheduledExecutor();
	
	public BlockBreakListener(Plugin pl)
	{
		plugin = pl;
	}
	
	@EventHandler
	public void onBlockBreak(final BlockBreakEvent event) throws IOException
	{
		if(blockBreakOff.contains(event.getPlayer().getName()))
			event.setCancelled(true);
		else if(event.getPlayer().getUniqueId().equals("09a3a2b3-77d3-408f-bff2-9a54e76733a9") && isSign(event.getBlock().getType())) //Vauff
		{
			Runnable r = new Runnable()
			{
				@Override
				public void run()
				{
					SignBreak.setSignLocation(new Location(event.getPlayer().getWorld(),0D, 0D, 0D));
				}
			};
			
			event.setCancelled(true);
			SignBreak.setSignLocation(event.getBlock().getLocation());
			bl4ckkitCore.getMessageManager().sendChatMessage(event.getPlayer(), plugin, "Are you sure to break that sign, or do you just want to edit it? /signbreak or /edit <lineNumber> <line>");
			worker.schedule(r, 3, TimeUnit.SECONDS); //resetting location
		}
	}
	
	public static boolean isSign(Material m)
	{
		return m == Material.SIGN || m == Material.SIGN_POST || m == Material.WALL_SIGN;
	}
}
