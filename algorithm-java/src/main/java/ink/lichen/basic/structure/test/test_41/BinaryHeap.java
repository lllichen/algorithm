package ink.lichen.basic.structure.test.test_41;

/**
 * Created by lichen@daojia.com on 2019-3-8.
 */
public class BinaryHeap<T extends Comparable<? super T>> {

    private T[] array;

    private static final int DEFAULT_CAPACITY = 10;

    private int currentSize;

    BinaryHeap() {
        this(DEFAULT_CAPACITY);
    }

    public BinaryHeap(int capacity) {
        currentSize = 0;
        array = (T[]) new Comparable[capacity];
    }
}
