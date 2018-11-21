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
        for ( tmp =a[i]; leftChild(i) < n; i = child ){
            child = leftChild(i);
            if ( child != n-1 && a[child+1].compareTo(a[child] ) > 0 ){
                child++;
            }
            if ( a[child].compareTo(tmp) > 0){
                a[i] = a[child];
            }else {
                break;
            }
        }
        a[i] = tmp;
    }


    private static final void print(Integer [] nums){
        for (int val : nums){
            System.out.print(val+"\t");
        }
    }

    public static <T extends Comparable<? super T>> void mergeSort(T[] a){
        T[] temp = (T[]) new Comparable[a.length];
        mergeSort(a,temp,0,a.length-1);
    }

    private static <T extends Comparable<? super T>> void mergeSort(T[] a, T[] temp, int left, int right) {
        if (left < right){
            int center = (left+right)>>1;
            mergeSort(a,temp,left,center);
            mergeSort(a,temp,center+1,right);
            merge(a,temp,left,center+1,right);
        }
    }

    private static<T extends Comparable<? super T>> void merge(T[] a, T[] temp, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int tempPos = leftPos;
        int numElements = rightEnd - leftPos+1;

        while (leftPos <= leftEnd && rightPos <= rightEnd){
            if (a[leftPos].compareTo(a[rightPos]) <= 0){
                temp[tempPos++] = a[leftPos++];
            }else {
                temp[tempPos++] = a[rightPos++];
            }
        }

        while (leftPos <= leftEnd){
            temp[tempPos++]=a[leftPos++];
        }

        while (rightPos <= rightEnd){
            temp[tempPos++] = a[rightPos++];
        }
        for (int i=0; i < numElements; i++,rightEnd--){
            a[rightEnd] = temp[rightEnd];
        }
    }


    public static void main(String[] args) {

        Integer a[] = new Integer[] {4,31,6,88,12,4,3,12,77,8,9,15,4,5,6};
        //n*log(n)
//        heapSort(a);
        mergeSort(a);
        print(a);
    }
}
