package me.hcfalerts.coinshop.listeners;

import me.hcfalerts.coinshop.HCFShop;
import me.hcfalerts.coinshop.menus.CoinShopMenu;
import me.hcfalerts.coinshop.utils.ChatUtil;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.entity.Player;

/**
 * @Authors HCFAlerts
 * @Project Simple Coinshop
 */

public class InventoryListener implements Listener {

    public InventoryListener(HCFShop plugin) {
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getWhoClicked() instanceof Player) {
            Player player = (Player) event.getWhoClicked();
            String title = event.getView().getTitle();
            ItemStack clickedItem = event.getCurrentItem();

            if (clickedItem == null || !clickedItem.hasItemMeta()) return;

            ItemMeta meta = clickedItem.getItemMeta();
            if (meta == null) return;

            String displayName = meta.getDisplayName();

            switch (title) {
                case "Coinshop":
                    event.setCancelled(true);
                    if (displayName.equals(ChatUtil.translate("&6&lCart"))) {
                        CoinShopMenu.openCartMenu(player);
                    } else if (displayName.equals(ChatUtil.translate("&6&lRanks &7(Permanent)"))) {
                        CoinShopMenu.openRanksMenu(player);
                    } else if (displayName.equals(ChatUtil.translate("&6&lPunishments"))) {
                        CoinShopMenu.openPunishmentsMenu(player);
                    }
                    break;

                case "Ranks":
                    event.setCancelled(true);
                    if (displayName.equals(ChatUtil.translate("&7&lBasic"))) {
                        CoinShopMenu.addItemToCart(player, "Basic");
                    } else if (displayName.equals(ChatUtil.translate("&f&lVIP Status"))) {
                        CoinShopMenu.addItemToCart(player, "VIP Status");
                    } else if (displayName.equals(ChatUtil.translate("&cBack"))) {
                        CoinShopMenu.openMainMenu(player);
                    }
                    break;

                case "Cart":
                    event.setCancelled(true);
                    if (displayName.equals(ChatUtil.translate("&aConfirm"))) {
                        CoinShopMenu.confirmCart(player);
                    } else if (displayName.equals(ChatUtil.translate("&cCancel"))) {
                        CoinShopMenu.clearCart(player);
                    } else if (displayName.equals(ChatUtil.translate("&cBack"))) {
                        CoinShopMenu.openMainMenu(player);
                    }
                    break;

                case "Punishments":
                    event.setCancelled(true);
                    if (displayName.equals(ChatUtil.translate("&cUnBlacklist"))) {
                        CoinShopMenu.addItemToCart(player, "UnBlacklist");
                    } else if (displayName.equals(ChatUtil.translate("&cUnBan"))) {
                        CoinShopMenu.addItemToCart(player, "UnBan");
                    } else if (displayName.equals(ChatUtil.translate("&cUnMute"))) {
                        CoinShopMenu.addItemToCart(player, "UnMute");
                    } else if (displayName.equals(ChatUtil.translate("&cBack"))) {
                        CoinShopMenu.openMainMenu(player);
                    }
                    break;
            }
        }
    }
}