package mapADTList;
import postcard.Postcard;
//import arrayList1.*;
//import linkedListList1.*;
import duoListList1.*;
//import cursorList1.*;
public class Map {
    List L;

    public Map(){
        L = new List();
        L.initCursor();
        Postcard dasha = new Postcard(new char[]{'D', 'a', 's', 'h', 'a'}, new char[]{'M', 'o', 's', 'c', 'o', 'w'});
        L.insert(L.getEndL(), dasha);
    }

    public void makeNull(){
        L.makeNull();
    }

    //ищет позицию ключа d
    public Position locateD(char[] d){
        Position q = L.getFirst();
        while (!q.arePosEqual(L.getEndL())){
            if (L.retrieve(q).equalToName(d)){
                return q;
            }
            q = L.getNext(q);
        }
        return null;
    }
    public void assign(char[] d, char[] r){
        //есть еще идея: если найдется имя, то удалить карточку и создать тупо новую с новым адресом
        Position locatedD = locateD(d);
        if (locatedD != null){
            L.delete(locatedD);
        }

        L.insert(L.getEndL(), new Postcard(d, r));
//        1. ищу имя Д.
//        2. если оно есть, то заменяю в нем адрес. Либо удаляю его и создаю новую карточку.
        //3. если нет, то создаю новую карточку просто и пихаю в начало
    }

    //Область определения d - имя
    //Область значений r - адрес
    public boolean compute(char[] d, char[] r){
        Position locatedD = locateD(d);
        if (locatedD != null){
            Postcard newAdress = L.retrieve(locatedD); //сделать отдельно метод копирования массива в r
            newAdress.copy_array(r);
            return true;
        }
        return false;
    }

//    public void copy_array(char[] r, char[] newArray){
////        char[] newArray = new char[r.length];
////        r = new char[newArray.length];
//        for (int i = 0; i < r.length; i++) {
//            r[i] = newArray[i];
//        }
////        return newArray;
//    }

    public void print(){
        L.print();
    }
    public void printArray(char[] array){
        for (int i = 0; i < array.length; i++) {
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
