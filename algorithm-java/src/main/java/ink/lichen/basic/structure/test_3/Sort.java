package ink.lichen.basic.structure.test_3;

/**
 * Created by lichen@daojia.com on 2018-11-22.
 */
public class Sort {

    private static final int leftChild(int i){
        return 2*i+1;
    }

    private static <T extends Comparable<? super T>> void percDowm(T[] a,int hole,int right){

    }

    public static <T extends Comparable<? super T>> void heapSort(T[] a){
        int i = (a.length+1) >> 1;
        for (;i >=0;i--){
            percDowm(a,i,a.length-1);
        }
    }

    public static void main(String[] args) {

    }
}
