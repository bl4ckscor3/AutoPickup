package bl4ckscor3.plugin.secutilities.features.commands;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import bl4ckscor3.plugin.secutilities.features.listener.PlayerJoinListener;

public class Join implements ISecutilCommand
{
	public static boolean hasJoined = false;

	@Override
	public void exe(CommandSender sender, Player p, Plugin pl, String[] args) throws InterruptedException
	{
		if(!hasJoined)
		{
			if(((Player)sender).getName().equals("Vauff"))
			{
				for(Player player : Bukkit.getOnlinePlayers())
				{
					if(!PlayerJoinListener.names.contains(p.getName()))
						player.showPlayer(p);

					player.sendMessage(ChatColor.YELLOW + "Vauff joined the game.");
				}

				hasJoined = true;
			}
		}
	}

	@Override
	public String getLabel()
	{
		return "join";
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
		return false;
	}
}