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

    //Возвращает позицию перед pos.
    public Position getPrevious(Position pos){ //есть
        if (pos.p > last + 1 || pos.p == 0)
            throw new MyException("Pos is out of bounds or list is empty");
        // вернуть pos-1 с проверкой того, не выходит ли позиция за пределы массивa
        // если выходит - выбросить исключение.
        // и еще добавить проверку если элемент первый
        return new Position(pos.p - 1);
    }

    //Возвращает элемент в позиции pos
    public Postcard retrieve(Position pos){ //есть
        if (pos.p > last + 1)
            throw new MyException("Pos is out of bounds!!!");
        //вернуть элемент из списка в позиции pos
        //если позиции нет, выбросить исключение
        return postcards_list[pos.p].cardObject;
    }

    //Вставляет элемент х в позицию pos
    public void insert(Position pos, Postcard x){ //почти есть
        last++;
        if (pos.p > last)
            return;

        for (int i = last; i > pos.p; i--) {
            postcards_list[i] = postcards_list[i - 1];
        }

        postcards_list[pos.p] = new PostcardObject(x);
        // проверить, есть ли позиция такая
        // если её нет, ничего не делать (return)
        // все элементы сдвинуть с конца вправо
        // и когда сдвинутся, вставить х в позицию pos

    }

    //Делает список пустым
    public void makeNull() { //есть
        last = -1;
    }

    //[1, 6, 9, 1, 3(last), 5]
    //Удаляет элемент в позиции pos
    public Position delete(Position pos){ //есть
        if (pos.p < last + 1){
            for (int i = pos.p + 1; i <= last ; i++) {
                postcards_list[i-1] = postcards_list[i];
            }
            last--;
        }
        return pos;
        // если позиции нет - ничего не делать
        // в цикле от pos до конца сдвинуть все элементы на 1 назад
        // уменьшить last на 1
    }

    //Возвращает позицию
    public Position locate(Postcard postcard){ //есть
        for (int i = 0; i < last; i++) {
            if (postcards_list[i].cardObject == postcard){
                return new Position(i);
            }
        }
        // через цикл проходим по элементам в массиве
        // и возвращаем встретившийся элемент
        // если его нет, то возвращаем последний
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

    //метод сравнения не работает правильно из класса Position...
    public boolean arePosEqual(Position a, Position b){
        return a.p == b.p;
    }

}
