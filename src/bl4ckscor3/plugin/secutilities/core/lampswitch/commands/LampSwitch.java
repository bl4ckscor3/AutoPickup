package bl4ckscor3.plugin.secutilities.core.lampswitch.commands;


import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import bl4ckscor3.plugin.secutilities.core.lampswitch.listener.PlayerInteractListener;

public class LampSwitch
{
	public static void exe(Player p, Plugin plugin)
	{
		if(!PlayerInteractListener.lampSwitchOn.contains(p.getName()))
		{
			PlayerInteractListener.lampSwitchOn.add(p.getName());
			p.sendMessage("[" + ChatColor.BLUE + plugin.getDescription().getName() + ChatColor.RESET + "] You can now toggle redstone lamps via a rightclick.");
		}
		else
		{
			PlayerInteractListener.lampSwitchOn.remove(p.getName());
			p.sendMessage("[" + ChatColor.BLUE + plugin.getDescription().getName() + ChatColor.RESET + "] You can no longer toggle redstone lamps.");
		}
	}
}
