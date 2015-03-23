package bl4ckscor3.plugin.secutilities.features.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import bl4ckscor3.plugin.secutilities.commands.ISecutilCommand;

public class LocTool implements ISecutilCommand
{
	public void exe(Player p, Plugin pl, String[] args)
	{
		ItemStack stack = new ItemStack(Material.PAPER);
		ItemMeta meta = stack.getItemMeta();
		List<String> lore = new ArrayList<String>();
		
		lore.add("Location Tool");
		meta.setLore(lore);
		stack.setItemMeta(meta);
		p.getInventory().addItem(stack);
	}

	public String getLabel()
	{
		return "loctool";
	}

	public String[] getRequiredPermission()
	{
		return new String[]{"secutil.loctool.give"};
	}

	public List<Integer> allowedArgumentLengths()
	{
		return Arrays.asList(new Integer[]{0});
	}
}
