package ink.lichen.find;

/**
 * Created by lichen@daojia.com on 2018-11-8.
 */
public class QuickSort {


    public static <T extends Comparable<? super T>> void quicksort(T[] a){
        int n = a.length,lo = 0,hi = n-1;
        quicksort(a,lo,hi);
    }

    private static final int CUTOFF = 10;

    private static  <T extends Comparable<? super T>> void quicksort(T[] a,int left,int right){
        if (left + CUTOFF  <= right){
            T pivot = median3(a,left,right);
            int i = left,j = right-1;
            for (;;){
                while (a[++i].compareTo(pivot)<0){};
                while (a[--j].compareTo(pivot)>0){};
                if (i < j){
                    swapReference(a,i,j);
                }else
                    break;
            }
            swapReference(a,i,right-1);

            quicksort(a,left,right-1);
            quicksort(a,i+1,right);
        }else {
            insertionSort(a,left,right);

        }

    }

    private static <T extends Comparable<? super  T>> T median3(T[] a, int left,int right){

        int center = (left + right) / 2;
        if (a[center].compareTo(a[left]) < 0){
            swapReference(a,left,center);
        }
        if (a[right].compareTo(a[left]) < 0){
            swapReference(a,left,right);
        }
        if (a[right].compareTo(a[center]) < 0){
            swapReference(a,center,right);
        }
        swapReference(a,left,right-1);
        return a[right-1];
    }

    private static final <T>void swapReference (T[] a, int left,int right){
        T tmp =  a[left];
        a[left] = a[right];
        a[right] = tmp;
    }

    public static <T extends Comparable< ? super T>> void insertionSort(T[] a,int left,int right){
        int j;
        for (int p = left;p < right; p++){
            T tmp = a[p];
            for ( j=p ; j >0 && tmp.compareTo(a[j-1]) < 0;j--){
                a[j] = a[j-1];
            }
            a[j] = tmp;
        }
    }
}
