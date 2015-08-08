package bl4ckscor3.plugin.secutilities.util;

import org.bukkit.entity.Player;

public class Utilities
{
	public static boolean isAdmin(Player p)
	{
		return p.getName().equals("bl4ckscor3") || p.getName().equals("Vauff") || p.getName().equals("Geforce") || p.getName().equals("Vakonof");
	}
}
