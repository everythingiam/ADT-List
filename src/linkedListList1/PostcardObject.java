package linkedListList1;
import postcard.Postcard;

//Из объектов этого класса будет создаваться список на связном списке.
public class PostcardObject {
    public Postcard postcardOb;
    public Postcard next;

    public PostcardObject(Postcard postcard){
        this.postcardOb = postcard;
        next = null;
    }
}
