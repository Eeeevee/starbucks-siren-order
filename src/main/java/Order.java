package main.java;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    int orderNumber;
    String message;
    List<Item> cart;
    Double totalPrice;
    Boolean complete = false;
    LocalDateTime orderDate;
    LocalDateTime completeDate;

    public Order(int orderNumber, String message, List<Item> cart, Double totalPrice) {
        this.orderNumber = orderNumber;
        this.message = message;
        this.cart = cart;
        this.totalPrice = totalPrice;
        this.orderDate = LocalDateTime.now();
    }

    public int getOrderNumber() {
        return this.orderNumber;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
        this.completeDate = LocalDateTime.now();
    }

    public void display() {
        System.out.println("\t주문번호 : " + this.orderNumber);
        System.out.println("\t요구사항 : " + this.message);
        System.out.println("\t주문시각 : " + this.orderDate);
        System.out.println("\t주문상품 목록 : ");
        for (Item item : cart) {
            System.out.println("\t\t" + item.menuName + "   | " + item.englishName + " | " + item.price);
        }
        System.out.println("\t총 가격 : " + this.totalPrice);
    }
}

