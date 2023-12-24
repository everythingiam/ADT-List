package queueArray;
import arrayList1.PostcardObject;
import postcard.Postcard;
import exception.MyException;

public class Queue {
    private int last;
    private int first;
    private PostcardObject[] postcard_list;


    public Queue(){
        postcard_list = new PostcardObject[20];
        last = postcard_list.length - 1;
        first = 0;
    }

    public void makeNull(){
        last = postcard_list.length - 1; //ласт МАКС - 1
        first = 0;
    }
    public Postcard front(){
        return postcard_list[first].cardObject;
    }
    public Postcard dequeue(){ //извлечь из начала очереди
        PostcardObject tmp = postcard_list[first];
        first++;
        return tmp.cardObject;
    }
    public void enqueue(Postcard x){ //добавить в конец очереди
        last++;
        postcard_list[last] = new PostcardObject(x);
    }

    public boolean empty(){
        return last == -1;
    }
    public boolean full(){
        return postcard_list.length == last - 1;
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
