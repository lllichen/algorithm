package ink.lichen.basic.structure.test_2;

/**
 * Created by lichen@daojia.com on 2018-11-21.
 */
public class Sort {



    public static <T extends Comparable< ? super T>> void  heapSort(T[] a){
        for (int i = a.length/2-1;i >= 0; i--){
            percDown(a,i,a.length);
        }
        for (int i = a.length-1 ; i >=0; i--){

            swap(a,0,i);
            percDown(a,0,i);
        }
    }

    private static <T extends Comparable< ? super T>> void swap(T[] a,int idx1, int idx2){
        T tmp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = tmp;
    }

    private static final int leftChild(int i){
        return 2*i+1;
    }


    private static <T extends Comparable< ? super T>> void percDown(T[] a,int i,int n){
        int child;
        T tmp;
        for (tmp =a[i]; leftChild(i) < n; i = child){
            child = leftChild(i);
            if (child != n-1 && a[child+1].compareTo(a[child])< 0){
                child++;
            }
            if (a[child].compareTo(tmp)< 0){
                a[i] = a[child];
            }else {
                break;
            }
        }
        a[i] = tmp;
    }

}
