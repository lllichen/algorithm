package ink.lichen.basic.structure.test_1;

public class Sort {


    public static <T extends Comparable<? super T>> void heapSort(T [] a){
        for (int i = a.length/2 -1; i>= 0; i--){
            percDown(a,i,a.length);
        }
        for (int i = a.length-1;i>0; i--){
            swapReference(a,0,i);
            percDown(a,0,i);
        }
    }

    private static<T extends Comparable<? super T>> void swapReference(T[] items, int a, int b) {
        T item = items[a];
        items[a] = items[b];
        items[b] = item;
    }

    private static  int leftChild(int i){
        return 2*i+1;
    }

    private static<T extends Comparable< ? super T>> void percDown(T[] a, int i, int n) {
        int child;
        T tmp;
        for (tmp = a[i]; leftChild(i) < n; i = child)
        {
            child = leftChild(i);
            if (child != n-1 && a[child].compareTo(a[child+1])<0 )
                child++;
            if (tmp.compareTo(a[child]) < 0){
                a[i] = a[child];
            }else
                break;
        }
        a[i] = tmp;
    }


    private static final void print(Integer [] nums){
        for (int val : nums){
            System.out.print(val+"\t");
        }
    }

    public static void main(String[] args) {
        Integer a[] = new Integer[] {4,31,6,88,12,4,3,12,77,8,9,15,4,5,6};
        heapSort(a);
        print(a);
    }
}
