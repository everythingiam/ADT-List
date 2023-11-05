import arrayList1.*;
//import linkedListList1.*;
import exception.MyException;
import postcard.Postcard;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void initFile(List L, String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner scan = new Scanner(file);
        Pattern pat = Pattern.compile("[\\s\\t]+"); // Паттерн разделения элементов
        while (scan.hasNextLine()) {
            String str = scan.nextLine(); // Чтение строки
            String[] sn = pat.split(str.trim()); // Разделение строки на составляющие
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
        List L = new List();
        List.initCurosor();
        try {
            initFile(L,"File.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Файла не существует");
            return;
        }
        L.print();
        Postcard pc5 = new Postcard(new char[]{'k', 'a', 's', 'h', 'a'}, new char[]{'N', 'e', 'w', ' ', 'Y', 'o', 'r', 'k'});

        System.out.println();
        Position pos = new Position(2);
        L.insert(pos, pc5);
//        System.out.println();
//        L.print();
//        Position next = L.getNext(pos);
//        Position endL = L.getEndL();
//        System.out.println();
//        List L2 = new List();
////           Position first = L2.getFirst();
//        init(L2);
//        Position pos2 = new Position(3);
//        Position next2 = L2.getNext(pos2);
//        Position previous = L.getPrevious(pos);
//        System.out.println(next2.p);
//        System.out.println(previous.p);
//        L.retrieve(pos).print_postcard();
//
//        System.out.println();
//        System.out.println();
//        L2.print();
//        System.out.println();
//        L2.delete(pos);
//        L2.print();
//
//        System.out.println(L.getEndL().p);
//
//        Position located = L.locate(pc5);
//        System.out.println(located.p);
//         p, q - позиция в списке, L - список

//         удаление дубликатов
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
        //за 'совпадает' отвечает метод isEqual(Postcard: b)
        //потом как-нибудь при реализации зафигачу его в алгоритм
        //5. ну и печатаем обработанный результат L.print()
    }
}
