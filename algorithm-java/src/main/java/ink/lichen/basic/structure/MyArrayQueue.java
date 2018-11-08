package ink.lichen.basic.structure;

/**
 * Created by lichen@daojia.com on 2018-4-13.
 */
public class MyArrayQueue<T> {

    private T [] theArray;

    private int theSize;

    private int front;

    private  int back;


    public MyArrayQueue(){
        doClear();
    }

    private void doClear() {
        front = back = 0;
        theSize = 0;
//        En
    }


    //

    public void enqueue(T val){
        
    }

}
