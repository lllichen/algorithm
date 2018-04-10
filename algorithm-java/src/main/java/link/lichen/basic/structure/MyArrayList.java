package link.lichen.basic.structure;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by lichen@daojia.com on 2018-3-26.
 */
public class MyArrayList<T> implements Iterable<T>{


    private static final int DEFAULT_CAPACITY = 10;

    private int theSize;

    private  T [] theItems;

    public int capacity(){
        return theItems.length;
    }

    public MyArrayList() {
        doClear();
    }

    public void clear(){
        doClear();
    }

    private void doClear (){
        theSize = 0;
        ensureCapacity( DEFAULT_CAPACITY );
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty (){
        return theSize == 0;
    }

    public void trimToSize(){
        ensureCapacity( size() );
    }

    public T get(int idx) {
        if (idx < 0 || idx >= size())
            throw new ArrayIndexOutOfBoundsException(  );
        return theItems[idx];
    }

    public T set(int idx,T newVal) {
        if (idx < 0 || idx >= size())
            throw new ArrayIndexOutOfBoundsException(  );
        T oldVal = theItems[idx];
        theItems[idx] = newVal;
        return oldVal;
    }

    public boolean add(T newVal) {
        add(size(),newVal);
        return true;
    }

    public void add (int idx, T newVal){
        if (idx < 0 || idx > size()){
            throw new ArrayIndexOutOfBoundsException();
        }
        if (size() == theItems.length){
            ensureCapacity( 2*size()+1 );
        }

        for (int i = size() ; i > idx; i--){
            theItems[i] = theItems[i-1];
        }
        theItems[idx] = newVal;
        theSize++;
    }

    public T remove(int idx) {
        if (idx < 0 || idx >= size()){
            throw new ArrayIndexOutOfBoundsException();
        }
        T oldVal = theItems[idx];
        for (int i =idx ; i < size()-1; i++ ) {
            theItems[i] = theItems[i+1];
        }
        theItems[theSize--] = null;
        return oldVal;
    }




    public void ensureCapacity(int newCapacity){
        if (newCapacity < size())
            return;
        T [] old = theItems;
        theItems = (T[])  new Object[newCapacity];
        for (int i = 0 ; i < size();i++)
            theItems[i] = old[i];
    }


    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    public void echoHash(){
        new ArrayListIterator().echoHash();
    }

    private class ArrayListIterator implements Iterator<T>{

        private int current = 0;

        public boolean hasNext() {
            return current < size();
        }

        public T next() {
            if(!hasNext())
                throw new NoSuchElementException( );
            return theItems[current++];
        }

        public void echoHash(){
            System.out.println(MyArrayList.this.hashCode());
        }

        public void remove() {
            MyArrayList.this.remove( current-- );
        }
    }
}
