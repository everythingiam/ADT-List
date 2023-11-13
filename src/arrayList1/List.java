package arrayList1;
import postcard.Postcard;
import exception.MyException;

public class List {
    private PostcardObject[] postcards_list; //массив
    private int last; //последний занятый

    //конструктор, массив объектов
    public List(){
        postcards_list = new PostcardObject[20];
        last = -1;
    }

    public static void initCurosor(){
    }

    //Возвращает следующую за рos позицию
    public Position getNext(Position pos){ //есть
        // вернуть p+1 с проверкой того, не выходит ли позиция за пределы массива.
        // если выходит - выбросить исключение.
        if (pos.p > last){
            throw new MyException("Pos is out of bounds!!!");
        }
        return new Position(pos.p + 1);
    }

    //Возвращает позицию после последнего 
    public Position getEndL(){ //есть
        return new Position(last + 1);
        }
    
    //Возвращает первую позицию
    public Position getFirst(){ //есть
        if (last == -1)
            throw new MyException("Empty list!!!");
        // если массив не пустой, то возвращаем позицию 0
        return new Position(0);
    }

    public Position getLast(){
        if (last == -1)
            throw new MyException("Empty list!!!");
        return new Position(last);
    }

    //Возвращает позицию перед pos.
    public Position getPrevious(Position pos){ //есть
        // вернуть pos-1 с проверкой того, не выходит ли позиция за пределы массивa
        // если выходит - выбросить исключение.
        // и еще добавить проверку если элемент первый
        if (pos.p > last || pos.p == 0)
            throw new MyException("Pos is out of bounds or list is empty");
        return new Position(pos.p - 1);
    }

    //Возвращает элемент в позиции pos
    public Postcard retrieve(Position pos){ //есть
        //вернуть элемент из списка в позиции pos
        //если позиции нет, выбросить исключение
        if (pos.p > last)
            throw new MyException("Pos is out of bounds!!!");
        return postcards_list[pos.p].cardObject;
    }

    //Вставляет элемент х в позицию pos
    public void insert(Position pos, Postcard x){ //есть
        // проверить, есть ли позиция такая
        // если её нет, ничего не делать (return)
        // все элементы сдвинуть с конца вправо
        // и когда сдвинутся, вставить х в позицию pos
        last++;
        if (pos.p > last)
            return;
        for (int i = last; i > pos.p; i--) {
            postcards_list[i] = postcards_list[i - 1];
        }

        postcards_list[pos.p] = new PostcardObject(x);
    }

    //Делает список пустым
    public void makeNull() { //есть
        last = -1;
    }

    //Удаляет элемент в позиции pos
    public Position delete(Position pos){ //есть
        // если позиции нет - ничего не делать
        // в цикле от pos до конца сдвинуть все элементы на 1 назад
        // уменьшить last на 1
        if (pos.p < last + 1){
            for (int i = pos.p + 1; i <= last ; i++) {
                postcards_list[i-1] = postcards_list[i];
            }
            last--;
        }
        return pos;
    }

    //Возвращает позицию
    public Position locate(Postcard x){ //есть
        // через цикл проходим по элементам в массиве
        // и возвращаем позицию встретившегося элемента
        // если его нет, то возвращаем последнюю
        for (int i = 0; i <= last; i++) {
            if (postcards_list[i].cardObject.isDataEqual(x)){
                return new Position(i);
            }
        }
        return new Position(last + 1);
    }

    //Печатает список
    public void print(){ //есть
        // через цикл от первого до last напечатать.. 
        // ну к каждому элементу приписать print_postcard()
        for (int i = 0; i <= last; i++) {
            postcards_list[i].cardObject.print_postcard();
            System.out.println();
        }
    }
    //Проверяет две позиции на равенство
    public boolean arePosEqual(Position a, Position b){
        return a.p == b.p;
    }

}
