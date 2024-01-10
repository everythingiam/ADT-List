package queueADTList;
//import cursorList1.List;
import postcard.Postcard;
import linkedListList1.*;
//import arrayList1.*;
//import cursorList1.*;
//import duoListList1.*;

public class Queue {
    private List L;
    public Queue(){
        L = new List();
        L.initCursor();
    }
    public void makeNull(){
        L.makeNull();
    }
    public Postcard front(){
        return new Postcard(L.retrieve(L.getFirst()));
    }

    public void enqueue(Postcard x){
        L.insert(L.getEndL(), x);
    }
    public Postcard dequeue(){
        Postcard tmp = L.retrieve(L.getFirst());
        L.delete(L.getFirst());
        return new Postcard(tmp);
    }
    public boolean empty(){return L.getFirst().equals(L.getEndL());
    }
    public boolean full(){
        return false;
    }
    public void print(){
        L.print();
    }
    //    MAKENULL(Q) – очищает очередь Q, делая ее пустой.
//            FRONT(Q) – возвращает первый элемент (копия) очереди Q.
//    DEQUEUE(Q) – удаляет первый элемент очереди Q, и возвращает его в качестве
//результатата.
//        ENQUEUE(Q, x) – вставляет элемент x в конец очереди Q.
//            EMPTY(Q) – возвращает значение true, если очередь Q пустая, и значение false в
//    противном случае.
//    FULL(Q) – возвращает значение true, если очередь Q полная, и значение false в
//    противном случае.
}
