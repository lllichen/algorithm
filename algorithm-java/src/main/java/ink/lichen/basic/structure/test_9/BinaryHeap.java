package ink.lichen.basic.structure.test_9;

import ink.lichen.basic.structure.UnderflowException;

public class BinaryHeap <T extends Comparable<? super T>> {

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
        if (currentSize == array.length -1){
            enlargeArray(2*array.length+1);
        }
        int hole = ++currentSize;
        array[0] = t;
        for (; array[hole>>1].compareTo(t) > 0; hole >>= 1 ){
            array[hole] = array[hole>>1];
        }
        array[hole] = t;
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
        percolateDown(1);
        return min;
    }

    private void percolateDown(int hole) {
        int child;
        T tmp;
        for (tmp = array[hole]; hole<<1 <=currentSize ; hole = child){
                child = hole <<1;
                if (child != currentSize&& array[child].compareTo(array[child+1])>0){
                    child++;
                }
                if (array[child].compareTo(tmp)<0){
                    array[hole] = array[child];
                }else
                    break;
        }
        array[hole] = tmp;
    }

    private void buildHeap( )
    {
        for( int i = currentSize / 2; i > 0; i-- )
            percolateDown( i );
    }

    private void enlargeArray(int size) {
        if (size <= currentSize){
            return;
        }
        T[] newItems = (T[]) new Comparable[size];
        for (int i =1; i < array.length;i++){
            newItems[i] = array[i];
        }
        array = newItems;
    }

    public BinaryHeap( T [ ] items )
    {
        currentSize = items.length;
        array = (T[]) new Comparable[ ( currentSize + 2 ) * 11 / 10 ];

        int i = 1;
        for( T item : items )
            array[ i++ ] = item;
        buildHeap( );
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
