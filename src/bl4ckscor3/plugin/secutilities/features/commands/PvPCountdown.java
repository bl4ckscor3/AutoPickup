package bl4ckscor3.plugin.secutilities.features.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;

public class PvPCountdown
{
	public static void exe(final CommandSender sender, final Plugin plugin)
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
					scheduler.cancelAllTasks();
					return;
				}
				
				Bukkit.dispatchCommand(sender, "broadcast " + i--);
			}
		};
		
		scheduler.runTaskTimer(plugin, r, 0, 20);
	}
}
