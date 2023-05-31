package org.example.mod.multiple.util;

import org.bukkit.Bukkit;

import java.util.UUID;

public class Uuid {
    public static UUID uuid;

    //public static String Name = null;
    public static String getuuid(String name) {
        uuid = Bukkit.getPlayerUniqueId(name);
        Bukkit.getConsoleSender().sendMessage(uuid);
        return null;
    }
}
