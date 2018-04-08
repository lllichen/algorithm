package ink.lichen.basic.structure;

import link.lichen.basic.structure.MyArrayList;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by lichen@daojia.com on 2018-4-8.
 */
public class MyArrayListTest {


    @Test
    public void testAdd(){
        MyArrayList<String> list = new MyArrayList<String>();
        list.add( "aa" );
        list.add( "bb" );
        list.add( "cc" );
        for (int i = 0 ; i < list.size() ; i++){
            System.out.println(list.get( i ));
        }
    }


    @Test
    public void testGet(){
        MyArrayList<String> list = new MyArrayList<String>();
        list.add( "aa" );
        list.add( "bb" );
        list.add( "cc" );
        System.out.println("index 0 is :"+ list.get( 0 ));
        System.out.println("index 1 is :"+ list.get( 1 ));
        System.out.println("index 2 is :"+ list.get( 2 ));
        System.out.println("index 3 is :"+ list.get( 3 ));
    }

}
