package com.br.skjoinplugin;

import com.br.skjoinplugin.commands.SkJoin;
import com.br.skjoinplugin.utils.Config;
import com.br.skjoinplugin.utils.ItemAPI;
import com.br.skjoinplugin.utils.PainelConfig;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

import static com.br.skjoinplugin.commands.SkJoin.StatusCodigo;

public final class Main extends JavaPlugin implements Listener {

    private static Main instance;

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {

        GetConfig();
        GetCommands();
        instance = this;
        Bukkit.getConsoleSender().sendMessage("§f[§e§lSk-JoinPlugin§f] §afoi iniciado com sucesso!");
        Bukkit.getPluginManager().registerEvents(this, instance);
        reloadConfig();
    }

    @Override
    public void onDisable() {

    }

    private void GetConfig() {
        getConfig().options().copyDefaults(false);
        saveDefaultConfig();
        reloadConfig();
    }

    public void GetCommands() {
        getCommand("skjoin").setExecutor(new SkJoin());
    }

    @EventHandler
    public void ClickInventoryPlayer (InventoryClickEvent e){
        if (e.getWhoClicked() != null){
            Player p = (Player) e.getWhoClicked();
            if (e.getInventory().getTitle().equalsIgnoreCase("§eConfiguração")){
                e.setCancelled(true);
                if (e.getSlot() == 20){

                    if (!StatusCodigo.containsKey("Config01")){
                        StatusCodigo.put("Config01",Config.JoinActiveMSG);
                    }

                    Boolean Codigo = StatusCodigo.get("Config01");

                    if (Codigo){
                        Main.getInstance().getConfig().set("JoinConfig.Join.Active-Msg",false);
                        StatusCodigo.put("Config01",false);
                        saveConfig();
                        p.sendMessage("§aAcabamos de Alterar a Configuração");
                        p.closeInventory();
                        reloadConfig();
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
                            Gui.setItem(20, PainelConfig.StatusConfig(Config.JoinActiveMSG));
                        }else{
                            Boolean JoinActive = StatusCodigo.get("Config01");
                            Gui.setItem(20,PainelConfig.StatusConfig(JoinActive));
                        }

                        if (!StatusCodigo.containsKey("Config02")){
                            StatusCodigo.put("Config02",Config.JoinActiveTitle);
                            Gui.setItem(22, PainelConfig.StatusConfig(Config.JoinActiveTitle));
                        }else{
                            Boolean JoinActive = StatusCodigo.get("Config02");
                            Gui.setItem(22,PainelConfig.StatusConfig(JoinActive));
                        }

                        if (!StatusCodigo.containsKey("Config03")){
                            StatusCodigo.put("Config03",Config.QuitActiveMSG);
                            Gui.setItem(24, PainelConfig.StatusConfig(Config.QuitActiveMSG));
                        }else{
                            Boolean JoinActive = StatusCodigo.get("Config03");
                            Gui.setItem(24,PainelConfig.StatusConfig(JoinActive));
                        }



                        p.openInventory(Gui);
                    }else{
                        Main.getInstance().getConfig().set("JoinConfig.Join.Active-Msg",true);
                        StatusCodigo.put("Config01",true);
                        saveConfig();
                        p.sendMessage("§aAcabamos de Alterar a Configuração");
                        p.closeInventory();
                        reloadConfig();
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
                            Gui.setItem(20, PainelConfig.StatusConfig(Config.JoinActiveMSG));
                        }else{
                            Boolean JoinActive = StatusCodigo.get("Config01");
                            Gui.setItem(20,PainelConfig.StatusConfig(JoinActive));
                        }

                        if (!StatusCodigo.containsKey("Config02")){
                            StatusCodigo.put("Config02",Config.JoinActiveTitle);
                            Gui.setItem(22, PainelConfig.StatusConfig(Config.JoinActiveTitle));
                        }else{
                            Boolean JoinActive = StatusCodigo.get("Config02");
                            Gui.setItem(22,PainelConfig.StatusConfig(JoinActive));
                        }

                        if (!StatusCodigo.containsKey("Config03")){
                            StatusCodigo.put("Config03",Config.QuitActiveMSG);
                            Gui.setItem(24, PainelConfig.StatusConfig(Config.QuitActiveMSG));
                        }else{
                            Boolean JoinActive = StatusCodigo.get("Config03");
                            Gui.setItem(24,PainelConfig.StatusConfig(JoinActive));
                        }


                        p.openInventory(Gui);
                    }
                }
                if (e.getSlot() == 22){

                    if (!StatusCodigo.containsKey("Config02")){
                        StatusCodigo.put("Config02",Config.JoinActiveTitle);
                    }

                    Boolean Codigo = StatusCodigo.get("Config02");

                    if (Codigo){
                        Main.getInstance().getConfig().set("JoinConfig.Join.Active-Title",false);
                        StatusCodigo.put("Config02",false);
                        saveConfig();
                        p.sendMessage("§aAcabamos de Alterar a Configuração");
                        p.closeInventory();
                        reloadConfig();
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
                            Gui.setItem(20, PainelConfig.StatusConfig(Config.JoinActiveMSG));
                        }else{
                            Boolean JoinActive = StatusCodigo.get("Config01");
                            Gui.setItem(20,PainelConfig.StatusConfig(JoinActive));
                        }

                        if (!StatusCodigo.containsKey("Config02")){
                            StatusCodigo.put("Config02",Config.JoinActiveTitle);
                            Gui.setItem(22, PainelConfig.StatusConfig(Config.JoinActiveTitle));
                        }else{
                            Boolean JoinActive = StatusCodigo.get("Config02");
                            Gui.setItem(22,PainelConfig.StatusConfig(JoinActive));
                        }

                        if (!StatusCodigo.containsKey("Config03")){
                            StatusCodigo.put("Config03",Config.QuitActiveMSG);
                            Gui.setItem(24, PainelConfig.StatusConfig(Config.QuitActiveMSG));
                        }else{
                            Boolean JoinActive = StatusCodigo.get("Config03");
                            Gui.setItem(24,PainelConfig.StatusConfig(JoinActive));
                        }



                        p.openInventory(Gui);
                    }else{
                        Main.getInstance().getConfig().set("JoinConfig.Join.Active-Title",true);
                        StatusCodigo.put("Config02",true);
                        saveConfig();
                        p.sendMessage("§aAcabamos de Alterar a Configuração");
                        p.closeInventory();
                        reloadConfig();
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
                            Gui.setItem(20, PainelConfig.StatusConfig(Config.JoinActiveMSG));
                        }else{
                            Boolean JoinActive = StatusCodigo.get("Config01");
                            Gui.setItem(20,PainelConfig.StatusConfig(JoinActive));
                        }

                        if (!StatusCodigo.containsKey("Config02")){
                            StatusCodigo.put("Config02",Config.JoinActiveTitle);
                            Gui.setItem(22, PainelConfig.StatusConfig(Config.JoinActiveTitle));
                        }else{
                            Boolean JoinActive = StatusCodigo.get("Config02");
                            Gui.setItem(22,PainelConfig.StatusConfig(JoinActive));
                        }

                        if (!StatusCodigo.containsKey("Config03")){
                            StatusCodigo.put("Config03",Config.QuitActiveMSG);
                            Gui.setItem(24, PainelConfig.StatusConfig(Config.QuitActiveMSG));
                        }else{
                            Boolean JoinActive = StatusCodigo.get("Config03");
                            Gui.setItem(24,PainelConfig.StatusConfig(JoinActive));
                        }


                        p.openInventory(Gui);
                    }
                }
                if (e.getSlot() == 24){

                    if (!StatusCodigo.containsKey("Config03")){
                        StatusCodigo.put("Config03",Config.QuitActiveMSG);
                    }

                    Boolean Codigo = StatusCodigo.get("Config03");

                    if (Codigo){
                        Main.getInstance().getConfig().set("JoinConfig.Quit.Active-Msg",false);
                        StatusCodigo.put("Config03",false);
                        saveConfig();
                        p.sendMessage("§aAcabamos de Alterar a Configuração");
                        p.closeInventory();
                        reloadConfig();
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
                            Gui.setItem(20, PainelConfig.StatusConfig(Config.JoinActiveMSG));
                        }else{
                            Boolean JoinActive = StatusCodigo.get("Config01");
                            Gui.setItem(20,PainelConfig.StatusConfig(JoinActive));
                        }

                        if (!StatusCodigo.containsKey("Config02")){
                            StatusCodigo.put("Config02",Config.JoinActiveTitle);
                            Gui.setItem(22, PainelConfig.StatusConfig(Config.JoinActiveTitle));
                        }else{
                            Boolean JoinActive = StatusCodigo.get("Config02");
                            Gui.setItem(22,PainelConfig.StatusConfig(JoinActive));
                        }

                        if (!StatusCodigo.containsKey("Config03")){
                            StatusCodigo.put("Config03",Config.QuitActiveMSG);
                            Gui.setItem(24, PainelConfig.StatusConfig(Config.QuitActiveMSG));
                        }else{
                            Boolean JoinActive = StatusCodigo.get("Config03");
                            Gui.setItem(24,PainelConfig.StatusConfig(JoinActive));
                        }



                        p.openInventory(Gui);
                    }else{
                        Main.getInstance().getConfig().set("JoinConfig.Quit.Active-Msg",true);
                        StatusCodigo.put("Config03",true);
                        saveConfig();
                        p.sendMessage("§aAcabamos de Alterar a Configuração");
                        p.closeInventory();
                        reloadConfig();
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
                            Gui.setItem(20, PainelConfig.StatusConfig(Config.JoinActiveMSG));
                        }else{
                            Boolean JoinActive = StatusCodigo.get("Config01");
                            Gui.setItem(20,PainelConfig.StatusConfig(JoinActive));
                        }

                        if (!StatusCodigo.containsKey("Config02")){
                            StatusCodigo.put("Config02",Config.JoinActiveTitle);
                            Gui.setItem(22, PainelConfig.StatusConfig(Config.JoinActiveTitle));
                        }else{
                            Boolean JoinActive = StatusCodigo.get("Config02");
                            Gui.setItem(22,PainelConfig.StatusConfig(JoinActive));
                        }

                        if (!StatusCodigo.containsKey("Config03")){
                            StatusCodigo.put("Config03",Config.QuitActiveMSG);
                            Gui.setItem(24, PainelConfig.StatusConfig(Config.QuitActiveMSG));
                        }else{
                            Boolean JoinActive = StatusCodigo.get("Config03");
                            Gui.setItem(24,PainelConfig.StatusConfig(JoinActive));
                        }


                        p.openInventory(Gui);
                    }
                }
            }
        }
    }

    @EventHandler
    public void Join(PlayerJoinEvent e){
        reloadConfig();
        e.setJoinMessage("");
        if (e.getPlayer() != null){
            Player p = e.getPlayer();
            if (Config.JoinActiveMSG){
                String JoinText = Config.JoinMensagem.replace("{Player}", ""+p.getDisplayName()).replace("{ServerName}", Config.ServerName).replace("&", "§");
                p.sendMessage(JoinText);
            }

            if (Config.JoinActiveTitle){
                String One = Config.OneTitle.replace("&","§");
                String Two = Config.TwoTitle.replace("&","§");
                String Title = One;
                String SubTitle = Two;
                p.sendTitle(""+Title,""+SubTitle);
            }
        }
    }

    @EventHandler
    public void PlayerQuit(PlayerQuitEvent e){
        if (e.getPlayer() != null){
            Player p  = e.getPlayer();
            if (Config.QuitActiveMSG){
                String QuitText = Config.QuitMensagem.replace("{Player}", ""+p.getDisplayName()).replace("{ServerName}", Config.ServerName).replace("&", "§");
                e.setQuitMessage(QuitText);
            }else{
                e.setQuitMessage("");
            }
        }

    }

    @EventHandler
    public void PlayerCloseInv(InventoryCloseEvent e){
        if (e.getPlayer() != null){
            Player p = (Player) e.getPlayer();
            if (e.getInventory().getTitle().equalsIgnoreCase("§eConfiguração")){
                p.sendMessage("§c§l[!] Lembre de dar /rl ou reiniciar o servidor para poder evitar problemas no Plugin");
                p.playSound(p.getLocation(), Sound.CAT_HIT,30,30);
            }
        }
    }
}
