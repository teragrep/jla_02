package com.teragrep.jla_02;

import com.teragrep.jla_04.*;

import java.io.*;
import java.util.concurrent.TimeoutException;
import java.util.logging.*;

public class JavaUtilLoggingLogger {
    static {
    }
    static Logger logger = Logger.getLogger(JavaUtilLoggingLogger.class.getName());
    public JavaUtilLoggingLogger() {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(System.getProperty("user.dir") + "/conf/logging.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            LogManager.getLogManager().readConfiguration(inputStream);
        }
        catch (IOException e) {
            System.out.println("Can't read conf/logging.properties: " + e.getMessage());
        }
        RelpHandler handler = null;
        try {
            handler = new RelpHandler();
        } catch (NoSuchFieldException | IOException | TimeoutException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        LogManager.getLogManager().reset();
        logger.addHandler(handler);
    }

    public void Log() {
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
