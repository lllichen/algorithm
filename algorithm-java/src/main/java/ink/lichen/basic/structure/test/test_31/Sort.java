package ink.lichen.basic.structure.test.test_31;

import static ink.lichen.basic.structure.Support.swap;

/**
 * Created by lichen@daojia.com on 2019-1-21.
 */
public class Sort {

    private static final int leftChild(int i){
        return 2*i +1;
    }

    private static<T extends Comparable<? super T>> void heapSort(T[] a){
        for (int i = a.length/2-1; i >=0 ;i--){
            percDown(a,i,a.length);
        }
        for (int i = a.length-1;i > 0; i--){
            swap(a,0,i);
            percDown(a,0,i);
        }
    }

    private static<T extends Comparable<? super T>> void percDown(T[] a, int i, int n) {
        int child;
        T tmp = a[i];
        for (;leftChild(i) < n ; i= child){
            child  = leftChild(i);
            if (child != n-1 && a[child+1].compareTo(a[child])>0){
                child++;
            }
        }
    }
}
