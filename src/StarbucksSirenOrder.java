import java.util.List;
import java.util.Scanner;

public class StarbucksSirenOrder {

    public static void main(String[] args) {
        menuCategory = new MenuCategory();
        managementContext = new ManagementContext();
        displayMainMenu();
    }

    // 메뉴 저장고
    private static MenuCategory menuCategory;

    private static ManagementContext managementContext;

    private static void displayMainMenu() {
        System.out.println("*STARBUCKS Order*\n");

        System.out.println("[Menu]");
        List<Menu> mainMenus = menuCategory.getMenus("Main");
        int nextNum = printMenu(mainMenus, 1);

        System.out.println("[Order]");
        List<Menu> orderMenus = menuCategory.getMenus("Order");    // 메뉴 컨텍스트에서 주문메뉴 조회
        printMenu(orderMenus, nextNum);     // 주문메뉴 출력

        handleMainMenuInput();  // 메인메뉴 입력처리
    }

    // 메뉴 목록 출력
    private static int printMenu(List<Menu> menus, int num) {
        for (int i = 0; i < menus.size(); i++, num++) {        // menus 목록에 있는 메뉴 출력 (전체 순번값인 num 값도 ++)
            System.out.println(num + ". " + menus.get(i).menuName + "   | " + menus.get(i).englishName); // ex. 0.메뉴이름 | 메뉴설명
        }
        return num;
    }

    // 메인메뉴 입력처리
    private static void handleMainMenuInput() {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int mainMenuSize = menuCategory.getMenus("Main").size();        // 메인메뉴 사이즈 조회
        int orderMenuSize = menuCategory.getMenus("Order").size();    // 주문메뉴 사이즈 조회

        if (input == 0) {
            displayManagementMenu();
        } else if (input <= mainMenuSize) {
            displayMenu(menuCategory.getMenus("Main").get(input - 1));
        } else if (input <= mainMenuSize + orderMenuSize) {
            int orderInput = input - mainMenuSize;
            switch (orderInput) {
                case 1:
                    displayOrderMenu();
                    break;
                case 2:
                    handleCancelMenuInput();
                    break;
                case 3:
                    handleListMenuInput();
                    break;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                    handleMainMenuInput();
            }
        } else {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            handleMainMenuInput();
        }
    }

    // 메뉴에 있는 상품메뉴 목록 출력
    private static void displayMenu(Menu menu) {
        System.out.println("STARBUCKS 에 오신걸 환영합니다.");
        System.out.println("아래 카테고리를 보시고 상품을 골라 입력해주세요.\n");

        System.out.println("[ " + menu.menuName + " MENU ]");
        List<Item> items = menuCategory.getMenuItems(menu.menuName); // 메뉴에 있는 상품메뉴 목록 조회

        printMenuItems(items);            // 상품메뉴 목록 출력
        handleMenuItemInput(items);        // 상품메뉴 입력 처리
    }

    private static void displayManagementMenu() {
        System.out.println("[STARBUCKS 관리 메뉴]");
        System.out.println("아래 목록해서 원하는 명령을 골라 입력해주세요.\n");

        managementContext.displayMainMenu();

        handleCommandInput();
    }

    private static void handleCommandInput() {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        if (input == 0) {
            displayMainMenu();
        } else if (input >= 1 && input <= 4) {
            switch (input) {
                case 1:
                    managementContext.displayWaitingOrdersAndProcess();
                    break;
                case 2:
                    managementContext.displayCompletedOrders();
                    break;
                case 3:
                    String menuName = getMenuName();
                    Item newItem = managementContext.createMenuItem();
                    menuCategory.addMenuItem(menuName, newItem);
                    break;
                case 4:
                    menuCategory.displayAllItem();
                    System.out.print("삭제할 상품 ID: ");
                    int itemId = sc.nextInt();
                    managementContext.deleteMenuItems(menuCategory.getMenuItemMap(), itemId);
                    break;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        } else {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
        }
        displayManagementMenu();
    }

    private static String getMenuName() {
        System.out.println("[ 메뉴 목록 ]");
        List<Menu> mainMenus = menuCategory.getMenus("Main");
        printMenu(mainMenus, 1);
        System.out.println(mainMenus.size() + 1 + ". 신규 메뉴");
        System.out.print("메뉴 ID: ");
        Scanner sc = new Scanner(System.in);
        int menuId = sc.nextInt();
        if (menuId <= mainMenus.size()) {
            return menuCategory.getMainMenuName(menuId);
        } else {
            System.out.print("신규 메뉴이름: ");
            String newMenuName = sc.next();
            System.out.print("신규 메뉴설명: ");
            String newMenuDescription = sc.next();
            menuCategory.addMenu(newMenuName, newMenuDescription);
            return newMenuName;
        }
    }

    // 상품 입력 처리
    private static void handleMenuItemInput(List<Item> items) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        if (input >= 1 && input <= items.size()) {    // 입력값 유효성 검증
            Item selectedItem = items.get(input - 1);    // 선택한 상품메뉴 조회
            displayConfirmation(selectedItem);        // 선택한 상품메뉴 확인 문구 출력
        } else {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            handleMenuItemInput(items);    // 상품메뉴 입력 처리 재수행
        }
    }

    private static void printMenuItems(List<Item> items) {
        for (int i = 0; i < items.size(); i++) {
            int num = i + 1;
            System.out.println(num + ". " + items.get(i).menuName + "   | " + items.get(i).englishName + " | " + items.get(i).price);
        }
    }

    // 선택한 상품메뉴 확인 문구 출력
    private static void displayConfirmation(Item menuItem) {
        System.out.println(menuItem.menuName + "   | " + menuItem.englishName + " | " + menuItem.price);
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인        2. 취소");

        handleConfirmationInput(menuItem);    // 확인여부 입력 처리
    }

    // 확인 여부 입력 처리
    private static void handleConfirmationInput(Item menuItem) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        if (input == 1) {                                // 1. 확인 입력시
            menuCategory.addToCart(menuItem);            // 선택한 상품을 컨텍스트의 장바구니에 추가
            System.out.println("장바구니에 추가되었습니다.");
            displayMainMenu();                            // 메인메뉴 출력하며 처음으로 돌아가기
        } else if (input == 2) {                        // 2. 취소 입력시
            displayMainMenu();                            // 바로 메인메뉴 출력하며 처음으로 돌아가기
        } else {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            handleConfirmationInput(menuItem);            // 잘못된 입력시 다시 확인여부 입력 처리 재수행
        }
    }

    // 주문메뉴1. 주문진행 메뉴 출력
    private static void displayOrderMenu() {
        System.out.println("아래와 같이 주문 하시겠습니까?\n");
        menuCategory.displayCart();			// 컨텍스트에서 장바구니 목록 출력

        System.out.println("[ Total ]");
        System.out.println("W " + menuCategory.getTotalPrice() + "\n");	// 컨텍스트에서 전체 가격 조회하여 출력

        System.out.println("1. 주문      2. 메뉴판");

        handleOrderMenuInput();				// 주문진행 입력 처리
    }

    // 주문메뉴1. 주문진행 입력 처리
    private static void handleOrderMenuInput() {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        if (input == 1) {
            displayOrderComplete();	// 1. 주문 입력시 주문완료 처리
        } else if (input == 2) {
            displayMainMenu();		// 2. 메뉴판 입력시 메인메뉴 출력하며 돌아가기
        } else {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            handleOrderMenuInput();	// 잘못된 입력시 주문진행 입력처리 재수행
        }
    }

    // 주문메뉴1. 주문 입력시 주문완료 처리
    private static void displayOrderComplete() {
        int orderNumber = menuCategory.generateOrderNumber(); 		// 컨텍스트에서 신규 주문번호 조회
        List<Item> cart = menuCategory.getCart();
        Double totalPrice = menuCategory.getTotalPrice();
        System.out.println("요구사항을 입력해주세요.");
        Scanner sc = new Scanner(System.in);
        String message = sc.nextLine();

        managementContext.addCartToOrder(orderNumber, message, cart, totalPrice);

        System.out.println("주문이 완료되었습니다!\n");
        System.out.println("대기번호는 [ " + orderNumber + " ] 번 입니다.");

        resetCartAndDisplayMainMenu();		// 장바구니 초기화 후 메인메뉴 출력
    }

    // 장바구니 초기화 후 메인메뉴 출력
    private static void resetCartAndDisplayMainMenu() {
        menuCategory.resetCart();		// 컨텍스트에서 장바구니 초기화
        System.out.println("(3초후 메뉴판으로 돌아갑니다.)");
        try {
            Thread.sleep(3000); // 3초 대기
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        displayMainMenu();		// 메인메뉴 출력하며 돌아가기
    }

    // 주문메뉴2. 주문취소 메뉴 출력
    private static void handleCancelMenuInput() {
        System.out.println("주문을 취소하시겠습니까?");
        System.out.println("1. 확인        2. 취소");

        handleCancelConfirmationInput();	// 주문취소 확인 입력값 처리
    }

    private static void handleListMenuInput() {
        managementContext.displayWaitingOrders();
        managementContext.displayCompletedOrders();

        displayMainMenu();
    }

    // 주문메뉴2. 주문취소 확인 입력값 처리
    private static void handleCancelConfirmationInput() {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        if (input == 1) {
            menuCategory.resetCart();	// 장바구니 초기화
            System.out.println("주문이 취소되었습니다.");
            displayMainMenu();			// 메인메뉴 출력하며 돌아가기
        } else if (input == 2) {
            displayMainMenu();			// 메인메뉴 출력하며 돌아가기
        } else {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            handleCancelConfirmationInput();	// 주문취소 확인 입력값 처리 재수행
        }
    }
}


