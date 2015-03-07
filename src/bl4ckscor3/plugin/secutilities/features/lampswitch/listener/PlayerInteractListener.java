package bl4ckscor3.plugin.secutilities.features.lampswitch.listener;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractListener implements Listener
{
	public static List<String> lampSwitchOn = new ArrayList<String>();
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) throws InterruptedException
	{
		if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK))
		{
			if(event.getClickedBlock().getType() == Material.REDSTONE_LAMP_OFF || event.getClickedBlock().getType() == Material.REDSTONE_LAMP_ON)
			{
				if(lampSwitchOn.contains(event.getPlayer().getName()))
					event.getClickedBlock().setType(event.getClickedBlock().getType() == Material.REDSTONE_LAMP_OFF ? Material.REDSTONE_LAMP_ON : Material.REDSTONE_LAMP_OFF);
			}
		}
	}
}
