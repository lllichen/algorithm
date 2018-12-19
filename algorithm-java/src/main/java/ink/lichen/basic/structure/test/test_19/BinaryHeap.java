package ink.lichen.basic.structure.test.test_19;

/**
 * Created by lichen@daojia.com on 2018-12-19.
 */
public class BinaryHeap<T extends Comparable<? super T>> {

    private T[] array;

    private int currentSize;

    private static final int DEFAULT_CAPACITY = 10;

    public BinaryHeap(int capacity) {
        currentSize = 0;
        array = (T[]) new Comparable[capacity+1];
    }

    public BinaryHeap(){
        this(DEFAULT_CAPACITY);
    }


}
