package mapLinkedList;
import linkedListList1.PostcardObject;
import postcard.Postcard;

public class Map {
    private PostcardObject head;

    public Map(){
        Postcard kasha = new Postcard(new char[]{'k', 'a', 's', 'h', 'a'}, new char[]{'N', 'e', 'w', '-', 'Y', 'o', 'r', 'k'});
        head = new PostcardObject(kasha);
    }

    public void makeNull(){
        head = null;
    }

    //ищет позицию ключа d
    private PostcardObject locateD(char[] d){
        PostcardObject current = head;
        while (current != null){
            if (current.cardObject.adress != d){
                return current;
            }
            current = current.next;
        }
        return null;
    }
    public void assign(char[] d, char[] r){
        //есть еще идея: если найдется имя, то удалить карточку и создать тупо новую с новым адресом
        PostcardObject locatedD = locateD(d);

        if (locatedD != null){
            locatedD = locatedD.next;
        }
        Postcard x = new Postcard(d, r);
        PostcardObject obj = new PostcardObject(x);
        obj.next = head;
        head = obj;
//        1. ищу имя Д.
//        2. если оно есть, то заменяю в нем адрес. Либо удаляю его и создаю новую карточку.
        //3. если нет, то создаю новую карточку просто и пихаю в начало
    }

    //Область определения d - имя
    //Область значений r - адрес
    public boolean compute(char[] d, char[] r){
        PostcardObject locatedD = locateD(d);

        if (locatedD != null){
            r = locatedD.cardObject.adress;
            return true;
        }
        return false;
    }

    public void print(){
        PostcardObject current = head;
        while (current != null){
            current.cardObject.print_postcard();
            current = current.next;
        }
    }

//    M – отображение, d – элемент из области определения, r – элемент из области
//значений.
//        Операции (указаны все и явные, и неявные параметры):
//    MAKENULL(M) – делает отображение M пустым.
//    ASSIGN(M, d, r) – делает M(d) равным r независимо от того, как M(d) было
//    определено ранее.
//    COMPUTE(M, d, r) – возвращает значение true и присваивает переменной r
//    значение M(d), если последнее определено, и возвращает false в противном
//    случае.
}
