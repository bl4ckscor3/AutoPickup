package bl4ckscor3.plugin.secutilities.features.listener;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.mewin.WGRegionEvents.events.RegionEnteredEvent;
import com.mewin.WGRegionEvents.events.RegionLeftEvent;

public class RegionEnteredLeftListener implements Listener
{
	private static final HashMap<String, ArrayList<String>> playersInRegions = new HashMap<String, ArrayList<String>>();
	
	@EventHandler
	public void onRegionEntered(RegionEnteredEvent event)
	{
		if(!playersInRegions.containsKey(event.getPlayer().getName()))
		{
			ArrayList<String> regions = new ArrayList<String>();
			
			regions.add(event.getRegion().getId());
			playersInRegions.put(event.getPlayer().getName(), regions);
		}
		else
		{
			ArrayList<String> regions = playersInRegions.get(event.getPlayer().getName());
			
			regions.add(event.getRegion().getId());
			playersInRegions.put(event.getPlayer().getName(), regions);
		}
	}
	
	@EventHandler
	public void onRegionLeft(RegionLeftEvent event)
	{
		if(playersInRegions.get(event.getPlayer().getName()).size() == 1)
			playersInRegions.remove(event.getPlayer().getName());
		else
		{
			ArrayList<String> regions = playersInRegions.get(event.getPlayer().getName());
			
			regions.remove(event.getRegion().getId());
			playersInRegions.put(event.getPlayer().getName(), regions);
		}
	}
	
	public static boolean isPlayerInRegion(String name, String region)
	{
		return playersInRegions.containsKey(name) && playersInRegions.get(name).contains(region);
	}
}
