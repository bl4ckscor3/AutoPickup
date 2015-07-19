package bl4ckscor3.plugin.secutilities.listener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
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
		
		Location l = event.getBlock().getLocation();
		
		if((l.getX() >= -600 && l.getX() <= 88) && (l.getZ() >= -46 && l.getZ() <= 723))
		{
			int newId = -1;
			
			switch(event.getBlock().getTypeId())
			{
				case 197: //reinforced iron bars
					newId = 101;
					break;
				case 200: //reinforced glass pane
					newId = 102;
					break;
				case 203: //reinforced stone
					newId = 98;
					break;
			}
			
			if(newId != -1) //id has changed
				event.getBlock().setTypeId(newId);
		}
	}
}
