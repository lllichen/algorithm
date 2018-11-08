package ink.lichen.find;

/**
 * Created by lichen@daojia.com on 2018-11-8.
 */
public class QuickSort {


    public static <T extends Comparable<? super T>> void quicksort(T[] a){
        int n = a.length,lo = 0,hi = n-1;
        quicksort(a,lo,hi);
    }

    public static  <T extends Comparable<? super T>> void quicksort(T[] a,int lo,int hi){

    }
}
