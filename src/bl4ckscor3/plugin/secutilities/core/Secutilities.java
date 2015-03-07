package bl4ckscor3.plugin.secutilities.core;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import bl4ckscor3.plugin.secutilities.exception.PluginNotInstalledException;
import bl4ckscor3.plugin.secutilities.features.commands.BlockBreak;
import bl4ckscor3.plugin.secutilities.features.commands.BlockPlace;
import bl4ckscor3.plugin.secutilities.features.commands.ColorCodes;
import bl4ckscor3.plugin.secutilities.features.commands.LocTool;
import bl4ckscor3.plugin.secutilities.features.listener.BlockBreakListener;
import bl4ckscor3.plugin.secutilities.features.listener.BlockPlaceListener;
import bl4ckscor3.plugin.secutilities.features.listener.PlayerInteractListener;
import bl4ckscor3.plugin.secutilities.features.pvplimit.PvPLimit;

public class Secutilities extends JavaPlugin
{
	@Override
	public void onEnable()
	{
		getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
		getServer().getPluginManager().registerEvents(new BlockPlaceListener(), this);
		getServer().getPluginManager().registerEvents(new PlayerInteractListener(this), this);
		getServer().getPluginManager().registerEvents(new PvPLimit(), this);
		
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
				return true;
			}
		}
		else if(cmd.getName().equalsIgnoreCase("blockplace"))
		{
			if(p.hasPermission("secutil.blockplace.toggle"))
			{
				if(args.length < 0)
					return false;
				
				BlockPlace.exe(p, this);
				return true;
			}
		}
		else if(cmd.getName().equalsIgnoreCase("colorcodes"))
		{
			if(p.hasPermission("secutil.colorcodes"))
			{
				if(args.length < 0)
					return false;
	
				ColorCodes.exe(p, this);
				return true;
			}
		}
		else if(cmd.getName().equalsIgnoreCase("loctool"))
		{
			if(p.hasPermission("secutil.loctool.give"))
			{
				if(args.length != 0)
					return false;
				
				LocTool.exe(p, this);
				return true;
			}			
		}
		return false;
	}
}