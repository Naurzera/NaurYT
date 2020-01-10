package com.ryuservers.utils;

import com.ryuservers.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    public static Inventory ajuda = getAjuda();

    private static void addItem(Material item, String display, List<String> lore, Inventory inventario, int slot, boolean glow){

        ItemStack contudo = new ItemStack(item);
        ItemMeta aquem = contudo.getItemMeta();

        aquem.setDisplayName(display);

        aquem.setLore(lore);

        contudo.setItemMeta(aquem);

        if (glow) EnchantGlow.addGlow(contudo);

        inventario.setItem(slot, contudo);

    }

    private static Inventory getAjuda(){

        Inventory ajuda = Bukkit.createInventory(null, 45, Main.getInstance().getConfig().getString("titulo"));

        ItemStack gls = new ItemStack(Material.STAINED_GLASS_PANE);
        gls.setDurability(Short.parseShort("7"));
        ItemMeta ta = gls.getItemMeta();
        ta.setDisplayName(" ");
        gls.setItemMeta(ta);

        int slot = 0;
        do{
            if (slot==10 || slot==19 || slot==28){
                slot+=7;
                ajuda.setItem(slot, gls);
                continue;
            }
            ajuda.setItem(slot, gls);
            slot++;
        }while(slot<45);

        Material item = Material.getMaterial(Main.getInstance().getConfig().getString("tipo-item-miniyt"));
        String nome = Main.getInstance().getConfig().getString("nome-item-miniyt").replaceAll("&", "§");
        List<String> lore = Main.getInstance().getConfig().getStringList("lore-item-miniyt");
        int n = 0;
        do {
            String linha = lore.get(n);
            linha = linha.replaceAll("&", "§");
            lore.set(n, linha);
            n++;
        }while (n<lore.size());
        boolean son = Main.getInstance().getConfig().getBoolean("miniyt-item-brilha");
        int slott = Main.getInstance().getConfig().getInt("miniyt-slot-inventario");

        addItem(item, nome, lore, ajuda, slott, son);



        Material itemm = Material.getMaterial(Main.getInstance().getConfig().getString("tipo-item-youtuber"));
        String nomee = Main.getInstance().getConfig().getString("nome-item-youtuber").replaceAll("&", "§");
        List<String> loree = Main.getInstance().getConfig().getStringList("lore-item-youtuber");
        int nn = 0;
        do {
            String linha = loree.get(nn);
            linha = linha.replaceAll("&", "§");
            loree.set(nn, linha);
            nn++;
        }while (nn<loree.size());
        boolean sonn = Main.getInstance().getConfig().getBoolean("youtuber-item-brilha");
        int slottt = Main.getInstance().getConfig().getInt("youtuber-slot-inventario");

        addItem(itemm, nomee, loree, ajuda, slottt, sonn);


        return ajuda;

    }

}
