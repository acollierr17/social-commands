package us.thenerdcave.utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import us.thenerdcave.MySocialcommands;

import java.io.*;
import java.util.logging.Level;
/**
 * Created by ANTHONY on 10/06/2017.
 */
@SuppressWarnings("deprecation")
public class ConfigUtils implements Listener {

    private MySocialcommands main;
    public ConfigUtils() {
    }

    private static FileConfiguration messages;
    private File messagesFile;
    public static ConfigUtils config;

    public void nameMessages() {
        config = this;
    }

    public static void AssignConfigMessages(Plugin plugin)  {
        messages = YamlConfiguration.loadConfiguration(new File(plugin.getDataFolder(), "messages.yml"));
    }

    public void reloadMessagesConfig() {
        if (messagesFile == null) {
            messagesFile = new File("plugins/SocialCommands/messages.yml");
        }
        messages = YamlConfiguration.loadConfiguration(messagesFile);
    }

    public FileConfiguration getMessagesConfig() {
        if (messages == null) {
                reloadMessagesConfig();
        }
        return messages;
    }

    public FileConfiguration getStringMessages() {
        return this.messages;
    }

    public void saveMessagesConfig(Plugin plugin) {
        try {
            messages.save(new File(plugin.getDataFolder(), "messages.yml"));
        } catch (IOException ex) {
            main.getLogger().log(Level.SEVERE, "Could not save messages config to " + messagesFile, ex);
        }
    }

    public void saveDefaultMessages() {
        if (messagesFile == null) {
            messagesFile = new File(main.getDataFolder(), "messages.yml");
        }
        if (!messagesFile.exists()) {
            main.saveResource("messages.yml", false);
        }
    }
}