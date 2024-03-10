package tmp;
import postcard.Postcard;
import exception.MyException;
public class List {
    private static PostcardObject[] postcard_list;
    private static int SPACE;
    private int head;

    public static void initCursor() { //инициализация
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

    private int previous(int pos) { //вспомогательный
        int prev = -1;
        int current = head;
        while (current != -1) {
            if (current == pos) {
                return prev;
            }
            prev = current;
            current = postcard_list[current].next;
        }
        return -1;
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
        return new Position(-1);
    }

    public void insert(Position pos, Postcard x) { // вставляет х в позицию р
        //вставка в пустой список
        //сделать в соответсвии в связном списком

        if (pos.p == -1){
            if (head == -1) {
                //вставка в пустой лист
                head = SPACE;
                SPACE = postcard_list[SPACE].next;
                postcard_list[head] = new PostcardObject(x);
                return;
            } else {
                //вставка в конец
                int npos = SPACE;
                SPACE = postcard_list[SPACE].next;
                postcard_list[npos] = new PostcardObject(x, -1);
                int prev = last();
                postcard_list[prev].next = npos;
                return;
            }
        }

        //вставка в голову
        if (pos.p == head) {
            int npos = SPACE;
            SPACE = postcard_list[SPACE].next;
            postcard_list[npos] = new PostcardObject(postcard_list[head].cardObject, postcard_list[head].next);
            postcard_list[head] = new PostcardObject(x, npos);
            return;
        }

        //в середину
        if (previous(pos.p) == -1){
            return;
        }

        int npos = SPACE;
        SPACE = postcard_list[SPACE].next;
        postcard_list[npos] = new PostcardObject(postcard_list[pos.p].cardObject, postcard_list[pos.p].next);
        postcard_list[pos.p] = new PostcardObject(x, npos);
    }

    public Position locate(Postcard x) { // возвращает позицию объекта x. если его нет, возвращает END()
        int i = head;
        while (i != -1) {
            if (postcard_list[i].cardObject.isDataEqual(x)) {
                return new Position(i);
            }
            i = postcard_list[i].next;
        }
        return new Position(-1);
    }

    public Postcard retrieve(Position pos) {
        int prev = previous(pos.p);
        if (pos.p == head || prev != -1) {
            return new Postcard(postcard_list[pos.p].cardObject);
        }
        throw new MyException("position is out of bounds");
    }

    public void delete(Position position) { //проверить на позишен -1
        if (position.p == -1 || head == -1){
            return;
        }

        if (position.p == head) {
            int pos = head;
            head = postcard_list[head].next;
            postcard_list[pos].next = SPACE;
            SPACE = pos;
        }
        int prev = previous(position.p);
        if (prev == -1) {
            return;
        }
        postcard_list[prev].next = postcard_list[position.p].next;
        postcard_list[position.p].next = SPACE;
        SPACE = position.p;
        position.p = postcard_list[prev].next;
    }

    public Position getNext(Position position) {

        if (position.p != head){ //тут на позишен -1 проверяить
            throw new MyException("position is out of bounds");
        }
        if (previous(position.p) == 0){
            return new Position(postcard_list[position.p].next);
        }

        int previ = previous(position.p);
        if (postcard_list[previ].next == -1){
            throw new MyException("position is out of bounds");
        }
        return new Position(postcard_list[position.p].next);
    }

    public Position getPrevious(Position pos) {
        if (pos.p == -1){
            throw new MyException("position is out of bounds");
        }
        int prev = previous(pos.p);
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

}


