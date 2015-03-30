package bl4ckscor3.plugin.secutilities.features.commands;

import java.util.Arrays;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import bl4ckscor3.plugin.bl4ckkitCore.core.bl4ckkitCore;

public class ColorCodes implements ISecutilCommand
{
	public void exe(Player p, Plugin pl, String[] args)
	{
		bl4ckkitCore.getMessageManager().sendChatMessage(p, pl, "&0: " + ChatColor.BLACK + "Black");
		bl4ckkitCore.getMessageManager().sendChatMessage(p, pl, "&1: " + ChatColor.DARK_BLUE + "Dark Blue");
		bl4ckkitCore.getMessageManager().sendChatMessage(p, pl, "&2: " + ChatColor.DARK_GREEN + "Dark Green");
		bl4ckkitCore.getMessageManager().sendChatMessage(p, pl, "&3: " + ChatColor.DARK_AQUA + "Cyan");
		bl4ckkitCore.getMessageManager().sendChatMessage(p, pl, "&4: " + ChatColor.DARK_RED + "Dark Red");
		bl4ckkitCore.getMessageManager().sendChatMessage(p, pl, "&5: " + ChatColor.DARK_PURPLE + "Purple");
		bl4ckkitCore.getMessageManager().sendChatMessage(p, pl, "&6: " + ChatColor.GOLD + "Orange");
		bl4ckkitCore.getMessageManager().sendChatMessage(p, pl, "&7: " + ChatColor.GRAY + "Grey");
		bl4ckkitCore.getMessageManager().sendChatMessage(p, pl, "&8: " + ChatColor.DARK_GRAY + "Dark Grey");
		bl4ckkitCore.getMessageManager().sendChatMessage(p, pl, "&a: " + ChatColor.GREEN + "Green");
		bl4ckkitCore.getMessageManager().sendChatMessage(p, pl, "&b: " + ChatColor.AQUA + "Aqua");
		bl4ckkitCore.getMessageManager().sendChatMessage(p, pl, "&c: " + ChatColor.RED + "Red");
		bl4ckkitCore.getMessageManager().sendChatMessage(p, pl, "&d: " + ChatColor.LIGHT_PURPLE + "Magenta");
		bl4ckkitCore.getMessageManager().sendChatMessage(p, pl, "&e: " + ChatColor.YELLOW + "Yellow");
		bl4ckkitCore.getMessageManager().sendChatMessage(p, pl, "&f: " + ChatColor.WHITE + "White");
		bl4ckkitCore.getMessageManager().sendChatMessage(p, pl, "&k: " + ChatColor.MAGIC + "Random");
		bl4ckkitCore.getMessageManager().sendChatMessage(p, pl, "&l: " + ChatColor.BOLD + "Bold");
		bl4ckkitCore.getMessageManager().sendChatMessage(p, pl, "&m: " + ChatColor.STRIKETHROUGH + "Strikethrough");
		bl4ckkitCore.getMessageManager().sendChatMessage(p, pl, "&n: " + ChatColor.UNDERLINE + "Underlined");
		bl4ckkitCore.getMessageManager().sendChatMessage(p, pl, "&o: " + ChatColor.ITALIC + "Italics");
		bl4ckkitCore.getMessageManager().sendChatMessage(p, pl, "&r: " + ChatColor.RESET + "Remove all formatting");
	}
	
	public String getLabel()
	{
		return "colorcodes";
	}

	public String[] getRequiredPermission()
	{
		return new String[]{"secutil.colorcodes"};
	}

	public List<Integer> allowedArgumentLengths()
	{
		return Arrays.asList(new Integer[]{0});
	}
}
