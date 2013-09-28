package com.treestompz.bungeebringall;

import net.md_5.bungee.api.plugin.Plugin;

public class BungeeBringAll extends Plugin {

    @Override
    public void onEnable() {
        BringAllCommand cmd = new BringAllCommand(this, "bringall", "bungeebringall.bringall");
        this.getProxy().getPluginManager().registerCommand(this, cmd);
    }
    
}
