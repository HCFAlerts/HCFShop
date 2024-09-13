package me.hcfalerts.coinshop.utils;

import me.hcfalerts.coinshop.HCFShop;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * @Authors HCFAlerts
 * @Project Simple Hubcore
 */

public class PlaceholderAPIExpansion extends PlaceholderExpansion {

   public boolean persist() {
      return true;
   }

   public boolean canRegister() {
      return true;
   }

   @NotNull
   public String getAuthor() {
      return "HCFAlerts";
   }

   @NotNull
   public String getVersion() {
      return HCFShop.getPlugin(HCFShop.class).getDescription().getVersion();
   }

   @NotNull
   public String getIdentifier() {
      return "hcfshop";
   }

   public String onPlaceholderRequest(Player player, @NotNull String identifier) {
      if (player == null) {
         return "";
      } else {
            return null;
         }
      }
}
