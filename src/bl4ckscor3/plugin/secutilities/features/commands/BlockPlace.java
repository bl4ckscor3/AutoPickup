package bl4ckscor3.plugin.secutilities.features.commands;

import java.util.Arrays;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import bl4ckscor3.plugin.secutilities.features.listener.BlockPlaceListener;

public class BlockPlace implements ISecutilCommand
{
	public void exe(Player p, Plugin pl, String[] args)
	{
		if(!BlockPlaceListener.blockPlaceOff.contains(p.getName()))
		{
			BlockPlaceListener.blockPlaceOff.add(p.getName());
			p.sendMessage("[" + ChatColor.BLUE + pl.getDescription().getName() + ChatColor.RESET + "] You turned block placing " + ChatColor.RED + "OFF" + ChatColor.RESET + ".");
		}
		else
		{
			BlockPlaceListener.blockPlaceOff.remove(p.getName());
			p.sendMessage("[" + ChatColor.BLUE + pl.getDescription().getName() + ChatColor.RESET + "] You turned block placing " + ChatColor.GREEN + "ON" + ChatColor.RESET + ".");
		}
	}

	public String getLabel()
	{
		return "blockplace";
	}

	public String[] getRequiredPermission()
	{
		return new String[]{"secutil.blockplace.toggle"};
	}

	public List<Integer> allowedArgumentLengths()
	{
		return Arrays.asList(new Integer[]{0});
	}
}
