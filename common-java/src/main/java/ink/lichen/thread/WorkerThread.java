package ink.lichen.thread;

import java.time.LocalDateTime;

/**
 * Created by lichen@daojia.com on 2018-5-4.
 */
public class WorkerThread implements Runnable{

    private String command;


    public WorkerThread(String command) {
        this.command = command;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + " Start. Time = " + LocalDateTime.now());
        processCommand();
        System.out.println(Thread.currentThread().getName() + " End. Time = " + LocalDateTime.now());
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.command;
    }

}
