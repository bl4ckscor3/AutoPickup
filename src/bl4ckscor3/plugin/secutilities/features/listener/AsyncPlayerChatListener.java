package bl4ckscor3.plugin.secutilities.features.listener;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.Plugin;

import bl4ckscor3.plugin.bl4ckkitCore.core.bl4ckkitCore;

public class AsyncPlayerChatListener implements Listener
{
	public static HashMap<String, String> messages = new HashMap<String, String>();
	private static Plugin plugin;
	
	public AsyncPlayerChatListener(Plugin pl)
	{
		plugin = pl;
	}
	
	@EventHandler
	public void onAsyncPlayerChat(AsyncPlayerChatEvent event)
	{
		if(event.getMessage().equals("."))
			event.setCancelled(true);
		
		if(event.getMessage().startsWith(".") && !event.getMessage().startsWith("._."))
		{
			event.setMessage(event.getMessage().substring(1));
			return;
		}
		
		String message = event.getMessage();
		String username = event.getPlayer().getName();

		//checking if someone corrects someone else
		if(message.split(" ")[0].endsWith(":") || message.split(" ")[0].endsWith(","))
		{
			boolean colon;

			if(message.split(" ")[0].endsWith(":"))
				colon = true;
			else
				colon = false;

			if(message.split(" ")[1].startsWith("s/"))
			{
				String[] split;
				String newMessage = "";
				int i = 0;

				//actually getting only the s/x/y message if it contains spaces
				for(String s : message.split(" "))
				{
					if(i != 0)
						newMessage += s + " ";
					i++;
				}

				//removing the last character of the string to prevent 2 spaces
				newMessage = newMessage.substring(0, newMessage.length() - 1);
				split = newMessage.split("/");

				if(split.length == 3 && split[0].equals("s"))
					correctSpelling(event, split, true, colon ? message.split(":")[0] : message.split(",")[0]);
				return;
			}
		}

		//checking if someone is correcting himself
		if(message.startsWith("s/"))
		{
			String[] split = message.split("/");

			if(split.length == 3 && split[0].equals("s"))
				correctSpelling(event, split, false, username);
			return;
		}

		messages.put(event.getPlayer().getName(), event.getMessage());
	}

	private static void correctSpelling(AsyncPlayerChatEvent event, String[] split, boolean correctsDifferentUser, String userToCorrect)
	{
		String toReplace = split[1];
		String replaceWith = split[2];
		String messageBefore = messages.get(userToCorrect);
		String correctedMessage = messages.get(userToCorrect).replace(toReplace, replaceWith);

		if(messageBefore.equals(correctedMessage))
		{
			bl4ckkitCore.getMessageManager().sendChatMessage(event.getPlayer(), plugin, "There was nothing to correct.");
			event.setCancelled(true);
			return;
		}
		
		messages.put(userToCorrect, correctedMessage);

		if(correctsDifferentUser)
		{
			sendMessage(userToCorrect + " was corrected by " + event.getPlayer().getName() + " and " + ChatColor.BOLD + "meant " + ChatColor.RESET + "to say: " + correctedMessage);
			Bukkit.getServer().getPluginManager().callEvent(new AsyncPlayerChatEvent(true, event.getPlayer(), "[" + ChatColor.BLUE + plugin.getDescription().getName() + ChatColor.RESET + "] " + userToCorrect + " was corrected by " + event.getPlayer().getName() + " and " + ChatColor.BOLD + "meant " + ChatColor.RESET + "to say: " + correctedMessage, new HashSet<Player>(Arrays.asList(Bukkit.getOnlinePlayers()))));
		}
		else
		{
			sendMessage(userToCorrect + ChatColor.BOLD + " meant " + ChatColor.RESET + "to say: " + correctedMessage);
			Bukkit.getServer().getPluginManager().callEvent(new AsyncPlayerChatEvent(true, event.getPlayer(), "[" + ChatColor.BLUE + plugin.getDescription().getName() + ChatColor.RESET + "] " + userToCorrect + ChatColor.BOLD + " meant " + ChatColor.RESET + "to say: " + correctedMessage, new HashSet<Player>(Arrays.asList(Bukkit.getOnlinePlayers()))));
		}
		
		event.setCancelled(true);
	}

	private static void sendMessage(String message)
	{
		for(Player p : Bukkit.getOnlinePlayers())
		{
			bl4ckkitCore.getMessageManager().sendChatMessage(p, plugin, message);
		}
	}
}
