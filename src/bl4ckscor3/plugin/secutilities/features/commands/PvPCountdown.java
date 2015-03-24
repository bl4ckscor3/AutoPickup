package bl4ckscor3.plugin.secutilities.features.commands;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;

public class PvPCountdown implements ISecutilCommand
{
	public void exe(Player p, Plugin pl, String[] args)
	{
			p.sendMessage("[" + ChatColor.BLUE + pl.getDescription().getName() + ChatColor.RESET + "] Only command blocks can use this command.");
	}
	
	public static void exe(final CommandSender sender, Plugin pl, final String[] args)
	{
		final BukkitScheduler scheduler = Bukkit.getScheduler();
		Runnable r = new Runnable()
		{
			int i = 10;
			
			public void run()
			{
				if(i == 0)
				{
					Bukkit.dispatchCommand(sender, "broadcast Fight!");
					
					if(args.length == 3)
						Bukkit.dispatchCommand(sender, "setblock " + args[0] + " " + args[1] + " " + args[2] + " minecraft:redstone_block");
					
					scheduler.cancelAllTasks();
					return;
				}
				
				Bukkit.dispatchCommand(sender, "broadcast " + i--);
			}
		};
		
		scheduler.runTaskTimer(pl, r, 0, 20);
	}

	public String getLabel()
	{
		return "pvpcountdown";
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
