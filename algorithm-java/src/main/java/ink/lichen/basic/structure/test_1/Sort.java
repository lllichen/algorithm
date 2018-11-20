package ink.lichen.basic.structure.test_1;

public class Sort {


    public static <T extends Comparable<? super T>> void heapSort(T [] items){
        for (int i = items.length/2 -1; i>= 0; i--){
            percDown(items,i,items.length);
        }
    }

    private static<T extends Comparable< ? super T>s> void percDown(T[] items, int i, int hole) {

    }
}
