package jdk;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Timer가 왜 Mediator 역할을 하는지 잘 모르겠음.
 */
public class MediatorInJdkTimer extends TimerTask {

    @Override
    public void run() {
        System.out.println("Start time:" + new Date());
        doSomeWork();
        System.out.println("End time:" + new Date());
    }

    // simulate a time consuming task
    private void doSomeWork() {
        try {

            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {

        TimerTask timerTask = new MediatorInJdkTimer(); //<-- Mediator?
        // running timer task as daemon thread
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(timerTask, 0, 10 * 1000);
        System.out.println("TimerTask begins! :" + new Date());
        // cancel after sometime
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timer.cancel();
        System.out.println("TimerTask cancelled! :" + new Date());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
