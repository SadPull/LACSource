/*
 * Decompiled with CFR 0_132.
 */
package net.minecraft.entity.player.Really.Client.ui.login;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.Really.Client.ui.login.Alt;

public class AltManager {
    static List<Alt> alts;
    static Alt lastAlt;

    public static void init() {
        AltManager.setupAlts();
        AltManager.getAlts();
    }

    public Alt getLastAlt() {
        return lastAlt;
    }

    public void setLastAlt(Alt alt) {
        lastAlt = alt;
    }

    public static void setupAlts() {
        alts = new ArrayList<Alt>();
    }

    public static List<Alt> getAlts() {
        return alts;
    }
}

