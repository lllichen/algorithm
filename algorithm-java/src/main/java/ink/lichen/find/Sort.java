package ink.lichen.find;

import java.util.ArrayList;

import static ink.lichen.basic.structure.Support.print;

/**
 * Created by lichen@daojia.com on 2018-11-12.
 */
public class Sort {

    public static  <T extends Comparable<? super T>> void insertionSort(T[] t){
        int j;
        for (int i = 1 ; i < t.length; i++){
            T tmp = t[i];
            for (j = i; j > 0 && tmp.compareTo(t[j-1])<0; j--){
                t[j] = t[j-1];
            }
            t[j] = tmp;
        }
    }

    public static <T extends Comparable<? super T>> void shellSort(T[] t){
        int j;
        for(int gap = t.length/2; gap >0; gap /= 2){
            for (int p = gap;p < t.length; p ++){
                T tmp = t[p];
                for (j = p; j > 0 && tmp.compareTo(t[j-gap])<0 ; j-=gap){
                    t[j] = t[j-gap];
                }
                t[j] = tmp;
            }
        }
    }

    //left child
    private static int leftChild(int i){
        return 2*i+1;
    }

    private static <T extends Comparable<? super T>> void percDown(T[] t,int i, int n){
        int child;
        T tmp;
        for (tmp = t[i];leftChild(i)<n; i= child){
            child = leftChild(i);
            if (child != n-1 && t[child].compareTo(t[child+1]) < 0)
            {
                child++;
            }
            if (tmp.compareTo(t[child]) < 0){
                t[i] = t[child];
            }else
                break;
        }
        t[i] = tmp;
    }

    private static <T extends Comparable<? super T>> void swapReference(T[] t, int lo, int hi){
        T tmp = t[lo];
        t[lo] = t[hi];
        t[hi] = tmp;
    }

    public static <T extends  Comparable<? super T>> void heapSort(T[] t){
        for (int i = t.length/2-1; i >= 0; i--){
            percDown(t,i,t.length);
        }
        for (int i = t.length-1 ; i>0;i--){
            swapReference(t,0,i);
            percDown(t,0,i);
        }
    }


    public static void radixSortA(String [] arr, int stringLen){
        final int BUCKETS = 256;
        ArrayList<String>[] buckets = new ArrayList[BUCKETS];

        for (int i = 0 ; i < BUCKETS; i++)
            buckets[i] = new ArrayList<>();

        for (int pos = stringLen - 1; pos >=0 ;pos --){
            for (String s : arr){
                buckets[s.charAt(pos)].add(s);
            }

            int idx = 0;
            for (ArrayList<String> thisBucket : buckets){
                for (String s : thisBucket){
                    arr[idx++] = s;
                }
                thisBucket.clear();
            }
        }
    }


    public static void main(String[] args) {
            Integer a[] = new Integer[] {4,31,6,88,12,4,3,12,77,8,9,15,4,5,6};
//            heapSort(a);
//            print(a);
//        Sort.insertionSort(t);
//        Sort.shellSort(t);
//        print(a);

        String[] strs = new String[]{"aa","cc","ab","ac","ef"};

        radixSortA(strs,2);
        print(strs);
    }
}
