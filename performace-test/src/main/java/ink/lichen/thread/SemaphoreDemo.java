package ink.lichen.thread;

import java.util.concurrent.Semaphore;

/**
 * Created by lichen@daojia.com on 2018-12-12.
 */
public class SemaphoreDemo {


    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(0);
        semaphore.release();
        semaphore.release();
        System.out.println(semaphore.availablePermits());
    }

}
