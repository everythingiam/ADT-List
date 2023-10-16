package postcard;

public class Postcard {
    public char[] name;
    public char[] adress;

    public Postcard(char[] name, char[] adress){
        this.name = name;
        this.adress = adress;
    }

    
//     //скопировать массивы

//     //Метод проверяет, равны ли почтовые отправления (я называю карточки).
//     //Нужен для того, чтобы в main сделать алогритм удаления дубликатов.
//     public boolean isEqual(Postcard b){ 
//         Postcard a = this;

//         // 1. Проходимся по имени и адресу с помощью цикла
//         // и сравниваем имена и адреса письма А с письмом В. 
//         // 2. Если в имени и(или) адресе какое-то несовпадение, то возвращает false. 
//         // 3. А если всё ок то true. 
//         return true;
//     }

//     //Печать одной карточки.
//     //Нужен для печати всего списка карточек.
    public void print_postcard(){
        // 1. Сначала одним циклом выводим имя
        // 2. Ставим пробел
        // 3. Другим циклом выводим адрес
        for (int i = 0; i < name.length; i++) {
            System.out.print(name[i]);
        }
        System.out.print(" ");
        for (int i = 0; i < adress.length; i++) {
            System.out.print(adress[i]);
        }
    }

    }
