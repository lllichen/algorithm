package ink.lichen.basic.structure.test_3;

import static ink.lichen.basic.structure.Support.print;

/**
 * Created by lichen@daojia.com on 2018-11-22.
 */
public class Sort {

    private static final int leftChild(int i){
        return 2*i+1;
    }

    private static <T extends Comparable<? super T>> void percDowm(T[] a,int hole,int n){
        int child;
        T tmp ;
        for (tmp = a[hole];leftChild(hole) < n;hole=child){
            child = leftChild(hole);
            if (child != n-1 && a[child].compareTo(a[child+1])<0){
                child++;
            }
            if (a[child].compareTo(tmp)>0){
                a[hole]  = a[child];
            }else
                break;
        }
        a[hole] = tmp;
    }

    private static<T extends Comparable<? super T>> void swap(T[] a,int i,int j){
        T tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static <T extends Comparable<? super T>> void heapSort(T[] a){

        for (int i = (a.length>>1) -1; i >= 0;i--){
            percDowm(a,i,a.length);
        }
        for (int i = a.length-1;i>=0;i-- ){
            swap(a,0,i);
            percDowm(a,0,i);
        }
    }


    public static <T extends Comparable< ? super T>> void mergeSort(T[] a){
        T [] temp = (T[]) new Comparable[a.length];
        mergeSort(a,temp,0,a.length-1);
    }

    private static <T extends Comparable<? super T>> void mergeSort(T[] a, T[] temp, int left, int right) {
        if (left < right){
            int center = (left+right)>>1;
            mergeSort(a,temp,left,center);
            mergeSort(a,temp,center+1,right);
            merge(a,temp,left,center,right);
        }
    }

    private static<T extends Comparable<? super T>> void merge(T[] a, T[] temp, int leftPos, int leftEnd, int rightEnd) {
        int rightPos = leftEnd+1;
        int tempPos = leftPos;
        int numElements = rightEnd - leftPos+1;
        while (leftPos <= leftEnd && rightPos <= rightEnd)
        {
            if (a[leftPos].compareTo(a[rightPos]) <= 0){
                temp[tempPos++] = a[leftPos++];
            }else {
                temp[tempPos++] = a[rightPos++];
            }
        }
        while (leftPos <= leftEnd){
            temp[tempPos++] = a[leftPos++];
        }
        while (rightPos <= rightEnd){
            temp[tempPos++] = a[rightPos++];
        }

        for (int i = 0 ; i < numElements; i++, rightEnd--){
           a[rightEnd] = temp[rightEnd];
        }
    }

    private static final int CUT_OFF = 10;

    public static <T extends Comparable<? super T>> void quickSort(T[] a){
        quickSort(a,0,a.length-1);
    }

    
    
    private static<T extends Comparable<? super T>> void quickSort(T[] a, int left, int right) {
        if (left+CUT_OFF <= right){
            T pivot = median3(a,left,right);
            int i = left,j= right-1;
            for (;;){
                if(a[++i].compareTo(pivot) <0){};
                if (a[--j].compareTo(pivot)>0){};
                if (i<j){
                    swap(a,i,j);
                }else {
                    break;
                }
            }
            swap(a,i,right-1);
            quickSort(a,left,i-1);
            quickSort(a,i+1,right);

        }else {
            insertionSort(a,left,right);
        }
    }

    private static <T extends Comparable<? super T>> T median3(T[] a, int left, int right) {
        int center = (right+left)>>1;
        if (a[center].compareTo(a[left]) < 0){
            swap(a,center,left);
        }
        if (a[right].compareTo(a[left]) <0){
            swap(a,right,left);
        }
        if (a[right].compareTo(a[center]) <0){
            swap(a,center,right);
        }
        swap(a,center,right-1);
        return a[right-1];
    }

    private static<T extends Comparable<? super T>> void insertionSort(T[] a, int left, int right) {

    }


    public static void main(String[] args) {
        Integer a[] = new Integer[] {4,31,6,88,12,4,3,12,77,8,9,15,4,5,6};
        //n*log(n)
//        heapSort(a);
//        insertionSort(a,0,a.length-1);
        mergeSort(a);
//        quickSort(a);
        print(a);
    }
}
