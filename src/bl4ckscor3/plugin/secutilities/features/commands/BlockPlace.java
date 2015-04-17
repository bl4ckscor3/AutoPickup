package bl4ckscor3.plugin.secutilities.features.commands;

import java.util.Arrays;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import bl4ckscor3.plugin.bl4ckkitCore.core.bl4ckkitCore;
import bl4ckscor3.plugin.secutilities.features.listener.BlockPlaceListener;

public class BlockPlace implements ISecutilCommand
{
	@Override
	public void exe(CommandSender sender, Player p, Plugin pl, String[] args)
	{
		if(!BlockPlaceListener.blockPlaceOff.contains(p.getName()))
		{
			BlockPlaceListener.blockPlaceOff.add(p.getName());
			bl4ckkitCore.getMessageManager().sendChatMessage(p, pl, "You turned block placing " + ChatColor.RED + "OFF" + ChatColor.RESET + ".");
		}
		else
		{
			BlockPlaceListener.blockPlaceOff.remove(p.getName());
			bl4ckkitCore.getMessageManager().sendChatMessage(p, pl, "You turned block placing " + ChatColor.GREEN + "ON" + ChatColor.RESET + ".");
		}
	}

	@Override
	public String getLabel()
	{
		return "blockplace";
	}

	@Override
	public String[] getRequiredPermission()
	{
		return new String[]{"secutil.blockplace.toggle"};
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
