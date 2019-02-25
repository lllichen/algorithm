package ink.lichen.basic.structure.test.test_37;

import static ink.lichen.basic.structure.Support.swap;

/**
 * Created by lichen@daojia.com on 2019-2-25.
 */
public class Sort {

    private static final int leftChild(int i){
        return 2*i+1;
    }

    private static<T extends Comparable<? super T>>  void heapSort(T[] a){
        for (int i = a.length/2-1; i>= 0;i--){
            percDown(a,i,a.length);
        }
        for (int i = a.length - 1; i > 0; i--){
            swap(a,0,i);
            percDown(a,i,a.length);
        }
    }

    private static void percDown(T[] a, int i, int n) {

    }
}
