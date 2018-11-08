package ink.lichen.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lichen@daojia.com on 2018-11-8.
 */
public class LockCompareSynchronize {



    public static void main(String[] args) throws Exception {


        long time1 = System.currentTimeMillis();

        final CountDownLatch latch = new CountDownLatch(5);
        final LockMap lockMap = new LockMap(new HashMap<Integer, Integer>());
        lockMap.put(1,1);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for(int i = 0 ; i < 10000; i++){
                    Integer val = lockMap.get(1);
                    lockMap.put(1,val+1);
                }
                latch.countDown();
            }
        };
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);
        Thread t4 = new Thread(runnable);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        latch.await();
        System.out.println(lockMap.get(1));
        long time2 = (System.currentTimeMillis()-time1);
        System.out.println(time2);

    }

    private static class LockMap {
        Map<Integer, Integer> map ;

        Lock lock = new ReentrantLock();

        public LockMap(Map<Integer, Integer> map) {
            this.map = map;
        }

        public void put(Integer key, Integer value){
            lock.lock();
            try {
                map.put(key,value);
            }finally {
                lock.unlock();
            }
        }

        public Integer get(Integer key){
            lock.lock();
            try {
                return map.get(key);
            }finally {
                lock.unlock();
            }
        }

    }

    private static class SynchronizeMap{
        Map<Integer, Integer> map ;

        public SynchronizeMap(Map<Integer, Integer> map) {
            this.map = map;
        }

        public synchronized void put(Integer key, Integer value){
                map.put(key,value);
        }

        public synchronized Integer get(Integer key){
                return map.get(key);
        }
    }

}
