package ink.lichen.basic.structure.test_4;

import static ink.lichen.basic.structure.Support.print;

public class Sort {

    private static final int


    private static <T extends Comparable<? super T>> void heapSort(T[] a){
        for (int i = a.length/2 -1; i >= 0; i--) {
            percDown(a,i,a.length);
        }
    }

    public static void main(String[] args) {
        Integer a[] = new Integer[] {4,31,6,88,12,4,3,12,77,8,9,15,4,5,6};
        //n*log(n)
        heapSort(a);
//        insertionSort(a,0,a.length-1);
//        mergeSort(a);
//        quickSort(a);
        print(a);
    }
}
}
