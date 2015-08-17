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
import bl4ckscor3.plugin.secutilities.commands.BlockBreak;
import bl4ckscor3.plugin.secutilities.commands.BlockPlace;
import bl4ckscor3.plugin.secutilities.commands.ColorCodes;
import bl4ckscor3.plugin.secutilities.commands.CreativeWarp;
import bl4ckscor3.plugin.secutilities.commands.GiveSkull;
import bl4ckscor3.plugin.secutilities.commands.ISecutilCommand;
import bl4ckscor3.plugin.secutilities.commands.Leather;
import bl4ckscor3.plugin.secutilities.commands.LocTool;
import bl4ckscor3.plugin.secutilities.commands.Milk;
import bl4ckscor3.plugin.secutilities.commands.PvPCountdown;
import bl4ckscor3.plugin.secutilities.commands.SignBreak;
import bl4ckscor3.plugin.secutilities.commands.TpOverride;
import bl4ckscor3.plugin.secutilities.commands.UniquePlayers;
import bl4ckscor3.plugin.secutilities.listener.AsyncPlayerChatListener;
import bl4ckscor3.plugin.secutilities.listener.BlockBreakListener;
import bl4ckscor3.plugin.secutilities.listener.BlockPlaceListener;
import bl4ckscor3.plugin.secutilities.listener.PlayerCommandPreprocessListener;
import bl4ckscor3.plugin.secutilities.listener.PlayerInteractListener;
import bl4ckscor3.plugin.secutilities.listener.PlayerJoinListener;
import bl4ckscor3.plugin.secutilities.listener.PlayerQuitListener;
import bl4ckscor3.plugin.secutilities.listener.PlayerTeleportListener;
import bl4ckscor3.plugin.secutilities.listener.SignChangeListener;
import bl4ckscor3.plugin.secutilities.listener.WorldJoinListener;
import bl4ckscor3.plugin.secutilities.misc.DonatorRoomEntrance;
import bl4ckscor3.plugin.secutilities.misc.Misc;
import bl4ckscor3.plugin.secutilities.misc.PvPLimit;
import bl4ckscor3.plugin.secutilities.misc.ToggleFloor;

public class Secutilities extends JavaPlugin
{
	private static final LinkedList<ISecutilCommand> commands = new LinkedList<ISecutilCommand>();

	private void setupCommands()
	{
		commands.add(new BlockBreak());
		commands.add(new BlockPlace());
		commands.add(new ColorCodes());
		commands.add(new CreativeWarp());
		commands.add(new GiveSkull());
		commands.add(new Leather());
		commands.add(new LocTool());
		commands.add(new Milk());
		commands.add(new SignBreak());
		commands.add(new UniquePlayers());
	}

	@Override
	public void onEnable()
	{
		bl4ckkitCore.registerPlugin(this);
		bl4ckkitCore.getPluginManager().registerEvents(this,
				new BlockBreakListener(this),
				new BlockPlaceListener(),
				new PlayerInteractListener(this),
				new PvPLimit(),
				new AsyncPlayerChatListener(this),
				new PlayerQuitListener(),
				new DonatorRoomEntrance(),
				new PlayerTeleportListener(),
				new PlayerJoinListener(this),
				new WorldJoinListener(),
				new Misc(),
				new SignChangeListener(this),
				new PlayerCommandPreprocessListener());
		setupCommands();

		try
		{
			PvPLimit.setup(this);
		}
		catch(PluginNotInstalledException e)
		{
			e.printStackTrace();
		}

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
						catch (Exception e)
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