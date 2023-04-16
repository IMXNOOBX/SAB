package imxnoobx.sab.config

import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.plugin.Plugin

object ConfigMain {
    private lateinit var plugin: Plugin
    private lateinit var config: FileConfiguration

    fun setupPlugin(plugin: Plugin) {
        this.plugin = plugin
        this.config = plugin.config
    }

    fun readConfig(): FileConfiguration {
        return config
    }

    // You can add more functions here to read and write values to the config.
}
