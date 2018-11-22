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
        System.out.println(n);
        for (tmp = a[hole];leftChild(hole)<= n;hole=child){
            child = leftChild(hole);
            if (child != n && a[child].compareTo(a[child+1])<0){
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
            percDowm(a,i,a.length-1);
        }
        for (int i = a.length-1;i>=0;i-- ){
            swap(a,0,i);
            percDowm(a,0,i-1);
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
