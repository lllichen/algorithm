package ink.lichen.basic.structure.test.test_old.test_5;

import ink.lichen.basic.structure.UnderflowException;

public class BinaryHeap<T extends Comparable<? super T>> {

    private T[] array;

    private int currentSize;

    private static final int DEFAULT_SIZE = 10;

    public BinaryHeap() {
        this(DEFAULT_SIZE);
    }

    public BinaryHeap(int size) {
        currentSize = 0;
        enlargeArray(size);
    }

    public void insert(T t){
        if (currentSize == array.length-1){
            enlargeArray(2*array.length+1);
        }
        int hole = ++currentSize;
        for (array[0] = t;t.compareTo(array[hole>>1])<0;hole >>=1 ){
            array[hole] =array[hole>>1];
        }
        array[hole] = t;
    }

    public T findMin(){
        if (isEmpty()){
            throw  new UnderflowException();
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
        int child ;
        T tmp =array[hole];
        for ( ;hole<<1 <=currentSize ; hole = child){
             child = hole<<1;
             if (child != currentSize && array[child].compareTo(array[child+1]) > 0 ){
                child++;
             }
             if ( tmp.compareTo(array[child])>0 ){
                 array[hole] = array[child];
             }else
                 break;
        }
        array[hole] = tmp;
    }

    private boolean isEmpty() {
        return currentSize == 0;
    }

    private void enlargeArray(int size) {
        if (size <= currentSize){
            return;
        }
        T[] newItems = (T[]) new Comparable[size];
        for (int i = 1 ; i <= currentSize;i++){
            newItems[i] = array[i];
        }
        array = newItems;
    }

    public static void main(String[] args) {
        BinaryHeap t = new BinaryHeap();
        t.insert(2);
        t.insert(1);
        t.insert(3);
        t.insert(4);
        t.insert(1);

        System.out.println(t.findMin());

        System.out.println(t.deleteMin());
//
        System.out.println(t.deleteMin());
//        System.out.println(t.findMin());
        System.out.println(t.deleteMin());
        System.out.println(t.deleteMin());
        System.out.println(t.findMin());
    }
}
