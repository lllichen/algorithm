package ink.lichen.find;

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

}
