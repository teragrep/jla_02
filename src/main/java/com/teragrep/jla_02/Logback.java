package com.teragrep.jla_02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import ch.qos.logback.classic.util.ContextInitializer;

import java.util.TimerTask;

public class Logback extends TimerTask {
    private static Logger logger;
    private static Marker LOG_AUDIT = MarkerFactory.getMarker("AUDIT");
    private static Marker LOG_DAILY = MarkerFactory.getMarker("DAILY");
    private static Marker LOG_METRIC = MarkerFactory.getMarker("METRIC");
    private int counter;

    public Logback() {
        System.setProperty(ContextInitializer.CONFIG_FILE_PROPERTY, "conf/logback.xml");
        logger = LoggerFactory.getLogger(Logback.class);
        LOG_AUDIT = MarkerFactory.getMarker("AUDIT");
        LOG_DAILY = MarkerFactory.getMarker("DAILY");
        LOG_METRIC = MarkerFactory.getMarker("METRIC");

    }

    @Override
    public void run() {
        try {
            logger.info(LOG_AUDIT, "Logback-audit says hi.");
            logger.info(LOG_DAILY, "Logback-daily says hi.");
            logger.info(LOG_METRIC, "Logback-metric says hi.");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
