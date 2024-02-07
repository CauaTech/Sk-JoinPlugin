package com.br.skjoinplugin.utils;

import org.bukkit.inventory.ItemStack;

public class PainelConfig {


    public static ItemStack StatusConfig(Boolean Status){
        if (Status){
            ItemStack Item = new ItemAPI("160:5")
                    .setName("§a§lAtivo")
                    .build();
            return  Item;
        }else{
            ItemStack Item = new ItemAPI("160:14")
                    .setName("§c§lDesligado")
                    .build();
            return  Item;
        }
    }
}
