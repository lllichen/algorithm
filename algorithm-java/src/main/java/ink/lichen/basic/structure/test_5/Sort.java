package ink.lichen.basic.structure.test_5;

import static ink.lichen.basic.structure.Support.print;
import static ink.lichen.basic.structure.Support.swap;

public class Sort {



    public static <T extends Comparable<? super T>> void heapSort(T[] a){

        for (int i = a.length/2-1 ; i>= 0; i--){
            percDown(a,i,a.length);
        }
        for (int i = a.length-1;i >=0 ; i--){
            swap(a,0,i);
            percDown(a,0,i);
        }
    }

    private static final int leftChild(int i){
        return 2*i+1;
    }

    private static<T extends Comparable<? super T>> void percDown(T[] a, int i, int n) {
        int child ;
        T tmp ;
        for (tmp = a[i]; leftChild(i) < n; i = child ){
            child = leftChild(i);
            if (child != n-1 && a[child].compareTo(a[child+1])<0){
                child++;
            }
            if (tmp.compareTo(a[child]) < 0){
                a[i] = a[child];
            }else {
                break;
            }
        }
        a[i] = tmp;
    }

    private static <T extends Comparable<? super T>> void insertionSort(T[] a,int left, int right){

        for (int i = left+1 ; i <= right; i++){
            int j;
            T tmp = a[i];
            for (j = i; j >left && tmp.compareTo(a[j-1])< 0; j--){
                a[j] = a[j-1];
            }
            a[j] = tmp;
        }
    }


    private static <T extends Comparable<? super T>> void  mergeSort(T[] a){
       T [] tmp = (T[]) new Comparable[a.length];
       mergeSort(a,tmp,0,a.length-1);
    }

    private static <T extends Comparable<? super T>> void mergeSort(T[] a, T[] tmp, int left, int right) {
        if (left < right){
            int center = (left+right)>>1;
            mergeSort(a,tmp,left,center);
            mergeSort(a,tmp,center+1,right);
            merge(a,tmp,left,center+1,right);
        }

    }

    private static<T extends Comparable<? super T>>  void merge(T[] a, T[] tmp, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos -1;
        int temPos = leftPos;
        int numsElements = rightEnd - leftPos+1;
        while (leftPos <= leftEnd && rightPos <= rightEnd){
            if (a[leftPos].compareTo(a[rightPos])<0 ){
                tmp[temPos++] = a[leftPos++];
            }else {
                tmp[temPos++] = a[rightPos++];
            }
        }

        while (leftPos <= leftEnd ){
            tmp[temPos++] = a[leftPos++];
        }

        while (rightPos <= rightEnd){
            tmp[temPos++] = a[rightPos++];
        }
        for (int i = 0 ; i < numsElements; i++ ,rightEnd--){
            a[rightEnd] = tmp[rightEnd];
        }
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
