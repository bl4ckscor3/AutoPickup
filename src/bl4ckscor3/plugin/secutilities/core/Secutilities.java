package bl4ckscor3.plugin.secutilities.core;

import java.util.LinkedList;

import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import bl4ckscor3.plugin.secutilities.exception.PluginNotInstalledException;
import bl4ckscor3.plugin.secutilities.features.PvPLimit;
import bl4ckscor3.plugin.secutilities.features.commands.BlockBreak;
import bl4ckscor3.plugin.secutilities.features.commands.BlockPlace;
import bl4ckscor3.plugin.secutilities.features.commands.ColorCodes;
import bl4ckscor3.plugin.secutilities.features.commands.ISecutilCommand;
import bl4ckscor3.plugin.secutilities.features.commands.LocTool;
import bl4ckscor3.plugin.secutilities.features.commands.Milk;
import bl4ckscor3.plugin.secutilities.features.commands.PvPCountdown;
import bl4ckscor3.plugin.secutilities.features.commands.SignBreak;
import bl4ckscor3.plugin.secutilities.features.commands.TpOverride;
import bl4ckscor3.plugin.secutilities.features.commands.UniquePlayers;
import bl4ckscor3.plugin.secutilities.features.listener.AsyncPlayerChatListener;
import bl4ckscor3.plugin.secutilities.features.listener.BlockBreakListener;
import bl4ckscor3.plugin.secutilities.features.listener.BlockPlaceListener;
import bl4ckscor3.plugin.secutilities.features.listener.PlayerInteractListener;
import bl4ckscor3.plugin.secutilities.features.listener.PlayerQuitListener;
import bl4ckscor3.plugin.secutilities.features.listener.timedisplayer.PlayerCommandPreprocessListener;
import bl4ckscor3.plugin.secutilities.features.listener.timedisplayer.TDPlayerJoinListener;

public class Secutilities extends JavaPlugin
{
	private static final LinkedList<ISecutilCommand> commands = new LinkedList<ISecutilCommand>();
	
	private void setupCommands()
	{
		commands.add(new BlockBreak());
		commands.add(new BlockPlace());
		commands.add(new ColorCodes());
		commands.add(new Leather());
		commands.add(new LocTool());
		commands.add(new Milk());
		commands.add(new SignBreak());
		commands.add(new UniquePlayers());
	}
	
	@Override
	public void onEnable()
	{
		getServer().getPluginManager().registerEvents(new BlockBreakListener(this), this);
		getServer().getPluginManager().registerEvents(new BlockPlaceListener(), this);
		getServer().getPluginManager().registerEvents(new PlayerInteractListener(this), this);
		getServer().getPluginManager().registerEvents(new PvPLimit(), this);
		getServer().getPluginManager().registerEvents(new AsyncPlayerChatListener(this), this);
		getServer().getPluginManager().registerEvents(new PlayerQuitListener(), this);
		//timedisplayer
		getServer().getPluginManager().registerEvents(new TDPlayerJoinListener(), this);
		getServer().getPluginManager().registerEvents(new PlayerCommandPreprocessListener(), this);
		setupCommands();
		
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

		if(sender instanceof BlockCommandSender)
		{
			if(cmd.getName().equalsIgnoreCase("pvpcountdown"))
			{
				if(args.length == 1 || args.length == 2 || args.length > 3)
					return false;
				
				PvPCountdown.exe(sender, this, args);
				return true;
			}
			else if(cmd.getName().equalsIgnoreCase("tp"))
			{
				TpOverride.exeCB((BlockCommandSender)sender, args, args.length < 3 ? "tpo " : "tele ");
				return true;
			}
			else if(cmd.getName().equalsIgnoreCase("tphere"))
			{
				TpOverride.exeCB((BlockCommandSender)sender, args, "tpohere ");
				return true;
			}
		}
		
		if(sender instanceof Player)
			p = (Player)sender;
		else
		{
			System.out.println("[" + getDescription().getName() + "] The console cannot use this plugin.");
			return true;
		}

		for(ISecutilCommand secutilCmd : commands)
		{
			if(secutilCmd.getLabel().equalsIgnoreCase(cmd.getName()))
			{
				if(hasAPermission(p, secutilCmd.getRequiredPermission()))
				{
					if(secutilCmd.allowedArgumentLengths().contains(args.length))
					{
						secutilCmd.exe(p, this, args);
						return true;
					}
					else
						return false;
				}
			}
		}
		
		if(cmd.getName().equalsIgnoreCase("tp"))
		{
			TpOverride.exe(p, args, args.length < 3 ? "tpo " : "tele ");
			return true;
		}
		else if(cmd.getName().equalsIgnoreCase("tphere"))
		{
			TpOverride.exe(p, args, "tpohere ");
			return true;
		}
		
		return false;
	}
	
	private boolean hasAPermission(Player p, String[] perms)
	{
		if(perms == null) //player does not need a permission for the command
			return true;
		
		for(String s : perms)
		{
			if(p.hasPermission(s))
				return true;
		}
		
		return false;
	}
}