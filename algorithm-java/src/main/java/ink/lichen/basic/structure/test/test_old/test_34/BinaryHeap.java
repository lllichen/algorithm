package ink.lichen.basic.structure.test.test_old.test_34;

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
        array[1] = array[currentSize--];
        percolateDown(1);
        return min;
    }

    private void percolateDown(int hole) {
        int child;
        T tmp = array[hole];
        for (;hole << 1 <= currentSize; hole = child){
            child = hole << 1;
            if (child != currentSize && array[child+1].compareTo(array[child])<0){
                child++;
            }
            if (array[child].compareTo(tmp)<0){
                array[hole] = array[child];
            }else {
                break;
            }
        }
        array[hole] = tmp;
    }

    public static void main( String [ ] args )
    {
        int numItems = 10000;
        BinaryHeap<Integer> h = new BinaryHeap<>( );
        int i = 37;

        for( i = 37; i != 0; i = ( i + 37 ) % numItems )
            h.insert( i );
        for( i = 1; i < numItems; i++ )
            if( h.deleteMin( ) != i )
                System.out.println( "Oops! " + i );
    }


}
