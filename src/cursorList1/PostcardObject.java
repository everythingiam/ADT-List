package cursorList1;
import postcard.Postcard;

public class PostcardObject {
    public Postcard cardObject;
    public int next;

    public PostcardObject(Postcard p){
        cardObject = p;
        next = -1;
    }
}
