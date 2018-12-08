package ink.lichen.thread;

/**
 * Created by lichen@daojia.com on 2018-12-8.
 */
public class ThreadDemo {

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                String name = Thread.currentThread().getName();
                int count = 0;
                while (!Thread.interrupted()) {
                    System.out.println(name + ": " + count++);
                }
            }
        };
        Thread thA = new Thread(r);
        Thread thB = new Thread(r);
        thA.start();
        thB.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thA.interrupt();
        thB.interrupt();
    }
}
