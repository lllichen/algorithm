package ink.lichen.basic.structure.test.test_23;

import static ink.lichen.basic.structure.Support.swap;

/**
 * Created by lichen@daojia.com on 2018-12-24.
 */
public class Sort {

    private static <T extends Comparable<? super T>> void heapSort(T[] a){
        for (int i = a.length/2-1;i >= 0 ;i--){
            percDown(a,i,a.length);
        }
        for (int i = a.length-1;i >0 ;i--){
            swap(a,0,i);
            percDown(a,0,i);
        }
    }

    private static <T extends Comparable<? super T>>  void percDown(T[] a, int i, int n) {

    }

    private static final int leftChild(int i){
        return 2*i+1;
    }

    private static <T extends Comparable<? super T>> void mergeSort(T[] a){

    }
    private static <T extends Comparable<? super T>> void mergeSort(T[] a,T[] arr,int left,int right){

    }

    private static <T extends Comparable<? super T>> void quickSort(T[] a){

    }
    private static <T extends Comparable<? super T>> void quickSort(T[] a,int left, int right){

    }

    private static <T extends Comparable<? super T>> void insertionSort(T[] a){

    }

}
