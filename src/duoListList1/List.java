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

    public static void initCurosor(){
    }

    public PostcardObject getPrevious(PostcardObject postcard){ //есть
        PostcardObject current = head;
        PostcardObject previous = null;
        while (current != null){
            if (postcard == current){
                return previous;
            }
            previous = current;
            current = current.next;
        }
        return null;
    }
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
        //проверка на наличие позиции
        if (pos == null) {
            return;
        }
        //вставка в пустой список:
        if (head == null) {
            head = new PostcardObject(x);
            tail = head;
            return;
        }
        //вставка в голову:
        if (pos.p == head){
            PostcardObject tmp = new PostcardObject(head.cardObject);
            if (head == tail){
                tail = tmp;
            } else{
                head.next.prev = tmp;
            }
            tmp.next = head.next;
            head.cardObject = x;
            tmp.prev = tail;
            head.next = tmp;
            return;
        }

        //вставка в конец
        if (pos.p == tail){
            PostcardObject tmp = new PostcardObject(tail.cardObject);
            tail.next = tmp;
            tail.cardObject = x;
            tmp.prev = tail;
            tail = tmp;
            return;
        }

        //вставка в позицию после последнего
        if (pos.p == null) {
            PostcardObject xx = new PostcardObject(x);
            xx.prev = tail;
            tail.next = xx;
            tail = xx;
            return;
        }

        PostcardObject previous = getPrevious(pos.p);
        //вставка в середину
        if (previous != null){
            PostcardObject tmp = new PostcardObject(pos.p.cardObject);
            tmp.next = pos.p.next;
            tmp.prev = pos.p;
            pos.p.cardObject = x;
            pos.p.next = tmp;
        }
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
        if (isInList(pos.p)){
            return pos.p.cardObject;
        } //здесь тоже нормальную порверук сделай
        throw new MyException("position is out of bounds");
    }

    public Position delete (Position pos){ //есть
//        1.Если позиции нет
        if (pos.p == null){
            return pos;
        }
        if(!isInList(pos.p)){
            return pos;
        }
//                удаление из головы
//        1. если позиция голова, то
//                2. если позивия еще и хвост, то удаляем единственный элемент (зануляем их)
//        3. голова = голова.next
//            4. предудщий за головой = null
//                5. вернуть позицию головы
        if (pos.p == head){
            if (pos.p == tail){
                head = null;
                tail = null;
                return new Position(null);
            }
            head = head.next;
            head.prev = null;
            return new Position(head);
        }
//        удаление с конца
//                1. если позиция это хвост, то
//                2. хвосту присваем ссылку на предыдущий
//                3. а сылка на следующий null
//                4. вернуть null
        if (pos.p == tail){
            tail = tail.prev;
            tail.next = null;
            return new Position(null);
        }

        pos.p.prev.next = pos.p.next;
        pos.p.next.prev = pos.p.prev;
        return new Position(pos.p.prev.next);
    }
    //Возвращает следующую за pos позицию
    public Position getNext (Position pos){ //есть
//        1. если позиция есть, и
//                2. если она еще и хвост, то вернуть пощицию в null
//            3. иначе вернуть следующую позицию
        if (isInList(pos.p)){
            if (pos.p == tail){
                return new Position(null);
            } else
            return new Position(pos.p.next);
        }
        //всё-таки поменять проверку с гетпревиус на просто изИнЛист
        throw new MyException("position out of bounds");
    }

    public Position getPrevious(Position pos){ //есть
        PostcardObject previous = getPrevious(pos.p);
        if (previous != null){
            return new Position(previous);
        }
//        1. если позивия есть, и
//                2. если предыдущая за ней не null, то вернуть предыдущую позицию
        throw new MyException("Position is out of bounds");
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
            System.out.println();
        }

    }
    public boolean arePosEqual(Position a, Position b){
        return a.p == b.p;
    }
}
