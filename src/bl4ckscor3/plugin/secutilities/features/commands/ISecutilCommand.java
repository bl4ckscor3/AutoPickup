package bl4ckscor3.plugin.secutilities.features.commands;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public interface ISecutilCommand
{
	public void exe(Player p, Plugin pl, String[] args);
	
	public String getLabel();
	
	public String[] getRequiredPermission();
	
	public List<Integer> allowedArgumentLengths();
}
