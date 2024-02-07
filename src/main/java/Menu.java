package main.java;

public class Menu {
    static int idSeq = 1;

    int id;
    String menuName;
    String englishName;

    Menu(String menuName, String englishName) {
        this.id = idSeq++;
        this.menuName = menuName;
        this.englishName = englishName;
    }
}
