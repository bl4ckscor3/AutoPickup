package bl4ckscor3.plugin.secutilities.event;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class WorldJoinEvent extends Event
{
	private static final HandlerList handlers = new HandlerList();
	private Player player;
	private World world;
	
	public WorldJoinEvent(Player p, World w)
	{
		player = p;
		world = w;
	}

	public Player getPlayer()
	{
		return player;
	}

	public World getWorld()
	{
		return world;
	}
	
	@Override
	public HandlerList getHandlers()
	{
		return handlers;
	}

	public static HandlerList getHandlerList()
	{
		return handlers;
	}
}
