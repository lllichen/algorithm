package ink.lichen.basic.structure.test.test_29;

/**
 * Created by lichen@daojia.com on 2019-1-14.
 */
public class BinaryHeap<T extends Comparable<? super T>> {

    private static final int DEFAULT_CAPACITY = 10;

    private int currentSize;

    private T[] array;


    BinaryHeap(){
        this(DEFAULT_CAPACITY);
    }


    public BinaryHeap(int capacity) {
        currentSize = 0;
        array = (T[]) new Comparable[capacity+1];
    }

    public void insert(){

    }
}
