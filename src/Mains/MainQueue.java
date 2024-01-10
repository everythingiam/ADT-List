package Mains;
import queueArray.Queue;
//import queueRingLinkedList.Queue;
//import queueADTList.Queue;
import postcard.Postcard;

public class MainQueue {
    public static void main(String[] args) {
        Postcard tom = new Postcard(new char[]{'T', 'o', 'm'}, new char[]{'I', 'T', 'M', 'O'});
        Postcard babushka = new Postcard(new char[]{'b', 'a', 'b', 'u', 's', 'h', 'k', 'a'}, new char[]{'N', 'e', 'w', '-', 'Y', 'o', 'r', 'k'});
        Postcard kasha = new Postcard(new char[]{'k', 'a', 's', 'h', 'a'}, new char[]{'N', 'e', 'w', '-', 'Y', 'o', 'r', 'k'});
        Postcard dasha = new Postcard(new char[]{'D', 'a', 's', 'h', 'a'}, new char[]{'N', 'e', 'w', '-', 'Y', 'o', 'r', 'k'});

       Queue Q = new Queue();
       Q.enqueue(tom);
       Q.enqueue(babushka);
       Q.enqueue(kasha);

        System.out.println();
        Q.print();
        System.out.println();
       Q.dequeue().print_postcard();
        System.out.println();
       Q.print();


        System.out.println();
        Q.front().print_postcard();
    }
}

