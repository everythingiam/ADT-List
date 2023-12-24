package stackArray;
import arrayList1.PostcardObject;
import postcard.Postcard;
import exception.MyException;

public class Stack {
    private PostcardObject[] postcard_list;
    private int last;

    public Stack(){
        last = -1;
        postcard_list = new PostcardObject[20];
    }
    public void makeNull(){ //есть
        last = -1;
    }

    public Postcard top(){ //есть
        return postcard_list[last].cardObject;
    }

    public Postcard pop(){ //есть
        PostcardObject tmp = postcard_list[last];
        last--;
        return tmp.cardObject;
    }

    public void push(Postcard x){ //есть
        postcard_list[++last] = new PostcardObject(x);
    }
    public boolean empty(){ //есть
        return last == -1;
    }
    public boolean full(){ //есть
        return last == postcard_list.length - 1;
    }

    public void print(){ //есть
        for (int i = last; i >= 0; i--) {
            postcard_list[i].cardObject.print_postcard();
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
