package imxnoobx.sab.events

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import imxnoobx.sab.config.HelperMain

class onPlayerJoin : Listener {

    @EventHandler
    fun onPlayerJoinEvent(event: PlayerJoinEvent) {
        if (event.isCancelled())
            return
            
        val player = event.player;

        HelperMain.playerLocations[player.uniqueId] = player.location
    }
}