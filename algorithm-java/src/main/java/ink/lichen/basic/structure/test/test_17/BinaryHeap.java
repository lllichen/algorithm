package ink.lichen.basic.structure.test.test_17;

public class BinaryHeap<T extends Comparable<? super T>> {


    private T[] array;

    private int currentSize;

    private static final int DEFAULT_SIZE = 10;

    public BinaryHeap(){
        this(DEFAULT_SIZE);
    }

    public BinaryHeap(int size) {
        currentSize = 0;
        array = (T[]) new Comparable[size];
    }

    public void insert(T t){

    }

    public T findMin(){

        return array[1];
    }

    public T deleteMin(){
        T min  = array[1];
        return min;
    }
}
