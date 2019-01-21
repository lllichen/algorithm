package ink.lichen.basic.structure.test.test_31;

/**
 * Created by lichen@daojia.com on 2019-1-21.
 */
public class BinaryHeap<T extends Comparable<? super T>> {

    private static final int DEFAULT_CAPACITY = 10;

    private T[] array;

    private int currentSize;

    public BinaryHeap(){
        this(DEFAULT_CAPACITY);
    }


    public BinaryHeap(int capacity) {
        currentSize = 0;
        array = (T[]) new Comparable[capacity+1];
    }



}
