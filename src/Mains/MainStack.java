package Mains;
//import stackArray.Stack;
import stackLinkedList.Stack;
//import stackADTList.Stack;
import postcard.Postcard;

public class MainStack {
    public static void main(String[] args) {
        Postcard tom = new Postcard(new char[]{'T', 'o', 'm'}, new char[]{'I', 'T', 'M', 'O'});
        Postcard babushka = new Postcard(new char[]{'b', 'a', 'b', 'u', 's', 'h', 'k', 'a'}, new char[]{'N', 'e', 'w', '-', 'Y', 'o', 'r', 'k'});
        Postcard kasha = new Postcard(new char[]{'k', 'a', 's', 'h', 'a'}, new char[]{'N', 'e', 'w', '-', 'Y', 'o', 'r', 'k'});
        Postcard dasha = new Postcard(new char[]{'D', 'a', 's', 'h', 'a'}, new char[]{'N', 'e', 'w', '-', 'Y', 'o', 'r', 'k'});

        Stack S = new Stack();
//проверять на вставку
        S.push(tom);
        S.push(babushka);
        S.push(kasha);
        S.print();
        System.out.println();
        S.top().print_postcard();
//        S.push(dasha);
//        S.empty();
//        S.full();
//
//        System.out.println();
//        S.print();
        System.out.println();
        S.pop().print_postcard();
        System.out.println();
        S.print();
//        System.out.println();
//
//        S.makeNull();
//        S.empty();
    }
}
