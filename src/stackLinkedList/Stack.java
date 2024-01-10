package stackLinkedList;
import postcard.Postcard;
import linkedListList1.PostcardObject;

public class Stack {
    private PostcardObject head;

    public Stack(){
        head = null;
    }

    public void makeNull(){ //есть
        head = null;
    }
    public boolean empty(){ //есть
        return head == null;
    }
    public boolean full(){
        return false;
    }
    public Postcard top(){ //есть
        return new Postcard(head.cardObject);
    }

   public Postcard pop(){ //есть
        PostcardObject tmp = head;
        head = head.next;
        return new Postcard(tmp.cardObject);
   }
    public void push(Postcard x){ //есть
        PostcardObject obj = new PostcardObject(x);
        obj.next = head;
        head = obj;
    }

    public void print(){ //есть
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
