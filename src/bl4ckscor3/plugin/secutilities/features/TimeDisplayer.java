package bl4ckscor3.plugin.secutilities.features;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class TimeDisplayer
{
	private static final List<String> joinedPlayers = new ArrayList<String>();
	private static Timer t = new Timer();
	
	public static void start(final Player p)
	{
		joinedPlayers.add(p.getName());
		
		t.schedule(new TimerTask()
		{
			@Override
			public void run()
			{
				Bukkit.dispatchCommand(p, "playtimetop 10");
			}
		}, 0, 600000);
	}
	
	public static void stop(Player p)
	{
		joinedPlayers.remove(p.getName());
		t.cancel();
		t = new Timer();
	}
}
