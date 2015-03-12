package bl4ckscor3.plugin.secutilities.core;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import bl4ckscor3.plugin.secutilities.exception.PluginNotInstalledException;
import bl4ckscor3.plugin.secutilities.features.PvPLimit;
import bl4ckscor3.plugin.secutilities.features.commands.BlockBreak;
import bl4ckscor3.plugin.secutilities.features.commands.BlockPlace;
import bl4ckscor3.plugin.secutilities.features.commands.ColorCodes;
import bl4ckscor3.plugin.secutilities.features.commands.LocTool;
import bl4ckscor3.plugin.secutilities.features.commands.PvPCountdown;
import bl4ckscor3.plugin.secutilities.features.commands.TpOverride;
import bl4ckscor3.plugin.secutilities.features.listener.AsyncPlayerChatListener;
import bl4ckscor3.plugin.secutilities.features.listener.BlockBreakListener;
import bl4ckscor3.plugin.secutilities.features.listener.BlockPlaceListener;
import bl4ckscor3.plugin.secutilities.features.listener.PlayerInteractListener;
import bl4ckscor3.plugin.secutilities.features.listener.PlayerQuitListener;

public class Secutilities extends JavaPlugin
{
	@Override
	public void onEnable()
	{
		getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
		getServer().getPluginManager().registerEvents(new BlockPlaceListener(), this);
		getServer().getPluginManager().registerEvents(new PlayerInteractListener(this), this);
		getServer().getPluginManager().registerEvents(new PvPLimit(), this);
		getServer().getPluginManager().registerEvents(new AsyncPlayerChatListener(this), this);
		getServer().getPluginManager().registerEvents(new PlayerQuitListener(), this);
		
		try
		{
			PvPLimit.setup(this);
		}
		catch(PluginNotInstalledException e)
		{
			e.printStackTrace();
		}

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
		
		if(cmd.getName().equalsIgnoreCase("pvpcountdown") && (!(sender instanceof ConsoleCommandSender) && !(sender instanceof Player)))
		{
			if(args.length == 1 || args.length == 2 || args.length > 3)
				return false;
			
			PvPCountdown.exe(sender, this, args);
			return true;
		}
		
		if(sender instanceof Player)
			p = (Player)sender;
		else
		{
			System.out.println("[" + getDescription().getName() + "] The console cannot use this plugin.");
			return true;
		}

		if(cmd.getName().equalsIgnoreCase("blockbreak"))
		{
			if(p.hasPermission("secutil.blockbreak.toggle"))
			{
				if(args.length < 0)
					return false;
				
				BlockBreak.exe(p, this);				
			}
		}
		else if(cmd.getName().equalsIgnoreCase("blockplace"))
		{
			if(p.hasPermission("secutil.blockplace.toggle"))
			{
				if(args.length < 0)
					return false;
				
				BlockPlace.exe(p, this);
			}
		}
		else if(cmd.getName().equalsIgnoreCase("colorcodes"))
		{
			if(p.hasPermission("secutil.colorcodes"))
			{
				if(args.length < 0)
					return false;
	
				ColorCodes.exe(p, this);
			}
		}
		else if(cmd.getName().equalsIgnoreCase("loctool"))
		{
			if(p.hasPermission("secutil.loctool.give"))
			{
				if(args.length != 0)
					return false;
				
				LocTool.exe(p, this);
			}			
		}
		else if(cmd.getName().equalsIgnoreCase("pvpcountdown"))
			p.sendMessage("[" + ChatColor.BLUE + getDescription().getName() + ChatColor.RESET + "] Only command blocks can use this command.");
		else if(cmd.getName().equalsIgnoreCase("tp"))
			TpOverride.exe(p, args, args.length < 3 ? "tpo " : "tele ");
		else if(cmd.getName().equalsIgnoreCase("tphere"))
			TpOverride.exe(p, args, "tpohere ");
		else
			return false;
		return true;
	}
}