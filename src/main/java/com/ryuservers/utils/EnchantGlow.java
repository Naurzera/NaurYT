package com.ryuservers.utils;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.enchantments.EnchantmentWrapper;
import org.bukkit.inventory.ItemStack;

import java.lang.reflect.Field;

public class EnchantGlow extends EnchantmentWrapper {

    private static Enchantment glow;

    public EnchantGlow(Integer id) {
        super(id);
    }

    public static void addGlow(ItemStack item) {
        Enchantment glow = getGlow();
        if (!item.containsEnchantment(glow))
            item.addEnchantment(glow, 1);
    }

    public static Enchantment getGlow() {
        if (glow != null)
            return glow;

        try {
            Field f = Enchantment.class.getDeclaredField("acceptingNew");
            f.setAccessible(true);
            f.set(null, true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        glow = new EnchantGlow(101);
        try {
            Enchantment.registerEnchantment(glow);
        } catch (IllegalArgumentException iae) {
        }
        return glow;
    }

    public static boolean isGlow(ItemStack item) {
        return item.getEnchantments().containsKey(glow);
    }

    @Override
    public boolean canEnchantItem(ItemStack item) {
        return true;
    }

    @Override
    public boolean conflictsWith(Enchantment other) {
        return false;
    }

    @Override
    public EnchantmentTarget getItemTarget() {
        return null;
    }

    @Override
    public int getMaxLevel() {
        return 10;
    }

    @Override
    public String getName() {
        return "Glow";
    }

    @Override
    public int getStartLevel() {
        return 1;
    }
}