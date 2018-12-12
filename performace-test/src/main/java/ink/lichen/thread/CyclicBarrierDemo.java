package ink.lichen.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lichen@daojia.com on 2018-12-12.
 */
public class CyclicBarrierDemo {

    private static final int val = 3;
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(val,()->{
            System.out.println("all is over");
        });
        System.out.println(barrier.getNumberWaiting());
        ExecutorService executorService = Executors.newFixedThreadPool(val);
        Runnable runnable = ()->{
            try {
                System.out.println(Thread.currentThread().getName()+" ready!!");
                barrier.await();
                System.out.println(Thread.currentThread().getName()+" end!!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        };
        executorService.submit(runnable);
        executorService.submit(runnable);
        executorService.submit(runnable);
        Thread.sleep(2000);
        System.out.println(barrier.getNumberWaiting());

        System.out.println("hahahha");

        executorService.shutdown();
        System.out.println("main end!!!");
    }
}
