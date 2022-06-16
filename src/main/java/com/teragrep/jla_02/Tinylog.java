package com.teragrep.jla_02;

import org.pmw.tinylog.Logger;

import java.util.TimerTask;

public class Tinylog extends TimerTask {
    @Override
    public void run() {
        try {
            Logger.info("Tinylog info says hi!");
            Logger.warn("Tinylog warn says hi!");
            Logger.error("Tinylog error says hi!");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
