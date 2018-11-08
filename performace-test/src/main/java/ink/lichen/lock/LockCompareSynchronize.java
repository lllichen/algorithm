package ink.lichen.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lichen@daojia.com on 2018-11-8.
 */
public class LockCompareSynchronize {



    public void testLock(){
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        Lock lock = new ReentrantLock();

    }

    public void testSynchronize(){
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
    }

    public static void main(String[] args) throws Exception {



    }
}
