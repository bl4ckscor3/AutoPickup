package bl4ckscor3.plugin.secutilities.features.pvplimit;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

//This is hardcoded for BreakIn' Bad
public class PvPLimit
{
	private static Plugin plugin;
	private static List<String> playersWithinPvP = new ArrayList<String>();
	
	public static void setup(Plugin pl)
	{
		plugin = pl;
	}

	public static void checkPlayerPos()
	{
		plugin.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable()
		{
			@Override
			public void run() 
			{
				for(Player p : Bukkit.getOnlinePlayers())
				{
					if(p.hasPermission("secutil.pvplimit.bypass"))
						continue;
					
					int x = p.getLocation().getBlockX();
					int z = p.getLocation().getBlockZ();

					if(playersWithinPvP.contains(p.getName()))
					{
						if(!((x >= -243 && x <= -93) && (z >= -3079 && z <= -2929)))
							playersWithinPvP.remove(p.getName());
						continue;
					}
					
					if((x >= -243 && x <= -93) && (z >= -3079 && z <= -2929))
					{
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "speed walk 1 " + p.getName());
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "speed fly 1 " + p.getName());
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "fly " + p.getName() + " disable");
						p.sendMessage("[" + ChatColor.BLUE + plugin.getDescription().getName() + ChatColor.RESET + "] You are not allowed to walk fast and fly within the pvp arena.");
						playersWithinPvP.add(p.getName());
					}
				}
			}
		}, 0, 60);
	}
	
	public static List<String> getPlayersWithinPvP()
	{
		return playersWithinPvP;
	}
	
	public static void removePlayer(String name)
	{
		playersWithinPvP.remove(name);
	}
}