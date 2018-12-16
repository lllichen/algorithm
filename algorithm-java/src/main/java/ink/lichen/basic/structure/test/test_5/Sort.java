package ink.lichen.basic.structure.test.test_5;

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

    private static <T extends Comparable<? super T>> void  quickSort(T[] a){
        quickSort(a,0,a.length-1);
    }

    private static final int CUT_OFF = 10;

    private static<T extends Comparable<? super T>>  void quickSort(T[] a, int left, int rigth) {
        if (left + CUT_OFF <= rigth){
            T pivot = median3(a,left,rigth);
            int i = left,j = rigth-1;
            for (;;){
                while (a[++i].compareTo(pivot) < 0){};
                while (a[--j].compareTo(pivot) > 0){};
                if (i < j){
                    swap(a,i,j);
                }else
                    break;
            }
            swap(a,i,rigth-1);
            quickSort(a,left,i-1);
            quickSort(a,i+1,rigth);
        }else
            insertionSort(a,left,rigth);

    }

    private static <T extends Comparable<? super T>> T median3(T[] a, int left, int rigth) {
        int center = (left + rigth) >> 1;
        if (a[center].compareTo(a[left])<0){
            swap(a,left,center);
        }
        if (a[rigth].compareTo(a[left])<0){
            swap(a,rigth,left);
        }
        if (a[rigth].compareTo(a[center]) <0){
            swap(a,rigth,center);
        }
        swap(a,center,rigth-1);
        return a[rigth-1];
    }


    public static void main(String[] args) {
        Integer a[] = new Integer[] {4,31,6,88,12,4,3,12,77,8,9,15,4,5,6};
        //n*log(n)
//        heapSort(a);
//        insertionSort(a,0,a.length-1);
//        mergeSort(a);
        quickSort(a);
        print(a);
    }
}
