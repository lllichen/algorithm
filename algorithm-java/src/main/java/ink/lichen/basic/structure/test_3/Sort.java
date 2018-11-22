package ink.lichen.basic.structure.test_3;

/**
 * Created by lichen@daojia.com on 2018-11-22.
 */
public class Sort {

    private static final int leftChild(int i){
        return 2*i+1;
    }

    private static <T extends Comparable<? super T>> void percDowm(T[] a,int hole,int right){
        int child;
        T tmp = a[hole];
        for (;leftChild(hole)<=right;hole=child){
            child = leftChild(hole);
            if (child != right && a[child].compareTo(a[child+1])>0){
                child++;
            }
            if (a[child].compareTo(tmp)>0){
                a[child]  = tmp;
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

        for (int i = (a.length+1) >> 1;i >=0;i--){
            percDowm(a,i,a.length-1);
        }
        for (int i = a.length-1;i>=0;i-- ){

            a[i] = a[0];
            percDowm();
        }
    }

    public static void main(String[] args) {

    }
}
