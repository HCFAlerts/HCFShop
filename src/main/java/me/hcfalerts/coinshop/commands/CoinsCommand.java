package me.hcfalerts.coinshop.commands;

import me.hcfalerts.coinshop.HCFShop;
import me.hcfalerts.coinshop.utils.ChatUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CoinsCommand implements CommandExecutor {

    private final HCFShop plugin;

    public CoinsCommand(HCFShop plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatUtil.translate("&cOnly players can check their coins."));
            return true;
        }

        Player player = (Player) sender;
        int coins = plugin.getCoins(player);

        player.sendMessage(ChatUtil.translate("&6Your Coins&7: &e" + coins + " &6⛃."));
        return true;
    }
}