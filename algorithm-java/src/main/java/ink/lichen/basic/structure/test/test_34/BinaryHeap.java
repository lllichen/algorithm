package ink.lichen.basic.structure.test.test_34;

import ink.lichen.basic.structure.UnderflowException;

/**
 * Created by lichen@daojia.com on 2019-2-12.
 */
public class BinaryHeap<T extends Comparable<? super T>> {

    private static final int DEFAULT_CAPACITY = 10;

    private T[] array;

    private int currentSize;


    BinaryHeap(){
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
        for (array[0] = t; array[hole >> 1].compareTo(t) > 0;  hole = hole>>1 ){
            array[hole] = array[hole >>1];
        }
        array[hole] = t;
    }

    private void enlargeArray(int size) {
        T[] old = array;
        array = (T[]) new Comparable[size];

        for (int i = 0 ; i < old.length; i++){
            array[i] = old[i];
        }
    }

    public T findMin(){
        if (isEmpty()){
            throw new UnderflowException();
        }
        T min = array[1];
        return min;
    }

    private boolean isEmpty() {
        return currentSize == 0;
    }

    public T deleteMin(){
        if (isEmpty()){
            throw new UnderflowException();
        }
        T min  = findMin();
        percolateDown(1);
        return min;
    }

    private void percolateDown(int hole) {
        
    }

}
