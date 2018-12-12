package ink.lichen.thread;

import java.util.concurrent.Semaphore;

/**
 * Created by lichen@daojia.com on 2018-12-12.
 */
public class PCBySemaphore {

    public static void main(String[] args) {
        Share s = new Share();
        Semaphore semCon = new Semaphore(0);
        Semaphore semPro = new Semaphore(1);
        new ProducerB(s,semPro,semCon).start();
        new ConsumerB(s,semPro,semCon).start();
    }
}

class Share{

    private char c;

    void setSharedChar(char c){
        this.c = c;
    }

    char getSharedChar(){
        return c;
    }
}

class ProducerB extends Thread{

    private final Share s;

    private final Semaphore semPro, semCon;

    public ProducerB(Share s, Semaphore semPro, Semaphore semCon) {
        this.s = s;
        this.semPro = semPro;
        this.semCon = semCon;
    }

    @Override
    public void run() {
        for (char ch = 'A'; ch <= 'Z'; ch++){
            try {
                semPro.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            s.setSharedChar(ch);
            System.out.println(ch + " produced by producer.");
            semCon.release();
        }
    }
}


class ConsumerB extends Thread{

    private final Share s;

    private final Semaphore semPro, semCon;

    public ConsumerB(Share s, Semaphore semPro, Semaphore semCon) {
        this.s = s;
        this.semPro = semPro;
        this.semCon = semCon;
    }

    @Override
    public void run() {
        char ch;
        do{
            try {
                semCon.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ch = s.getSharedChar();
            System.out.println(ch + " consumed by consumer.");
            semPro.release();
        }while (ch != 'Z');
    }
}



