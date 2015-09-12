package bl4ckscor3.plugin.secutilities.commands;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import bl4ckscor3.plugin.bl4ckkitCore.core.bl4ckkitCore;

public class MaxPlayers implements ISecutilCommand
{
	private static int playerCount = 0;
	
	@Override
	public void exe(CommandSender sender, Player p, Plugin pl, String[] args) throws Exception
	{
		bl4ckkitCore.getMessageManager().sendChatMessage(sender, pl, "A maximum of " + ChatColor.GOLD + getMaxPlayerCount(pl) + ChatColor.RESET + " players have joined the server at once.");
	}

	@Override
	public String getLabel()
	{
		return "maxplayers";
	}

	@Override
	public String[] getRequiredPermission()
	{
		return null;
	}

	@Override
	public List<Integer> allowedArgumentLengths()
	{
		return Arrays.asList(new Integer[]{0});
	}

	@Override
	public boolean isConsoleCommand()
	{
		return true;
	}
	
	public static void setPlayerCountOnEnable(int count)
	{
		playerCount = count;
	}

	public static void increase(Plugin pl)
	{
		playerCount++;
		
		if(getMaxPlayerCount(pl) < playerCount)
			setMaxPlayerCount(pl, playerCount);
			
	}
	
	public static void decrease(Plugin pl)
	{
		if(playerCount > 0)
			playerCount--;
	}
	
	private static int getMaxPlayerCount(Plugin pl)
	{
		return YamlConfiguration.loadConfiguration(new File(pl.getDataFolder(), "maxPlayers.yml")).getInt("count");
	}
	
	private static void setMaxPlayerCount(Plugin pl, int count)
	{
		YamlConfiguration.loadConfiguration(new File(pl.getDataFolder(), "maxPlayers.yml")).set("count", count);
	}
}
