package bl4ckscor3.plugin.secutilities.features.commands;

import java.util.Arrays;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import bl4ckscor3.plugin.secutilities.features.listener.BlockBreakListener;

public class BlockBreak implements ISecutilCommand
{
	public void exe(Player p, Plugin pl, String[] args)
	{
		if(!BlockBreakListener.blockBreakOff.contains(p.getName()))
		{
			BlockBreakListener.blockBreakOff.add(p.getName());
			p.sendMessage("[" + ChatColor.BLUE + pl.getDescription().getName() + ChatColor.RESET + "] You turned block breaking " + ChatColor.RED + "OFF" + ChatColor.RESET + ".");
		}
		else
		{
			BlockBreakListener.blockBreakOff.remove(p.getName());
			p.sendMessage("[" + ChatColor.BLUE + pl.getDescription().getName() + ChatColor.RESET + "] You turned block breaking " + ChatColor.GREEN + "ON" + ChatColor.RESET + ".");
		}
	}

	public String getLabel()
	{
		return "blockbreak";
	}

	public String[] getRequiredPermission()
	{
		return new String[]{"secutil.blockbreak.toggle"};
	}
	
	public List<Integer> allowedArgumentLengths()
	{
		return Arrays.asList(new Integer[]{0});
	}
}
