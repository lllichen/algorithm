package ink.lichen.thread;

import java.util.concurrent.Semaphore;

/**
 * Created by lichen@daojia.com on 2018-12-12.
 */
public class PCBySemaphore {

    private Semaphore empty = new Semaphore(3);
    private Semaphore semaphore = new Semaphore(3);

}

class share{

}
