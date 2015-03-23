package bl4ckscor3.plugin.secutilities.features.commands;

import java.util.Arrays;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import bl4ckscor3.plugin.secutilities.commands.ISecutilCommand;
import bl4ckscor3.plugin.secutilities.core.Secutilities;
import bl4ckscor3.plugin.secutilities.exception.PluginNotInstalledException;
import bl4ckscor3.plugin.secutilities.util.Utilities;

import com.earth2me.essentials.Essentials;

public class UniquePlayers implements ISecutilCommand
{

	public void exe(Player p, Plugin pl, String[] args)
	{
		try
		{
			p.sendMessage("[" + ChatColor.BLUE + pl.getDescription().getName() + ChatColor.RESET + "] " + ChatColor.GOLD + ((Essentials)Utilities.getPlugin((Secutilities)pl, "Essentials")).getUserMap().getUniqueUsers() + ChatColor.RESET + " unique players have joined the server.");
		}
		catch(PluginNotInstalledException e)
		{
			e.printStackTrace();
		}
	}

	public String getLabel()
	{
		return "uniqueplayers";
	}

	public String[] getRequiredPermission()
	{
		return null;
	}

	public List<Integer> allowedArgumentLengths()
	{
		return Arrays.asList(new Integer[]{0});
	}

}
