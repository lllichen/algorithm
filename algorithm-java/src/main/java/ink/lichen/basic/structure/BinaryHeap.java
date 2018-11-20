package ink.lichen.basic.structure;

/**
 * Created by lichen@daojia.com on 2018-11-20.
 */
public class BinaryHeap<T extends Comparable<? super T>> {

    private static final int DEFAULT_CAPACITY = 10;

    private int currentSize;

    private T [] array;

    public BinaryHeap(){
        currentSize = 0;
        enlargeArray(10);
    }

    public BinaryHeap(T[] items){
        currentSize = items.length;
        array = (T[]) new Comparable[(currentSize+2)*11/10];

        int i = 1;
        for (T item : items)
        {
            array[i++] = item;
        }
        buildHeap();
    }

    private void buildHeap() {
        for (int i = currentSize/2; i >0 ;i--){
            percolateDown(i);
        }
    }


    public void insert(T t){
        if (currentSize == array.length-1){
            enlargeArray(array.length*2 + 1);
        }
        int hole = ++currentSize;
        for (array[0] = t; t.compareTo(array[hole/2]) < 0; hole /= 2){
            array[hole] = array[hole/2];
        }
        array[hole] = t;
    }

    private void  enlargeArray(int newSize){
        if (newSize< currentSize){
            return;
        }
        T[] newItems = (T[]) new Comparable[newSize];
        for (int i = 1 ; i<currentSize;i++){
            newItems[i] = array[i];
        }
        array = newItems;
    }

    public  T deleteMin(){
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
        for (;hole*2 <= currentSize; hole = child){
            child = hole * 2;
            if ( child != currentSize && array[child + 1].compareTo(array[child])<0){
                child++;
            }
            if (array[child].compareTo(tmp) < 0){
                array[hole] = array[child];
            }else
                break;
        }
        array[hole] = tmp;
    }

    private T findMin() {
        return array[1];
    }

    public void makeEmpty(){
        currentSize = 0;
        enlargeArray(DEFAULT_CAPACITY);
    }

    private boolean isEmpty() {
        return currentSize == 0;
    }

    public static void main(String[] args) {
        BinaryHeap binaryHeap = new BinaryHeap();
        binaryHeap.insert(5);
        binaryHeap.insert(3);
        binaryHeap.insert(4);
        binaryHeap.insert(9);
        binaryHeap.insert(1);
        System.out.println(binaryHeap.findMin());
    }
}
