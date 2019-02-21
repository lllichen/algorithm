package ink.lichen.lock;

/**
 * Created by lichen@daojia.com on 2019-2-21.
 */
public class ABCTest {


        public static void main(String[] args) {
            MajusculeABC maj = new MajusculeABC();
            Thread t_a = new Thread(new Thread_ABC(maj , 'A'));
            Thread t_b = new Thread(new Thread_ABC(maj , 'B'));
            Thread t_c = new Thread(new Thread_ABC(maj , 'C'));
            t_a.start();
            t_b.start();
            t_c.start();
        }


}
class MajusculeABC {
}
class Thread_ABC implements Runnable {

    private MajusculeABC majusculeABC;

    private char value;

    public Thread_ABC(MajusculeABC majusculeABC,char value) {
        this.majusculeABC = majusculeABC;
        this.value = value;
    }

    @Override
    public void run() {

    }
}