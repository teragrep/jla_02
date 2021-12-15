package com.teragrep.jla_02;

import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {
        final int sleep_duration = (System.getenv("SLEEP_DURATION") == null) ? 5 : Integer.parseInt(System.getenv("SLEEP_DURATION"));
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Thread Log4j2 = new Thread(
            new Runnable(){
                public void run(){
                    System.out.println("Starting Log4j2");
                    Log4j2 log4j2 = new Log4j2();
                    while(true) {
                        try {
                            log4j2.Log();
                            Thread.sleep(sleep_duration * 1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            System.exit(1);
                        }
                    }
                }
            }
        );
        Log4j2.start();

        Thread Log4j = new Thread(
            new Runnable(){
                public void run(){
                    System.out.println("Starting Log4j");
                    Log4j log4j = new Log4j();
                    while(true) {
                        try {
                            log4j.Log();
                            Thread.sleep(sleep_duration * 1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            System.exit(1);
                        }
                    }
                }
            }
        );
        Log4j.start();

        Thread JavaUtilLoggingLogger = new Thread(
            new Runnable(){
                public void run(){
                    System.out.println("Starting JavaUtilLoggingLogger");
                    JavaUtilLoggingLogger javautillogginglogger = new JavaUtilLoggingLogger();
                    while(true) {
                        try {
                            javautillogginglogger.Log();
                            Thread.sleep(sleep_duration * 1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            System.exit(1);
                        }
                    }
                }
            }
        );
        JavaUtilLoggingLogger.start();

        Thread Logback = new Thread(
            new Runnable(){
                public void run(){
                    System.out.println("Starting Logback");
                    Logback logback = new Logback();
                    while(true) {
                        try {
                            logback.Log();
                            Thread.sleep(sleep_duration * 1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            System.exit(1);
                        }
                    }

                }
            }
        );
        Logback.start();

        Thread Tinylog = new Thread(
            new Runnable() {
                public void run() {
                    System.out.println("Starting Tinylog");
                    Tinylog tinylog = new Tinylog();
                    while (true) {
                        try {
                            tinylog.Log();
                            Thread.sleep(sleep_duration * 1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            System.exit(1);
                        }
                    }
                }
            }
        );
        // Tinylog.start(); // WIP

        while(true) {
            try {
                Thread.sleep(1000000);
            }
            catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
    }
}
