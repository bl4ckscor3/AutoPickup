package bl4ckscor3.plugin.secutilities.features.commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import bl4ckscor3.plugin.secutilities.features.listener.BlockPlaceListener;

public class BlockPlace
{
	public static void exe(Player p, Plugin plugin)
	{
		if(!BlockPlaceListener.blockPlaceOff.contains(p.getName()))
		{
			BlockPlaceListener.blockPlaceOff.add(p.getName());
			p.sendMessage("[" + ChatColor.BLUE + plugin.getDescription().getName() + ChatColor.RESET + "] You turned block placing " + ChatColor.RED + "OFF" + ChatColor.RESET + ".");
		}
		else
		{
			BlockPlaceListener.blockPlaceOff.remove(p.getName());
			p.sendMessage("[" + ChatColor.BLUE + plugin.getDescription().getName() + ChatColor.RESET + "] You turned block placing " + ChatColor.GREEN + "ON" + ChatColor.RESET + ".");
		}
	}
}
