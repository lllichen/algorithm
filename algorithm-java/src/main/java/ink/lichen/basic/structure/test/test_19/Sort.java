package ink.lichen.basic.structure.test.test_19;

/**
 * Created by lichen@daojia.com on 2018-12-19.
 */
public class Sort {

    public static final int leftChild(int i){
        return (i<<1) +1;
    }

    public static <T extends Comparable<? super T>> void heapSort(T[] a){

    }

    public static <T extends Comparable<? super T>> void quickSort(T[] a){

    }

    public static <T extends Comparable<? super T>> void mergeSort(T[] a){
        T[] arr = (T[]) new Comparable[a.length];
        mergeSort(a,arr,0,a.length-1);
    }


    public static <T extends Comparable<? super T>> void mergeSort(T[] a,T[] arr,int left,int right){
        if (left < right){
            int center = (left+right)>>1;
            mergeSort(a,arr,left,center);
            mergeSort(a,arr,center+1,right);
            merge(a,arr,left,center+1,right);
        }
    }

    public static <T extends Comparable<? super T>> void merge(T[] a,T[] arr,int leftPos,int rightPos,int rightEnd){
        int temPos = leftPos;
        int leftEnd = rightPos -1;
        int numElements = rightEnd - leftPos +1;
        while (leftPos <= leftEnd && rightPos <= rightEnd){
            if (a[leftPos].compareTo(a[rightPos])<0){
                arr[temPos++] = a[leftPos++];
            }else
                arr[temPos++] = a[rightPos++];
        }

        while (leftPos <= leftEnd ){
                arr[temPos++] = a[leftPos++];
        }

        while (rightPos <= rightEnd){
                arr[temPos++] = a[rightPos++];
        }
        for (int i = 0; i < numElements; i++ ,rightEnd--){
            a[rightEnd] = arr[rightEnd];
        }
    }

    public static <T extends Comparable<? super T>> void insertionSort(T[] a){

    }
}
