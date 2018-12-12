package ink.lichen.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lichen@daojia.com on 2018-12-12.
 */
public class RLDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        final ReentrantLock lock = new ReentrantLock();


        class Worker implements Runnable{

            private final String name;

            Worker(String name){
                this.name = name;
            }

            @Override
            public void run() {
                lock.lock();
                try {
                    if (lock.isHeldByCurrentThread()){
                        System.out.printf("Thread %s entered critical section.%n", name);
                        System.out.printf("Thread %s performing work.%n",name);

                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.printf("Thread %s finished work.%n",name);
                    }
                }finally {
                    lock.unlock();
                }
            }
        }

        executorService.execute(new Worker("ThdA"));
        executorService.execute(new Worker("ThdB"));

        try{
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdownNow();
    }
}
