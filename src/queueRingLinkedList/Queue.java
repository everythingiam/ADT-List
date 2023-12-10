package queueRingLinkedList;
import linkedListList1.Position;
import postcard.Postcard;
import linkedListList1.PostcardObject;
import exception.MyException;

public class Queue {
    PostcardObject head;
    PostcardObject tail;
    private int count = 0;
    private int MAX = 10;
    public Queue(){
        head = null;
        tail = null;
    }

    public void makeNull(){
        head = null;
        tail = null;
        count = 0;
    }

    public Postcard front(){
        if (empty()){
            throw new MyException("Stack is empty");
        }
        return head.cardObject;
    }
    public void enqueue(Postcard x){
        PostcardObject xx = new PostcardObject(x);
        if (empty()) {
            xx.next = xx;
            head = xx;
            tail = xx;
        } else {
            tail.next = xx; // связываем текущий последний элемент с новым узлом
            xx.next = head; // новый узел теперь становится последним и связывается с головой
            tail = xx; // обновляем указатель на последний элемент
        }

        count++;
    }
    public Postcard dequeue(){
        if (empty()){
            throw new MyException("Stack is empty");
        }
        PostcardObject tmp = head;
        head = head.next;
        tail.next = head;
        count--;
        return tmp.cardObject;
    }

    public boolean empty(){
        return head == null;
    }
    public boolean full(){
        return count >= MAX;
    }
    public void print(){
        if (empty()) {
            System.out.println("Queue is empty");
            return;
        }
        PostcardObject current = head;
        do {
            current.cardObject.print_postcard();
            current = current.next;
        } while (current != head);
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
