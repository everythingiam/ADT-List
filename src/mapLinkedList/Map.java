package mapLinkedList;
import linkedListList1.PostcardObject;
import postcard.Postcard;

public class Map {
    private PostcardObject head;

    public Map(){
        Postcard dasha = new Postcard(new char[]{'D', 'a', 's', 'h', 'a'}, new char[]{'M', 'o', 's', 'c', 'o', 'w'});
        head = new PostcardObject(dasha);
    }

    public void makeNull(){
        head = null;
    }

    //ищет позицию ключа d
    private PostcardObject locateD(char[] d){ //ищет ключ d
        PostcardObject current = head;
        while (current != null){
            if (!current.cardObject.equalToName(d)){
                return current;
            }
            current = current.next;
        }
        return null;
    }
    public void assign(char[] d, char[] r){
        PostcardObject locatedD = locateD(d);
        if (locatedD != null){
            head = head.next;
            copy_array(r, locatedD.cardObject.adress);
        }
        Postcard x = new Postcard(d, r);
        PostcardObject obj = new PostcardObject(x);
        obj.next = head;
        head = obj;
    }

    //Область определения d - имя
    //Область значений r - адрес
    public boolean compute(char[] d, char[] r){
        PostcardObject locatedD = locateD(d);

        if (locatedD != null){
            char[] newArray = locatedD.cardObject.adress;
            copy_array(r, newArray);
            return true;
        }
        return false;
    }
    public void copy_array(char[] r, char[] newArray){ //копирует массив в массив
        for (int i = 0; i < r.length; i++) {
            r[i] = newArray[i];
        }
    }

    public void print(){ //ппечать отображкения
        PostcardObject current = head;
        while (current != null){
            current.cardObject.print_postcard();
            current = current.next;
        }
    }
    public void printArray(char[] array){
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '\u0000'){
                break;
            }
            System.out.print(array[i]);
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
