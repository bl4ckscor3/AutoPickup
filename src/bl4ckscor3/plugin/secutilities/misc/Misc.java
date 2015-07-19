package bl4ckscor3.plugin.secutilities.misc;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class Misc implements Listener
{
	private static final int[][] positions = {
		new int[]{-440, 90, 611},
		new int[]{-440, 90, 611 + 15},
		new int[]{-440, 90, 611 + 15 * 2},
		new int[]{-440, 90, 611 + 15 * 3},
		new int[]{-440, 90, 611 + 15 * 4},
		new int[]{-440, 90, 611 + 15 * 5},
		new int[]{-440, 90, 611 + 15 * 6},
		new int[]{-440, 90, 611 + 15 * 7},
		new int[]{-440, 90, 611 + 15 * 8},
		new int[]{-454, 90, 731},
		new int[]{-470, 90, 731},
		new int[]{-484, 90, 731},
		new int[]{-484, 90, 731 - 15},
		new int[]{-484, 90, 731 - 15 * 2},
		new int[]{-484, 90, 731 - 15 * 3},
		new int[]{-484, 90, 731 - 15 * 4},
		new int[]{-484, 90, 731 - 15 * 5},
		new int[]{-484, 90, 731 - 15 * 6},
		new int[]{-484, 90, 731 - 15 * 7},
		new int[]{-484, 90, 731 - 15 * 8},
		new int[]{-470, 90, 611},
		new int[]{-454, 90, 611},
		new int[]{-454, 90, 671},
		new int[]{-454, 90, 671}
	};

	@EventHandler
	public void onBlockBreak(BlockBreakEvent event)
	{
		if(event.getPlayer().getName().equals("bl4ckscor3"))
		{
			for(int[] i : positions)
			{
				if(event.getBlock().getX() == i[0] && event.getBlock().getY() == i[1] && event.getBlock().getZ() == i[2])
					event.setCancelled(true);
			}
		}
	}
}
