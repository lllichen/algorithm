package ink.lichen.basic.structure.test.test_40;

import static ink.lichen.basic.structure.Support.swap;

/**
 * Created by lichen@daojia.com on 2019-3-7.
 */
public class Sort {


    private static final int leftChild(int i){
        return 2*i+1;
    }

    private static <T extends Comparable<? super T>> void heapSort(T[] a){
        for (int i = a.length/2-1 ; i >=0; i--){
            percDown(a,i,a.length);
        }
        for (int i = a.length-1; i >= 0; i--){
            swap(a,0,i);
            percDown(a,0,i);
        }
    }

    private static <T extends Comparable<? super T>> void percDown(T[] a, int i, int n) {
        int child;
        T tmp = a[i];
        for ( ;leftChild(i) < n; i= child){
            child = leftChild(i);
            if (child != n-1 && a[child+1].compareTo(a[child])>0){
                child++;
            }
            if (a[child].compareTo(tmp)>0){
                a[i] = a[child];
            }else {
                break;
            }
        }
        a[i] = tmp;
    }

    private static <T extends Comparable<? super T>> void mergeSort(T[] a){
        T[] arr = (T[]) new Comparable[a.length];
        mergeSort(a,arr,0,a.length-1);
    };

    private static <T extends Comparable<? super T>> void mergeSort(T[] a,T[] arr ,int left, int right){
        if (left < right){
            int center = (left+right)>>1;
            mergeSort(a,arr,left,center);
            mergeSort(a,arr,center+1,right);
            merge(a,arr,left,center+1,right);
        }
    }

    private static <T extends Comparable<? super T>> void merge(T[] a, T[] arr, int leftPos, int rightPos, int rightEnd) {
        int temPos = leftPos;
        int leftEnd = rightPos - 1;
        int numElements = rightEnd - leftPos + 1;
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

        for (int i = 0 ; i < numElements; i++,rightEnd--){
            a[rightEnd] = arr[rightEnd];
        }
    }



//    private static <T extends Comparable<? super T>> void heapSort(){};
//    private static <T extends Comparable<? super T>> void heapSort(){};
//    private static <T extends Comparable<? super T>> void heapSort(){};
//    private static <T extends Comparable<? super T>> void heapSort(){};






}
