package postcard;

public class Postcard {
    private char[] name = new char[20];
    private char[] adress = new char[40];

    public Postcard(char[] name, char[] adress){
        this.name = name;
        this.adress = adress;
    }


    //Метод проверяет, равны ли почтовые отправления (я называю карточки).
    //Нужен для того, чтобы в main сделать алогритм удаления дубликатов.
    public boolean isEqual(Postcard b){ 
        Postcard a = this;

        // Проходимся по имени и адресу с помощью цикла
        // и сравниваем имена и адреса письма А с письмом В. 
        // Если в имени и(или) адресе какое-то несовпадение, то возвращает false. 
        // А если всё ок то true. 
        return true;
    }

    //Печать одной карточки.
    //Нужен для печати всего списка карточек.
    public void print_postcard(){
        // Сначала одним циклом выводим имя
        // Ставим пробел
        // Другим циклом выводим адрес
    }

}
