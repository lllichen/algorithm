package ink.lichen.basic.structure.test.test_old.test_30;

import static ink.lichen.basic.structure.Support.CUT_OFF;
import static ink.lichen.basic.structure.Support.print;
import static ink.lichen.basic.structure.Support.swap;

/**
 * Created by lichen@daojia.com on 2019-1-17.
 */
public class Sort {


    private static final int leftChild(int i){
        return 2*i+1;
    }

    private static<T extends Comparable<? super T>> void heapSort(T[] a){
        for (int i = a.length/2-1; i>= 0 ; i--){
            percDown(a,i,a.length);
        }
        for (int i = a.length-1;i > 0 ; i--){
            swap(a,0,i);
            percDown(a,0,i);
        }
    }

    private static<T extends Comparable<? super T>> void percDown(T[] a, int i, int n) {
        int child;
        T tmp = a[i];
        for (;leftChild(i) < n ; i = child){
            child = leftChild(i);
            if ( child != n-1 && a[child+1].compareTo(a[child])>0) {
                child++;
            }
            if (a[child].compareTo(tmp)>0){
                a[i] = a[child] ;
            }else
                break;
        }
        a[i] = tmp;
    }

    private static < T extends Comparable<? super T>> void mergeSort(T[] a){
        T [] arr = (T[]) new Comparable[a.length];
        mergeSort(a,arr,0,a.length-1);
    }

    private static < T extends Comparable<? super T>> void mergeSort(T[] a,T[] arr, int left,int right){
        if (left < right){
            int center = (left+right)>>1;
            mergeSort(a,arr,left,center);
            mergeSort(a,arr,center+1,right);
            merge(a,arr,left,center+1,right);
        }
    }

    private static < T extends Comparable<? super T>> void merge(T[] a,T[] arr, int leftPos,int rightPos,int rightEnd){
        int temPos = leftPos;
        int numElement = rightEnd - leftPos + 1;
        int leftEnd = rightPos - 1;

        while (leftPos <= leftEnd && rightPos <= rightEnd){
            if (a[leftPos].compareTo(a[rightPos])<0){
                arr[temPos++] = a[leftPos++];
            }else {
                arr[temPos++] = a[rightPos++];
            }
        }

        while (leftPos <= leftEnd ){
            arr[temPos++] = a[leftPos++];
        }

        while (rightPos <= rightEnd){
                arr[temPos++] = a[rightPos++];
        }
        for (int i = 0 ; i < numElement; i++,rightEnd--){
            a[rightEnd] = arr[rightEnd];
        }

    }

    private static < T extends Comparable<? super T>> void quickSort(T[] a){
        quickSort(a,0,a.length-1);
    }

    private static < T extends Comparable<? super T>> void quickSort(T[] a,int left,int right){
        if (left + CUT_OFF <= right){
            T pivot = median3(a,left,right);
            int i = 0 , j = right-1;
            for (;;){
                while (a[++i].compareTo(pivot)<0){};
                while (a[--j].compareTo(pivot)>0){};
                if (i < j){
                    swap(a,i,j);
                }else
                    break;
            }
            swap(a,i,right-1);
            quickSort(a,left,i-1);
            quickSort(a,i+1,right);
        }else {
            insertionSort(a,left,right);
        }
    }

    private static <T extends Comparable<? super T>> T median3(T[] a, int left, int right) {
        int center= (left + right) >> 1;
        if (a[center].compareTo(a[left])<0){
            swap(a,center,left);
        }
        if (a[right].compareTo(a[left])<0){
            swap(a,right,left);
        }
        if (a[right].compareTo(a[center])<0){
            swap(a,center,right);
        }
        swap(a,center,right-1);
        return a[right-1];
    }

    private static < T extends Comparable<? super T>> void insertionSort(T[] a,int left,int right){
        for (int i = left ; i <= right; i++){
            T tmp = a[i];
            int j;
            for ( j = i ; j > left && tmp.compareTo(a[j-1])<0;j --){
                a[j] = a[j-1];
            }
            a[j] = tmp;
        }
    }

    public static void main(String[] args) {
        Integer a[] = new Integer[]{4, 31, 6, 88, 12, 4, 3, 12, 77, 8, 9, 15, 4, 5, 6, 99, 0, 1000};
        //n*log(n)
//        heapSort(a);
        insertionSort(a,0,a.length-1);
//        mergeSort(a);
//        quickSort(a);
        print(a);
    }
}
