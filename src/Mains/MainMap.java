package Mains;
//import postcard.Postcard;
import mapADTList.Map;
import postcard.Postcard;

public class MainMap {
    public static void main(String[] args) {
        Map M = new Map();
        Postcard tom = new Postcard(new char[]{'T', 'o', 'm'}, new char[]{'I', 'T', 'M', 'O'});
        Postcard babushka = new Postcard(new char[]{'b', 'a', 'b', 'u', 's', 'h', 'k', 'a'}, new char[]{'N', 'e', 'w', '-', 'Y', 'o', 'r', 'k'});
        Postcard kasha = new Postcard(new char[]{'k', 'a', 's', 'h', 'a'}, new char[]{'N', 'e', 'w', '-', 'Y', 'o', 'r', 'k'});
        Postcard dasha = new Postcard(new char[]{'D', 'a', 's', 'h', 'a'}, new char[]{'M', 'o', 's', 'c', 'o', 'w'});
        M.assign(tom.name, kasha.adress);
        M.assign(tom.name, dasha.adress);
        M.print();
    }
}