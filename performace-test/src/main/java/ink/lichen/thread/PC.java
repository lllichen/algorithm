package ink.lichen.thread;

/**
 * Created by lichen@daojia.com on 2018-12-8.
 */
public class PC {

    public static void main(String[] args) {
        Shared s = new Shared();
        new Producer(s).start();
        new Consumer(s).start();
    }




}
class Producer extends Thread{
    private final Shared s;

    Producer(Shared s){
        this.s = s;
    }

    @Override
    public void run() {
        for (char ch = 'A'; ch <= 'Z'; ch++){
            s.setSharedChar(ch);
            System.out.println(ch + " produced by producer.");
        }
    }
}

class Consumer extends Thread{
    private Shared s;

    public Consumer(Shared s) {
        this.s = s;
    }

    public void run() {
        char ch;
        do{
            ch = s.getSharedChar();
            System.out.println(ch + " consumed by consumer.");
        }
        while (ch != 'Z');
    }
}

class Shared {
    private char c;
    private volatile boolean writeable = true;

    synchronized void setSharedChar(char c) {
        while (!writeable) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.c = c;
            writeable = false;
            notify();
        }
    }

    synchronized char getSharedChar(){
        while (writeable){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        writeable = true;
        notify();
        return c;
    }
}