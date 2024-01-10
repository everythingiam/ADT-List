package Mains;
import treeLists.*;
import symbol.*;

public class MainTrees {
    // симметричный обход дерева
    public static void symmetry(Tree T, int index) {
        int left = T.LEFTMOST_CHILD(index);
        if (left != -1) {
            symmetry(T, left);
        }
        T.LABEL(index).print();
        int right = T.RIGHT_SIBLING(left);
        if (right != -1) {
            symmetry(T, right);
        }
    }

    public static void main(String[] args) {
        // создание дерева
        Tree T = new Tree();
        T.initialization();
        T.CREATE(new Symbol('g'));
        Tree T1 = new Tree();
        T1.CREATE(new Symbol('e'));
        Tree T2 = T1.CREATE(new Symbol('f'), T);

        Tree T3 = new Tree();
        T3.CREATE(new Symbol('c'));

        Tree T4 = new Tree();
        T4.CREATE(new Symbol('a'));

        Tree T5 = T4.CREATE(new Symbol('b'), T3);

        Tree tree = T5.CREATE(new Symbol('d'), T2);

//        symmetry(tree, tree.ROOT());
    }
}