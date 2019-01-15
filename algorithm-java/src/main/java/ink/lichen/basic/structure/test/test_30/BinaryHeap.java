package ink.lichen.basic.structure.test.test_30;

/**
 * Created by lichen@daojia.com on 2019-1-15.
 */
public class BinaryHeap <T extends Comparable<? super T>>{


    private static final int DEFAULT_CAPACITY = 10;

    private int currentSize;

    private T[] array;

    BinaryHeap(){
        this(DEFAULT_CAPACITY);
    }

    public BinaryHeap(int capacity) {
        currentSize = 0;
        array = (T[]) new Comparable[capacity];
    }

    public void  insert(T t){
        if (currentSize == array.length-1){
            enlargeArray(array.length*2+1);
        }
        int hole = ++currentSize;
    }

    private void enlargeArray(int size) {

    }


}
