package duoListList1;

import postcard.Postcard;

public class PostcardObject {
    public Postcard cardObject;
    public PostcardObject next;
    public PostcardObject prev;

    public PostcardObject(Postcard postcard){
        next = null;
        prev = null;
        this.cardObject = postcard;
    }
    public PostcardObject(PostcardObject x){
        cardObject = x.cardObject;
        next = null;
    }
}