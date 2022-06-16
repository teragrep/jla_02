package com.teragrep.jla_02;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.apache.logging.log4j.core.config.xml.XmlConfigurationFactory;
import org.apache.logging.log4j.LogManager;

import java.util.TimerTask;

public class Log4j2  extends TimerTask {
    private static Logger logger;
    private static Marker LOG_AUDIT;
    private static Marker LOG_DAILY;
    private static Marker LOG_METRIC;

    public Log4j2() {
        System.setProperty(XmlConfigurationFactory.CONFIGURATION_FILE_PROPERTY, "conf/log4j2.xml");
        logger = LogManager.getLogger(Log4j2.class);
        LOG_AUDIT = MarkerManager.getMarker("AUDIT");
        LOG_DAILY = MarkerManager.getMarker("DAILY");
        LOG_METRIC = MarkerManager.getMarker("METRIC");
    }

    @Override
    public void run() {
        try {
            logger.info(LOG_AUDIT, "Log4j2 info audit says hi!");
            logger.info(LOG_DAILY, "Log4j2 info daily says hi!");
            logger.info(LOG_METRIC, "Log4j2 info metric says hi!");
            logger.warn(LOG_AUDIT, "Log4j2 warn audit says hi!");
            logger.warn(LOG_DAILY, "Log4j2 warn daily says hi!");
            logger.warn(LOG_METRIC, "Log4j2 warn metric says hi!");
            logger.error(LOG_AUDIT, "Log4j2 error audit says hi!");
            logger.error(LOG_DAILY, "Log4j2 error daily says hi!");
            logger.error(LOG_METRIC, "Log4j2 error metric says hi!");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
