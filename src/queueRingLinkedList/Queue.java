package queueRingLinkedList;
import linkedListList1.Position;
import postcard.Postcard;
import linkedListList1.PostcardObject;
import exception.MyException;

public class Queue {

    PostcardObject tail;

    public Queue(){
        tail = null;
    }

    public void makeNull(){
        tail = null;
    }

    public Postcard front(){
        return new Postcard(tail.next.cardObject);
    }
    public void enqueue(Postcard x){
        if (tail == null){
            tail = new PostcardObject(x);
            tail.next = tail;
        } else {
            PostcardObject tmp = new PostcardObject(x);
            tmp.next = tail.next;
            tail.next = tmp;
            tail = tmp;
        }

    }
    public Postcard dequeue(){
        PostcardObject tmp = tail.next;
        if (tail.next == tail){
            tail = null;
        } else {
            tail.next = tail.next.next;
        }
        return tmp.cardObject;
    }

    public boolean empty(){
        return tail == null;
    }
    public boolean full(){
        return false;
    }
    public void print(){
        PostcardObject current = tail.next;
        do {
            current.cardObject.print_postcard();
            current = current.next;
        } while (current != tail.next);
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
