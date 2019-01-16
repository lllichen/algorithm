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
        for (array[0] = t; t.compareTo(array[hole>>1]) <0; hole >>= 1 ){
            array[hole] = array[hole>>1];
        }
        array[hole] = t;
    }

    private void enlargeArray(int size) {
        T[] old = array;
        array = (T[]) new Comparable[size];
        for (int i = 0 ; i < old.length; i ++){
            array[i] = old[i];
        }
    }


}
