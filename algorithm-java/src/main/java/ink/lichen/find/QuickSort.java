package ink.lichen.find;

/**
 * Created by lichen@daojia.com on 2018-11-8.
 */
public class QuickSort {


    public static <T extends Comparable<? super T>> void quicksort(T[] a){
        int n = a.length,lo = 0,hi = n-1;
        quicksort(a,lo,hi);
    }

    private static  <T extends Comparable<? super T>> void quicksort(T[] a,int lo,int hi){

    }

    private static <T extends Comparable<? super  T>> T median3(T[] a, int left,int right){

        int center = (left + right) / 2;
        if (a[center].compareTo(a[left]) < 0){
//            swapReference();
        }

        return a[0];
    }

//    private void swapReference
}
