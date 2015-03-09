package bl4ckscor3.plugin.secutilities.features.commands;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class TpOverride
{
	public static void exe(Player p, String[] args, String cmd)
	{
		for(String s : args)
		{
			cmd += s + " ";
		}

		Bukkit.dispatchCommand(p, cmd.substring(0, cmd.length() - 1));
	}
}
