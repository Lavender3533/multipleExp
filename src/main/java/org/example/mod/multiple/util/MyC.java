package org.example.mod.multiple.util;

import org.example.mod.multiple.multiple;

public class MyC {
    public static int[] U = new int[3];

    public static void f() {
        U[0] = multiple.expmain.getConfig().getInt("ExpMagnification.multiple");
        U[1] = multiple.expmain.getConfig().getInt("ExpMagnification.multiple1");
        U[2] = multiple.expmain.getConfig().getInt("ExpMagnification.multiple2");
    }

}
