package link.lichen.basic.structure;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by lichen@daojia.com on 2018-4-9.
 */
public class MyLinkedList<T> implements Iterable<T> {


    private int theSize;

    private Node beginMarker;

    private Node endMarker;

    private int modCount = 0;

    private static class Node<T> {
        public Node(Node p, Node n, T d) {
            data = d;
            prev = p;
            next = n;
        }

        private T data;
        public Node<T> prev;

        public Node<T> next;
    }


    public MyLinkedList() {
        doClear();
    }

    public void clear() {
        doClear();
    }

    private void doClear() {
        beginMarker = new Node<T>( null, null, null );
        endMarker = new Node<T>( beginMarker, null, null );
        beginMarker.next = endMarker;
        theSize = 0;
        modCount++;

    }

    public int size() {
        return theSize;
    }


    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean add(T t) {
        add( size(), t );
        return true;
    }

    public void add(int idx, T t) {
        addBefore( getNode( idx, 0, size() ), t );
    }

    public T get(int idx){
        return getNode( idx ).data;
    }

    private Node<T> getNode(int idx) {
        return getNode( idx,0,size() );
    }

    private void addBefore(Node<T> p, T t) {
        Node<T> newNode = new Node( p.prev, p, t );
        p.prev.next = p.prev = newNode;
        theSize++;
        modCount++;
    }

    public T set(int idx,T newVal){
        Node<T> p  = getNode( idx );
        T oldVal = p.data;
        p.data = newVal;
        return oldVal;
    }

    public T remove(int idx) {
        return remove( getNode( idx));
    }

    private T remove(Node<T> val) {
        T oldVal = val.data;
        val.prev.next = val.next;
        val.next.prev = val.prev;
        modCount++;
        theSize--;
        return oldVal;
    }

    private Node getNode(int idx, int low, int upper) {
        Node<T> p;
        if (idx < low || idx > upper)
            throw new IndexOutOfBoundsException( );
        if(idx < size()/2){
            p = beginMarker.next;
            for (int i = 0 ; i < idx ; i++)
                p = p.next;
        }else {
            p = endMarker;
            for (int i = size(); i > idx; i--)
                p = p.prev;
        }

        return p;
    }


    @Override
    public Iterator iterator() {
        return new LinkListIterator();
    }

    private class LinkListIterator implements Iterator<T> {

        private Node<T> current = beginMarker.next;

        private int expectedModCount = modCount;

        private boolean okToRemove = false;

        @Override
        public boolean hasNext() {
            return current != endMarker;
        }

        @Override
        public T next() {
            if(expectedModCount != modCount){
                throw new ConcurrentModificationException();
            }
            if (!hasNext()){
                throw new NoSuchElementException(  );
            }
            T val = current.data;
            current = current.next;
            okToRemove = true;
            return val;
        }

        @Override
        public void remove() {
            if(expectedModCount != modCount){
                throw new ConcurrentModificationException();
            }
            if(!okToRemove){
                throw new IllegalStateException(  );
            }
            
            MyLinkedList.this.remove( current.prev );
            expectedModCount++;
            okToRemove = false;
        }
    }
}
