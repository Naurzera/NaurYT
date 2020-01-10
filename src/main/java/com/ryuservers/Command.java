package com.ryuservers;

import com.ryuservers.utils.Menu;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command implements CommandExecutor {

    public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String arg, String[] args) {
        if (cmd.getName().equalsIgnoreCase("yt") || cmd.getName().equalsIgnoreCase("youtuber")){

            if (sender instanceof Player){

                Player p = (Player)sender;
                p.openInventory(Menu.ajuda);

            }

        }
        return false;
    }
}
