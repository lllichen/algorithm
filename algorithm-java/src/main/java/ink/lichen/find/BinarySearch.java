package ink.lichen.find;

/**
 * Created by lichen@daojia.com on 2017-12-7.
 */
public class BinarySearch {


    public static final int find(int[] a,int val){
        if (a.length < 0) {
            return -1;
        }
        int high = a.length-1;
        int low = 0;

        while (low <= high) {
            int mid = (high+low)/2;
            if (a[mid] > val ){
                high = mid -1;
            }else if(a[mid] < val ){
                low = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }


    public static final int find(int[] a, int val, int low, int high){
        if (low > high){
            return -1;
        }
        int mid = (high+low)/2;
        if (a[mid] > val){
            return find( a,val,low,mid-1 );
        }else if (a[mid] < val){
            return find( a,val,mid+1,high );
        }else {
            return mid+1;
        }
    }
}
