package bl4ckscor3.plugin.secutilities.features.breakplace.commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import bl4ckscor3.plugin.secutilities.features.breakplace.listener.BlockBreakListener;

public class BlockBreak
{
	public static void exe(Player p, Plugin plugin)
	{
		if(!BlockBreakListener.blockBreakOff.contains(p.getName()))
		{
			BlockBreakListener.blockBreakOff.add(p.getName());
			p.sendMessage("[" + ChatColor.BLUE + plugin.getDescription().getName() + ChatColor.RESET + "] You turned block breaking " + ChatColor.RED + "OFF" + ChatColor.RESET + ".");
		}
		else
		{
			BlockBreakListener.blockBreakOff.remove(p.getName());
			p.sendMessage("[" + ChatColor.BLUE + plugin.getDescription().getName() + ChatColor.RESET + "] You turned block breaking " + ChatColor.GREEN + "ON" + ChatColor.RESET + ".");
		}

	}
}
