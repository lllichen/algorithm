package ink.lichen.basic.structure.test.test_41;

import ink.lichen.basic.structure.UnderflowException;

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
        int hole = ++currentSize;
        for (array[0] = t;t.compareTo(array[hole>>1])<0;hole >>=1){
            array[hole] = array[hole>>1];
        }
        array[hole] = t;
    }

    public T findMin(){
        if (isEmpty()){
            throw new UnderflowException();
        }
        T min = array[1];
        return min;
    }

    public T deleteMin(){
        if (isEmpty()){
            throw new UnderflowException();
        }
        T min = findMin();
        array[1] = array[currentSize--];
        percolateDown(1);
        return min;
    }

    private void percolateDown(int hole) {
        int child;
        T tmp = array[hole];
//        for (int i = 0 ;i < )
    }

    private boolean isEmpty() {
        return currentSize == 0;
    }

    private void enlargeArray(int size) {
        T[] old = array;
        array = (T[]) new Comparable[size];
        for (int i = 0 ; i < old.length; i++){
            array[i] = old[i];
        }
    }
}
