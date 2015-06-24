package bl4ckscor3.plugin.secutilities.features.listener;

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
		
		if(RegionEnteredLeftListener.isPlayerInRegion(event.getPlayer().getName(), "town"))
		{
			int newId = 0;
			
			switch(event.getBlock().getTypeId())
			{
				case 197: //reinforced iron bars
					newId = 101;
					break;
				case 200: //reinforced glass pane
					newId = 102;
					break;
				case 1: //reinforced stone
					newId = 98;
					break;
			}
			
			event.getBlock().setTypeId(newId);
		}
	}
}
