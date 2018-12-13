package ink.lichen.thread;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by lichen@daojia.com on 2018-12-13.
 */
public class CompleteServiceDemo {


    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService es = Executors.newFixedThreadPool(10);
        CompletionService<String> cs = new ExecutorCompletionService<>(es);
        cs.submit(()->{
            Thread.sleep(10000);
            return "hello world";
        });
        Future<String> result = cs.take();

        System.out.println(result.get());
        System.out.println();
        result = cs.take();
        System.out.println(result.get());
        es.shutdown();
    }
}
