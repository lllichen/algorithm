package ink.lichen.basic.structure.test_8;

public class BinaryHeap<T extends Comparable<? super T>> {


    private T[] array;

    private int currentSize;

    private static final int DEFAULT_SIZE = 10;


    BinaryHeap(){
        this(DEFAULT_SIZE);
    }

    public BinaryHeap(int size) {
        currentSize = 0;
        enlargeArray(size);
    }

    private void enlargeArray(int size) {
        if (size <= currentSize){
            return;
        }
        T[] newItems = (T[]) new Comparable[size];
        for (int i = 0 ; i < currentSize; i++){
            newItems[i] = array[i];
        }
        array = newItems;
    }

    private void insert(T t){
        if (currentSize == array.length-1){
            enlargeArray(2*array.length+1);
        }
        int hole = ++currentSize;
        for (array[0] = t; array[hole>>1].compareTo(t)<0 ;hole >>= 1) {

        }
    }
}
