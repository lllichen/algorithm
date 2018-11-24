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
