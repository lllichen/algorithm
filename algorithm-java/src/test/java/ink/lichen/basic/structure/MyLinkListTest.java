package ink.lichen.basic.structure;

import link.lichen.basic.structure.MyArrayList;
import link.lichen.basic.structure.MyLinkedList;
import org.junit.Test;

import java.util.Iterator;

/**
 * Created by lichen@daojia.com on 2018-4-10.
 */
public class MyLinkListTest {


    @Test
    public void testRemove(){
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.remove( 0 );
        println( linkedList );
    }

    @Test
    public void testIterator() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        Iterator iterator =linkedList.iterator();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.remove();


        println( linkedList );
    }


    private void println(MyLinkedList list){
        for(int i = 0 ; i < list.size() ; i++){
            System.out.println("index "+i+" is :"+list.get( i ));
        }
    }
}
