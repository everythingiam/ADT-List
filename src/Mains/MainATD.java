package Mains;
//import arrayList1.*;
//import linkedListList1.*;
import duoListList1.*;
//import cursorList1.*;
//import tmp.*;
import postcard.Postcard;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.File;
import java.io.FileNotFoundException;

public class MainATD {
    public static void initFile(List L, String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner scan = new Scanner(file);
        Pattern pat = Pattern.compile("[\\s\\t]+");
        while (scan.hasNextLine()) {
            String str = scan.nextLine();
            String[] sn = pat.split(str.trim());
            char[] name = sn[0].toCharArray();
            char[] adress = sn[1].toCharArray();
            Postcard pc = new Postcard(name, adress);
            L.insert(L.getEndL(), pc);
        }
        scan.close();
    }
    public static void main(String[] args){
        //1. Создаем объект списка - List L = new List();
        //2. инициализируем его с помощью init(L);
        //3. ставим p(позицию) как первый элемент списка;
        //4. дальше проворачиваем махинацию удаления дубликатов,
        //которую Андрей Сергеевич когда-то написал нам на доске
        //5. ну и печатаем обработанный результат L.print()
        List L = new List();
        List.initCursor();
        try {
            initFile(L,"File.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Файла не существует");
            return;
        }
        L.print();
        Postcard tom = new Postcard(new char[]{'T', 'o', 'm'}, new char[]{'I', 'T', 'M', 'O'});
        Postcard babushka = new Postcard(new char[]{'b', 'a', 'b', 'u', 's', 'h', 'k', 'a'}, new char[]{'N', 'e', 'w', '-', 'Y', 'o', 'r', 'k'});
        Postcard kasha = new Postcard(new char[]{'k', 'a', 's', 'h', 'a'}, new char[]{'N', 'e', 'w', '-', 'Y', 'o', 'r', 'k'});
        Postcard dasha = new Postcard(new char[]{'D', 'a', 's', 'h', 'a'}, new char[]{'N', 'e', 'w', '-', 'Y', 'o', 'r', 'k'});

        System.out.println();

        Position p = L.getFirst();
        Position q;

         while (!p.arePosEqual(L.getEndL())) {
             q = L.getNext(p);
             while (!q.arePosEqual(L.getEndL())) {
                 if (L.retrieve(p).isDataEqual(L.retrieve(q))){
                     L.delete(q);
                 } else {
                     q = L.getNext(q);
                 }
             }
             p = L.getNext(p); //обращение к только что удаленному адресу может быть просто некст
         }
         L.print();
//
        System.out.println();
//
        System.out.println("Проверки методов:");
//        L.insert(L.locate(kasha), babushka); //вставка в середину
//        L.insert(L.locate(kasha), babushka);
//
        L.insert(L.getFirst(), tom); //вставка в начало самое (перед первым)
//
        L.insert(L.getEndL(), dasha); //вставка в позицию после последнего

//        L.insert(L.locate(dasha), babushka); //вставка в последний элемент
//        System.out.println();
        L.print();

        System.out.println();
//        L.retrieve(L.locate(kasha)).print_postcard();
//        System.out.println();
//        L.retrieve(L.locate(kasha)).print_postcard();
//
//        System.out.println();
//        L.retrieve(L.getNext(L.locate(kasha))).print_postcard();
//
//        System.out.println();
//
//        System.out.println();
//        L.retrieve(L.getFirst()).print_postcard();
//
//        L.retrieve(L.locate(tom)).print_postcard();
//        L.delete(L.locate(babushka));
//        L.delete(L.getEndL());
        L.delete(L.locate(dasha));

        L.insert(L.locate(kasha), babushka);
        L.print();
//        System.out.println();

//        L.insert(L.getNext(L.locate(dasha)), babushka);
//        L.print();
//        L.retrieve(L.getPrevious(L.getEndL())).print_postcard();
//        L.retrieve(L.getNext(L.locate(kasha))).print_postcard();
//        L.retrieve(L.getPrevious(L.getFirst())).print_postcard();
//        L.retrieve(L.locate(tom)).print_postcard();

//        L.retrieve(L.getEndL()).print_postcard();

    }

}
