package me.hcfalerts.coinshop.commands;

import me.hcfalerts.coinshop.HCFShop;
import me.hcfalerts.coinshop.menus.CoinShopMenu;
import me.hcfalerts.coinshop.utils.ChatUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @Authors HCFAlerts
 * @Project Simple Coinshop
 */

public class CoinShopCommand implements CommandExecutor {

    public CoinShopCommand(HCFShop plugin) {
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatUtil.translate("&cThis command is only for players."));
            return true;
        }

        Player player = (Player) sender;

        CoinShopMenu.openMainMenu(player);

        return true;
    }
}

