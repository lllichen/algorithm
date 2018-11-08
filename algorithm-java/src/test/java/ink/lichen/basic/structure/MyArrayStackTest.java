package ink.lichen.basic.structure;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by lichen@daojia.com on 2018-4-11.
 */
public class MyArrayStackTest {

    @Test
    public void testStackPushAndPop(){
        MyArrayStack<String> stack = new MyArrayStack<>();
        stack.push( "a" );
        stack.push( "b" );
        stack.push( "c" );
        stack.push( "d" );

        Assert.assertTrue( stack.pop().equals( "d" ) );
        Assert.assertTrue( stack.size()==3 );
        Assert.assertTrue( stack.pop().equals( "c" ) );
        Assert.assertTrue( stack.size()==2 );
        Assert.assertTrue( stack.pop().equals( "b" ) );
        Assert.assertTrue( stack.size()==1 );
        Assert.assertTrue( stack.pop().equals( "a" ) );
        Assert.assertTrue( stack.size()==0 );
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testEmptyStackPop(){
        MyArrayStack<String> stack = new MyArrayStack<>();
        Assert.assertTrue( stack.pop() == null);
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void testEmptyStackTop(){
        MyArrayStack<String> stack = new MyArrayStack<>();
        Assert.assertTrue( stack.pop() == null);
    }




    @Test
    public void testStackClear(){
        MyArrayStack<String> stack = new MyArrayStack<>();
        stack.push( "a" );
        stack.push( "b" );
        stack.push( "c" );
        stack.push( "d" );
        System.out.println(stack.pop());
        System.out.println(stack.size());
    }

}
