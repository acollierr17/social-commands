package us.thenerdcave.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import us.thenerdcave.MySocialcommands;
import us.thenerdcave.utils.ConfigUtils;

/**
 * Created by ANTHONY on 10/05/2017.
 */
@SuppressWarnings("deprecation")
public class CmdReload implements CommandExecutor {

    private MySocialcommands main;
    private ConfigUtils configutils = new ConfigUtils();

    public CmdReload(MySocialcommands main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        if (!sender.hasPermission("sc.screload")) {
            sender.sendMessage(ChatColor.RED + "You have insufficient permissions for this command.");
            return true;
        }

        sender.sendMessage(ChatColor.GOLD + "Social Commands " + ChatColor.GRAY + "messages configuration has been reloaded!");
        configutils.reloadMessagesConfig();
        return true;
    }
}
