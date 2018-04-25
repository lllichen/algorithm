package ink.lichen.basic.find;

import ink.lichen.find.BinarySearch;
import org.junit.Test;

/**
 * Created by lichen@daojia.com on 2018-4-11.
 */
public class BinarySearchTest {


    @Test
    public void testSearchWhile(){
        int[] ints = new int[]{1,2,3,4,5,6,7,8,9,10,11,15,20,22,30,31};
        System.out.println(BinarySearch.find(ints,32));
    }

    @Test
    public void testSearchIterator(){
        int[] ints = new int[]{1,2,3,4,5,6,7,8,9,10,11,15,20,22,30,31};
        System.out.println(BinarySearch.find(ints,15,0,ints.length-1));
    }
}
