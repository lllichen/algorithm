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


    public static <T> void print(T[] t){
        for(T val : t){
            System.out.println(val);
        }
    }


    public static void main(String[] args) {
        Integer [] t = new Integer[]{4,3,2,6,5,4,7,8};
//        Sort.insertionSort(t);
        Sort.shellSort(t);
        print(t);
    }
}
