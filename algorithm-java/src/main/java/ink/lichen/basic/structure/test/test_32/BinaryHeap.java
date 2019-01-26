package ink.lichen.basic.structure.test.test_32;

import ink.lichen.basic.structure.UnderflowException;

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


    public T findMin(){
        if (isEmpty()){
            throw  new UnderflowException();
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
        for (; hole << 1 <= currentSize ; hole = child){
            child = hole << 1;
            if (child != currentSize && array[child+1].compareTo(array[child]) <0){
                child++;
            }
            if (array[child].compareTo(tmp)<0){
                array[hole] = array[child];
            }else
                break;
        }
        array[hole] = tmp;
    }

    private boolean isEmpty() {
        return currentSize == 0;
    }


    private void enlargeSize(int size) {
        T[] old = array;
        array = (T[]) new Comparable[size];
        for (int i = 0 ; i < size ;i ++){
            array[i] = old[i];
        }
    }
}
