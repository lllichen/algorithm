package ink.lichen.basic.structure.test.test_32;

/**
 * Created by lichen@daojia.com on 2019-1-25.
 */
public class BinaryHeap<T extends Comparable<? super T>> {

    private T[] array;

    private static final int DEFAULT_CAPACITY = 10;

    private int currentSize;

    public BinaryHeap(){
        this(DEFAULT_CAPACITY);
    }


    public BinaryHeap(int capacity) {
        currentSize = 0;
        array = (T[]) new Comparable[capacity+1];
    }

    public void insert(T t){
        if (currentSize == array.length-1){
            enlargeSize(array.length*2+1);
        }

        int hole = ++currentSize;
        for (array[0] = t;t.compareTo(array[hole>>1])<0; hole >>= 1){
            array[hole] = array[hole >>1];
        }
    }

    private void enlargeSize(int size) {

    }
}
