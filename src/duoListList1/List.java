package duoListList1;
import postcard.Postcard;
import exception.MyException;

public class List {
    private PostcardObject head;
    private PostcardObject tail;

    //Возвращает позицию после последнего
    public Position getEndL() {  //есть
        return new Position(null);
    }

    public static void initCursor(){
    }

    //Проверяет, есть ли в списке карточка
    public boolean isInList(PostcardObject postcard){
        PostcardObject current = head;
        while (current != null){
            if (postcard == current){
                return true;
            }
            current = current.next;
        }
        return false;
    }
    //Вставляет элемент х в позицию pos
    public void insert(Position pos, Postcard x){ //есть
        if (pos.p == null){
            //вставка в голову
            if (head == null) {
                head = new PostcardObject(x);
                tail = head;
                return;
            }
            //вставка в позицию после последнего
            else {
                PostcardObject xx = new PostcardObject(x);
                xx.prev = tail;
                tail.next = xx;
                tail = xx;
                return;
            }
        }
        //если позиция не определена, то я вставляю после последнего.
        //варианты: 1, 2. проверка pos.p равен null. 3 это в тэил вствка,
        // 4 общий случай поиском (куда-нибудь кроме хвоста)

        //вставка в конец
        if (pos.p == tail){
            PostcardObject tmp = new PostcardObject(tail.cardObject);
            tail.next = tmp;
            tail.cardObject = x;
            tmp.prev = tail;
            tail = tmp;
            return;
        }

        //вставка в середину
        if (!isInList(pos.p)){
            return;
        }

        PostcardObject tmp = new PostcardObject(pos.p.cardObject);
        tmp.next = pos.p.next;
        tmp.prev = pos.p;
        pos.p.cardObject = x;
        pos.p.next = tmp;

    }

    public Position locate(Postcard x){ //есть
//        1. Пройтись по всем списку (через цикл, пока текущий не опустошится)
//        2. Если встретился объект х - вернуть позицию (сравнение через метод isEqual)
//            3. если нет - вернуть null
        PostcardObject current = head;
        while (current != null){
            if (current.cardObject.isDataEqual(x)){
                return new Position(current);
            }
            current = current.next;
        }
        return new Position(null);
    }

    public Postcard retrieve (Position pos){ //есть
//        1. если есть позиция, то вернуть объект из нее
//                2. если ее нет - выбросить исключение
        if (pos.p == null || !isInList(pos.p)){
            throw new MyException("position is out of bounds");
        }
        return new Postcard(pos.p.cardObject);
    }

    public void delete (Position pos){ //есть
//        1.Если позиции нет
        if (pos.p == null || head == null){ //проверить хед = 0 (пустой ли список) то ртурн
            return;
        }

        if (pos.p == head){
            if (pos.p == tail){
                head = null;
                tail = null;
                return;
            }
            head = head.next;
            head.prev = null;
            return;
        }
//        удаление с конца
//                1. если позиция это хвост, то
//                2. хвосту присваем ссылку на предыдущий
//                3. а сылка на следующий null
//                4. вернуть null
        if (pos.p == tail){
            tail = tail.prev;
            tail.next = null;
            pos.p = pos.p.next;
            return;
        }

        pos.p.prev.next = pos.p.next;
        pos.p.next.prev = pos.p.prev;
        pos.p = pos.p.next;
    }
    //Возвращает следующую за pos позицию
    public Position getNext (Position pos){ //есть
//        1. если позиция есть, и
//                2. если она еще и хвост, то вернуть пощицию в null
//            3. иначе вернуть следующую позицию
        if (pos.p == null || !isInList(pos.p)){
            throw new MyException("position out of bounds");
        }

        if (pos.p == tail)
            return new Position(null);

        return new Position(pos.p.next);
    }

    //Возвращает позицию предыдущего
    public Position getPrevious(Position pos){ //есть
        if (pos.p == null || !isInList(pos.p) || pos.p == head){
            throw new MyException("position out of bounds");
        }
        return new Position(pos.p.prev);
    }

    //делает список пустым
    public void makeNull(){ //есть
        this.head = null;
        this.tail = null;
    }

    //Возвращает первую позицию
    public Position getFirst(){ //есть
        return new Position(this.head);
    }

    public void print(){ //есть
        //проходимя по всему списку и печатаем поэлементно
        PostcardObject current = head;
        while (current != null) {
            current.cardObject.print_postcard();
            current = current.next;
        }

    }

}
