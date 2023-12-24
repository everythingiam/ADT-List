package arrayList1;
public class Position {

    //для массива позиция просто число - порядковый номер элемента
    public int p; 

    public Position(int position){
        p = position;
    }

    //Проверяет две позиции на равенство
    public boolean arePosEqual(Position b){
        return this.p == b.p;
    }
}
