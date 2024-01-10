package treeLists;

import symbol.*;

public class Tree {

    private static Leaf[] array;
    private static int SPACE;

    private int root; // корень дерева

    // элемент массива
    private static class Leaf {

        private int index_next;
        private Symbol label;
        private Item next;

        public Leaf(int i, Symbol s, Item c) {
            index_next = i;
            label = s;
            next = c;
        }

        public Leaf(int i) {
            index_next = i;
        }
    }
    //элемент связного списка сыновей
    private class Item {

        private int name;
        private Item next;

        public Item(int i, Item n) {
            name = i;
            next = n;
        }
    }

    // инициализация массива пустых
    public static void initialization() {
        array = new Leaf[50];
        SPACE = 0;
        for (int i = 0; i < array.length - 1; i++) {
            array[i] = new Leaf(i + 1);
        }
        array[array.length - 1] = new Leaf(-1);
    }

    public Tree() {
        root = -1;
    }

    // возвращает имя родителя узла n в дереве Т
    public int PARENT(int n) {
        // у корня нет родителя
        if (n == this.root) {
            return -1;
        }

        int par = find_parent(this.root, n);
        return par;
    }

    //рекурсивный метод поиска родителя
    //leaf - вершина, которую проверяем
    //child - вершина, для которой ищем родителя
    private int find_parent(int leaf, int child) {
        if (is_child(child, leaf)) {
            return leaf;
        }
        if (array[leaf].next != null) {
            int temp = find_parent(array[leaf].next.name, child);
            if (temp != -1) {
                return temp;
            }
        }
        if (array[leaf].next.next != null) {
            int temp = find_parent(array[leaf].next.next.name, child);
            if (temp != -1) {
                return temp;
            }
        }
        return -1;
    }

    // возвращает true, если с есть в списке детей р
    private boolean is_child(int c, int p) {
        Item current = array[p].next;
        while (current != null) {
            if (current.name == c) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // возвращает самого левого сына узла в дереве.
    public int LEFTMOST_CHILD(int name) {
        // некорректное имя
        if (name == -1) {
            return -1;
        }
        int par = find_parent(this.root, name);

        // вершина есть в дереве
        if (par != -1 || name == root) {
            Item current = array[name].next; // смотрим сына узла name
            // если вершина name лист
            if (current == null) {
                return -1;
            }
            return current.name; // имя сына
        }
        return -1;
    }

    // возвращает правого брата узла n в дереве
    // wn 3HayeHue A, ecnn TaKoBOro He CylWlEeCTBYeT.
    public int RIGHT_SIBLING(int name) {
        int par = find_parent(this.root, name);
        // вершина не в дереве или корень
        if (par == -1) {
            return -1;
        }
        Item current = array[par].next; // первый сын родителя
        if (current.name == name) {
            if (current.next != null) {
                return current.next.name;
            }
        }
        return -1;
    }

    // возвращает метку узла в дереве.
    public Symbol LABEL(int name) {
        // проверить, есть ли лист в дереве
        if (name != -1 && (find_parent(this.root, name) != -1 || name == this.root)) {
            return new Symbol(array[name].label);
        }
        return new Symbol('?');
    }

    // создает новое дерево
    public Tree CREATEO(Symbol v) {
        // если дерево пустое - это дерево и есть результат
        // если не пцстое то сделать пустым
        if (this.root != -1) {
            this.MAKENULL();
        }
        this.root = SPACE;
        SPACE = array[SPACE].index_next;
        array[this.root].index_next = -1;
        array[this.root].label = v;
        array[this.root].next = null;
        return this;
    }

    public Tree CREATE(Symbol v) {
        // дерево, на котором вызвали, становится сыном
        Tree t = new Tree();
        t.root = SPACE;
        SPACE = array[SPACE].index_next;
        array[t.root].index_next = -1;
        array[t.root].label = v;
        array[t.root].next = new Item(this.root, null);
        this.root = -1;
        return t;
    }

    public Tree CREATE(Symbol v, Tree T) {
        // передается правый сын
        // проверить, не передали ли то же дерево, на котором вызвали
        if (this == T) {
            return CREATE(v);
        }
        Tree t = new Tree();
        t.root = SPACE;
        SPACE = array[SPACE].index_next;
        array[t.root].index_next = -1;
        array[t.root].label = v;
        array[t.root].next = new Item(this.root, new Item(T.root, null));
        this.root = -1;
        T.root = -1;
        return t;
    }

    // возвращает узел, который корень дерева
    public int ROOT() {
        return root;
    }

    // делает дерево Т пустым деревом
    public void MAKENULL() {
        // обратным обходом вернуть все вершины в список пустых
        deleting(this.root);
        this.root = -1;
    }

    // удаление узла name
    private void deleting(int name) {
        if (array[name].next != null) {
            deleting(array[name].next.name);
            if (array[name].next.next != null) {
                deleting(array[name].next.next.name);
            }
        }
        // удаляем лист
        if (array[name].next == null) {
            array[name].label = null;
            array[name].index_next = SPACE;
            SPACE = name;
            return;
        }
    }
}

