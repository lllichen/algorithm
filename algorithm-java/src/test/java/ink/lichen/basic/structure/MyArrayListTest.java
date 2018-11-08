package ink.lichen.basic.structure;

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
        println( list );
    }


    @Test
    public void testRemove(){
        MyArrayList<String> list = new MyArrayList<String>();
        list.add( "aa" );
        list.add( "bb" );
        list.add( "cc" );
        list.remove( 0 );
        println( list );
    }


    @Test
    public void testEnsureCapacity(){
        MyArrayList<String> list = new MyArrayList<String>();
        list.add( "aa" );
        list.add( "bb" );
        list.add( "cc" );
        list.trimToSize();
        list.add( "dd" );
        list.add( "dd" );
        list.add( "dd" );
        list.add( "dd" );
        list.add( "dd" );
        list.add( "dd" );
        list.add( "dd" );
        list.add( "dd" );
        list.add( "dd" );
        list.add( "dd" );
        list.add( "dd" );

        System.out.println(list.capacity());
        println( list );
    }

    @Test
    public void testIterator(){
        MyArrayList a1 = new MyArrayList();
       a1.echoHash();
        System.out.println(a1.iterator().hashCode());
       a1.echoHash();
        System.out.println(a1.iterator().hashCode());
       a1.echoHash();
        System.out.println(a1.iterator().hashCode());
        MyArrayList a2 = new MyArrayList();
        a2.echoHash();
        a2.echoHash();
        a2.echoHash();

    }


    private void println(MyArrayList list){
        for(int i = 0 ; i < list.size() ; i++){
            System.out.println("index "+i+" is :"+list.get( i ));
        }
    }


}

