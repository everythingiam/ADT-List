package linkedListList1;

import postcard.Postcard;
import exception.MyException;

import java.awt.*;

public class List {
    private PostcardObject head;

    //конструктор, голова изначално
    public List(){
        head = null;
    }

    public static void initCursor(){
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


    //Возвращает ссылку на последний элемент
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
    private PostcardObject getPrevious(PostcardObject postcard){ //есть
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
        //проверка на наличие позиции
        //вставка в позицию после последнего
        //вставка в пустой лист

        if (pos.p == null) {
            if (head == null){
                head = new PostcardObject(x);
                return;
            }
            else {
                PostcardObject last = last();
                last.next = new PostcardObject(x);
                return;
            }
        }

        //вставка в голову
        if (pos.p == head){ //1. если позиция после последнего. 2 варианта : когда хед равен нулл, и когда не равен
            PostcardObject tmp = new PostcardObject((head.cardObject));
            tmp.next = head.next;
            head.cardObject = x;
            head.next = tmp;
            return;
        }

        //вставка в середину
            PostcardObject tmp = new PostcardObject(pos.p.cardObject);
            tmp.next = pos.p.next;
            pos.p.cardObject = x;
            pos.p.next = tmp;
    }

    //Делает список пустым
    public void makeNull() { //есть
        head = null; //обнулить ссылку на head
    }

    
    //Удаляет элемент в позиции pos
    public void delete(Position pos){ //есть
        //если позиции нет или список пуст
        if (pos.p == null || head == null)
            return;
        //удалить из головы
        if (pos.p == head){
            head = head.next;
            return;
        }

        //если позиция не в списке
        PostcardObject previous = getPrevious(pos.p);
        if (previous == null){
            return;
        }
        //удаление с конца или середины
        previous.next = pos.p.next;
        pos.p = pos.p.next;
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
        return new Position(null);
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

