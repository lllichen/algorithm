package ink.lichen.basic.structure;

/**
 * Created by lichen@daojia.com on 2019-2-23.
 */
public class LinkedList<T> {

    private Node header;

    private Node tail;

    public LinkedList(){
        header =  new Node(null,null,null);
        tail = new Node(header,null,null);
        header.next = tail;
    }

    public boolean add(T t){
        Node node = tail.pre;
        Node newNode = new Node(node,tail,t);
        node.next = newNode;
        newNode.next = tail;
        tail.pre = newNode;
        return true;
    }

    public T remove(){
        if (isEmpty()){
            throw new IllegalStateException();
        }
        Node<T> node = tail.pre;
        node.pre.next = node.next;
        tail.pre = node.pre;
        return node.val;
    }

    private boolean isEmpty(){
        if (header.next == tail){
            return true;
        }
        return false;
    }

    private static class  Node<T>{

        Node<T>  pre;
        Node<T> next;
        T val;

        public Node(Node<T> p,Node<T> n,T val){
            this.pre = p;
            this.next = n;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        System.out.println(linkedList.remove());
        System.out.println(linkedList.remove());
        System.out.println(linkedList.remove());
    }
}
