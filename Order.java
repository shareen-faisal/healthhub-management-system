
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;

class Order<T extends Item> {
    private int orderNumber;
    private static int totalOrders = 0;
    private int userId;
    private LocalDate orderingDate;
    private LocalTime orderingTime;
    private ArrayList<Cart<T>> list;

    public Order(int number, ArrayList<Cart<T>> c) {
        this.userId = number;
        this.list = c;
        this.orderingDate = LocalDate.now();
        this.orderingTime = LocalTime.now();
        this.orderNumber = ++totalOrders;
    }//con

    public Order(int orderNumber, LocalDate orderingDate, LocalTime orderingTime, ArrayList<Cart<T>> cart) {
        this.orderNumber = orderNumber;
        this.orderingDate = orderingDate;
        this.orderingTime = orderingTime;
        this.list = cart;
    }

    public LocalDate getOrderingDate() {
        return orderingDate;
    }

    public void setOrderingDate(LocalDate orderingDate) {
        this.orderingDate = orderingDate;
    }

    public LocalTime getOrderingTime() {
        return orderingTime;
    }

    public void setOrderingTime(LocalTime orderingTime) {
        this.orderingTime = orderingTime;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public ArrayList<Cart<T>> getList() {
        return list;
    }

    public void setList(ArrayList<Cart<T>> list) {
        this.list = list;
    }

    public void displayOrder() {
        System.out.println("Order Number: " + orderNumber);
        System.out.println("User ID: " + userId);
        System.out.println("Ordering Date: " + orderingDate);
        System.out.println("Ordering Time: " + orderingTime);
        System.out.println("Items in Cart:");
        for (Cart<T> item : list) {
            System.out.print(" - ");
            item.display();
            System.out.println();
        }//for
    }
}//class