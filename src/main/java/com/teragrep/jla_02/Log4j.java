package com.teragrep.jla_02;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.util.TimerTask;

public class Log4j extends TimerTask {

    private static Logger logger;

    public Log4j() {
        DOMConfigurator.configure("conf/log4j.xml");
        logger = Logger.getLogger(Log4j.class);
    }

    @Override
    public void run() {
        try {
            logger.info("Log4j info says hi!");
            logger.warn("Log4j warn says hi!");
            logger.error("Log4j error says hi!");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
