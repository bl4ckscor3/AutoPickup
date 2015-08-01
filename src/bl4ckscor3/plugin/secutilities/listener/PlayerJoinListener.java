package bl4ckscor3.plugin.secutilities.listener;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

import bl4ckscor3.plugin.bl4ckkitCore.core.bl4ckkitCore;

public class PlayerJoinListener implements Listener
{
	private static Plugin plugin;
	private static final List<String> playersJoined = new ArrayList<String>(); 

	public PlayerJoinListener(Plugin pl)
	{
		plugin = pl;
	}

	@EventHandler
	public void onPlayerJoin(final PlayerJoinEvent event)
	{
		if(event.getPlayer().getName().equals("Vauff"))
		{
			for(Player p : Bukkit.getOnlinePlayers())
			{
				if(p.hasPermission("secutil.showSJ"))
					bl4ckkitCore.getMessageManager().sendChatMessage(p, plugin, "Vauff silently joined.");
			}
		}

		if(!playersJoined.contains(event.getPlayer().getName()))
		{
			Random r = new Random();

			if(bl4ckkitCore.getPlayerManager().isPlayerOnline("bl4ckscor3"))
			{
				Bukkit.getScheduler().runTaskLater(plugin, new Runnable(){
					@Override
					public void run()
					{
						String message = ChatColor.WHITE + "[" + ChatColor.RED + "Admin" + ChatColor.WHITE + "] " + ChatColor.DARK_RED + "bl4ckscor3" + ChatColor.WHITE + ": Welcome " + event.getPlayer().getName() + " :)";
						
						for(Player p : Bukkit.getOnlinePlayers())
						{
							p.sendMessage(message);
						}
						
						Bukkit.getServer().getPluginManager().callEvent(new AsyncPlayerChatEvent(false, Bukkit.getPlayer("bl4ckscor3"), message, new HashSet<Player>(Arrays.asList(Bukkit.getOnlinePlayers()))));
					}
				}, 3L + (long)r.nextInt(6) * 20); //wait 3 seconds
			}

			if(bl4ckkitCore.getPlayerManager().isPlayerOnline("Vauff"))
			{
				Bukkit.getScheduler().runTaskLater(plugin, new Runnable(){
					@Override
					public void run()
					{
						String message = ChatColor.WHITE + "[" + ChatColor.RED + "Admin" + ChatColor.WHITE + "] " + ChatColor.DARK_RED + "Vauff" + ChatColor.WHITE + ": welcome " + event.getPlayer().getName() + "!";
						
						for(Player p : Bukkit.getOnlinePlayers())
						{
							p.sendMessage(message);
						}
						
						Bukkit.getServer().getPluginManager().callEvent(new AsyncPlayerChatEvent(false, Bukkit.getPlayer("Vauff"), message, new HashSet<Player>(Arrays.asList(Bukkit.getOnlinePlayers()))));
					}
				}, 3L + (long)r.nextInt(6) * 20); //wait 3 seconds
			}
			
			playersJoined.add(event.getPlayer().getName());
		}
	}

	public static void setupPlayerList()
	{
		for(File f : new File("world/players").listFiles())
		{
			playersJoined.add(f.getName().split(".")[0]);
		}
	}
}
