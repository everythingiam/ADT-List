package queueArray;
import arrayList1.PostcardObject;
import postcard.Postcard;

public class Queue {
    private int front;
    private int rear;
    private int SIZE = 20;
    private PostcardObject[] postcard_list;


    public Queue(){
        postcard_list = new PostcardObject[SIZE];
        rear = SIZE - 1;
        front = 0;
    }

    public void makeNull(){
        rear = SIZE - 1;
        front = 0;
    }
    public Postcard front(){
        return new Postcard(postcard_list[front].cardObject);
    }
    public Postcard dequeue(){ //извлечь из начала очереди
        PostcardObject tmp = postcard_list[front];
        front = shift(front);
        return tmp.cardObject;
    }

    public void enqueue(Postcard x){ //добавить в конец очереди
        rear = shift(rear);
        postcard_list[rear] = new PostcardObject(x);
    }
//циклический массив
    public int shift(int num){
        return (num + 1) % SIZE;
    }
    public boolean empty(){
        return front == shift(rear);
    }
    //сделать отдеьлно метод для сдвига и дважды вызвать его на фуле
    public boolean full(){
        return front == shift(shift(rear));
    }
    public void print() {
        for (int i = front; i < shift(rear); i++) {
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

    //    public void print(){
//        int i = front;
//        int en = shift(rear);
//        while (i != en){
//            postcard_list[i].cardObject.print_postcard();
//            i = shift(i);
//        }
//    }
}
