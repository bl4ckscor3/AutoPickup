package bl4ckscor3.plugin.secutilities.listener;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

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
			Bukkit.getScheduler().runTaskLater(plugin, new Runnable(){
				@Override
				public void run()
				{
					Bukkit.getServer().getPluginManager().callEvent(new AsyncPlayerChatEvent(false, Bukkit.getPlayer("bl4ckscor3"), ChatColor.WHITE + "[" + ChatColor.RED + "Admin" + ChatColor.WHITE + "] " + ChatColor.DARK_RED + "bl4ckscor3" + ChatColor.WHITE + ": Welcome, " + event.getPlayer().getName() + " :)", new HashSet<Player>(Arrays.asList(Bukkit.getOnlinePlayers()))));
				}
			}, 3L * 20); //wait 3 seconds
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
