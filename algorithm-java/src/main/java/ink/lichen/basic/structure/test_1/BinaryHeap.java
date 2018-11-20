package ink.lichen.basic.structure.test_1;

import ink.lichen.basic.structure.UnderflowException;

public class BinaryHeap <T extends Comparable< ? super T> >{




    private T[] array;

    private static final int DEFAULT_SIZE = 10;

    private int currentSize;

    public BinaryHeap(){
        makeEmpty();
    }

    public void insert(T item) {
        if (currentSize == array.length-1){
            enlargeArray(2*array.length+1);
        }
        int hole = ++currentSize;
        for (array[0] = item;item.compareTo(array[hole/2]) < 0;hole/=2){
            array[hole] = array[hole/2];
        }
        array[hole] = item;

    }

    public T findMin(){
        if (isEmpty()){
            throw new UnderflowException();
        }
        return array[1];
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public void makeEmpty() {
        currentSize = 0;
        enlargeArray(DEFAULT_SIZE);
    }

    public T deleteMin(){
        if (isEmpty()){
            throw new UnderflowException();
        }
        for (int i = 0 ; i < )
    }

    private void enlargeArray(int size) {
        if (size <= currentSize){
            return;
        }
        T[] newItems = (T[]) new Object[size];
        for (int i = 1 ; i <= currentSize; i++){
            newItems[i] = array[i];
        }
        array = newItems;
    }

}
