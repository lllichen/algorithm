package ink.lichen.basic.structure.test.test_23;

/**
 * Created by lichen@daojia.com on 2018-12-24.
 */
public class BinaryHeap<T extends Comparable<? super T>> {

    private T[] array;

    private int currentSize;

    private static final int DEFAULT_CAPACITY=10;


    public BinaryHeap(){
        this(DEFAULT_CAPACITY);
    }

    public BinaryHeap(int capacity) {
        currentSize = 0;
        array = (T[]) new Comparable[capacity+1];
    }

    public void insert(T t){
        if (currentSize == array.length-1){
            enlargeArray(array.length*2+1);
        }
    }

    private void enlargeArray(int size) {

    }

}
