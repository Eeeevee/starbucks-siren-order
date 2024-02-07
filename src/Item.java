public class Item extends Menu {
    Double price;

    Item(String menuName, String englishName, Double price) {
        super(menuName, englishName);
        this.price = price;
    }
}
