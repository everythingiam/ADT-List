package Mains;
import stackArray.Stack;
import postcard.Postcard;

public class MainSQM {
    public static void main(String[] args) {
        Postcard tom = new Postcard(new char[]{'T', 'o', 'm'}, new char[]{'I', 'T', 'M', 'O'});
        Postcard babushka = new Postcard(new char[]{'b', 'a', 'b', 'u', 's', 'h', 'k', 'a'}, new char[]{'N', 'e', 'w', '-', 'Y', 'o', 'r', 'k'});
        Postcard kasha = new Postcard(new char[]{'k', 'a', 's', 'h', 'a'}, new char[]{'N', 'e', 'w', '-', 'Y', 'o', 'r', 'k'});
        Postcard dasha = new Postcard(new char[]{'D', 'a', 's', 'h', 'a'}, new char[]{'N', 'e', 'w', '-', 'Y', 'o', 'r', 'k'});

        Stack S = new Stack();
//        S.empty();
//        S.full();
        S.push(tom);
        S.push(babushka);
        S.print();
        System.out.println();
        S.top().print_postcard();
        S.push(dasha);
        System.out.println();
        S.empty();
        S.full();

        System.out.println();
        S.print();
        System.out.println();
        S.pop().print_postcard();
        System.out.println();
        System.out.println();
        S.print();
        System.out.println();

        S.makeNull();
        S.empty();
    }
}
