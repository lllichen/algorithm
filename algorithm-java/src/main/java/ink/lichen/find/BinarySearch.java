package ink.lichen.find;

/**
 * Created by lichen@daojia.com on 2017-12-7.
 */
public class BinarySearch {


    // -1 error
    public static int find(int [] a,int begin, int end,int dest){

        if(begin > end){
            return -1;
        }
        int mid =(begin+end)/2;
        if (a[mid]<dest)
            return find( a,mid+1,end,dest );
        else if (a[mid] > dest)
            return find( a,begin,mid-1,dest );
        else
            return mid+1;
    }


    public static int find(int[] a,int target){
        int begin = 0;
        int end = a.length-1;
        while ( begin <= end){
            int mid = (begin+end)/2;
            if (a[mid] > target ){
                end = mid-1;
            }else if (a[mid] < target){
                begin = mid+1;
            }else if (a[mid] == target){
                 return mid+1;
            }
        }
        return -1;
    }

}
