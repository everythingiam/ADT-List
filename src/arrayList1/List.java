package arrayList1;
import postcard.Postcard;

public class List {
    private PostcardObject[] postcards_list; //массив
    private int last; //последний занятый

    //конструктор, массив объектов
    public List(){
        postcards_list = new PostcardObject[20];
        last = -1;
    }

    //Возвращает следующую за рos позицию
    public Position getNext(Position pos){
        // вернуть p+1 с проверкой того, не выходит ли позиция за пределы массива.
        // если выходит - выбросить исключение.
        return new Position(pos.p + 1);
    }

    //Возвращает позицию после последнего 
    public Position getEndL(){
        return new Position(last + 1);
        }
    
    //Возвращает первую позицию
    public Position getFirst(){
        // если массив не пустой, то возвращаем позицию 0
        return new Position(0);
    }

    //Возвращает позицию перед pos.
    public Position getPrevious(Position pos){
        // вернуть pos-1 с проверкой того, не выходит ли позиция за пределы массивa
        // если выходит - выбросить исключение.
        // и еще добавить проверку если элемент первый
        return new Position(pos.p - 1);
    }

    //Возвращает элемент в позиции pos
    public Postcard retrieve(Position pos){
        //вернуть элемент из списка в позиции pos
        //если позиции нет, выбросить исключение
        return postcards_list[pos.p].cardObject;
    }

    //Вставляет элемент х в позицию pos
    public void insert(Position pos, Postcard x){
        // проверить, есть ли позиция такая
        // если её нет, ничего не делать (return)
        // все элементы сдвинуть с конца вправо
        // и когда сдвинутся, вставить х в позицию pos

    }

    //Делает список пустым
    public void makeNull() {
        last = -1;
    }

    //[1, 6, 9, 1, 3(last), 5]
    //Удаляет элемент в позиции pos
    public void delete(Position pos){
        // если позиции нет - ничего не делать
        // в цикле от pos до конца сдвинуть все элементы на 1 назад
        // уменьшить last на 1
    }

    //Возвращает позицию
    public Position locate(PostcardObject postcard){
        // через цикл проходим по элементам в массиве
        // и возвращаем встретившийся элемент
        // если его нет, то возвращаем последний
        return new Position(last + 1);
    }

    //Печатает список
    public void print(){
        // через цикл от первого до last напечатать.. 
        // ну к каждому элементу приписать print_postcard()
    }
}
