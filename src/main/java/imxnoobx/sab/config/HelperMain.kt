package imxnoobx.sab.config

import org.bukkit.ChatColor
import org.bukkit.Location
import org.bukkit.entity.Player
import java.util.*

object HelperMain {
    val playerLocations = mutableMapOf<UUID, Location>()

    fun hasNonAnsiChars(message: String): Boolean {
        val ansiPattern = "\u001B\\[[;\\d]*m" // ANSI color escape sequence pattern
        val nonAnsiPattern = "[^\\x00-\\x7F$ansiPattern]" // Pattern for non-ANSI characters
        return nonAnsiPattern.toRegex().containsMatchIn(message)
    }

    fun sendColoredMessage(player: Player, message: String) {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message))
    }
}