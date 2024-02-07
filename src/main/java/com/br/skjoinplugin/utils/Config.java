package com.br.skjoinplugin.utils;

import com.br.skjoinplugin.Main;

import java.util.HashMap;

public class Config {

    public static String ServerName =  Main.getInstance().getConfig().getString("Config.ServerName");

    public static String Permission = Main.getInstance().getConfig().getString("Config.Permission");

    public static boolean JoinActiveMSG = Main.getInstance().getConfig().getBoolean("JoinConfig.Join.Active-Msg");
    public static boolean JoinActiveTitle = Main.getInstance().getConfig().getBoolean("JoinConfig.Join.Active-Title");

    public static String JoinMensagem = Main.getInstance().getConfig().getString("JoinConfig.Join.Join-Mensagem.Mensagem");

    public static String OneTitle = Main.getInstance().getConfig().getString("JoinConfig.Join.Title.One");
    public static String TwoTitle = Main.getInstance().getConfig().getString("JoinConfig.Join.Title.Two");


    public static boolean QuitActiveMSG = Main.getInstance().getConfig().getBoolean("JoinConfig.Quit.Active-Msg");
    public static String QuitMensagem = Main.getInstance().getConfig().getString("JoinConfig.Quit.Mensagem");



}
