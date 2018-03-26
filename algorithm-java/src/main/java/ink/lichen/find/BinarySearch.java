package ink.lichen.find;

/**
 * Created by lichen@daojia.com on 2017-12-7.
 */
public class BinarySearch {


    // -1 error
    public static int find(int [] a,int end,int dest){
        if(a.length < 1)
            return -1;
        int length = a.length;
        int mid = length/2;
        if (a[mid]<dest)
            return find( a,mid,a.length );


        return 0;
    }

}
