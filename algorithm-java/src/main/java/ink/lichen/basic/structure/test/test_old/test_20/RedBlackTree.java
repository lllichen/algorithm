package ink.lichen.basic.structure.test.test_old.test_20;

/**
 * Created by lichen@daojia.com on 2018-12-20.
 * 1.每个节点或是红色或是黑色.
 * 2.根是黑色的.
 * 3.如果一个节点是红色的，其子节点一定是黑色的.
 * 4.从一个节点到null引用的每一条路径必须包含相同数目的黑色节点。
 * 着色法则的一个结论是：红黑树的高度最多是2log(n+1),因此，查找操作保证是一种
 * 对数操作。
 */
public class RedBlackTree<T extends Comparable<? super T>> {

    private static final int BLACK = 1; //black must be 1
    private static final int RED = 0;

    private RedBlackNode<T> header;
    private RedBlackNode<T> nullNode;

    //Used in insert routine and it's helper
    private RedBlackNode<T> current;
    private RedBlackNode<T> parent;
    private RedBlackNode<T> grand;
    private RedBlackNode<T> great;


    public RedBlackTree() {
        nullNode = new RedBlackNode<>(null);
        nullNode.left = nullNode.right = nullNode;
        header = new RedBlackNode<>(null);
        header.left = header.right = nullNode;
    }


    private int compare(T item, RedBlackNode<T> t) {
        if (t == header) {
            return 1;
        } else
            return item.compareTo(t.element);
    }

    public void insert(T item) {
        current = parent = grand = header;
        nullNode.element = item;
        while (compare(item, current) != 0) {
            great = grand;
            grand = parent;
            parent = current;
            current = compare(item, current) < 0 ? current.left : current.right;

            // Check if two red children; fix if so
            if (current.left.color == RED && current.right.color == RED) {
                handleReorient(item);
            }
        }

        if (current != nullNode){
            return;
        }
        current = new RedBlackNode<>(item,nullNode,nullNode);

        if (compare(item,parent)<0){
            parent.left = current;
        }else
            parent.right = current;
        handleReorient( item );
    }

    private void handleReorient(T item)
    {
        current.color = RED;
        current.left.color = BLACK;
        current.right.color = BLACK;

        if (parent.color == RED){
            grand.color = RED;
            if(compare(item,grand)<0 != (compare(item,parent)<0)){
                parent = rotate(item,great);
            }
            current = rotate(item,great);
            current.color = BLACK;
        }
        header.right.color = BLACK;
    }

    private RedBlackNode<T> rotate(T item, RedBlackNode<T> parent) {
        if (compare(item,parent) < 0)
            return parent.left = compare(item,parent.left)<0 ?rotateWithLeftChild(parent.left):
                    rotateWithRightChild(parent.left);
        else
           return parent.right = compare(item,parent.right)<0 ? rotateWithLeftChild( parent.right ):  // RL
                   rotateWithRightChild( parent.right );  // RR
    }

    private RedBlackNode rotateWithLeftChild(RedBlackNode k2) {
        RedBlackNode k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        return k1;
    }

    private RedBlackNode rotateWithRightChild(RedBlackNode k1) {
        RedBlackNode k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        return k2;
    }

    public void printTree( )
    {
        if( isEmpty( ) )
            System.out.println( "Empty tree" );
        else
            printTree( header.right );
    }

    public boolean isEmpty( )
    {
        return header.right == nullNode;
    }

    private void printTree( RedBlackNode<T> t )
    {
        if( t != nullNode )
        {

            printTree( t.left );
            System.out.println( t.element );
            printTree( t.right );

        }
    }


    private static class RedBlackNode<T>{

        public RedBlackNode(T theElement) {
            this(theElement,null,null);
        }

        public RedBlackNode(T element, RedBlackNode left, RedBlackNode right) {
            this.element = element;
            this.left = left;
            this.right = right;
            this.color = BLACK;
        }

        T element; //the data in the node
        RedBlackNode left; //Left child
        RedBlackNode right; //Right child
        int color;   //Color
    }


    public static void main(String[] args) {
        RedBlackTree redBlackTree = new RedBlackTree();
        redBlackTree.insert(10);
        redBlackTree.insert(85);
        redBlackTree.insert(15);
        redBlackTree.insert(70);
        redBlackTree.insert(20);
        redBlackTree.insert(60);
        redBlackTree.insert(30);
        redBlackTree.insert(50);
        redBlackTree.insert(65);
        redBlackTree.insert(80);
        redBlackTree.insert(90);
        redBlackTree.insert(40);
        redBlackTree.insert(5);
        redBlackTree.insert(55);
//        System.out.println(redBlackTree.header.right.element);
        redBlackTree.insert(45);
//        System.out.println(redBlackTree.header.right.element);
        redBlackTree.printTree();
    }

}
