import arrayList1.*;
//import linkedListList1.*;
//import duoListList1.*;
import postcard.Postcard;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
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
        List.initCurosor();
        try {
            initFile(L,"File.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Файла не существует");
            return;
        }
        L.print();
        Postcard pc4 = new Postcard(new char[]{'m', 'i', 's', 's', 'i', 'n', 'g'}, new char[]{'N', 'e', 'w', '-', 'Y', 'o', 'r', 'k'});
        Postcard pc5 = new Postcard(new char[]{'k', 'a', 's', 'h', 'a'}, new char[]{'N', 'e', 'w', '-', 'Y', 'o', 'r', 'k'});
        Postcard pc6 = new Postcard(new char[]{'D', 'a', 's', 'h', 'a'}, new char[]{'N', 'e', 'w', '-', 'Y', 'o', 'r', 'k'});

        System.out.println();
        System.out.println();

        Position located = L.locate(pc5);
        L.insert(located, pc6);

        Position p = L.getFirst();
        Position q;
         while (!(L.arePosEqual(p, L.getEndL()))) {
             q = L.getNext(p);
             while (!L.arePosEqual(q, L.getEndL())) {
                 if (L.retrieve(p).isDataEqual(L.retrieve(q))){
                     q = L.delete(q);
                 } else {
                     q = L.getNext(q);
                 }
             }
             p = L.getNext(p);
         }
         L.print();

//        System.out.println();
//
//        Position located = L.locate(pc5);
//        L.insert(located, pc6);
    }
}
