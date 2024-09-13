package me.hcfalerts.coinshop.managers;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

/**
 * @Authors HCFAlerts
 * @Project Simple Coinshop
 */

public class CoinsManager {

    private static final HashMap<UUID, Integer> playerCoins = new HashMap<>();

    public static int getCoins(Player player) {
        return playerCoins.getOrDefault(player.getUniqueId(), 0);
    }

    public static void setCoins(Player player, int amount) {
        playerCoins.put(player.getUniqueId(), amount);
    }

    public static void addCoins(Player player, int amount) {
        int currentCoins = getCoins(player);
        setCoins(player, currentCoins + amount);
    }

    public static void removeCoins(Player player, int amount) {
        int currentCoins = getCoins(player);
        setCoins(player, Math.max(currentCoins - amount, 0));
    }
}