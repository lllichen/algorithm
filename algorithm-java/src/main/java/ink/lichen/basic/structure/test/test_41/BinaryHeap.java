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

    public void insert(T t){
        if (currentSize == array.length-1){
            enlargeArray(array.length*2+1);
        }
    }

    private void enlargeArray(int size) {
        T[] old = array;
        array = (T[]) new Comparable[size];
        for (int i = 0 ; i < old.length; i++){
            array[i] = old[i];
        }
    }
}
