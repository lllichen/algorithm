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
        T min = array[1];
        array[1] = array[currentSize--];
        percolateDown(1);
        return min;
    }

    private void percolateDown(int hole) {
        int child;
        T tmp = array[hole];
        for (;hole <= currentSize; hole = child ){
            child = 2* hole;
            if (child < currentSize&& array[child+1].compareTo(array[child]) < 0 ){
                child++;
            }
            if (tmp.compareTo(array[child]) > 0){
                array[hole] = array[child];
            }else
                break;
        }
        array[hole] = tmp;
    }

    private void decreaseKey(int hole,T val){

    }

    private void increaseKey(int hole,T val){

    }

    private T delete(int hole){
        T min = (T) new Object();
        T ret = array[hole];
        decreaseKey(hole, min );
        deleteMin();
        return ret;
    }

    private void enlargeArray(int size) {
        if (size <= currentSize){
            return;
        }
        T[] newItems = (T[]) new Comparable[size];
        for (int i = 1 ; i <= currentSize; i++){
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
        System.out.println(t.deleteMin());
//        System.out.println(t.findMin());
        System.out.println(t.deleteMin());
//        System.out.println(t.findMin());
        System.out.println(t.deleteMin());
        System.out.println(t.deleteMin());
//        System.out.println(t.findMin());
    }
}
