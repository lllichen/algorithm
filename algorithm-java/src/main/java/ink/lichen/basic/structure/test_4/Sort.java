package ink.lichen.basic.structure.test_4;

import static ink.lichen.basic.structure.Support.print;
import static ink.lichen.basic.structure.Support.swap;

public class Sort {

    private static final int leftChild(int i) {
        return 2 * i + 1;
    }

    
    
    private static <T extends Comparable<? super T>> void heapSort(T[] a){
        for (int i = a.length>>2 -1; i >= 0; i--) {
            percDown(a,i,a.length);
        }
        for (int i = a.length -1; i >=0 ;i--) {
            swap(a,0,i);
            percDown(a,0,i);
        }
    }

    private static <T extends Comparable<? super T>> void percDown(T[] a, int i, int n) {
        int child ;
        T tmp;
        for (tmp = a[i];leftChild(i) < n; i = child ) {
            child = leftChild(i);
            if (child != n-1 && a[child+1].compareTo(a[child]) > 0 ){
                child++;
            }
            if (a[child].compareTo(tmp)>0) {
                a[i] = a[child];
            }else
                break;
        }
        a[i] = tmp;
    }


    public static <T extends Comparable< ? super T>> void mergeSort(T[] a){
        T [] tempArray = (T[]) new Comparable[a.length];
        mergeSort(a,tempArray,0,a.length-1);
    }

    private static <T extends Comparable <? super T>> void mergeSort(T[] a, T[] tempArray, int left, int rigth) {
        if (left < rigth){
            int center = (left+rigth)>>1;
            mergeSort(a,tempArray,left,center);
            mergeSort(a,tempArray,center+1,rigth);
            merge(a,tempArray,left,center+1,rigth);
        }
    }

    private static <T extends Comparable <? super T>> void merge(T[] a, T[] tempArray, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos -1;
        int tempPos = leftPos;
        int numElements = rightEnd - leftPos +1;
        while (leftPos <= leftEnd && rightPos <= rightEnd){
            if (a[leftPos].compareTo(a[rightPos])<0){
                tempArray[tempPos++] = a[leftPos++];
            }else {
                tempArray[tempPos++] = a[rightPos++];
            }
        }

        while (leftPos <= leftEnd ){
            tempArray[tempPos++] = a[leftPos++];
        }

        while (rightPos <= rightEnd){
            tempArray[tempPos++] = a[rightPos++];
        }

        for (int i = 0 ; i< numElements; i++,rightEnd--){
            a[rightEnd] = tempArray[rightEnd];
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
