package ink.lichen.basic.structure.test.test_17;

import static ink.lichen.basic.structure.Support.print;

public class Sort {


    private static <T extends Comparable<? super T>> void heapSort(T[] a){

    }

    private static <T extends Comparable<? super T>> void heapSort(T[] a,int i, int n){

    }


    private static <T extends Comparable<? super T>> void quickSort(T[] a){

    }

    private static <T extends Comparable<? super T>> void quickSort(T[] a, int left, int right){

    }

    private static <T extends Comparable<? super T>> void insertionSort(T[] a, int left, int right){

    }

    private static <T extends Comparable<? super T>> void mergeSort(T[] a){

    }

    private static <T extends Comparable<? super T>> void mergeSort(T[] a,int left, int right){

    }

    public static void main(String[] args) {
        Integer a[] = new Integer[]{4, 31, 6, 88, 12, 4, 3, 12, 77, 8, 9, 15, 4, 5, 6, 99, 0, 1000};
        //n*log(n)
//        heapSort(a);
//        insertionSort(a,0,a.length-1);
//        mergeSort(a);
//        quickSort(a);
        print(a);
    }

}
