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


    private static < T extends Comparable< ? super T> > void mergeSort(T[] a,T[] tempArray,int left, int right){
        if (left < right){
            int center = (left+right)/2;
            mergeSort(a,tempArray,left,center);
            mergeSort(a,tempArray,center+1,right);
            merge(a,tempArray,left,center+1,right);
        }
    }

    private static<T extends Comparable<? super T>> void merge(T[] a, T[] tempArray, int leftPos, int rightPos, int rightEnd) {

        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos +1;

        while (leftPos <= leftEnd && rightPos <= rightEnd){
            if (a[leftPos].compareTo(a[rightPos]) <= 0){
                tempArray[tmpPos++] = a[leftPos++];
            }else
                tempArray[tmpPos++] = a[rightPos++];
        }

        while (leftPos <= leftEnd){
            tempArray[tmpPos++] = a[leftPos++];
        }

        while (rightPos <= rightEnd){
            tempArray[tmpPos++] = a[rightPos++];
        }

        for (int i = 0 ;i < numElements; i++,rightEnd--){
            a[rightEnd] = tempArray[rightEnd];
        }

    }

    private static  <T extends Comparable<? super T> > void mergeSort(T[] a){
        T[] tempArray = (T[]) new Comparable[a.length];
        mergeSort(a,tempArray,0,a.length-1);
    }

    private static  <T extends Comparable<? super T>> void quickSort(T[] a){
        quickSort(a,0,a.length-1);
    }

    private static final int CUTOFF = 10;

    private static <T extends Comparable<? super T>> T median3(T[] a,int left, int right){
        int center = (left+right) / 2;
        if (a[center].compareTo(a[left]) < 0){
            swapReference(a,left,center);
        }
        if (a[right].compareTo(a[left]) < 0){
            swapReference(a,left,right);
        }
        if (a[right].compareTo(a[center]) < 0){
            swapReference(a,center,right);
        }
        swapReference(a,center,right-1);
        return a[right-1];
    }

    private static <T extends Comparable<? super T>> void quickSort(T[] a,int left, int right){
        if (left + CUTOFF <= right){
            T pivot = median3(a, left, right);
            int i = left ,j = right -1;
            for (;;){
                while (a[++i].compareTo(pivot) < 0){};
                while (a[--j].compareTo(pivot) > 0){};
                if (i < j){
                    swapReference(a,i,j);
                }else
                    break;
            }
            swapReference(a,i,right-1);
            quickSort(a,left,i-1);
            quickSort(a,i+1,right);
        }else
            insertionSort(a,left,right);
    }

    private static <T extends Comparable<? super T>> void insertionSort(T[] a, int left, int right) {
        int j;
        for (int i = left +1; i<= right ; i++ ){
            T tmp = a[i];
            for (j = i; j>left && tmp.compareTo(a[j-1])<0;j--){
                a[j] = a[j-1];
            }
            a[j] = tmp;
        }

    }


    public static void main(String[] args) {
        Integer a[] = new Integer[] {4,31,6,88,12,4,3,12,77,8,9,15,4,5,6};
        heapSort(a);
//        mergeSort(a);
//        quickSort(a);
//        insertionSort(a,0,a.length-1);
        print(a);
    }
}
