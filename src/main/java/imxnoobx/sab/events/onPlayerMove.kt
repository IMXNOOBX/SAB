package imxnoobx.sab.events

import org.bukkit.Location
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerMoveEvent
import java.util.*

class onPlayerMove : Listener {

    @EventHandler
    fun onPlayerMoveEvent(event: PlayerMoveEvent) {
        if (event.isCancelled())
            return

        val player = event.player;

        // player.sendMessage("You moved !");
    }
}