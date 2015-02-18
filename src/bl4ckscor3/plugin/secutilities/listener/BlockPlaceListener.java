package bl4ckscor3.plugin.secutilities.listener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlaceListener implements Listener
{
	public static List<String> blockPlaceOff = new ArrayList<String>();
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event) throws IOException
	{
		if(blockPlaceOff.contains(event.getPlayer().getName()))
			event.setCancelled(true);
	}
}
