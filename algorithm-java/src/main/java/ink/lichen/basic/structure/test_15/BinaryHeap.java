package ink.lichen.basic.structure.test_15;

import ink.lichen.basic.structure.UnderflowException;

public class BinaryHeap <T extends Comparable<? super T>>{


    private T[] array;

    private static final int DEFAULT_CAPACITY = 10;

    private int currentSize;

    public BinaryHeap(){
        this(DEFAULT_CAPACITY);
    }

    public BinaryHeap(int capacity) {
        array = (T[]) new Comparable[capacity+1];
        currentSize = 0;
    }

    public void insert(T t){
        if (currentSize == array.length-1){
            enlargeArray((array.length<<1)+1);
        }
    }

    private void enlargeArray(int size) {
        T[] old = array;
        array = (T[]) new Comparable[size];
        for (int i = 0;i < old.length; i++){
            array[i] = old[i];
        }
    }

    public T findMin(){
        if (isEmpty()){
            throw new UnderflowException();
        }
        return array[1];
    }

    private boolean isEmpty() {
        return currentSize == 0;
    }

    public T deleteMin(){
        if (isEmpty()){
            throw new UnderflowException();
        }
        T min = findMin();
        array[1] = array[currentSize--];
        return min;
    }
}
