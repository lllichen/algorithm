package ink.lichen.basic.structure;

public class BinaryHeap_1 <T extends Comparable<? super T>> {

    private T [] array;

    private int currentSize;

    private static final int DEFAULT_SIZE = 10;

    public BinaryHeap_1(){
        currentSize = 0;
        enlargeArray(DEFAULT_SIZE);
    }

    public void insert(T item){
       if (currentSize == array.length -1){
           enlargeArray(2*array.length+1);
       }
       int hole = ++currentSize;
       for (array[0] = item; item.compareTo(array[hole/2])<0; hole /= 2){
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

    public T deleteMin(){
        if (isEmpty()){
            throw new UnderflowException();
        }
        T min = array[1];
        array[1] = array[currentSize--];
        perlocateDown(1);
        return min;
    }

    private void perlocateDown(int idx){
        int child;
        T temp = array[idx];
        for (;idx*2 <=currentSize; idx = child){
            child = idx*2;
            if (child !=currentSize && array[child+1].compareTo(array[child])<0){
                child++;
            }
            if (temp.compareTo(array[child])>0){
                array[child] = array[child];
            }else
                break;
        }
        array[idx] = temp;
    }

    private boolean isEmpty() {
        return currentSize == 0;
    }

    private void enlargeArray(int newSize){
        if (newSize <= currentSize){
            return;
        }
        T[] newItems = (T[]) new Comparable[newSize];
        for (int i = 0 ; i < currentSize; i++){
            newItems[i] = array[i];
        }
        array = newItems;
    }
}
