package bl4ckscor3.plugin.secutilities.misc;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.mewin.WGRegionEvents.events.RegionEnteredEvent;
import com.mewin.WGRegionEvents.events.RegionLeaveEvent;

public class DonatorRoomEntrance implements Listener
{
	private static int playersInRegion = 0;

	@EventHandler
	public void onRegionEntered(RegionEnteredEvent event) throws IOException
	{
		if(event.getRegion().getId().equalsIgnoreCase("donatorroomentrance"))
		{
			if(playersInRegion == 0)
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "setblock -246 55 288 minecraft:air");
			playersInRegion++;
		}
	}

	@EventHandler
	public void onRegionLeave(RegionLeaveEvent event)
	{
		if(event.getRegion().getId().equalsIgnoreCase("donatorroomentrance"))
		{
			playersInRegion--;

			if(playersInRegion == 0)
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "setblock -246 55 288 minecraft:redstone_block");
		}
	}
}