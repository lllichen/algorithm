package ink.lichen.thread;

/**
 * Created by lichen@daojia.com on 2018-12-8.
 */
public class PC {

    public static void main(String[] args) {

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
    }

    class Producer extends Thread{
        private final Shared s;

        Producer(Shared s){
            this.s = s;
        }

        @Override
        public void run() {
            for (char ch = 'A'; ch <= 'Z'; ch++){

            }
        }
    }
}
