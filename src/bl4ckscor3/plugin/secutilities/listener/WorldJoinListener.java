package bl4ckscor3.plugin.secutilities.listener;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import bl4ckscor3.plugin.secutilities.event.WorldJoinEvent;

public class WorldJoinListener implements Listener
{
	@EventHandler
	public void onWorldJoin(WorldJoinEvent event)
	{
		String name = event.getPlayer().getName();
		
		if(name.equals("Geforce") || name.equals("Vauff") || name.equals("bl4ckscor3"))
			return;
		
		if(event.getWorld().getName().equals("creative"))
			event.getPlayer().setGameMode(GameMode.CREATIVE);
		else if(event.getWorld().getName().equals("world"))
			event.getPlayer().setGameMode(GameMode.SURVIVAL);
	}
}
