package bl4ckscor3.plugin.secutilities.features.commands;

import java.util.Arrays;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import bl4ckscor3.plugin.bl4ckkitCore.core.bl4ckkitCore;
import bl4ckscor3.plugin.bl4ckkitCore.exception.PluginNotInstalledException;

import com.earth2me.essentials.Essentials;

public class UniquePlayers implements ISecutilCommand
{

	public void exe(Player p, Plugin pl, String[] args)
	{
		try
		{
			bl4ckkitCore.getMessageManager().sendChatMessage(p, pl, ChatColor.GOLD + "" + ((Essentials)bl4ckkitCore.getPluginManager().getPlugin(pl, "Essentials")).getUserMap().getUniqueUsers() + ChatColor.RESET + " unique players have joined the server.");
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
