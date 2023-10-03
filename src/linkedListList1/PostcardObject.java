package linkedListList1;
import postcard.Postcard;

//Из объектов этого класса будет создаваться список на связном списке.
public class PostcardObject {
    public Postcard cardObject;
    public PostcardObject next;

    public PostcardObject(Postcard postcard){
        this.cardObject = postcard;
    }
}
