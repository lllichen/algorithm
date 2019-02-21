package ink.lichen.lock;

/**
 * Created by lichen@daojia.com on 2019-2-21.
 */
public class DeadLock {

    private  String str1 = "lock1";

    private  String str2 = "lock2";

    Thread th1 = new Thread(()->{
        synchronized (str1){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("get lock2");

            synchronized (str2){
                System.out.println("get lock2 ok!");
            }
        }
    });

    Thread th2 = new Thread(()->{
        synchronized (str2){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("get lock1");

            synchronized (str1){
                System.out.println("get lock2 ok!");
            }
        }
    });


    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();
        deadLock.th1.start();
        deadLock.th2.start();
    }

}
