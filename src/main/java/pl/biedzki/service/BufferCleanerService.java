package pl.biedzki.service;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class BufferCleanerService implements Runnable {

    // implemented run method to be used in thread
    public void run() {
        TimerTask cleanBuffer = new TimerTask() {
            public void run() {
               // System.out.println("Todo buffer action");
            }
        };

        Timer timer = new Timer("Timer");

    //timer parameters
        long delay = 1000L;
        long period = 1000L;
        timer.scheduleAtFixedRate(cleanBuffer, delay, period);
    }

}
