package ink.lichen.basic.structure;

/**
 * Created by lichen@daojia.com on 2018-11-20.
 */
public class BinaryHeap<T extends Comparable<? super T>> {

    private static final int DEFAULT_CAPACITY = 16;

    private int currentSize;

    private T [] array;

    public BinaryHeap(){

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

    private boolean isEmpty() {
        return currentSize == 0;
    }


}
