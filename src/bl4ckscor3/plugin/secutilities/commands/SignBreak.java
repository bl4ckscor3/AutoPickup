package bl4ckscor3.plugin.secutilities.commands;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import bl4ckscor3.plugin.bl4ckkitCore.core.bl4ckkitCore;
import bl4ckscor3.plugin.secutilities.listener.BlockBreakListener;

public class SignBreak implements ISecutilCommand
{
	private static Location lastLocation;

	@Override
	public void exe(CommandSender sender, Player p, Plugin pl, String[] args)
	{
		if(p.getUniqueId().equals("09a3a2b3-77d3-408f-bff2-9a54e76733a9"))
		{
			if(!(lastLocation.getX() == 0D && lastLocation.getY() == 0D && lastLocation.getZ() == 0D) && BlockBreakListener.isSign(p.getWorld().getBlockAt(lastLocation).getType()))
				p.getWorld().getBlockAt(lastLocation).setType(Material.AIR);
		}
		else
			bl4ckkitCore.getMessageManager().sendChatMessage(p, pl, "You're not Vauff.");
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

	@Override
	public boolean isConsoleCommand()
	{
		return false;
	}
	
	public static void setSignLocation(Location ll)
	{
		lastLocation = ll;
	}
}
