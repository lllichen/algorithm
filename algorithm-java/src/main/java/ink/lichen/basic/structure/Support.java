package ink.lichen.basic.structure;

/**
 * Created by lichen@daojia.com on 2018-11-22.
 */
public class Support {



    public static final void print(Integer [] nums){
        for (int val : nums){
            System.out.print(val+"\t");
        }
    }

    public static<T extends Comparable<? super T>> void swap(T[] a,int i,int j){
        T tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

}
