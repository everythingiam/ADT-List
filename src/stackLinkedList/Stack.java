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
        if (head == null){
            System.out.println("yes it is empty");
            return true;
        }
        System.out.println("no it is not empty");
        return false;

        //return head == null - короткая форма
    }
    public boolean full(){
        if (count >= MAX){
            System.out.println("yes it is full");
            return true;
        }
        System.out.println("no it is not full");
        return false;
//        return count == MAX; - краткая форма
    }
    public Postcard top(){ //есть
        return head.cardObject;
    }

   public Postcard pop(){ //есть
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
        PostcardObject current = head;
        while (current != null){
            current.cardObject.print_postcard();
            current = current.next;
            System.out.println();
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
