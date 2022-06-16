package com.teragrep.jla_02;

import java.text.SimpleDateFormat;
import java.util.Timer;

public class Main {
    public static void main(String[] args) {
        final int sleep_duration = ((System.getenv("SLEEP_DURATION") == null) ? 5 : Integer.parseInt(System.getenv("SLEEP_DURATION")))*1000;

        Timer timer = new Timer();

        System.out.println("Sending events every " + sleep_duration + " milliseconds");

        Thread Log4j2 = new Thread(
            new Runnable(){
                public void run(){
                    System.out.println("Starting Log4j2");
                    timer.scheduleAtFixedRate(new Log4j2(), 0, sleep_duration);
                }
            }
        );
        Log4j2.start();

        Thread Log4j = new Thread(
            new Runnable(){
                public void run(){
                    System.out.println("Starting Log4j");
                    timer.scheduleAtFixedRate(new Log4j(), 0, sleep_duration);
                }
            }
        );
        Log4j.start();

        Thread JavaUtilLoggingLogger = new Thread(
            new Runnable(){
                public void run(){
                    System.out.println("Starting JavaUtilLoggingLogger");
                    timer.scheduleAtFixedRate(new JavaUtilLoggingLogger(), 0, sleep_duration);
                }
            }
        );
        JavaUtilLoggingLogger.start();

        Thread Logback = new Thread(
            new Runnable(){
                public void run(){
                    System.out.println("Starting Logback");
                    timer.scheduleAtFixedRate(new Logback(), 0, sleep_duration);
                }
            }
        );
        Logback.start();

        Thread Tinylog = new Thread(
            new Runnable() {
                public void run() {
                    System.out.println("Starting Tinylog");
              //      timer.scheduleAtFixedRate(new Tinylog(), 0, sleep_duration);
                }
            }
        );
        // Tinylog.start(); // WIP

        try {
            Thread.currentThread().join();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
