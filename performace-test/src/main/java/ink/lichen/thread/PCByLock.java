package ink.lichen.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lichen@daojia.com on 2018-12-13.
 */
public class PCByLock {

    public static void main(String[] args) {
        ShareByLock s = new ShareByLock();
        new ProducerByLock(s).start();
        new ConsumerByLock(s).start();
    }
}

class ShareByLock {
    private char c;

    private volatile boolean available;

    private final Lock lock;

    private final Condition condition;

    public ShareByLock() {
        available = false;
        this.lock = new ReentrantLock();
        this.condition = lock.newCondition();
    }

    Lock getLock(){
        return lock;
    }

    char getSharedChar(){
        lock.lock();
        try {
            while (!available){
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                available = false;
                condition.signal();
            }
        }finally {
            lock.unlock();
            return c;
        }
    }

    void setSharedChar(char c){
        lock.lock();
        try {
            while (available) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.c = c;
            available = true;
            condition.signal();
        }finally {
            lock.unlock();
        }
    }
}

class ProducerByLock extends Thread{
    private final Lock l;

    private final ShareByLock s;

    public ProducerByLock( ShareByLock s) {
        this.l = s.getLock();
        this.s = s;
    }

    @Override
    public void run() {
        for (char ch = 'A'; ch <= 'Z'; ch++){
            l.lock();
            s.setSharedChar(ch);
            System.out.println(ch + " produced by producer.");
            l.unlock();
        }
    }
}


class ConsumerByLock extends Thread{

    private final Lock l;

    private final ShareByLock s;

    public ConsumerByLock(ShareByLock s) {
        this.l = s.getLock();
        this.s = s;
    }

    @Override
    public void run() {
        char ch;
        do {
            l.lock();
            ch = s.getSharedChar();
            System.out.println(ch + " consumed by consumer. ");
            l.unlock();
        }
        while (ch != 'Z');
    }
}
