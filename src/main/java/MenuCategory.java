package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuCategory {
    private Map<String, List<Menu>> menus;   // 메뉴
    private Map<String, List<Item>> menuItems;   // 목록
    private List<Item> cart;    // 장바구니
    private double totalPrice;  // 가격
    private int orderNumber;   // 주문번호

    public MenuCategory() {
        menus = new HashMap<>();
        menuItems = new HashMap<>();
        cart = new ArrayList<>();
        totalPrice = 0.0;
        orderNumber = 0;

        initializeMenuItems();
    }

    private void initializeMenuItems() {
        // 카테고리
        List<Menu> mainMenus = new ArrayList<>();
        mainMenus.add(new Menu("피지오", "Starbucks Fizzio"));
        mainMenus.add(new Menu("에스프레소", "Espresso"));
        mainMenus.add(new Menu("블론드", "Blonde Coffee"));
        mainMenus.add(new Menu("디카페인 커피", "Decaf Coffee"));
        mainMenus.add(new Menu("티바나", "Teavana"));
        mainMenus.add(new Menu("콜드 브루", "Cold Brew"));
        mainMenus.add(new Menu("리프레셔", "Starbucks Refreshers"));
        mainMenus.add(new Menu("프라푸치노", "Frappuccino"));
        mainMenus.add(new Menu("블렌디드", "Blended"));
        mainMenus.add(new Menu("기타", "Others"));

        // 주문, 주문 취소, 주문 목록
        List<Menu> orderMenus = new ArrayList<>();
        orderMenus.add(new Menu("main.java.Order", "장바구니 확인"));
        orderMenus.add(new Menu("Cancel", "진행중인 주문 취소"));
//        orderMenu.add(new main.java.Menu("main.java.Order List", "주문 목록"));

        menus.put("Main", mainMenus);
        menus.put("main.java.Order", orderMenus);

        // 메뉴
        List<Item> fizzioMenu = new ArrayList<>();
        fizzioMenu.add(new Item("쿨 라임 피지오", "Cool Lime Starbucks Fizzio", 5.9));
        fizzioMenu.add(new Item("피치 딸기 피지오", "Peach Strawberry Starbucks Fizzio", 5.7));
        fizzioMenu.add(new Item("유자 패션 피지오", "Yuja Passion Starbucks Fizzio", 5.9));

        List<Item> espressoMenu = new ArrayList<>();
        espressoMenu.add(new Item("푸른 용 헤이즐넛 라떼", "Blue Dragon Hazelnut Latte", 6.3));
        espressoMenu.add(new Item("바닐라 플랫 화이트", "Vanilla Flat White", 5.9));
        espressoMenu.add(new Item("스타벅스 돌체 라떼", "Starbucks Dolce Latte", 5.9));
        espressoMenu.add(new Item("카페 모카", "Caffe Mocha", 5.5));
        espressoMenu.add(new Item("카페 아메리카노", "Caffe Americano", 4.5));
        espressoMenu.add(new Item("카페 라떼", "Caffe Latte", 5.0));
        espressoMenu.add(new Item("카푸치노", "Cappuccino", 5.0));
        espressoMenu.add(new Item("카라멜 마키아또", "Caramel Macchiato", 5.9));
        espressoMenu.add(new Item("화이트 초콜릿 모카", "White Chocolate Mocha", 5.9));
        espressoMenu.add(new Item("커피 스타벅스 더블 샷", "Coffee Starbucks Double Shot", 5.1));
        espressoMenu.add(new Item("바닐라 스타벅스 더블 샷", "Vanilla Starbucks Double Shot", 5.1));
        espressoMenu.add(new Item("헤이즐넛 스타벅스 더블 샷", "Hazelnut Starbucks Double Shot", 5.1));
        espressoMenu.add(new Item("에스프레소", "Espresso", 4.0));
        espressoMenu.add(new Item("에스프레소 마키아또", "Espresso Macchiato", 4.0));
        espressoMenu.add(new Item("에스프레소 콘 파나", "Espresso Con Panna", 4.2));

        List<Item> blondeMenu = new ArrayList<>();
        blondeMenu.add(new Item("블론드 바닐라 더블 샷 마키아또", "Blonde Vanilla Double Shot Macchiato", 5.9));
        blondeMenu.add(new Item("블론드 스타벅스 돌체 라떼", "Blonde Starbucks Dolce Latte", 5.9));
        blondeMenu.add(new Item("블론드 카페 라떼", "Blonde Caffe Latte", 5.9));
        blondeMenu.add(new Item("블론드 카페 아메리카노", "Blonde Caffe Americano", 4.5));
        blondeMenu.add(new Item("블론드 더 그린 쑥 크림 라떼", "The Green Mugwort Cream Latte", 7.0));

        List<Item> decafMenu = new ArrayList<>();
        decafMenu.add(new Item("디카페인 스타벅스 돌체 라뗴", "DECAF Starbucks Dolce Latte", 6.2));
        decafMenu.add(new Item("디카페인 카라멜 마키아또", "DECAF Caramel Macchiato", 6.2));
        decafMenu.add(new Item("디카페인 카페 라떼", "DECAF Caffe Latte", 5.3));
        decafMenu.add(new Item("디카페인 카페 아메리카노", "DECAF Caffe Americano", 4.8));
        decafMenu.add(new Item("1/2 디카페인 카라멜 마키아또", "Half DECAF Caramel Macchiato", 6.2));
        decafMenu.add(new Item("1/2 디카페인 카페 라떼", "Half DECAF Caffe Latte", 5.3));
        decafMenu.add(new Item("1/2 디카페인 카페 아메리카노", "Half DECAF Caffe Americano", 4.8));

        List<Item> teavanaMenu = new ArrayList<>();
        teavanaMenu.add(new Item("푸른 용 클래식 밀크 티", "Blue Dragon Classic Milk Tea", 6.2));
        teavanaMenu.add(new Item("스노우 말차 라떼", "Snow Malcha Latte", 7.9));
        teavanaMenu.add(new Item("레몬 캐모마일 블렌드 티", "Lemon Chamomile Blend Tea", 6.9));
        teavanaMenu.add(new Item("스타벅스 클래식 밀크 티", "Starbucks Classic Milk Tea", 5.9));
        teavanaMenu.add(new Item("스타벅스 클래식 밀크 티 보틀", "Starbucks Classic Milk Tea Bottle", 9.9));
        teavanaMenu.add(new Item("제주 유기농 말차로 만든 라떼", "Malcha Latte from Jeju Organic Farm", 6.1));
        teavanaMenu.add(new Item("유자 민트 티", "Yuja Mint Tea", 5.9));
        teavanaMenu.add(new Item("자몽 허니 블랙 티", "Grapefruit Honey Black Tea", 5.7));
        teavanaMenu.add(new Item("제주 유기 녹차", "Jeju Organic Green Tea", 5.3));
        teavanaMenu.add(new Item("잉글리쉬 브렉퍼스트 티", "English Breakfast Tea", 4.5));
        teavanaMenu.add(new Item("얼 그레이 티", "Earl Grey Brewed Tea", 4.5));
        teavanaMenu.add(new Item("유스베리 티", "Youthberry Brewed Tea", 4.5));
        teavanaMenu.add(new Item("히비커스 블렌드 티", "Hibiscus Blend Brewed Tea", 4.5));
        teavanaMenu.add(new Item("민트 블렌드 티", "Mint Blend Brewed Tea", 4.5));
        teavanaMenu.add(new Item("캐모마일 블렌드 티", "Chamomile Blend Brewed Tea", 4.5));
        teavanaMenu.add(new Item("레드 파워 패션 티", "Red Power Passion Tea", 5.9));
        teavanaMenu.add(new Item("얼 그레이 바닐라 라떼", "Earl Grey Vanilla Latte", 6.1));
        teavanaMenu.add(new Item("차이 티 라떼", "Chai Tea Latte", 5.5));

        List<Item> coldBrewMenu = new ArrayList<>();
        coldBrewMenu.add(new Item("시그니처 더 블랙 콜드 브루", "Signature The Black Cold Brew", 19.6));
        coldBrewMenu.add(new Item("오트 콜드 브루", "Oat Cold Brew", 5.8));
        coldBrewMenu.add(new Item("돌체 콜드 브루", "Dolce Cold Brew", 6.0));
        coldBrewMenu.add(new Item("바닐라 크림 콜드 브루", "Vanilla Cream Cold Brew", 5.8));
        coldBrewMenu.add(new Item("콜드 브루", "Cold Brew", 4.9));
        coldBrewMenu.add(new Item("나이트로 바닐라 크림", "Nitro Vanilla Cream Cold Brew", 6.1));
        coldBrewMenu.add(new Item("나이트로 콜드 브루", "Nitro Cold Brew", 6.0));
        coldBrewMenu.add(new Item("제주 비자림 콜드 브루", "Jeju Forest Cold Brew", 6.8));
        coldBrewMenu.add(new Item("여수 윤슬 헤이즐넛 콜드 브루", "Yeosu Shining Hazelnut Cold Brew", 7.5));

        List<Item> refreshersMenu = new ArrayList<>();
        refreshersMenu.add(new Item("망고 용과 레모네이드 스타벅스 리프레셔", "Mango Dragonfruit with Lemonade Starbucks Refreshers", 5.9));
        refreshersMenu.add(new Item("퍼플 드링크 위드 망고 용과 스타벅스 리프레셔", "Purple Drink with Mango Dragonfruit Starbucks Refreshers", 5.9));
        refreshersMenu.add(new Item("딸기 아사이 레모네이드 스타벅스 리프레셔", "Strawberry Acai with Lemonade Starbucks Refreshers", 5.9));
        refreshersMenu.add(new Item("핑크 드링크 위드 딸기 아사이 스타벅스 리프레셔", "Pink Drink with Strawberry Acai Starbucks Refreshers", 5.9));

        List<Item> frappuccinoMenu = new ArrayList<>();
        frappuccinoMenu.add(new Item("제주 유기농 말차로 만든 크림 프라푸치노", "Malcha Cream Frappuccino from Jeju Organic Farm", 6.3));
        frappuccinoMenu.add(new Item("자바 칩 프라푸치노", "Java Chip Frappuccino", 6.3));
        frappuccinoMenu.add(new Item("피스타피오 아보카도 초콜릿 프라푸치노", "Pistachio Avocado Chocolate Cream Frappuccino", 6.3));
        frappuccinoMenu.add(new Item("초콜릿 크림 칩 프라푸치노", "Chocolate Cream Chip Frappuccino", 6.0));
        frappuccinoMenu.add(new Item("화이트 초콜릿 크림 칩 프라푸치노", "White Chocolate Cream Chip Frappuccino", 6.0));
        frappuccinoMenu.add(new Item("카라멜 프라푸치노", "Caramel Frappuccino", 5.9));
        frappuccinoMenu.add(new Item("에스프레소 프라푸치노", "Espresso Frappuccino", 5.5));
        frappuccinoMenu.add(new Item("제주 까망 크림 프라푸치노", "Jeju Black Sesame Cream Frappuccino", 7.5));
        frappuccinoMenu.add(new Item("제주 쑥떡 크림 프라푸치노", "Jeju Mugwort Cream Frappuccino", 7.5));
        frappuccinoMenu.add(new Item("화이트 타이거 프라푸치노", "White Tiger Frappuccino", 6.5));

        List<Item> blendedMenu = new ArrayList<>();
        blendedMenu.add(new Item("딸기 딜라이트 요거트 블렌디드", "Strawberry Delight Yogurt Blended", 6.3));
        blendedMenu.add(new Item("망고 바나나 브렌디드", "Mango Banana Blended", 6.3));
        blendedMenu.add(new Item("피치 요거트 블렌디드", "Peach Yogurt Blended", 6.1));
        blendedMenu.add(new Item("망고 패션 티 블렌디드", "Mango Passion Tea Blended", 5.4));
        blendedMenu.add(new Item("레드 파워 스매시 블렌디드", "Red Power Smash Blended", 6.5));
        blendedMenu.add(new Item("더 그린 쑥 블렌디드", "The Green Mugwort Blended", 7.2));
        blendedMenu.add(new Item("코튼 스카이 요거트 블렌디드", "Cotton Sky Yogurt Blended", 9.8));

        List<Item> othersMenu = new ArrayList<>();
        othersMenu.add(new Item("핑크 폼 딸기 라떼", "Pink Foam Strawberry Milk", 6.8));
        othersMenu.add(new Item("스타벅스 딸기 라떼", "Starbucks Strawberry Milk", 6.5));
        othersMenu.add(new Item("시그니처 핫 초콜릿", "Signature Hot Chocolate", 5.7));
        othersMenu.add(new Item("스팀 우유", "Steamed Milk", 4.1));
        othersMenu.add(new Item("우유", "Milk", 4.1));
        othersMenu.add(new Item("제주 까망 라떼", "Jeju Black Sesame Latte", 7.2));
        othersMenu.add(new Item("플러디 판다 핫 초콜릿", "Fluffy Panda Hot Chocolate", 6.5));
        othersMenu.add(new Item("레드 파워 스매셔", "Red Power Smasher", 6.5));
        othersMenu.add(new Item("스타벅스 슬래머", "Starbucks Slammer", 6.5));

        menuItems.put("피지오", fizzioMenu);
        menuItems.put("에스프레소", espressoMenu);
        menuItems.put("블론드", blondeMenu);
        menuItems.put("디카페인 커피", decafMenu);
        menuItems.put("티바나", teavanaMenu);
        menuItems.put("콜드 브루", coldBrewMenu);
        menuItems.put("리프레셔", refreshersMenu);
        menuItems.put("프라푸치노", frappuccinoMenu);
        menuItems.put("블렌디드", blendedMenu);
        menuItems.put("기타", othersMenu);
    }

    // 카테고리 조회
    public List<Menu> getMenus(String key) {
        return menus.get(key);
    }

    // 메뉴 조회
    public List<Item> getMenuItems(String key) {
        return menuItems.get(key);
    }

    public Map<String, List<Item>> getMenuItemMap() {
        return menuItems;
    }

    public List<Item> getCart() {
        return cart;
    }

    public void addMenu(String key, String englishName) {
        menus.get("Main").add(new Menu(key, englishName));
        menuItems.put(key, new ArrayList<>());
    }

    public void addMenuItem(String key, Item newItem) {
        menuItems.get(key).add(newItem);
    }

    public String getMainMenuName(int id) {
        List<Menu> categorys = menus.get("Main");

        for (Menu category : categorys) {
            if (category.id == id) {
                return category.menuName;
            }
        }
        return "";
    }

    // 장바구니에 상품 추가
    public void addToCart(Item menuItem) {
        cart.add(menuItem);
        totalPrice += menuItem.price;
    }

    // 장바구니 출력
    public void displayAllItem() {
        System.out.println("[장바구니]");

        menuItems.forEach((key, value) -> {
            System.out.println("[" + key + "main.java.Menu] ");

            for (Item item : value) {
                System.out.println(item.id + ". " + item.menuName + " |" + item.price + " | " + item.englishName);
            }
        });
    }

    public void displayCart() {
        for (Item item : cart) {
            System.out.println(item.menuName + " | " + item.price + " | " + item.englishName);
        }
    }

    // 장바구니 전체가격 조회
    public double getTotalPrice() {
        return totalPrice;
    }

    // 신규 주문번호 조회
    public int generateOrderNumber() {
        orderNumber++;
        return orderNumber;
    }

    //장바구니 초기화
    public void resetCart() {
        cart.clear();
        totalPrice = 0.0;
    }
}
