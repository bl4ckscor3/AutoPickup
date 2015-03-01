package bl4ckscor3.plugin.secutilities.util;

import org.bukkit.plugin.Plugin;

import bl4ckscor3.plugin.secutilities.core.Secutilities;
import bl4ckscor3.plugin.secutilities.exception.PluginNotInstalledException;

public class Utilities
{
	public static Plugin getPlugin(Secutilities secutil, String name) throws PluginNotInstalledException
	{
		Plugin plugin = secutil.getServer().getPluginManager().getPlugin(name);
		
		if(plugin == null)
			throw new PluginNotInstalledException(name);
		return plugin;
	}
}
