package imxnoobx.sab.events

import imxnoobx.sab.config.ConfigMain
import imxnoobx.sab.config.HelperMain
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.AsyncPlayerChatEvent

class onPlayerChat : Listener {

    @EventHandler
    fun onPlayerChatEvent(event: AsyncPlayerChatEvent) {
        if (event.isCancelled())
            return

        val player = event.player;
        val message = event.message
        val config = ConfigMain.readConfig()

        if (player.isOp())
            return

        if (!config.getBoolean("chat-protection"))
            return

        if (config.getBoolean("move-before-chat") && !player.hasPermission("sab.chat.move")) {
            val joinLocation = HelperMain.playerLocations.get(player.uniqueId)
            val currentLocation = player.location
            val ammountOfBlocks = config.getInt("move-before-chat-block")

            val distance = if (joinLocation != null) currentLocation.distance(joinLocation) else null

            if (distance != null && distance < ammountOfBlocks) {
                event.isCancelled = true
                val resMessage = config.getString("move-before-chat-message")

                if (resMessage != null && !resMessage.equals(""))
                    HelperMain.sendColoredMessage(player, resMessage.replace("{blocks}", "$ammountOfBlocks"))

                return // Message blocked, no need to continue with the checks
            }
        }

        if (config.getBoolean("block-non-ansi-characters") && !player.hasPermission("sab.chat.ansi")) {
            val check = HelperMain.hasNonAnsiChars(message)
            if (check) {
                val resMessage = config.getString("chat-blocked-message")
                event.isCancelled = check
                if (resMessage != null && !resMessage.equals(""))
                    HelperMain.sendColoredMessage(player, resMessage)
                return
            }
        }

        val chat_filter = config.getConfigurationSection("message-blacklist")
        if (chat_filter != null && chat_filter.getBoolean("enabled") && !player.hasPermission("sab.chat.blacklist")) {
            for (regex in chat_filter.getStringList("custom-regex-blacklist")) {
                val check = regex.toRegex().containsMatchIn(message)

                if (check) {
                    val resMessage = config.getString("chat-blocked-message")
                    event.isCancelled = check

                    if (resMessage != null && !resMessage.equals(""))
                        HelperMain.sendColoredMessage(player, resMessage)
                }
            }
        }

    }
}
