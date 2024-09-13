package me.hcfalerts.coinshop.menus;

import me.hcfalerts.coinshop.utils.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @Authors HCFAlerts
 * @Project Simple Coinshop
 */

public class CoinShopMenu {

    private static final HashMap<Player, List<String>> cart = new HashMap<>();
    private static final HashMap<String, Integer> itemPrices = new HashMap<>();

    static {
        itemPrices.put("VIP Status", 100000);
        itemPrices.put("Basic", 1000);
    }

    public static void openMainMenu(Player player) {
        Inventory mainMenu = Bukkit.createInventory(null, 45, "Coinshop");

        ItemStack cartItem;
        List<String> playerCart = cart.getOrDefault(player, new ArrayList<>());
        if (playerCart.isEmpty()) {
            cartItem = new ItemStack(Material.MINECART);
            ItemMeta cartMeta = cartItem.getItemMeta();
            cartMeta.setDisplayName(ChatUtil.translate("&6&lEmpty Cart"));
            List<String> cartLore = new ArrayList<>();
            cartLore.add(ChatUtil.translate("&7Your cart is currently empty."));
            cartLore.add(ChatUtil.translate("&7Add items to your cart to see them here."));
            cartMeta.setLore(cartLore);
            cartItem.setItemMeta(cartMeta);
        } else {
            cartItem = new ItemStack(Material.STORAGE_MINECART);
            ItemMeta cartMeta = cartItem.getItemMeta();
            cartMeta.setDisplayName(ChatUtil.translate("&6&lCart"));
            List<String> cartLore = new ArrayList<>();
            cartLore.add(ChatUtil.translate("&6&lBuyer&7: &f" + player.getName()));
            cartLore.add(ChatUtil.translate("&7"));
            cartLore.add(ChatUtil.translate("&7Click to view your cart"));
            cartMeta.setLore(cartLore);
            cartItem.setItemMeta(cartMeta);
        }
        mainMenu.setItem(40, cartItem);

        ItemStack ranksItem = new ItemStack(Material.INK_SACK, 1, (short) 10);
        ItemMeta ranksMeta = ranksItem.getItemMeta();
        ranksMeta.setDisplayName(ChatUtil.translate("&6&lRanks &7(Permanent)"));
        List<String> ranksLore = new ArrayList<>();
        ranksLore.add(ChatUtil.translate("&6&lAvailable Ranks"));
        ranksLore.add(ChatUtil.translate("&7"));
        ranksLore.add(ChatUtil.translate("&7▶ &fVIP Status"));
        ranksLore.add(ChatUtil.translate("&7▶ &7Basic"));
        ranksLore.add(ChatUtil.translate("&7"));
        ranksLore.add(ChatUtil.translate("&7Click to view Ranks category"));
        ranksMeta.setLore(ranksLore);
        ranksItem.setItemMeta(ranksMeta);
        mainMenu.setItem(21, ranksItem);

        ItemStack punishmentsItem = new ItemStack(Material.IRON_BARDING);
        ItemMeta punishmentsMeta = punishmentsItem.getItemMeta();
        punishmentsMeta.setDisplayName(ChatUtil.translate("&6&lPunishments"));
        List<String> punishmentsLore = new ArrayList<>();
        punishmentsLore.add(ChatUtil.translate("&6&lAvailable Products"));
        punishmentsLore.add(ChatUtil.translate("&7"));
        punishmentsLore.add(ChatUtil.translate("&7▶ &cUnBlacklist"));
        punishmentsLore.add(ChatUtil.translate("&7▶ &cUnBan"));
        punishmentsLore.add(ChatUtil.translate("&7▶ &cUnMute"));
        punishmentsLore.add(ChatUtil.translate("&7"));
        punishmentsLore.add(ChatUtil.translate("&7Click to view Punishments category"));
        punishmentsMeta.setLore(punishmentsLore);
        punishmentsItem.setItemMeta(punishmentsMeta);
        mainMenu.setItem(23, punishmentsItem);

        ItemStack crystalItem = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 4);
        ItemMeta crystalMeta = crystalItem.getItemMeta();
        crystalMeta.setDisplayName(ChatUtil.translate("&7"));
        crystalItem.setItemMeta(crystalMeta);
        mainMenu.setItem(17, crystalItem);
        mainMenu.setItem(1, crystalItem);
        mainMenu.setItem(9, crystalItem);
        mainMenu.setItem(7, crystalItem);
        mainMenu.setItem(37, crystalItem);
        mainMenu.setItem(35, crystalItem);
        mainMenu.setItem(27, crystalItem);
        mainMenu.setItem(43, crystalItem);

        ItemStack crystal2Item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 1);
        ItemMeta crystal2Meta = crystal2Item.getItemMeta();
        crystal2Meta.setDisplayName(ChatUtil.translate("&7"));
        crystal2Item.setItemMeta(crystal2Meta);
        mainMenu.setItem(0, crystal2Item);
        mainMenu.setItem(8, crystal2Item);
        mainMenu.setItem(44, crystal2Item);
        mainMenu.setItem(36, crystal2Item);

        player.openInventory(mainMenu);
    }

    public static void openRanksMenu(Player player) {
        Inventory ranksMenu = Bukkit.createInventory(null, 36, "Ranks");

        ItemStack rank1 = new ItemStack(Material.INK_SACK, 1, (short) 8);
        ItemMeta rank1Meta = rank1.getItemMeta();
        rank1Meta.setDisplayName(ChatUtil.translate("&7&lBasic"));
        rank1Meta.setLore(Collections.singletonList(ChatUtil.translate("&6Cost&7: &f1.000 &e⛃")));
        rank1.setItemMeta(rank1Meta);
        ranksMenu.setItem(14, rank1);

        ItemStack rank2 = new ItemStack(Material.INK_SACK, 1, (short) 7);
        ItemMeta rank2Meta = rank2.getItemMeta();
        rank2Meta.setDisplayName(ChatUtil.translate("&f&lVIP Status"));
        rank2Meta.setLore(Collections.singletonList(ChatUtil.translate("&6Cost&7: &f100.000 &e⛃")));
        rank2.setItemMeta(rank2Meta);
        ranksMenu.setItem(12, rank2);

        ItemStack backButton = new ItemStack(Material.BARRIER);
        ItemMeta backMeta = backButton.getItemMeta();
        backMeta.setDisplayName(ChatUtil.translate("&cBack"));
        backButton.setItemMeta(backMeta);
        ranksMenu.setItem(31, backButton);

        player.openInventory(ranksMenu);
    }

    public static void addItemToCart(Player player, String itemName) {
        cart.computeIfAbsent(player, k -> new ArrayList<>()).add(itemName);
        player.sendMessage(ChatUtil.translate("&aAdded &l" + itemName + "&a to your cart."));
    }

    public static void openCartMenu(Player player) {
        Inventory cartMenu = Bukkit.createInventory(null, 45, "Cart");

        List<String> playerCart = cart.getOrDefault(player, new ArrayList<>());

        ItemStack cartItem;
        if (playerCart.isEmpty()) {
            cartItem = new ItemStack(Material.MINECART);
            ItemMeta cartMeta = cartItem.getItemMeta();
            cartMeta.setDisplayName(ChatUtil.translate("&6&lEmpty Cart"));
            List<String> cartLore = new ArrayList<>();
            cartLore.add(ChatUtil.translate("&7Your cart is currently empty."));
            cartLore.add(ChatUtil.translate("&7Add items to your cart to see them here."));
            cartMeta.setLore(cartLore);
            cartItem.setItemMeta(cartMeta);
        } else {
            cartItem = new ItemStack(Material.STORAGE_MINECART);
            ItemMeta cartMeta = cartItem.getItemMeta();
            cartMeta.setDisplayName(ChatUtil.translate("&6&lCart"));
            List<String> cartLore = new ArrayList<>();
            cartLore.add(ChatUtil.translate("&6&lBuyer&7: &f" + player.getName()));
            cartLore.add(ChatUtil.translate("&7"));
            cartLore.add(ChatUtil.translate("&7Click to view your cart"));
            cartMeta.setLore(cartLore);
            cartItem.setItemMeta(cartMeta);
        }
        cartMenu.setItem(40, cartItem);

        int slot = 0;
        for (String itemName : playerCart) {
            ItemStack item;
            int price = itemPrices.getOrDefault(itemName, 0);

            if (itemName.equals("VIP Status")) {
                item = new ItemStack(Material.INK_SACK, 1, (short) 7);
            } else if (itemName.equals("Basic")) {
                item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            } else {
                item = new ItemStack(Material.PAPER);
            }

            ItemMeta meta = item.getItemMeta();
            if (meta != null) {
                meta.setDisplayName(ChatUtil.translate(itemName));
                List<String> lore = new ArrayList<>();
                lore.add(ChatUtil.translate("&6Cost&7: &f" + price + " &e⛃"));
                meta.setLore(lore);
                item.setItemMeta(meta);
            }

            cartMenu.setItem(slot, item);
            slot++;
        }

        ItemStack confirmButton = new ItemStack(Material.WOOL, 1, (short) 5);
        ItemMeta confirmMeta = confirmButton.getItemMeta();
        confirmMeta.setDisplayName(ChatUtil.translate("&aConfirm"));
        confirmButton.setItemMeta(confirmMeta);
        cartMenu.setItem(39, confirmButton);

        ItemStack clearCartButton = new ItemStack(Material.WOOL, 1, (short) 14);
        ItemMeta clearCartMeta = clearCartButton.getItemMeta();
        clearCartMeta.setDisplayName(ChatUtil.translate("&cCancel"));
        clearCartButton.setItemMeta(clearCartMeta);
        cartMenu.setItem(41, clearCartButton);

        ItemStack backButton = new ItemStack(Material.BARRIER);
        ItemMeta backMeta = backButton.getItemMeta();
        backMeta.setDisplayName(ChatUtil.translate("&cBack"));
        backButton.setItemMeta(backMeta);
        cartMenu.setItem(40, backButton);

        player.openInventory(cartMenu);
    }

    public static void confirmCart(Player player) {
        List<String> playerCart = cart.getOrDefault(player, new ArrayList<>());
        if (playerCart.isEmpty()) {
            player.sendMessage(ChatUtil.translate("&cYour cart is empty. Please add items to your cart before confirming."));
            return;
        }

        int totalCost = playerCart.stream()
                .mapToInt(itemName -> itemPrices.getOrDefault(itemName, 0))
                .sum();

        player.sendMessage(ChatUtil.translate("&aYou have confirmed the following items:"));
        for (String itemName : playerCart) {
            player.sendMessage(ChatUtil.translate("&7- &f" + itemName + " &7Cost: &f" + itemPrices.getOrDefault(itemName, 0) + " &e⛃"));
        }
        player.sendMessage(ChatUtil.translate("&7Total cost: &f" + totalCost + " &e⛃"));

        cart.remove(player);
        player.closeInventory();
    }

    public static void clearCart(Player player) {
        cart.remove(player);
        player.closeInventory();
        player.sendMessage(ChatUtil.translate("&cYour cart has been cleared."));
    }

    public static void openPunishmentsMenu(Player player) {
        Inventory punishmentsMenu = Bukkit.createInventory(null, 36, "Punishments");

        ItemStack unBlacklistItem = new ItemStack(Material.BOOK);
        ItemMeta unBlacklistMeta = unBlacklistItem.getItemMeta();
        unBlacklistMeta.setDisplayName(ChatUtil.translate("&cUnBlacklist"));
        unBlacklistMeta.setLore(Collections.singletonList(ChatUtil.translate("&6Cost&7: &f30.000 &e⛃")));
        unBlacklistItem.setItemMeta(unBlacklistMeta);
        punishmentsMenu.setItem(11, unBlacklistItem);

        ItemStack unBanItem = new ItemStack(Material.BOOK);
        ItemMeta unBanMeta = unBanItem.getItemMeta();
        unBanMeta.setDisplayName(ChatUtil.translate("&cUnBan"));
        unBanMeta.setLore(Collections.singletonList(ChatUtil.translate("&6Cost&7: &f20.000 &e⛃")));
        unBanItem.setItemMeta(unBanMeta);
        punishmentsMenu.setItem(13, unBanItem);

        ItemStack unMuteItem = new ItemStack(Material.BOOK);
        ItemMeta unMuteMeta = unMuteItem.getItemMeta();
        unMuteMeta.setDisplayName(ChatUtil.translate("&cUnMute"));
        unMuteMeta.setLore(Collections.singletonList(ChatUtil.translate("&6Cost&7: &f10.000 &e⛃")));
        unMuteItem.setItemMeta(unMuteMeta);
        punishmentsMenu.setItem(15, unMuteItem);

        ItemStack backButton = new ItemStack(Material.BARRIER);
        ItemMeta backMeta = backButton.getItemMeta();
        backMeta.setDisplayName(ChatUtil.translate("&cBack"));
        backButton.setItemMeta(backMeta);
        punishmentsMenu.setItem(31, backButton);

        player.openInventory(punishmentsMenu);
    }
}