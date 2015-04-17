package bl4ckscor3.plugin.secutilities.features.commands;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;

import bl4ckscor3.plugin.bl4ckkitCore.core.bl4ckkitCore;

public class PvPCountdown implements ISecutilCommand
{
	@Override
	public void exe(CommandSender sender, Player p, Plugin pl, String[] args)
	{
		bl4ckkitCore.getMessageManager().sendChatMessage(p, pl, "Only command blocks can use this command.");
	}
	
	public static void exe(final CommandSender sender, Plugin pl, final String[] args)
	{
		final BukkitScheduler scheduler = Bukkit.getScheduler();
		BukkitRunnable r = new BukkitRunnable()
		{
			int i = 10;
			
			@Override
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

	@Override
	public String getLabel()
	{
		return "pvpcountdown";
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
