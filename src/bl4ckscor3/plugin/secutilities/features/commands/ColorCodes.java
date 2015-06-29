package bl4ckscor3.plugin.secutilities.features.commands;

import java.util.Arrays;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import bl4ckscor3.plugin.bl4ckkitCore.core.bl4ckkitCore;

public class ColorCodes implements ISecutilCommand
{
	@Override
	public void exe(CommandSender sender, Player p, Plugin pl, String[] args)
	{
		bl4ckkitCore.getMessageManager().sendChatMessage(sender, pl, "&0: " + ChatColor.BLACK + "Black");
		bl4ckkitCore.getMessageManager().sendChatMessage(sender, pl, "&1: " + ChatColor.DARK_BLUE + "Dark Blue");
		bl4ckkitCore.getMessageManager().sendChatMessage(sender, pl, "&2: " + ChatColor.DARK_GREEN + "Dark Green");
		bl4ckkitCore.getMessageManager().sendChatMessage(sender, pl, "&3: " + ChatColor.DARK_AQUA + "Cyan");
		bl4ckkitCore.getMessageManager().sendChatMessage(sender, pl, "&4: " + ChatColor.DARK_RED + "Dark Red");
		bl4ckkitCore.getMessageManager().sendChatMessage(sender, pl, "&5: " + ChatColor.DARK_PURPLE + "Purple");
		bl4ckkitCore.getMessageManager().sendChatMessage(sender, pl, "&6: " + ChatColor.GOLD + "Orange");
		bl4ckkitCore.getMessageManager().sendChatMessage(sender, pl, "&7: " + ChatColor.GRAY + "Grey");
		bl4ckkitCore.getMessageManager().sendChatMessage(sender, pl, "&8: " + ChatColor.DARK_GRAY + "Dark Grey");
		bl4ckkitCore.getMessageManager().sendChatMessage(sender, pl, "&9: " + ChatColor.BLUE + "Blue");
		bl4ckkitCore.getMessageManager().sendChatMessage(sender, pl, "&a: " + ChatColor.GREEN + "Green");
		bl4ckkitCore.getMessageManager().sendChatMessage(sender, pl, "&b: " + ChatColor.AQUA + "Aqua");
		bl4ckkitCore.getMessageManager().sendChatMessage(sender, pl, "&c: " + ChatColor.RED + "Red");
		bl4ckkitCore.getMessageManager().sendChatMessage(sender, pl, "&d: " + ChatColor.LIGHT_PURPLE + "Magenta");
		bl4ckkitCore.getMessageManager().sendChatMessage(sender, pl, "&e: " + ChatColor.YELLOW + "Yellow");
		bl4ckkitCore.getMessageManager().sendChatMessage(sender, pl, "&f: " + ChatColor.WHITE + "White");
		bl4ckkitCore.getMessageManager().sendChatMessage(sender, pl, "&k: " + ChatColor.MAGIC + "Random");
		bl4ckkitCore.getMessageManager().sendChatMessage(sender, pl, "&l: " + ChatColor.BOLD + "Bold");
		bl4ckkitCore.getMessageManager().sendChatMessage(sender, pl, "&m: " + ChatColor.STRIKETHROUGH + "Strikethrough");
		bl4ckkitCore.getMessageManager().sendChatMessage(sender, pl, "&n: " + ChatColor.UNDERLINE + "Underlined");
		bl4ckkitCore.getMessageManager().sendChatMessage(sender, pl, "&o: " + ChatColor.ITALIC + "Italics");
		bl4ckkitCore.getMessageManager().sendChatMessage(sender, pl, "&r: " + ChatColor.RESET + "Remove all formatting");
	}
	
	@Override
	public String getLabel()
	{
		return "colorcodes";
	}

	@Override
	public String[] getRequiredPermission()
	{
		return new String[]{"secutil.colorcodes"};
	}

	@Override
	public List<Integer> allowedArgumentLengths()
	{
		return Arrays.asList(new Integer[]{0});
	}
	
	@Override
	public boolean isConsoleCommand()
	{
		return true;
	}
}
