package ink.lichen.basic.structure;

/**
 * Created by lichen@daojia.com on 2018-11-22.
 */
public class DisjSets {

    private int[] s;

    public DisjSets(int numElements){
        s = new int[numElements];
        for (int i = 0 ;i < s.length;i++){
            s[i] = -1;
        }
    }

    public void union(int root1,int root2){
        s[root2] = root1;
    }

    public int find(int x){
        if (s[x] < 0){
            return x;
        }else
            return find(s[x]);
    }

    public static void main(String[] args) {
        DisjSets disjSets = new DisjSets(10);
        disjSets.union(4,5);
        disjSets.union(6,7);
        disjSets.union(4,6);
        System.out.println(disjSets.find(4));
        System.out.println(disjSets.find(5));
        System.out.println(disjSets.find(6));
        System.out.println(disjSets.find(7));
    }
}
