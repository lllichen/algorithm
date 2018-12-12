package ink.lichen.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lichen@daojia.com on 2018-12-12.
 */
public class CountDownLatchDemo {

    private static final int val = 3;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch end = new CountDownLatch(3);
        CountDownLatch begin = new CountDownLatch(1);

        ExecutorService executorService = Executors.newFixedThreadPool(val);
        Runnable runnable = ()->{
            try {
                System.out.println(Thread.currentThread().getName()+" ready!!");
                begin.await();
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName()+" end!!");
                end.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        executorService.submit(runnable);
        executorService.submit(runnable);
        executorService.submit(runnable);
        begin.countDown();
        System.out.println("hahahha");
        end.await();
        executorService.shutdown();
        System.out.println("main end!!!");
    }
}
