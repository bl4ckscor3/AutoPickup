package bl4ckscor3.plugin.secutilities.listener;

import java.io.File;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.plugin.Plugin;

public class SignChangeListener implements Listener
{
	private Plugin plugin;
	
	public SignChangeListener(Plugin pl)
	{
		plugin = pl;
	}
	
	@EventHandler
	public void onSignChange(SignChangeEvent event)
	{
		if(event.getLine(0).equalsIgnoreCase("[CWarp]"))
		{
			File f = new File(plugin.getDataFolder(), "/warps/" + event.getLine(1) + ".yml");

			if(!f.exists())
			{
				event.setLine(0, ChatColor.DARK_RED + "[CWarp]");
				return;
			}
			
			event.setLine(0, ChatColor.DARK_GREEN + "[CWarp]");
			event.setLine(1, f.getName().split("\\.")[0]);
		}
	}
}
