package ink.lichen.basic.structure;

/**
 * Created by lichen@daojia.com on 2018-11-29.
 * <p>
 * 红黑树是具有以下着色性质的二叉查找树:
 * 1. 每一个节点或者着成红色，或者着成黑色。
 * 2. 根是黑色的。
 * 3. 如果有一个节点是红色的，那么它的子节点必须是黑色的。
 * 4. 从一个节点到一个null引用的每一条路径必须包含相同数目的黑色节点。
 * <p>
 * 着色法则的一个结论是，红黑树的高度最多是2log(N+1),因此，查找操作保证是一种对数操作。
 */
public class RedBlackTree_T<T extends Comparable<? super T>> {


//    private static final int BLACK = 1;
//    private static final int RED = 0;
//
//    private RedBlackNode<T> header;
//    private RedBlackNode<T> nullNode;
//
//    private static class RedBlackNode<T> {
//
//        RedBlackNode(T theElement) {
//            this(theElement, null, null);
//        }
//
//        T elemet;
//        RedBlackNode<T> left;
//        RedBlackNode<T> right;
//        int color;
//
//        public RedBlackNode(T theElement, RedBlackNode lt, RedBlackNode rt) {
//            elemet = theElement;
//            left = lt;
//            right = rt;
//            color = RedBlackTree_T.BLACK;
//        }
//    }
//
//    private RedBlackTree_T<T> rotate(T item, RedBlackNode<T> parent) {
//
//        if (compare(item, parent) < 0) {
//            return parent.left = compare(item, parent.left) < 0 ?
//                    rotateWithLeftChild(parent.left) : rotateWithRightChild(parent.left);
//        } else {
//            return parent.right = compare(item, parent.right) < 0 ?
//                    rotateWithLeftChild(parent.right) : rotateWithRightChild(parent.right);
//        }
//    }
//
//    private final int compare(T item, RedBlackNode<T> t) {
//        if (t == header) {
//            return 1;
//        } else
//            return item.compareTo(t.elemet);
//    }
//
//    private RedBlackNode<T> current;
//    private RedBlackNode<T> grand;
//    private RedBlackNode<T> parent;
//    private RedBlackNode<T> great;
//
//    private void handleReorient(T item) {
//        current.color = RED;
//        current.left.color = BLACK;
//        current.right.color = BLACK;
//        if (parent.color == RED) {
//            grand.color = RED;
//            if ((compare(item, grand) < 0) != (compare(item, parent) < 0)) {
//                parent == rotate(item,grand);
//            }
//            current = rotate(item, great);
//            current.color = BLACK;
//
//        }
//        header.right.color = BLACK;
//    }
//
//    public void insert(T item){
//        current = parent = grand = header;
//        nullNode.elemet = item;
//        while (compare(item,current)!= 0){
//            great = grand;grand = parent; parent = current;
//            current = compare(item,current)<0? current.left:current.right;
//
//            if (current.left.color ==RED && current.right.color == RED){
//                handleReorient(item);
//            }
//        }
//
//        if (current != nullNode){
//            return;
//        }
//
//        if (compare(item,parent)<0){
//            parent.left = current;
//        }else {
//            parent.right = current;
//        }
//        handleReorient(item);
//    }
}
