package bl4ckscor3.plugin.secutilities.features.commands;

import java.util.Arrays;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import bl4ckscor3.plugin.bl4ckkitCore.core.bl4ckkitCore;
import bl4ckscor3.plugin.secutilities.features.listener.BlockBreakListener;

public class BlockBreak implements ISecutilCommand
{
	@Override
	public void exe(CommandSender sender, Player p, Plugin pl, String[] args)
	{
		if(!BlockBreakListener.blockBreakOff.contains(p.getName()))
		{
			BlockBreakListener.blockBreakOff.add(p.getName());
			bl4ckkitCore.getMessageManager().sendChatMessage(p, pl, "You turned block breaking " + ChatColor.RED + "OFF" + ChatColor.RESET + ".");
		}
		else
		{
			BlockBreakListener.blockBreakOff.remove(p.getName());
			bl4ckkitCore.getMessageManager().sendChatMessage(p, pl, "You turned block breaking " + ChatColor.GREEN + "ON" + ChatColor.RESET + ".");
		}
	}

	@Override
	public String getLabel()
	{
		return "blockbreak";
	}

	@Override
	public String[] getRequiredPermission()
	{
		return new String[]{"secutil.blockbreak.toggle"};
	}
	
	@Override
	public List<Integer> allowedArgumentLengths()
	{
		return Arrays.asList(new Integer[]{0});
	}

	@Override
	public boolean isConsoleCommand()
	{
		return false;
	}
}
