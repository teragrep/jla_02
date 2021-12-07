package com.teragrep.jla_02;

import org.pmw.tinylog.Logger;

public class Tinylog {
    public void Log() {
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
