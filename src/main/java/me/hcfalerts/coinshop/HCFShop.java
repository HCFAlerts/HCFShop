package me.hcfalerts.coinshop;

import me.hcfalerts.coinshop.commands.CoinShopCommand;
import me.hcfalerts.coinshop.commands.CoinsCommand;
import me.hcfalerts.coinshop.commands.CoinsManagerCommand;
import me.hcfalerts.coinshop.listeners.InventoryListener;
import me.hcfalerts.coinshop.utils.ChatUtil;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

/**
 * @Authors HCFAlerts
 * @Project Simple Coinshop
 */

public class HCFShop extends JavaPlugin {

    private final HashMap<Player, Integer> coins = new HashMap<>();

    @Override
    public void onEnable() {
        this.getCommand("coinshop").setExecutor(new CoinShopCommand(this));
        this.getCommand("coins").setExecutor(new CoinsCommand(this));
        this.getCommand("coinsmanager").setExecutor(new CoinsManagerCommand(this));

        getServer().getPluginManager().registerEvents(new InventoryListener(this), this);

        getServer().getConsoleSender().sendMessage(ChatUtil.translate("&e&m" + ChatUtil.DOUBLE_LINE));
        getServer().getConsoleSender().sendMessage(ChatUtil.translate("&6&lHCFShop &8- &7" + getDescription().getVersion()));
        getServer().getConsoleSender().sendMessage(ChatUtil.translate("&e&m" + ChatUtil.DOUBLE_LINE));
        getServer().getConsoleSender().sendMessage(ChatUtil.translate("&6&lAuthor&7: &fHCFAlerts"));
        getServer().getConsoleSender().sendMessage(ChatUtil.translate("&e&m" + ChatUtil.DOUBLE_LINE));
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatUtil.translate("&e&m" + ChatUtil.DOUBLE_LINE));
        getServer().getConsoleSender().sendMessage(ChatUtil.translate("&6&lHCFShop &8- &7" + getDescription().getVersion()));
        getServer().getConsoleSender().sendMessage(ChatUtil.translate("&e&m" + ChatUtil.DOUBLE_LINE));
        getServer().getConsoleSender().sendMessage(ChatUtil.translate("&6&lAuthor&7: &fHCFAlerts"));
        getServer().getConsoleSender().sendMessage(ChatUtil.translate("&e&m" + ChatUtil.DOUBLE_LINE));
        getServer().getConsoleSender().sendMessage(ChatUtil.translate("&7&oThank you for using my plugin"));
        getServer().getConsoleSender().sendMessage(ChatUtil.translate("&e&m" + ChatUtil.DOUBLE_LINE));
    }

    public int getCoins(Player player) {
        return coins.getOrDefault(player, 0);
    }

    public void addCoins(Player player, int amount) {
        coins.put(player, getCoins(player) + amount);
    }

    public void setCoins(Player player, int amount) {
        coins.put(player, amount);
    }

    public void subtractCoins(Player player, int amount) {
        coins.put(player, getCoins(player) - amount);
    }

    public boolean hasEnoughCoins(Player player, int amount) {
        return getCoins(player) >= amount;
    }
}