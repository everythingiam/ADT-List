package cursorList1;

public class Position {
    public int p;

    public Position(int position){
        p = position;
    }
    //Проверяет две позиции на равенство
    public boolean arePosEqual(Position b){
        return this.p == b.p;
    }
}
