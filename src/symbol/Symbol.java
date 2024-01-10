package symbol;

public class Symbol {
    public char symbol;

    public Symbol(char ch) {
        symbol = ch;
    }

    public Symbol(Symbol ch) {
        this.symbol = ch.symbol;
    }

    public void print() {
        System.out.println(symbol);
    }
}
