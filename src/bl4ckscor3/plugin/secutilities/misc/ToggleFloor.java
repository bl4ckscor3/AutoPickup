package bl4ckscor3.plugin.secutilities.misc;

import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.BlockCommandSender;

public class ToggleFloor
{
	public static void exeCB(BlockCommandSender sender, String[] args)
	{
		World w = sender.getServer().getWorld("world");

		if(args[0].equals("add"))
		{
			for(int x = -228; x <= -216; x++)
			{
				for(int z = 278; z >= 270; z--)
				{
					Block b = w.getBlockAt(x, 68, z);
					
					if(z == 276)
						b.setTypeId(89);
					else
					{
						b.setTypeId(5);
						b.setData((byte)1);
					}
				}
			}
		}
		else if(args[0].equals("remove"))
		{
			for(int x = -228; x <= -216; x++)
			{
				for(int z = 278; z >= 270; z--)
				{
					w.getBlockAt(x, 68, z).setTypeId(0);
				}
			}
		}
	}
}
