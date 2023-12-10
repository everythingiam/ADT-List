package stackADTList;
//import cursorList1.List;
import postcard.Postcard;
import linkedListList1.*;
//import arrayList1.*;
//import cursorList1.*;
//import duoListList1.*;
import exception.MyException;

public class Stack {

    private List L;
    private int count;
    private int MAX = 10;
    public Stack(){
        L = new List();
        L.initCursor();
        count = 0;
    }

    public void makeNull(){
        L.makeNull();
        count = 0;
    }
    public Postcard top(){
        if (empty()){
            throw new MyException("Stack is empty");
        }
        return L.retrieve(L.getFirst());
    }
    public Postcard pop(){
        if (empty()){
            throw new MyException("Stack is empty");
        }
        Postcard tmp = L.retrieve(L.getFirst());
        L.delete(L.getFirst());
        count--;
        return tmp;
    }
    public void push(Postcard x){
        L.insert(L.getFirst(), x);
        count++;
    }
    public boolean empty() {
        return count == 0;
        //return L.getFirst().equals(L.getEndL());
    }

    public boolean full(){

        return count >= MAX;
    }
    public void print(){
        if (empty()) {
            System.out.println("Stack is empty");
            return;
        }
        L.print();
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
