package cursorList1;
import postcard.Postcard;

public class PostcardObject {
    public Postcard cardObject;
    public int next;

    public PostcardObject(Postcard p){ // конструктор элемента списка с данными
        cardObject = p;
        next = -1;
    }
    public PostcardObject(int i){ //конструктор элемента с номером следующего
        next = i;
    }
    public PostcardObject(Postcard p, int i){ // конструктор элемента списка с данными и номером следующего элемента
        next = i;
        cardObject = p;
    }
}
