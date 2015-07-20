package bl4ckscor3.plugin.secutilities.commands;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.Plugin;

import com.earth2me.essentials.Essentials;
import com.earth2me.essentials.User;

import bl4ckscor3.plugin.bl4ckkitCore.core.bl4ckkitCore;
import bl4ckscor3.plugin.bl4ckkitCore.exception.PluginNotInstalledException;

public class GiveSkull implements ISecutilCommand
{
	@Override
	public void exe(CommandSender sender, Player p, Plugin pl, String[] args) throws InterruptedException, PluginNotInstalledException
	{
		Player receiver = Bukkit.getPlayer(args[1]);
		User u = ((Essentials)bl4ckkitCore.getPluginManager().getPlugin(pl, "Essentials")).getUser(receiver);
		ItemStack stack = new ItemStack(Material.SKULL_ITEM, Integer.parseInt(args[2]), (byte) 3);
		SkullMeta meta = (SkullMeta)stack.getItemMeta();
		HashMap<Integer,ItemStack> overflow = new HashMap<Integer,ItemStack>();
		
		if(u.getMoney().intValue() < Integer.parseInt(args[2]) * 150) //a skull costs $150
		{
			bl4ckkitCore.getMessageManager().sendChatMessage(sender, pl, "User has insufficient funds: " + u.getMoney());
			return;
		}
		
		meta.setOwner(args[0]);
		meta.setDisplayName(ChatColor.WHITE + "Skull of " + args[0]);
		stack.setItemMeta(meta);
		Bukkit.dispatchCommand(sender, "eco take " + args[1] + " " + (Integer.parseInt(args[2]) * 150));
		overflow = receiver.getInventory().addItem(stack);
		
		if(!overflow.isEmpty())
		{
			for(ItemStack is : overflow.values())
			{
				p.getInventory().addItem(is);
			}
			
			bl4ckkitCore.getMessageManager().sendChatMessage(sender, pl, "User had insufficient inventory space. The excess items have been added to your inventory.");
		}
	}

	@Override
	public String getLabel()
	{
		return "giveskull";
	}

	@Override
	public String[] getRequiredPermission()
	{
		return new String[]{"secutil.giveskull.use"};
	}

	@Override
	public List<Integer> allowedArgumentLengths()
	{
		return Arrays.asList(new Integer[]{3});
	}

	@Override
	public boolean isConsoleCommand()
	{
		return true;
	}
}
