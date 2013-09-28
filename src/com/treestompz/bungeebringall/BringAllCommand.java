package com.treestompz.bungeebringall;

import java.util.Collection;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class BringAllCommand extends Command {

    private BungeeBringAll plugin;
    
    public BringAllCommand(BungeeBringAll plugin, String name, String perm) {
        super(name, perm);
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSender cs, String[] arg1) {
        if(!(cs instanceof ProxiedPlayer)) {
            cs.sendMessage(ChatColor.RED + "Only players can use this command!");
            return;
        }
        ProxiedPlayer sender = (ProxiedPlayer) cs;
        Collection<ProxiedPlayer> coll = plugin.getProxy().getPlayers();
        if(coll.size() <= 1) {
            sender.sendMessage(ChatColor.RED + "You are the only player on this Bungee instance :(");
            return;
        }
        if(coll.size() == 2) {
            sender.sendMessage(ChatColor.AQUA + "Bringing 1 player to your current server...");
        } else {
            sender.sendMessage(ChatColor.AQUA + "Bringing " + (coll.size() - 1) + " players to your current server...");
        }
        for(ProxiedPlayer p : coll) {
            if(p != sender) {
                p.sendMessage(ChatColor.AQUA + "You are being forcibly connected to " + sender.getServer().getInfo().getName());
                p.connect(sender.getServer().getInfo());
            }
        }
    }

    
    
}
