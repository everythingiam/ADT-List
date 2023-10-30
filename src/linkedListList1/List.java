package linkedListList1;

import postcard.Postcard;
import exception.MyException;

public class List {
    private PostcardObject head; //массив

    //конструктор, массив объектов
    public List(){
        head = null;
    }

    //Возвращает следующую за рos позицию
    public Position getNext(Position pos){
        //если список не пустой, вернуть следующий.
        //если элемент первый, вернуть head.next
        if (pos.p == head)
            return new Position(head.next);
        return new Position(pos.p.next);
        //return null если нет следующей 
        
    }

    //Возвращает позицию после последнего 
    public Position getEndL(){
        return new Position(null);
        }
    
    //Возвращает первую позицию
    public Position getFirst(){
        // возвращаем голову 
        return new Position(head);
    }

    //Возвращает позицию перед pos.
    public Position getPrevious(Position pos){
        PostcardObject previous = head;
        if (previous == head){
            return null;
        }
        else while (previous.next.next != null){
            previous = previous.next;
        }
        // если такая позиция есть и она не первая, то
        // создать переменную previous и впихнуть в неё head.
        // и пока previous.next не станет пустым, 
        // то проходить через список.
        // дойдет до конца - вернуть previous
        return new Position(previous);
        //вернуть null если нет пердыдущей
    }
    
    //Возвращает элемент в позиции pos
    public Postcard retrieve(Position pos){ //РАСПИСАТЬ КАК ПРОВЕРИТЬ СУЩЕСТВОВАНИЕ ПОЗИЦИИ (создать метод)
        //проверять наличием предыдущего элемента
        //если такая позиция есть, вернуть объект из неё.
        //если нет - выбросить исключение
        return pos.p.cardObject; 
    }

    //Вставляет элемент х в позицию pos
    public void insert(Position pos, Postcard x){
//        PostcardObject xx = new PostcardObject(x);
//        if (head == null){
//           head = xx;
//        }
//        // [3, 5, 1, 9, 2, 0, 5, 2,]
//        else {
//            PostcardObject current = head;
//            while (current.next != ){
//
//            }
        }
        // если список пустой, то x.next = head, a head = x <- то вообще какой-то бред
        // если не пустой, то берем предыдущий элемент 
        // делаем его текущим
        // следующий за текущим делаем x
        // сдвигаем всё вправо
        // и это тоже херня, как это вообще приняли??? что я написала


    //Делает список пустым
    public void makeNull() { //есть

        head = null; //обнулить ссылку на head
    }

    
    //Удаляет элемент в позиции pos
    public void delete(Position pos){
        
    }

    //Возвращает позицию
    public Position locate(Postcard postcard){
        PostcardObject current = head;
        // пройтись по всему списку
        // если встретился элемент - вернуть его позицию
        return new Position(current);
        // если не встречается - вернуть end (null)
    }
}

