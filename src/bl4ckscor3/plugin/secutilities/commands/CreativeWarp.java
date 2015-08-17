package bl4ckscor3.plugin.secutilities.commands;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.plugin.Plugin;

import bl4ckscor3.plugin.bl4ckkitCore.core.bl4ckkitCore;

public class CreativeWarp implements ISecutilCommand
{
	@Override
	public void exe(CommandSender sender, Player p, Plugin pl, String[] args) throws Exception
	{
		if(args[0].equalsIgnoreCase("set") && p.hasPermission("secutil.cwarp.create"))
		{
			if(args.length == 2)
			{
				File f = new File(pl.getDataFolder(), "/warps/" + args[1] +".yml");
				YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

				if(!f.exists())
					f.createNewFile();
				else
				{
					bl4ckkitCore.getMessageManager().sendChatMessage(p, pl, "This warp already exists.");
					return;
				}
				
				if(!p.getWorld().getName().equals("creative"))
				{
					bl4ckkitCore.getMessageManager().sendChatMessage(p, pl, "You can only set these types of warps in the creative world.");
					f.delete();
					return;
				}
				
				yaml.set("x", p.getLocation().getX());
				yaml.set("y", p.getLocation().getY());
				yaml.set("z", p.getLocation().getZ());
				yaml.set("pitch", p.getLocation().getPitch());
				yaml.set("yaw", p.getLocation().getYaw());
				yaml.save(f);
				bl4ckkitCore.getMessageManager().sendChatMessage(p, pl, "Creative warp " + ChatColor.AQUA + args[1] + ChatColor.WHITE + " has been set at your coordinates.");
			}
			else
				bl4ckkitCore.getMessageManager().sendChatMessage(p, pl, "You need to specify a warp name!");
		}
		else if(args[0].equalsIgnoreCase("delete") && p.hasPermission("secutil.cwarp.delete"))
		{
			if(args.length == 2)
			{
				File f = new File(pl.getDataFolder(), "/warps/" + args[1] + ".yml");

				if(!f.exists())
				{
					bl4ckkitCore.getMessageManager().sendChatMessage(p, pl, "This warp does not exist.");
					return;
				}

				f.delete();
				bl4ckkitCore.getMessageManager().sendChatMessage(p, pl, "Creative warp " + ChatColor.AQUA + args[1] + ChatColor.WHITE + " has been deleted.");
			}
			else
				bl4ckkitCore.getMessageManager().sendChatMessage(p, pl, "You need to specify a warp name!");
		}
		else if(args[0].equalsIgnoreCase("list") && p.hasPermission("secutil.cwarp.warp"))
		{
			File folder = new File(pl.getDataFolder(), "warps");
			File[] list = folder.listFiles();
			String warpsInString = "";
			boolean blue = false;

			for(File f : list)
			{
				warpsInString += (blue ? ChatColor.AQUA : ChatColor.WHITE) + f.getName().split("\\.")[0] + " ";
				blue = !blue;
			}

			bl4ckkitCore.getMessageManager().sendChatMessage(p, pl, warpsInString.equals("") ? "There are no warps set." : warpsInString);
		}
		else
		{
			if(p.hasPermission("secutil.cwarp.warp"))
			{
				File f = new File(pl.getDataFolder(), "/warps/" + args[0] + ".yml");
				YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

				if(!f.exists())
				{
					bl4ckkitCore.getMessageManager().sendChatMessage(p, pl, "This warp does not exist.");
					return;
				}

				p.teleport(new Location(Bukkit.getWorld("creative"), yaml.getDouble("x"), yaml.getDouble("y"), yaml.getDouble("z"), (float)yaml.getDouble("yaw"), (float)yaml.getDouble("pitch")), TeleportCause.COMMAND);
				bl4ckkitCore.getMessageManager().sendChatMessage(p, pl, "Warped to " + ChatColor.AQUA + args[0] + ChatColor.WHITE + ".");
			}
		}
	}

	@Override
	public String getLabel()
	{
		return "creative";
	}

	@Override
	public String[] getRequiredPermission()
	{
		return new String[]{"secutil.cwarp.create", "secutil.cwarp.delete", "secutil.cwarp.warp"};
	}

	@Override
	public List<Integer> allowedArgumentLengths()
	{
		return Arrays.asList(new Integer[]{1,2});
	}

	@Override
	public boolean isConsoleCommand()
	{
		return false;
	}
}
