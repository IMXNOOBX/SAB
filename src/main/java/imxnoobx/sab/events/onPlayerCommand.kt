package imxnoobx.sab.events

import org.bukkit.Location
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.command.CommandExecutor
import java.util.*

class onPlayerCommand : Listener {

    @EventHandler
    fun onPlayerMoveEvent(event: CommandExecutor) {
		if (event.isCancelled())
            return

        val player = event.player;

        // player.sendMessage("You moved !");
    }
}