package ink.lichen.thread;

/**
 * Created by lichen@daojia.com on 2018-12-8.
 */
public class ThreadStop {

    public static void main(String[] args) {
        class StoppableThread extends Thread{
            private volatile boolean stopped;

            @Override
            public void run() {
                while (!stopped){
                    System.out.println("running");
                }
            }
            void stopThread(){
                stopped = true;
            }
        }

        StoppableThread thd = new StoppableThread();
        thd.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ready stop");
        thd.stopThread();
    }
}
