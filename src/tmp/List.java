package tmp;
import postcard.Postcard;
import exception.MyException;
public class List {
    private static PostcardObject[] postcard_list;
    private static int SPACE;
    private int head;

    public static void initCursor() {
        postcard_list = new PostcardObject[50];
        SPACE = 0;
        for (int i = 0; i < postcard_list.length - 1; i++) {
            postcard_list[i] = new PostcardObject(i + 1);
        }
        postcard_list[postcard_list.length - 1] = new PostcardObject(-1);
    }

    public List() {
        head = -1;
    }

    private int previous(int necessary) {
        int prev = -1;
        int current = head;
        while (current != -1) {
            if (postcard_list[current].equals(postcard_list[necessary])) {
                return prev;
            }
            prev = current;
            current = postcard_list[current].next;
        }
        return prev;
    }

    private int last() {
        int prev = -1;
        int current = head;
        while (current != -1) {
            prev = current;
            current = postcard_list[current].next;
        }
        return prev;
    }

    public Position getEndL() {
        return new Position(postcard_list.length - 1);
    }

    public void insert(Position position, Postcard x) {
        if (head == -1) {
            head = SPACE;
            SPACE = postcard_list[SPACE].next;
            postcard_list[head] = new PostcardObject(x);
            return;
        }
        if (position.p == head) {
            int pos = SPACE;
            SPACE = postcard_list[SPACE].next;
            postcard_list[pos] = new PostcardObject(postcard_list[head].cardObject, postcard_list[head].next);
            postcard_list[head].cardObject = x;
            postcard_list[head].next = pos;
            return;
        }
        if (position.p == -1) {
            int pos = SPACE;
            SPACE = postcard_list[SPACE].next;
            postcard_list[pos] = new PostcardObject(x, -1);
            int prev = last();
            postcard_list[prev].next = pos;
            return;
        }
        if (previous(position.p) != -1) {
            int pos = SPACE;
            SPACE = postcard_list[SPACE].next;
            postcard_list[pos] = new PostcardObject(postcard_list[position.p].cardObject, postcard_list[position.p].next);
            postcard_list[position.p].cardObject = x;
            postcard_list[position.p].next = pos;
            return;
        }
    }

    public Position locate(Postcard x) {
        PostcardObject xx = new PostcardObject(x);
        int i = head;
        while (i != -1) {
            if (postcard_list[i].equals(xx)) {
                return new Position(i);
            }
            i = postcard_list[i].next;
        }
        return new Position(postcard_list.length - 1);
    }

    public Postcard retrieve(Position position) {
        if (position.p == head || previous(position.p) != -1) {
            return postcard_list[position.p].cardObject;
        }
        throw new MyException("position is out of bounds");
    }

    public Position delete(Position position) {
        if (position.p == head) {
            int pos = head;
            head = postcard_list[head].next;
            postcard_list[pos].next = SPACE;
            SPACE = pos;
            return new Position(head);
        }
        int prev = previous(position.p);
        if (prev != -1) {
            if (position.p == last()) {
                postcard_list[prev].next = -1;
                postcard_list[position.p].next = SPACE;
                SPACE = position.p;
                return new Position(-1);
            }
            postcard_list[prev].next = postcard_list[position.p].next;
            postcard_list[position.p].next = SPACE;
            SPACE = position.p;
            return new Position(postcard_list[prev].next);
        }
        return position;
    }

    public Position getNext(Position position) {
        if (position.p == last()) {
            return new Position(-1);
        }
        if (position.p == head || previous(position.p) != -1) {
            return new Position(postcard_list[position.p].next);
        }
        throw new MyException("position is out of bounds");
    }

    public Position getPrevious(Position position) {
        int prev = previous(position.p);
        if (prev != -1) {
            return new Position(prev);
        }
        throw new MyException("position is out of bounds");
    }

    public void makenull() {
        postcard_list[last()].next = SPACE;
        SPACE = head;
        head = -1;
    }

    public Position getFirst() {
        return new Position(head);
    }

    public void print() {
        int current = head;
        while (current != -1) {
            postcard_list[current].cardObject.print_postcard();
            current = postcard_list[current].next;
        }
        System.out.println();
    }
    public boolean arePosEqual(Position a, Position b){
        return a.p == b.p;
    }
}


