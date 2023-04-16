package imxnoobx.sab

import imxnoobx.sab.config.ConfigMain
import imxnoobx.sab.events.onPlayerChat
import imxnoobx.sab.events.onPlayerJoin
import imxnoobx.sab.events.onPlayerMove
import org.bukkit.plugin.java.JavaPlugin


class SimpleAntiBot : JavaPlugin() {
    val version = "1.0.1"

    override fun onEnable() {
        // Plugin startup logic
        logger.info("plugin load started!")

        config.options().copyDefaults(true);
        saveDefaultConfig()

        ConfigMain.setupPlugin(this)

        server.pluginManager.registerEvents(onPlayerJoin(), this)
        server.pluginManager.registerEvents(onPlayerChat(), this)
        server.pluginManager.registerEvents(onPlayerMove(), this)

        logger.info("plugin load finished, loaded version: " + version)
    }

    override fun onDisable() {
        // Plugin shutdown logic
        logger.info("plugin unloaded successfully!")
    }

    fun onReload() {
        // Plugin reload logic
        logger.info("plugin reloaded successfully!")
    }
}
