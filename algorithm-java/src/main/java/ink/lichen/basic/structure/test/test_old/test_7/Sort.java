package ink.lichen.basic.structure.test.test_old.test_7;

import static ink.lichen.basic.structure.Support.CUT_OFF;
import static ink.lichen.basic.structure.Support.print;
import static ink.lichen.basic.structure.Support.swap;

public class Sort {


    public static <T extends Comparable<? super T>> void heapSort(T[] a) {
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            percDown(a, i, a.length);
        }
        for (int i = a.length - 1; i >= 0; i--) {
            swap(a, 0, i);
            percDown(a, 0, i);
        }
    }

    private static final int leftChild(int i) {
        return 2 * i + 1;
    }

    private static <T extends Comparable<? super T>> void percDown(T[] a, int i, int n) {
        int child;
        T t;
        for (t = a[i]; leftChild(i) < n; i = child) {
            child = leftChild(i);
            if (child != n - 1 && a[child].compareTo(a[child + 1]) < 0) {
                child++;
            }
            if (a[child].compareTo(t) > 0) {
                a[i] = a[child];
            } else
                break;
        }
        a[i] = t;
    }

    private static <T extends Comparable<? super T>> void insertionSort(T[] a, int left, int right) {

        for (int i = left + 1; i <= right; i++) {
            T tmp = a[i];
            int j;
            for (j = i; j > left && tmp.compareTo(a[j - 1]) < 0; j--) {
                a[j] = a[j - 1];
            }
            a[j] = tmp;
        }
    }

    private static <T extends Comparable<? super T>> void mergeSort(T[] a){
        T[] tmpArr = (T[]) new Comparable[a.length];

        mergeSort(a,tmpArr,0,a.length-1);
    }

    private static<T extends Comparable<? super T>> void mergeSort(T[] a, T[] tmpArr, int left, int right) {
        if (left < right){
            int center = (left + right) >> 1;
            mergeSort(a,tmpArr,left,center);
            mergeSort(a,tmpArr,center+1,right);
            merge(a,tmpArr,left,center+1,right);
        }

    }

    private static<T extends Comparable<? super T>> void merge(T[] a, T[] tmpArr, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos -1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;
        while (leftPos <= leftEnd && rightPos <= rightEnd ){
            if (a[leftPos].compareTo(a[rightPos]) < 0 ){
                tmpArr[tmpPos++] = a[leftPos++];
            }else
                tmpArr[tmpPos++] = a[rightPos++];
        }

        while ( rightPos <= rightEnd ){
            tmpArr[tmpPos++] = a[rightPos++];
        }

        while (leftPos <= leftEnd  ){
            tmpArr[tmpPos++] = a[leftPos++];

        }
        for (int i = 0 ; i < numElements; i ++ ,rightEnd--){
            a[rightEnd] = tmpArr[rightEnd];
        }
    }


    private static <T extends Comparable<? super T>> void quickSort(T[] a){
        quickSort(a,0,a.length-1);
    }

    private static <T extends Comparable<? super T>> void quickSort(T[] a, int left, int right) {
        if (left + CUT_OFF <= right){
            T pivot =median3(a,left,right);
            int i = left,j = right-1;
            for (;;){
                while (a[++i].compareTo(pivot) < 0){};
                while (a[--j].compareTo(pivot) > 0){};
                if (i < j)
                    swap(a,i,j);
                else
                    break;
            }
            swap(a,i,right-1);
            quickSort(a,left,i-1);
            quickSort(a,i+1,right);
        }else
            insertionSort(a,left,right);

    }

    private static <T extends Comparable<? super T>> T median3(T[] a, int left, int right) {
        int center = (left + right) >> 1;
        if (a[center].compareTo(a[left]) < 0)
            swap(a,center,left);
        if (a[right].compareTo(a[left]) < 0)
            swap(a,right,left);
        if (a[right].compareTo(a[center]) < 0)
            swap(a,center,right);
        swap(a,center,right-1);
        return a[right-1];
    }


    public static void main(String[] args) {
        Integer a[] = new Integer[]{4, 31, 6, 88, 12, 4, 3, 12, 77, 8, 9, 15, 4, 5, 6, 99, 0, 1000};
        //n*log(n)
//        heapSort(a);
//        insertionSort(a,0,a.length-1);
//        mergeSort(a);
        quickSort(a);
        print(a);
    }
}
