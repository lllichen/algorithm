package ink.lichen.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lichen@daojia.com on 2018-5-22.
 */
public class Sample {

    private int count;

    public void inc () {
        synchronized (this) {
            ++count;
        }
    }

}

class Counter {

    private Lock lock = new ReentrantLock( );

    private int count = 0;

    public int inc() {
        lock.lock();
        count = count+1;
        lock.unlock();
        return count;
    }



}