package bl4ckscor3.plugin.secutilities.features.loctool.commands;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class LocTool
{
	public static void exe(Player p, Plugin plugin)
	{
		ItemStack stack = new ItemStack(Material.PAPER);
		ItemMeta meta = stack.getItemMeta();
		
		meta.setDisplayName("Location Tool");
		stack.setItemMeta(meta);
		p.getInventory().addItem(stack);
	}
}
