package bl4ckscor3.plugin.secutilities.commands;

import java.util.Arrays;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import bl4ckscor3.plugin.bl4ckkitCore.core.bl4ckkitCore;
import bl4ckscor3.plugin.bl4ckkitCore.exception.PluginNotInstalledException;

import com.earth2me.essentials.Essentials;

public class UniquePlayers implements ISecutilCommand
{
	@Override
	public void exe(CommandSender sender, Player p, Plugin pl, String[] args)
	{
		try
		{
			bl4ckkitCore.getMessageManager().sendChatMessage(sender, pl, ChatColor.GOLD + "" + ((Essentials)bl4ckkitCore.getPluginManager().getPlugin(pl, "Essentials")).getUserMap().getUniqueUsers() + ChatColor.RESET + " unique players have joined the server.");
		}
		catch(PluginNotInstalledException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public String getLabel()
	{
		return "uniqueplayers";
	}

	@Override
	public String[] getRequiredPermission()
	{
		return null;
	}

	@Override
	public List<Integer> allowedArgumentLengths()
	{
		return Arrays.asList(new Integer[]{0});
	}

	@Override
	public boolean isConsoleCommand()
	{
		return true;
	}
}
