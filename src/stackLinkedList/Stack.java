package stackLinkedList;
import postcard.Postcard;
import linkedListList1.PostcardObject;
import exception.MyException;

public class Stack {
    private PostcardObject head;
    private int count = 0;
    private int MAX = 10;

    public Stack(){
        head = null;
    }

    public void makeNull(){ //есть
        head = null;
        count = 0;
    }
    public boolean empty(){ //есть
        return head == null;
    }
    public boolean full(){
        return count >= MAX;
    }
    public Postcard top(){ //есть
        if (empty()){
            throw new MyException("Stack is empty");
        }
        return head.cardObject;
    }

   public Postcard pop(){ //есть
       if (empty()){
           throw new MyException("Stack is empty");
       }
        PostcardObject tmp = head;
        head = head.next;
        count--;
        return tmp.cardObject;
   }
    public void push(Postcard x){ //есть
//        if (head == null){
//            head = new PostcardObject(x);
//            return;
//        }
        PostcardObject obj = new PostcardObject(x);

        obj.next = head;
        head = obj;

        count++;
    }

    public void print(){ //есть
        if (empty()) {
            System.out.println("Stack is empty");
            return;
        }

        PostcardObject current = head;
        while (current != null){
            current.cardObject.print_postcard();
            current = current.next;
        }
    }

    //    S – стек, x – элемент.
//            Операции (указаны все и явные, и неявные параметры):
//    MAKENULL(S) – делает стек пустым.
//            TOP(S) – возвращает элемент (копия) из вершины стека S.
//    POP(S) – удаляет элемент из вершины стека S, и возвращает его в качестве
//результатата.
//        PUSH(S, x) – вставляет элемент x в вершину стека S.
//            EMPTY(S) – возвращает значение true, если стек S пустой, и значение false в
//    противном случае.
//    FULL(S) – возвращает значение true, если стек S полный, и значение false в
//    противном случае.
}
