package com.br.skjoinplugin.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemAPI {

    private final ItemStack itemStack;
    private final ItemMeta itemMeta;

    public ItemAPI(String id) {
        String[] parts = id.split(":");
        int dataValue = 0;

        if (parts.length == 2) {
            try {
                dataValue = Integer.parseInt(parts[1]);
            } catch (NumberFormatException e) {
            }
        }
        Material material = Material.matchMaterial(parts[0]);

        this.itemStack = new ItemStack(material, 1, (short) dataValue);
        this.itemMeta = itemStack.getItemMeta();
    }

    public ItemAPI(Material material) {
        this.itemStack = new ItemStack(material);
        this.itemMeta = itemStack.getItemMeta();
    }

    public ItemAPI setAmount(int amount) {
        itemStack.setAmount(amount);
        return this;
    }

    public ItemAPI setName(String displayName) {
        itemMeta.setDisplayName(displayName);
        return this;
    }

    public ItemAPI lore(List<String> lore) {
        itemMeta.setLore(lore);
        return this;
    }

    public ItemAPI addLore(String loreLine) {
        List<String> lore = itemMeta.getLore();
        if (lore == null) {
            lore = new ArrayList<>();
        }
        lore.add(loreLine);
        itemMeta.setLore(lore);
        return this;
    }

    public ItemStack build() {
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
