package us.thenerdcave.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import us.thenerdcave.MySocialcommands;
import us.thenerdcave.utils.ConfigUtils;

/**
 * Created by ANTHONY on 10/05/2017.
 */
public class CmdDiscord implements CommandExecutor {

    private MySocialcommands main;
    private ConfigUtils configutils = new ConfigUtils();

    public CmdDiscord(MySocialcommands main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        if (!(sender instanceof Player)) {
            main.getLogger().info(ChatColor.GOLD + "This command can only be executed by a player!");
            return true;
        }

        String discord = configutils.getStringMessages().getString("discord");
        String prefixcolor = configutils.getStringMessages().getString("prefix-color");
        String color = configutils.getMessagesConfig().getString("color");

        sender.sendMessage(ChatColor.GOLD + ChatColor.translateAlternateColorCodes('&', prefixcolor + "Discord » ") + (ChatColor.GRAY + ChatColor.translateAlternateColorCodes('&', color + discord)));

        return true;
    }
}
