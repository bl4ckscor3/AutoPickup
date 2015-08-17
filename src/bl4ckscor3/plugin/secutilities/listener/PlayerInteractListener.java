package bl4ckscor3.plugin.secutilities.listener;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import bl4ckscor3.plugin.bl4ckkitCore.core.bl4ckkitCore;

public class PlayerInteractListener implements Listener
{
	private static Plugin plugin;

	public PlayerInteractListener(Plugin pl)
	{
		plugin = pl;
	}

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event)
	{
		if(event.getAction() == Action.LEFT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_BLOCK)
		{
			ItemStack hand = event.getPlayer().getItemInHand();

			if(hand.getType() == Material.PAPER && hand.getItemMeta().getLore().get(0).equals("Location Tool"))
			{
				Location l = event.getClickedBlock().getLocation();

				bl4ckkitCore.getMessageManager().sendChatMessage(event.getPlayer(), plugin, "x: " + l.getBlockX() + " y: " + l.getBlockY() + " z: " + l.getBlockZ());
				event.setCancelled(true);
			}
		}

		if(event.getAction() == Action.RIGHT_CLICK_BLOCK && isSign(event.getClickedBlock()))
		{
			if(event.getPlayer().hasPermission("secutil.cwarp.warp"))
			{
				String[] lines = ((Sign)event.getClickedBlock().getState()).getLines();

				if(lines[0].equalsIgnoreCase(ChatColor.DARK_RED + "[CWarp]"))
				{
					bl4ckkitCore.getMessageManager().sendChatMessage(event.getPlayer(), plugin, "This warp does not exist.");
					return;
				}
				else if(lines[0].equalsIgnoreCase(ChatColor.DARK_GREEN + "[CWarp]"))
				{
					File f = new File(plugin.getDataFolder(), "/warps/" + lines[1] + ".yml");
					YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

					event.getPlayer().teleport(new Location(Bukkit.getWorld("creative"), yaml.getDouble("x"), yaml.getDouble("y"), yaml.getDouble("z"), (float)yaml.getDouble("yaw"), (float)yaml.getDouble("pitch")), TeleportCause.COMMAND);
					bl4ckkitCore.getMessageManager().sendChatMessage(event.getPlayer(), plugin, "Warped to " + ChatColor.AQUA + lines[1] + ChatColor.WHITE + ".");
				}
			}
		}
	}
	
	private boolean isSign(Block block)
	{
		return block.getType() == Material.SIGN || block.getType() == Material.WALL_SIGN || block.getType() == Material.SIGN_POST;
	}
}
