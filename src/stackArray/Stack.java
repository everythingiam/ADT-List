package stackArray;
import arrayList1.PostcardObject;
import postcard.Postcard;
import exception.MyException;

public class Stack {
    private PostcardObject[] postcard_list;
    private int last;

    public Stack(){
        last = -1;
        postcard_list = new PostcardObject[10];
    }
    public void makeNull(){ //есть
        last = -1;
    }

    public Postcard top(){ //есть
        if (last == -1){
            throw new MyException("Stack is empty");
        }
        return postcard_list[last].cardObject;
    }

    public Postcard pop(){ //есть
        if (last == -1){
            throw new MyException("Stack is empty");
        }
        last--;
        return postcard_list[last+1].cardObject;
    }

    public void push(Postcard x){ //есть
        last++;
        postcard_list[last] = new PostcardObject(x);
    }
    public boolean empty(){ //есть
        if (last == -1){
            System.out.println("yes it is empty");
            return true;
        }
        System.out.println("no it is not empty");
        return false;
    }
    public boolean full(){ //есть
        if (last == postcard_list.length - 1){
            System.out.println("yes it is full");
            return true;
        }
        System.out.println("no it is not full");
        return false;
    }

    public void print(){ //есть
        for (int i = 0; i <= last; i++) {
            postcard_list[i].cardObject.print_postcard();
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
