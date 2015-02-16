package bl4ckscor3.plugin.secutilities.listener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener
{
	public static List<String> blockBreakOff = new ArrayList<String>();
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) throws IOException
	{
		if(blockBreakOff.contains(event.getPlayer().getName()))
			event.setCancelled(true);
	}
}
