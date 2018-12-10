package ink.lichen.thread;

/**
 * Created by lichen@daojia.com on 2018-12-10.
 */
class ThreadB extends Thread{
    int total;
    @Override
    public void run(){
        synchronized(this){
            for(int i=0; i<100 ; i++){
                total += i;
            }
            notify();
        }
    }
}

