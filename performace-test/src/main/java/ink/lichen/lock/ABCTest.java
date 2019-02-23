package ink.lichen.lock;

import java.util.concurrent.Semaphore;

/**
 * Created by lichen@daojia.com on 2019-2-21.
 */
public class ABCTest {


    public static void main(String[] args) {
        MajusculeABC maj = new MajusculeABC();
        Thread t_a = new Thread(new Thread_ABC(maj, 'A'));
        Thread t_b = new Thread(new Thread_ABC(maj, 'B'));
        Thread t_c = new Thread(new Thread_ABC(maj, 'C'));
        t_a.start();
        t_b.start();
        t_c.start();
    }


}

class MajusculeABC {

    Semaphore a = new Semaphore(1);
    Semaphore b = new Semaphore(0);
    Semaphore c = new Semaphore(0);


}

class Thread_ABC implements Runnable {

    private MajusculeABC majusculeABC;

    private char value;

    public Thread_ABC(MajusculeABC majusculeABC, char value) {
        this.majusculeABC = majusculeABC;
        this.value = value;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 2; j++) {
            }

        }
    }
}