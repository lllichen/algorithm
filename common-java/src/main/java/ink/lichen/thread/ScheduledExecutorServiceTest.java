package ink.lichen.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by lichen@daojia.com on 2018-5-4.
 */
public class ScheduledExecutorServiceTest {


    public static void main(String[] args) {
        scheduleWithDelay();
        scheduleAtRate();
    }


    public static void scheduleWithDelay(){
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool( 3 );
        WorkerThread workerThread = new WorkerThread( "do some thing" );
        scheduledExecutorService.scheduleWithFixedDelay( workerThread,3000,3000, TimeUnit.MICROSECONDS );
    }

    public static void scheduleAtRate(){
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool( 3 );
        WorkerThread workerThread = new WorkerThread( "do some thing" );
        scheduledExecutorService.scheduleAtFixedRate( workerThread,3000,3000,TimeUnit.MICROSECONDS );
    }

}
