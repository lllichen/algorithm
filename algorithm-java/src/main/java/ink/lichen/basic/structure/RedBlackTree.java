package ink.lichen.basic.structure;

/**
 * Created by lichen@daojia.com on 2018-11-29.
 */
public class RedBlackTree<T extends Comparable<? super  T>> {


    private static class RedBlackNode<T> {

        RedBlackNode(T theElement){
            this(theElement,null,null);
        }

        T elemet;
        RedBlackNode<T> left;
        RedBlackNode<T> right;
        int color;

        public RedBlackNode(T theElement, RedBlackNode left, RedBlackNode right) {
        }
    }

}
