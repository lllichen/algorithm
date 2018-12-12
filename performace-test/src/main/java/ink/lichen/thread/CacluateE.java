package ink.lichen.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by lichen@daojia.com on 2018-12-12.
 */
public class CacluateE {


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Callable<String> callable;
        callable = () -> {
            Thread.sleep(20000);
            return "hello,world";
        };
        Future<String> taskFuture = executorService.submit(callable);
        try{
            while (!taskFuture.isDone()){
                System.out.println("I'm waiting");
            }
            System.out.println(taskFuture.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdownNow();
    }
}
