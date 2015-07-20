package bl4ckscor3.plugin.secutilities.commands;

import java.util.List;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public interface ISecutilCommand
{
	public void exe(CommandSender sender, Player p, Plugin pl, String[] args) throws Exception;
	
	public String getLabel();
	
	public String[] getRequiredPermission();
	
	public List<Integer> allowedArgumentLengths();
	
	public boolean isConsoleCommand();
}
