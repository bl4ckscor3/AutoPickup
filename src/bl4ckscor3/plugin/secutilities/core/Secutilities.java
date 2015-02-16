package bl4ckscor3.plugin.secutilities.core;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import bl4ckscor3.plugin.secutilities.listener.BlockBreakListener;

public class Secutilities extends JavaPlugin
{
	@Override
	public void onEnable()
	{
		getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
		System.out.println("[" + getDescription().getName() + "] v " + getDescription().getVersion() + " enabled.");
	}

	@Override
	public void onDisable()
	{
		System.out.println("[" + getDescription().getName() + "] v " + getDescription().getVersion() + " disabled.");
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		Player p = null;

		if(sender instanceof Player)
			p = (Player)sender;
		else
		{
			System.out.println("[" + getDescription().getName() + "] The console cannot use this plugin.");
			return true;
		}

		if(cmd.getName().equalsIgnoreCase("blockbreak"))
		{
			if(p.hasPermission("blockbreak.toggle"))
			{
				if(!BlockBreakListener.blockBreakOff.contains(p.getName()))
				{
					BlockBreakListener.blockBreakOff.add(p.getName());
					p.sendMessage("[" + ChatColor.BLUE + getDescription().getName() + ChatColor.RESET + "] You turned block breaking " + ChatColor.RED + "OFF" + ChatColor.RESET + ".");
				}
				else
				{
					BlockBreakListener.blockBreakOff.remove(p.getName());
					p.sendMessage("[" + ChatColor.BLUE + getDescription().getName() + ChatColor.RESET + "] You turned block breaking " + ChatColor.GREEN + "ON" + ChatColor.RESET + ".");
				}
				
				return true;
			}
		}

		return false;
	}
}