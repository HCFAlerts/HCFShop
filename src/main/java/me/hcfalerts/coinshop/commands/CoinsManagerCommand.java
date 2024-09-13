package me.hcfalerts.coinshop.commands;

import me.hcfalerts.coinshop.HCFShop;
import me.hcfalerts.coinshop.utils.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @Authors HCFAlerts
 * @Project Simple Coinshop
 */

public class CoinsManagerCommand implements CommandExecutor {

    private final HCFShop plugin;

    public CoinsManagerCommand(HCFShop plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("coinsmanager.use")) {
            sender.sendMessage(ChatUtil.translate("&cYou don't have permission to use this command."));
            return true;
        }

        if (args.length < 3) {
            sender.sendMessage(ChatUtil.translate("&9&m" + ChatUtil.NORMAL_LINE));
            sender.sendMessage(ChatUtil.translate("&7» &c/coinsmanager <player> <add/set/remove> <amount>"));
            sender.sendMessage(ChatUtil.translate("&9&m" + ChatUtil.NORMAL_LINE));
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            sender.sendMessage(ChatUtil.translate("&cPlayer not found."));
            return true;
        }

        String action = args[1];
        int amount;

        try {
            amount = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            sender.sendMessage(ChatUtil.translate("&cAmount must be a number."));
            return true;
        }

        switch (action.toLowerCase()) {
            case "add":
                plugin.addCoins(target, amount);
                sender.sendMessage(ChatUtil.translate("&aAdded &l" + amount + "&a coins to &l" + target.getName()));
                break;

            case "set":
                plugin.setCoins(target, amount);
                sender.sendMessage(ChatUtil.translate("&aSet &l" + target.getName() + "&a's coins to &l" + amount));
                break;

            case "remove":
                plugin.subtractCoins(target, amount);
                sender.sendMessage(ChatUtil.translate("&aRemoved &l" + amount + "&a coins from &l" + target.getName()));
                break;

            default:
                sender.sendMessage(ChatUtil.translate("&9&m" + ChatUtil.NORMAL_LINE));
                sender.sendMessage(ChatUtil.translate("&7» &c/coinsmanager <player> <add/set/remove> <amount>"));
                sender.sendMessage(ChatUtil.translate("&9&m" + ChatUtil.NORMAL_LINE));
                break;
        }

        return true;
    }
}