package ink.lichen.basic.structure.test_10;

import ink.lichen.basic.structure.UnderflowException;


public class BinaryHeap<T extends Comparable<? super T>> {

    private T[] array;

    private int currentSize;

    private static final int DEFAULT_CAPACITY = 10;

    public BinaryHeap(){
        this(DEFAULT_CAPACITY);
    }

    public BinaryHeap(int capacity) {
        currentSize = 0;
        array = (T[]) new Comparable[capacity+1];
    }

    public void insert(T a){
        if (currentSize == array.length-1){
            enlargeArray(2*array.length+1);
        }
        int hole = ++currentSize;
        for (array[0] = a;array[hole>>1].compareTo(a)>0; hole >>= 1){
            array[hole] = array[hole>>1];
        }
        array[hole] = a;
    }

    private void enlargeArray(int size) {
        T[] old = array;
        array = (T[]) new Comparable[size];
        for (int i = 0 ; i < old.length;i++){
            array[i] = old[i];
        }
    }
    public T findMin(){
        if (isEmpty()){
            throw new UnderflowException();
        }
        return array[1];
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
        for (;hole<<1 <= currentSize ;hole = child ){
            child = hole<<1;
            if (child !=currentSize && array[child+1].compareTo(array[child])<0 ){
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


    // Test program
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