package us.thenerdcave;

import org.bukkit.plugin.java.JavaPlugin;
import us.thenerdcave.commands.*;
import us.thenerdcave.utils.ConfigUtils;
/**
 * Created by ANTHONY on 10/05/2017.
 */
public class MySocialcommands extends JavaPlugin {

    private ConfigUtils config = new ConfigUtils();

    public void onEnable () {
        System.out.println("Plugin enabled!");
        //
        ConfigUtils.AssignConfigMessages(this);
        //
        this.saveResource("messages.yml", false);
        config.reloadMessagesConfig();
        //
        getServer().getPluginManager().registerEvents(new ConfigUtils(), this);
        //
        getCommand("website").setExecutor(new CmdWebsite(this));
        getCommand("discord").setExecutor(new CmdDiscord(this));
        getCommand("teamspeak").setExecutor(new CmdTeamspeak(this));
        getCommand("twitter").setExecutor(new CmdTwitter(this));
        getCommand("facebook").setExecutor(new CmdFacebook(this));
        getCommand("instagram").setExecutor(new CmdInstagram(this));
        getCommand("snapchat").setExecutor(new CmdSnapchat(this));
        getCommand("youtube").setExecutor(new CmdYoutube(this));
        getCommand("screload").setExecutor(new CmdReload(this));
    }

    public void onDisable() {
        System.out.println("Plugin disabled!");
    }
}