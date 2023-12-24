package duoListList1;

public class Position {

    //для двусвязного списка позиция адрес конкретного элемента в памяти
    public PostcardObject p;

    public Position(PostcardObject position){
        this.p = position;
    }

    //Проверяет две позиции на равенство
    public boolean arePosEqual(Position b){
        return this.p == b.p;
    }
}

