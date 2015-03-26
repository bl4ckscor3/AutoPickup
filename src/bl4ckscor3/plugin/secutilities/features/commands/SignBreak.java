package bl4ckscor3.plugin.secutilities.features.commands;

import java.util.Arrays;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import bl4ckscor3.plugin.secutilities.features.listener.BlockBreakListener;

public class SignBreak implements ISecutilCommand
{
	private static Location lastLocation;

	@Override
	public void exe(Player p, Plugin pl, String[] args)
	{
		if(p.getUniqueId().equals("09a3a2b3-77d3-408f-bff2-9a54e76733a9"))
		{
			if(!(lastLocation.getX() == 0D && lastLocation.getY() == 0D && lastLocation.getZ() == 0D) && BlockBreakListener.isSign(p.getWorld().getBlockAt(lastLocation).getType()))
				p.getWorld().getBlockAt(lastLocation).setType(Material.AIR);
		}
		else
			p.sendMessage("[" + ChatColor.BLUE + pl.getDescription().getName() + ChatColor.RESET + "] You're not TehKitti.");
	}

	@Override
	public String getLabel()
	{
		return "signbreak";
	}

	@Override
	public String[] getRequiredPermission()
	{
		return new String[]{"secutil.signbreak.use"};
	}

	@Override
	public List<Integer> allowedArgumentLengths()
	{
		return Arrays.asList(new Integer[]{0});
	}

	public static void setSignLocation(Location ll)
	{
		lastLocation = ll;
	}
}
