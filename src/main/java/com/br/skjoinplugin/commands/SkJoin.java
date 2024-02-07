package com.br.skjoinplugin.commands;

import com.br.skjoinplugin.Main;
import com.br.skjoinplugin.utils.Config;
import com.br.skjoinplugin.utils.ItemAPI;
import com.br.skjoinplugin.utils.PainelConfig;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class SkJoin implements CommandExecutor {

    public static HashMap<String, Boolean> StatusCodigo =  new HashMap<String, Boolean>();


    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("skjoin")) {
            if (!(s instanceof Player)) {
                s.sendMessage("§cEste comando só pode ser executado por jogadores.");
                return true;
            }

            if (!s.hasPermission(Config.Permission)) {
                s.sendMessage("§cVocê não tem permissão para usar este comando.");
                return true;
            }

            Player p = (Player) s;

            if (args.length != 1) {
                s.sendMessage(" ");
                s.sendMessage("§c§lComando inválido! ");
                s.sendMessage("§eParece que você digitou algo errado. Confira a lista de comandos disponíveis usando §e/skjoin help.");
                s.sendMessage(" ");
                ((Player) s).playSound(p.getLocation(), Sound.SPIDER_DEATH,30,30);
                return true;
            }

            if (args[0].equalsIgnoreCase("help")){
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("§f§l(§e§lSK JOIN§f§l)");
                s.sendMessage(" ");
                p.sendMessage("§6§lComandos Disponíveis:");
                s.sendMessage("§e/skjoin admin : §f§lPara abrir o gui para alterar as configurações de seu plugin.");
                p.sendMessage("");
                return true;
            }

            if (args[0].equalsIgnoreCase("admin")){
                Inventory Gui = Bukkit.createInventory(null,36,"§eConfiguração");

                ItemStack Painel = new ItemAPI("397:1")
                        .setName("§eSk JoinPlugin")
                        .build();

                ItemStack TitleItem = new ItemAPI("41")
                        .setName("§eTitle na Entrada")
                        .build();

                ItemStack JoinItem = new ItemAPI("57")
                        .setName("§eMensagem de Entrada")
                        .build();

                ItemStack QuitItem = new ItemAPI("152")
                        .setName("§eMensagem de Saida")
                        .build();


                Gui.setItem(4,Painel);

                Gui.setItem(11,JoinItem);
                Gui.setItem(13,TitleItem);
                Gui.setItem(15,QuitItem);


                if (!StatusCodigo.containsKey("Config01")){
                    StatusCodigo.put("Config01",Config.JoinActiveMSG);
                    Gui.setItem(20,PainelConfig.StatusConfig(Config.JoinActiveMSG));
                }else{
                    Boolean JoinActive = StatusCodigo.get("Config01");
                    Gui.setItem(20,PainelConfig.StatusConfig(JoinActive));
                }

                if (!StatusCodigo.containsKey("Config02")){
                    StatusCodigo.put("Config02",Config.JoinActiveTitle);
                    Gui.setItem(22, PainelConfig.StatusConfig(Config.JoinActiveTitle));
                }else{
                    Boolean TitleActive = StatusCodigo.get("Config02");
                    Gui.setItem(22,PainelConfig.StatusConfig(TitleActive));
                }

                if (!StatusCodigo.containsKey("Config03")){
                    StatusCodigo.put("Config03",Config.QuitActiveMSG);
                    Gui.setItem(24, PainelConfig.StatusConfig(Config.QuitActiveMSG));
                }else{
                    Boolean QuitActive = StatusCodigo.get("Config03");
                    Gui.setItem(24,PainelConfig.StatusConfig(QuitActive));
                }

                p.openInventory(Gui);


                return true;
            }
        }
        return false;
    }
}
