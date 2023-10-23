package com.teragrep.jla_02;

import com.teragrep.jla_04.*;

import java.io.*;
import java.util.TimerTask;
import java.util.concurrent.TimeoutException;
import java.util.logging.*;

public class JavaUtilLoggingLogger extends TimerTask {
    static {
    }
    static Logger logger = Logger.getLogger(JavaUtilLoggingLogger.class.getName());
    public JavaUtilLoggingLogger() {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(System.getProperty("user.dir") + "/conf/logging.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
        try {
            LogManager.getLogManager().readConfiguration(inputStream);
        }
        catch (IOException e) {
            System.out.println("Can't read conf/logging.properties: " + e.getMessage());
            System.exit(1);
        }
        RelpHandler handler = null;
        try {
            handler = new RelpHandler();
        } catch (NoSuchFieldException | IOException | TimeoutException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            System.exit(1);
        }
        LogManager.getLogManager().reset();
        logger.addHandler(handler);
    }

    @Override
    public void run() {
        try {
            logger.info("JavaUtilLoggingLogger info says hi");
            logger.warning("JavaUtilLoggingLogger warning says hi");
            logger.severe("JavaUtilLoggingLogger severe says hi");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
