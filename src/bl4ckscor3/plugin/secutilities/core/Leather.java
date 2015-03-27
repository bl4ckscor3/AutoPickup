package bl4ckscor3.plugin.secutilities.core;

import java.util.Arrays;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.Plugin;

import bl4ckscor3.plugin.secutilities.features.commands.ISecutilCommand;

public class Leather implements ISecutilCommand
{
	@Override
	public void exe(Player p, Plugin pl, String[] args)
	{
		ItemStack stack = new ItemStack(resolveArmorPart(args[0]));
		LeatherArmorMeta meta;
		
		if(stack.getType() == Material.COAL)
		{
			p.sendMessage("[" + ChatColor.BLUE + pl.getDescription().getName() + ChatColor.RESET + "] Available armor pieces are: helmet, chestplate, pants, leggings and boots.");
			return;
		}

		if(!args[1].startsWith("0x"))
			args[1] = "0x" + args[1];
		else if(args[1].startsWith("#"))
			args[1] = args[1].replace("#", "0x");
		
		args[1] = args[1].split("x")[1];
		args[1] = args[1].toUpperCase();
		
		int r = Integer.parseInt(args[1].substring(0, 2), 16);
		int g = Integer.parseInt(args[1].substring(2, 4), 16);
		int b = Integer.parseInt(args[1].substring(4), 16);
		
		meta = (LeatherArmorMeta)stack.getItemMeta();
		meta.setColor(Color.fromRGB(r, g, b));
		stack.setItemMeta(meta);
		p.getInventory().addItem(stack);
	}

	@Override
	public String getLabel()
	{
		return "leather";
	}

	@Override
	public String[] getRequiredPermission()
	{
		return new String[]{"secutil.leather.use"};
	}

	@Override
	public List<Integer> allowedArgumentLengths()
	{
		return Arrays.asList(new Integer[]{2});
	}
	
	private static Material resolveArmorPart(String part)
	{
		switch(part)
		{
			case "helmet":
				return Material.LEATHER_HELMET;
			case "chestplate":
				return Material.LEATHER_CHESTPLATE;
			case "pants": case "leggings":
				return Material.LEATHER_LEGGINGS;
			case "boots":
				return Material.LEATHER_BOOTS;
			default:
				return Material.COAL; //placeholder to determine that something went wrong
		}
	}
}
