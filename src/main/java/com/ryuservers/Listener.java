package com.ryuservers;

import com.ryuservers.utils.Menu;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.inventory.InventoryClickEvent;

public class Listener implements org.bukkit.event.Listener {

    @EventHandler(priority = EventPriority.NORMAL)
    public void clickInv(InventoryClickEvent e){

        if (!(e.getWhoClicked() instanceof Player)) return;

        Player p = (Player) e.getWhoClicked();

        if (e.getCurrentItem() == null)return;
        if (e.getCurrentItem().getType().equals(Material.AIR))return;
        if (e.getCurrentItem().getItemMeta() == null)return;

        if (e.getSlot()> Menu.ajuda.getSize())return;

        if (e.getClickedInventory().getName().equalsIgnoreCase(Main.getInstance().getConfig().getString("titulo"))) {

            if (e.getCurrentItem().isSimilar(Menu.ajuda.getItem(e.getSlot()))) {

                e.setResult(Event.Result.DENY);

            }

        }

    }

}
