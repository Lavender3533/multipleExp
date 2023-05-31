/*
    命令
 */
package org.example.mod.multiple.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.example.mod.multiple.multiple;
import org.example.mod.multiple.util.CU;
import org.example.mod.multiple.util.MyC;
import org.example.mod.multiple.util.Uuid;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class command implements TabExecutor {
    //public static String inExpd;
    public static String itplayer;

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command,
                             @NotNull String label, @NotNull String[] args) {
        //This is a test message;
        String inExp = args[0];
        itplayer = inExp;
        if (args.length == 1) {
            sender.sendMessage(CU.c("&a/multiple help"));
            return true;
        }

        if (inExp.equals("help")) {
            sender.sendMessage(CU.c("&e/multiple info --- 插件信息"));
            sender.sendMessage(CU.c("&e/multiple on --- 启动自定义经验倍率"));
            sender.sendMessage(CU.c("&e/multiple off --- 关闭自定义经验倍率"));
            sender.sendMessage(CU.c("&e/multiple reload --- 重载插件"));
            return true;
        }
        if (inExp.equals("info")) {
            sender.sendMessage("根据玩家的权限组调整玩家获得的经验倍率", "\n by:lavender3533");
            return true;
        }
        if (inExp.equals("reload")) {
            multiple.expmain.reloadConfig();
            sender.sendMessage("重新加载成功");
            sender.sendMessage("yours UUID be " + Uuid.getuuid(sender.getName()));
            return true;
        }
        if (inExp.equals("on")) {
            multiple.activity = true;
            sender.sendMessage("开启成功 \n 您现在的自定倍率是" + MyC.U[2]);
            return true;
        }
        if (inExp.equals("off")) {
            multiple.activity = false;
            sender.sendMessage("自定义经验倍率关闭");
            return true;
        }


        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        LinkedList<String> strings1 = new LinkedList<>();
        List<String> asList = Arrays.asList("help", "reload", "on", "off");
        if (commandSender instanceof Player && itplayer.isEmpty()) {
            asList.addAll(strings1);
            return strings1;
        } else {
            for (String i : asList) {
                if (i.toLowerCase().startsWith(itplayer.toLowerCase())) {
                    asList.add(i);
                    return strings1;
                }
            }
        }


        return strings1;
    }
}

//    @Override
//    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender,
//                                                @NotNull Command command, @NotNull String label, @NotNull String[] args) {
//        LinkedList<String> linkedList = new LinkedList<>();
//        List<String> aslist = Arrays.asList("help", "reload", "openMultiple", "closeMultiple");
//        if (sender instanceof Player && inExpd.isEmpty()) {
//            aslist.addAll(linkedList);
//            return linkedList;
//        } else {
//            for (String foSting : aslist) {
//                if (foSting.toLowerCase().startsWith(inExpd.toLowerCase())) {
//                    aslist.add(foSting);
//                    return linkedList;
//                }
//            }
//        }
//        return linkedList;
//    }
//}

