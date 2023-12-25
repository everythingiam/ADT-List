package tmp;

public class Position {
    public int p;

    public Position(int position){
        p = position;
    }
    public boolean arePosEqual(Position b){
        return this.p == b.p;
    }
}

