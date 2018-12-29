package ink.lichen.basic.structure.test.test_26;

/**
 * Created by lichen@daojia.com on 2018-12-26.
 */
public class RedBlackTree<T extends Comparable<? super T>> {

    private static final int BLACK = 1;
    private static final int RED = 0;

    private RedBlackNode<T> header;
    private RedBlackNode<T> nullNode;

    private RedBlackNode<T> current;
    private RedBlackNode<T> parent;
    private RedBlackNode<T> grand;
    private RedBlackNode<T> great;

    public RedBlackTree( ) {
        nullNode      = new RedBlackNode<>(null);
        nullNode.left = nullNode.right = nullNode;
        header        = new RedBlackNode<>(null);
        header.left   = header.right = nullNode;
    }

    private int compare(T item, RedBlackNode<T> t){
        if (t == header){
            return 1;
        }else
            return item.compareTo(t.element);
    }

    private static class RedBlackNode<T> {


        public RedBlackNode(T theElement){
            this(theElement,null,null);
        }

        T element;

        RedBlackNode<T> left;
        RedBlackNode<T> right;

        int color;

        public RedBlackNode(T theElement, RedBlackNode lt, RedBlackNode rt) {
            element = theElement;
            left = lt;
            right = rt;
            color = BLACK;
        }
    }
}
