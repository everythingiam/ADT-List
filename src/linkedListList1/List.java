package linkedListList1;

import postcard.Postcard;
import exception.MyException;

public class List {
    private PostcardObject head; //массив

    //конструктор, голова изначално
    public List(){
        head = null;
    }

    public static void initCurosor(){
    }
    //Возвращает следующую за рos позицию
    public Position getNext(Position pos){ //есть
        //если список не пустой, вернуть следующий.
        //если элемент первый, вернуть head.next
        //исключение, если нет следующей
        if (pos.p == head)
            return new Position(head.next);

        PostcardObject previous = getPrevious(pos.p);
        if (previous != null){
            previous = previous.next;
            return new Position(previous.next);
        }
        throw new MyException("Position is out of bounds!");
    }

    //Возвращает позицию после последнего 
    public Position getEndL(){ //есть
        return new Position(null);
        }
    
    //Возвращает первую позицию
    public Position getFirst(){ //есть
        // возвращаем голову 
        return new Position(this.head);
    }

    //Возвращает последнюю позицию
    public Position getLast(){
        PostcardObject last = last();
        return new Position(last);
    }
    //Возвращает последний элемент
    private PostcardObject last() { //есть
        PostcardObject current = head;
        PostcardObject previous = null;
        while (current != null){
            previous = current;
            current = current.next;
        }
        return previous;
    }

    //Возвращает предыдущий элемент для переданного в параметнр
    public PostcardObject getPrevious(PostcardObject postcard){ //есть
        PostcardObject previous = null;
        PostcardObject current = head;
        while (current != null){
            if(current == postcard){
                return previous;
            }
            previous = current;
            current = current.next;
        }
        return null;
    }
    //Возвращает позицию перед pos.
    public Position getPrevious(Position pos){ //есть
        // если такая позиция есть и она не первая, то
        // создать переменную previous и впихнуть в неё head.
        // и пока previous.next не станет пустым,
        // то проходить через список.
        // дойдет до конца - вернуть previous
        //вернуть исключен е если нет пердыдущей
        PostcardObject previous = getPrevious(pos.p);
        if (previous != null){
            return new Position(previous);
        }
        throw new MyException("Position is out of bounds");
    }
    
    //Возвращает элемент в позиции pos
    public Postcard retrieve(Position pos){ //есть
        //проверять наличием предыдущего элемента
        //если такая позиция есть, вернуть объект из неё.
        //если нет - выбросить исключение
        PostcardObject previous = getPrevious(pos.p);
        if ((pos.p == head) || previous != null) {
            return pos.p.cardObject;
        }
        throw new MyException("Position is out of bounds");
    }

    //Вставляет элемент х в позицию pos
    public void insert(Position pos, Postcard x) { //есть
    //вставка в пустой лист
        if (head == null){
            head = new PostcardObject(x);
            return;
        }
        //вставка в голову
        if (pos.p == head){
            PostcardObject tmp = new PostcardObject((head.cardObject));
            tmp.next = head.next;
            head.cardObject = x;
            head.next = tmp;
            return;
        }
        //вставка в позицию после последнего
        if (pos.p == null){
            PostcardObject last = last();
            last.next = new PostcardObject(x);
            return;
        }
        //вставка в середину
        if (getPrevious(pos.p) != null) {
            PostcardObject tmp = new PostcardObject(pos.p.cardObject);
            tmp.next = pos.p.next;
            pos.p.cardObject = x;
            pos.p.next = tmp;
        }
    }

    //Делает список пустым
    public void makeNull() { //есть
        head = null; //обнулить ссылку на head
    }

    
    //Удаляет элемент в позиции pos
    public Position delete(Position pos){ //есть
        //если позиции нет
        if (pos.p == null)
            return pos;
        //удалить из головы
        if (pos.p == head){
            head = head.next;
            return new Position(head);
        }

        //если позиция не в списке
        PostcardObject previous = getPrevious(pos.p);
        if (previous == null) {
            return pos;
        }

        //удаление из конца или середины
        previous.next = pos.p.next;
        return new Position(previous.next);
    }
    public boolean arePosEqual(Position a, Position b){
        return a.p == b.p;
    }

    //Возвращает позицию
    public Position locate(Postcard x){
        // пройтись по всему списку
        // если встретился элемент - вернуть его позицию
        // если не встречается - вернуть end (null)
        PostcardObject current = head;
        while (current != null){
            if (current.cardObject.isDataEqual(x)){
                return new Position(current);
            }
            current= current.next;
        }
        return null;
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
}

