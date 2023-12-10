package queueArray;
import arrayList1.PostcardObject;
import postcard.Postcard;
import exception.MyException;

public class Queue {
    private int last;
    private int first;
    private int count;
    private PostcardObject[] postcard_list;
    private int MAX = 20;

    public Queue(){
        postcard_list = new PostcardObject[MAX];
        last = -1;
        first = 0;
        count = 0;
    }

    public void makeNull(){
        last = -1;
        first = 0;
        count = 0;
    }
    public Postcard front(){
        if (empty()){
            throw new MyException("Queue is empty");
        }

        return postcard_list[first].cardObject;
    }
    public Postcard dequeue(){ //извлечь из начала очереди
        if (empty()){
            throw new MyException("Queue is empty");
        }
        PostcardObject tmp = postcard_list[first++];

        if (first == MAX) { //циклический перенос
            first = 0;
        }
        count--;
        return tmp.cardObject;
    }
    public void enqueue(Postcard x){ //добавить в конец очереди
        if (last == MAX - 1){ //циклический перенос
            last = -1;
        }
        last++;

        postcard_list[last] = new PostcardObject(x);
        count++;
    }

    public boolean empty(){
        if (count == 0){
            return true;
        }
        return false;
    }
    public boolean full(){
        if (count >= MAX){
            return true;
        }
        return false;
    }
    public void print(){
        for (int i = first; i <= last; i++) {
            postcard_list[i].cardObject.print_postcard();
        }
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
