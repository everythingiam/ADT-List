package postcard;

public class Postcard {
    public char[] name = new char[30];
    public char[] adress = new char[50];

    public Postcard(char[] name, char[] adress){
        this.name = name;
        this.adress = adress;
    }

    public Postcard (Postcard x){
        this.name = new char[30];
        this.adress = new char[50];

        for (int i = 0; i < x.name.length; i++) {
            this.name[i] = x.name[i];
        }
        for (int i = 0; i < x.adress.length; i++) {
            this.adress[i] = x.adress[i];
        }
//        for (int i = 0; i < this.name.length; i++) {
//
//        }
//        Postcard copy = new Postcard(this.name, this.adress);
    }
    
//     //скопировать массивы

     //Метод проверяет, равны ли почтовые отправления (я называю карточки).
     //Нужен для того, чтобы в main сделать алогритм удаления дубликатов.
     public boolean isEqual(Postcard b){
        Postcard a = this;
        for (int i = 0; i < a.name.length; i++) {
            if (a.name[i] != b.name[i]){
                return false;
            }
        }

        for (int i = 0; i < b.adress.length; i++) {
            if (a.adress[i] != b.adress[i]){
                return false;
            }
        }
        // 1. Проходимся по имени и адресу с помощью цикла
        // и сравниваем имена и адреса письма А с письмом В.
        // 2. Если в имени и(или) адресе какое-то несовпадение, то возвращает false.
        // 3. А если всё ок то true.
        return true;
    }
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
