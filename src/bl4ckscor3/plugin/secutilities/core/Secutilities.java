package bl4ckscor3.plugin.secutilities.core;

import java.util.LinkedList;

import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import bl4ckscor3.plugin.bl4ckkitCore.core.bl4ckkitCore;
import bl4ckscor3.plugin.bl4ckkitCore.exception.PluginNotInstalledException;
import bl4ckscor3.plugin.secutilities.features.DonatorRoomEntrance;
import bl4ckscor3.plugin.secutilities.features.Misc;
import bl4ckscor3.plugin.secutilities.features.PvPLimit;
import bl4ckscor3.plugin.secutilities.features.ToggleFloor;
import bl4ckscor3.plugin.secutilities.features.commands.BlockBreak;
import bl4ckscor3.plugin.secutilities.features.commands.BlockPlace;
import bl4ckscor3.plugin.secutilities.features.commands.ColorCodes;
import bl4ckscor3.plugin.secutilities.features.commands.ISecutilCommand;
import bl4ckscor3.plugin.secutilities.features.commands.Join;
import bl4ckscor3.plugin.secutilities.features.commands.Leather;
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
import bl4ckscor3.plugin.secutilities.features.listener.PlayerJoinListener;
import bl4ckscor3.plugin.secutilities.features.listener.PlayerQuitListener;
import bl4ckscor3.plugin.secutilities.features.listener.PlayerTeleportListener;
import bl4ckscor3.plugin.secutilities.features.listener.timedisplayer.PlayerCommandPreprocessListener;
import bl4ckscor3.plugin.secutilities.features.listener.timedisplayer.TDPlayerJoinListener;
import bl4ckscor3.plugin.secutilities.features.listener3.WorldJoinListener;

public class Secutilities extends JavaPlugin
{
	private static final LinkedList<ISecutilCommand> commands = new LinkedList<ISecutilCommand>();

	private void setupCommands()
	{
		commands.add(new BlockBreak());
		commands.add(new BlockPlace());
		commands.add(new ColorCodes());
		commands.add(new Join());
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
		getServer().getPluginManager().registerEvents(new PlayerQuitListener(this), this);
		getServer().getPluginManager().registerEvents(new DonatorRoomEntrance(), this);
		getServer().getPluginManager().registerEvents(new PlayerJoinListener(this), this);
		getServer().getPluginManager().registerEvents(new PlayerTeleportListener(), this);
		getServer().getPluginManager().registerEvents(new WorldJoinListener(), this);
		getServer().getPluginManager().registerEvents(new Misc(), this);
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

		bl4ckkitCore.registerPlugin(this);
		bl4ckkitCore.getMessageManager().sendEnabledMessage(this);
	}

	@Override
	public void onDisable()
	{
		bl4ckkitCore.unregisterPlugin(this);
		bl4ckkitCore.getMessageManager().sendDisabledMessage(this);
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

				try
				{
					PvPCountdown.exe(sender, this, args);
				}
				catch (InterruptedException e){}
				
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
			else if(cmd.getName().equals("togglefloor"))
			{
				ToggleFloor.exeCB((BlockCommandSender)sender, args);
			}
		}

		if(sender instanceof Player)
			p = (Player)sender;

		for(ISecutilCommand secutilCmd : commands)
		{
			if(secutilCmd.getLabel().equalsIgnoreCase(cmd.getName()))
			{
				if(hasAPermission(sender, secutilCmd.getRequiredPermission()))
				{
					if(secutilCmd.allowedArgumentLengths().contains(args.length))
					{
						if(sender instanceof ConsoleCommandSender && !secutilCmd.isConsoleCommand())
						{	
							bl4ckkitCore.getMessageManager().sendDisallowMessage(this);
							return true;
						}
						
						try
						{
							secutilCmd.exe(sender, p, this, args);
						}
						catch (InterruptedException e)
						{
							e.printStackTrace();
						}
						
						return true;
					}
					else
						return false;
				}
			}
		}

		if(cmd.getName().equalsIgnoreCase("tp"))
			TpOverride.exe(p, args, args.length < 3 ? "tpo " : "tele ");
		else if(cmd.getName().equalsIgnoreCase("tphere"))
			TpOverride.exe(p, args, "tpohere ");
		else if(cmd.getName().equalsIgnoreCase("killall") || cmd.getName().equals("butcher"))
			bl4ckkitCore.getMessageManager().sendChatMessage(p, this, "Kill commandos are blocked due to security reasons.");
		return true;
	}

	private boolean hasAPermission(CommandSender sender, String[] perms)
	{
		if(perms == null) //player does not need a permission for the command
			return true;

		for(String s : perms)
		{
			if(sender.hasPermission(s))
				return true;
		}

		return false;
	}
}