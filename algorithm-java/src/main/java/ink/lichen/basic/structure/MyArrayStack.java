package ink.lichen.basic.structure;

/**
 * Created by lichen@daojia.com on 2018-4-11.
 */
public class MyArrayStack<T> {


    private T [] theArray;

    private int DEFAULT_SIZE = 10;

    private int theSize;

    private int topOfStack;

    public MyArrayStack(){
        doClear();
    }

    private void doClear() {
        theSize = 0;
        ensureCapacity(DEFAULT_SIZE);
        topOfStack = -1;
    }

    public int size(){
        return theSize;
    }

    public boolean isEmpty(){
        return topOfStack == -1;
    }


    private void ensureCapacity(int newCapacity) {
        if (newCapacity < theSize){
            return;
        }
        T[] old = theArray;
        theArray = (T[]) new Object[newCapacity];
        for (int i = 0 ; i < size(); i++)
            theArray[i] = old[i];
    }

    public void push(T t){
        if (size() == theArray.length){
            ensureCapacity( 2*size()+1 );
        }
        theSize++;
        theArray[++topOfStack] = t;
    }

    public T pop(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException(  );
        }
        theSize--;
        return theArray[topOfStack--];
    }

    public T top(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException(  );
        }
        return theArray[topOfStack];
    }

}
