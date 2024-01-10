package arrayList1;
import postcard.Postcard;
import exception.MyException;

public class ListTest {

    public class PostcardObjectTest{
        Postcard cardObject;

        public PostcardObjectTest(Postcard cardObject){
            this.cardObject = cardObject;
        }
    }

    public class PositionTest{
        int p;

        public PositionTest(int p){
            this.p = p;
        }
    }
    private PostcardObjectTest[] postcard_list;
    private int last;
    public ListTest(){
        postcard_list = new PostcardObjectTest[20];
        last = -1;
    }


    //Возвращает следующую за рos позицию
    public Position getNext(PositionTest pos){ //есть
        if (pos.p > last){
            throw new MyException("pos is out of bounds");
        }
        return new Position(pos.p + 1);
    }

    //Возвращает позицию после последнего
    public PositionTest getEndL(){ //есть
        return new PositionTest(last + 1);
    }

    //Возвращает первую позицию
    public PositionTest getFirst(){ //есть
        if (last == -1) {
            throw new MyException("empty list");
        }
        return new PositionTest(0);
    }

    public PositionTest getLast(){
        if (last == -1) {
            throw new MyException("empty list");
        }
        return new PositionTest(last);
    }

    //Возвращает позицию перед pos.
    public PositionTest getPrevious(Position pos){ //есть
        if (pos.p > last) {
            throw new MyException("pos is out of bounds");
        }
        return new PositionTest(pos.p - 1);
    }

    //Возвращает элемент в позиции pos
    public Postcard retrieve(Position pos){ //есть
        if (pos.p > last || last == -1){
            throw new MyException("empty list or pos is out of bounds");
        }
        return postcard_list[pos.p].cardObject;
    }

    //Вставляет элемент х в позицию pos
    public void insert(Position pos, Postcard x){ //есть
        if (pos.p > last){
            return;
        }
        last++;
        for (int i = last; i > pos.p; i--) {
            postcard_list[i-1] = postcard_list[i];
        }
        postcard_list[pos.p] = new PostcardObjectTest(x);
    }

    //Делает список пустым
    public void makeNull() { //есть
        last = -1;
    }

    //Удаляет элемент в позиции pos
    public void delete(Position pos){ //есть
        if (pos.p > last){
            throw new MyException("pos is out of bounds");
        }
        for (int i = pos.p; i < last; i++) {
            postcard_list[i - 1] = postcard_list[i];
        }
        last--;
    }

    //Возвращает позицию
    public PositionTest locate(Postcard x){ //есть
        if (last == -1) {
            throw new MyException("empty list");
        }
        for (int i = 0; i <= last; i++) {
            if (postcard_list[i].cardObject.isDataEqual(x))
                return new PositionTest(i);
        }
        return new PositionTest(last + 1);
    }

    //Печатает список
    public void print(){ //есть
        for (int i = 0; i < last; i++) {
            postcard_list[i].cardObject.print_postcard();
        }
    }


}

