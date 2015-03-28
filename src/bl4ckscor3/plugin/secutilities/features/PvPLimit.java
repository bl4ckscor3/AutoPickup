package bl4ckscor3.plugin.secutilities.features;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

import bl4ckscor3.plugin.secutilities.core.Secutilities;
import bl4ckscor3.plugin.secutilities.exception.PluginNotInstalledException;
import bl4ckscor3.plugin.secutilities.util.Utilities;

import com.earth2me.essentials.Essentials;
import com.earth2me.essentials.User;
import com.mewin.WGRegionEvents.events.RegionEnteredEvent;

//This is semi hardcoded for BreakIn' Bad
public class PvPLimit implements Listener
{
	private static Plugin plugin;
	private static Essentials ess;
	private static List<String> regions = new ArrayList<String>();

	public static void setup(Plugin pl) throws PluginNotInstalledException
	{
		plugin = pl;
		ess = (Essentials)Utilities.getPlugin((Secutilities)plugin, "Essentials");
		regions.add("pvp");
		regions.add("pvp_autumn");
		regions.add("pvp_yoshiland");
	}

	@EventHandler
	public void onRegionEntered(RegionEnteredEvent event) throws IOException
	{
		if(regions.contains(event.getRegion().getId()))
		{
			if(event.getPlayer().hasPermission("secutil.pvplimit.bypass"))
				return;

			User u = ess.getUser(event.getPlayer());
			boolean cheatWasEnabled = false;

			if(u.isGodModeEnabled())
			{
				u.setGodModeEnabled(false);
				cheatWasEnabled = true;
			}

			u.setAllowFlight(false);

			if(u.getWalkSpeed() >= 1.0F)
			{
				u.setWalkSpeed(0.2F);
				cheatWasEnabled = true;
			}

			if(cheatWasEnabled)
				event.getPlayer().sendMessage("[" + ChatColor.BLUE + plugin.getDescription().getName() + ChatColor.RESET + "] You are not allowed to have cheats enabled in the PvP-Arena.");
		}
	}
}