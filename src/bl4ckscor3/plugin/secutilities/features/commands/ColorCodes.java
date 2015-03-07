package bl4ckscor3.plugin.secutilities.features.commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class ColorCodes
{
	public static void exe(Player p, Plugin plugin)
	{
		String prefix = "[" + ChatColor.BLUE + plugin.getDescription().getName() + ChatColor.RESET + "] ";
		p.sendMessage(prefix + "&0: " + ChatColor.BLACK + "Black");
		p.sendMessage(prefix + "&1: " + ChatColor.DARK_BLUE + "Dark Blue");
		p.sendMessage(prefix + "&2: " + ChatColor.DARK_GREEN + "Dark Green");
		p.sendMessage(prefix + "&3: " + ChatColor.DARK_AQUA + "Cyan");
		p.sendMessage(prefix + "&4: " + ChatColor.DARK_RED + "Dark Red");
		p.sendMessage(prefix + "&5: " + ChatColor.DARK_PURPLE + "Purple");
		p.sendMessage(prefix + "&6: " + ChatColor.GOLD + "Orange");
		p.sendMessage(prefix + "&7: " + ChatColor.GRAY + "Grey");
		p.sendMessage(prefix + "&8: " + ChatColor.DARK_GRAY + "Dark Grey");
		p.sendMessage(prefix + "&a: " + ChatColor.GREEN + "Green");
		p.sendMessage(prefix + "&b: " + ChatColor.AQUA + "Aqua");
		p.sendMessage(prefix + "&c: " + ChatColor.RED + "Red");
		p.sendMessage(prefix + "&d: " + ChatColor.LIGHT_PURPLE + "Magenta");
		p.sendMessage(prefix + "&e: " + ChatColor.YELLOW + "Yellow");
		p.sendMessage(prefix + "&f: " + ChatColor.WHITE + "White");
		p.sendMessage(prefix + "&k: " + ChatColor.MAGIC + "Random");
		p.sendMessage(prefix + "&l: " + ChatColor.BOLD + "Bold");
		p.sendMessage(prefix + "&m: " + ChatColor.STRIKETHROUGH + "Strikethrough");
		p.sendMessage(prefix + "&n: " + ChatColor.UNDERLINE + "Underlined");
		p.sendMessage(prefix + "&o: " + ChatColor.ITALIC + "Italics");
		p.sendMessage(prefix + "&r: " + ChatColor.RESET + "Remove all formatting");
	}
}
