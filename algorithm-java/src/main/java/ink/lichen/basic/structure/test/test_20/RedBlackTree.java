package ink.lichen.basic.structure.test.test_20;

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


}
