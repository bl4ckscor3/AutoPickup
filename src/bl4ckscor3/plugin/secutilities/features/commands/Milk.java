package bl4ckscor3.plugin.secutilities.features.commands;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;

public class Milk implements ISecutilCommand
{
	public void exe(Player p, Plugin pl, String[] args)
	{
		if(args.length == 1)
		{
			if(p.hasPermission("secutil.milk.others"))
			{
				Player player = Bukkit.getPlayer(args[0]);
				
				if(pl == null)
				{
					p.sendMessage("[" + ChatColor.BLUE + pl.getDescription().getName() + ChatColor.RESET + "] " + args[0] + " is currently not online.");
					return;
				}
				
				Collection<PotionEffect> effects = player.getActivePotionEffects();
				
				for(PotionEffect effect : effects)
				{
					p.removePotionEffect(effect.getType());
				}
				
				p.sendMessage("[" + ChatColor.BLUE + pl.getDescription().getName() + ChatColor.RESET + "] You removed all potion effects from " + args[0] + ".");
			}
		}
		else
		{
			if(p.hasPermission("secutil.milk.own"))
			{
				Collection<PotionEffect> effects = p.getActivePotionEffects();

				for(PotionEffect effect : effects)
				{
					p.removePotionEffect(effect.getType());
				}

				p.sendMessage("[" + ChatColor.BLUE + pl.getDescription().getName() + ChatColor.RESET + "] You removed all your potion effects.");
			}
		}
	}

	public String getLabel()
	{
		return "milk";
	}

	public String[] getRequiredPermission()
	{
		return new String[]{"secutil.milk.others", "secutil.milk.own"};
	}

	public List<Integer> allowedArgumentLengths()
	{
		return Arrays.asList(new Integer[]{0, 1});
	}
}
