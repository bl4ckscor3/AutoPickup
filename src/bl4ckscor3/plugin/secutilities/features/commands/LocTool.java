package bl4ckscor3.plugin.secutilities.features.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class LocTool implements ISecutilCommand
{
	public void exe(CommandSender sender, Player p, Plugin pl, String[] args)
	{
		ItemStack stack = new ItemStack(Material.PAPER);
		ItemMeta meta = stack.getItemMeta();
		List<String> lore = new ArrayList<String>();
		
		lore.add("Location Tool");
		meta.setLore(lore);
		stack.setItemMeta(meta);
		p.getInventory().addItem(stack);
	}

	@Override
	public String getLabel()
	{
		return "loctool";
	}

	@Override
	public String[] getRequiredPermission()
	{
		return new String[]{"secutil.loctool.give"};
	}

	@Override
	public List<Integer> allowedArgumentLengths()
	{
		return Arrays.asList(new Integer[]{0});
	}
	
	@Override
	public boolean isConsoleCommand()
	{
		return false;
	}
}
