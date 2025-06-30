class Cart<T extends Item> {
	

      private T item;
    private int selectedQuantity;
    private String selectedDate;
    private String selectedTime;


public Cart(T item, int selectedQuantity) {
    this.item = item;
    this.selectedQuantity = selectedQuantity;
    this.selectedDate = null;
    this.selectedTime = null;
}

public Cart(T item, int selectedQuantity, String selectedDate, String selectedTime) {
    this.item = item;
    this.selectedQuantity = selectedQuantity;
    this.selectedDate = selectedDate;
    this.selectedTime = selectedTime;
}

public T getItem() {
    return item;
}

public void setItem(T item) {
    this.item = item;
}

public int getSelectedQuantity() {
    return selectedQuantity;
}

public void setSelectedQuantity(int selectedQuantity) {
    this.selectedQuantity = selectedQuantity;
}

public String getSelectedDate() {
    return selectedDate;
}

public void setSelectedDate(String selectedDate) {
    this.selectedDate = selectedDate;
}

public String getSelectedTime() {
    return selectedTime;
}

public void setSelectedTime(String selectedTime) {
    this.selectedTime = selectedTime;
}

@Override
public boolean equals(Object obj) {
    if (obj instanceof Cart) {
        Cart<?> cart = (Cart<?>) obj;
        return this.item.equals(cart.item);
    }
    return false;
}

@Override
public String toString() {
    return "Cart{" +
            "item=" + item +
            ", selectedQuantity=" + selectedQuantity +
            ", selectedDate='" + selectedDate + '\'' +
            ", selectedTime='" + selectedTime + '\'' +
            '}';
}

public void display() {
    if (item instanceof Medicine) {
        Medicine medicine = (Medicine) item;
        System.out.println("Item: " + medicine.getName() + ", Quantity: " + selectedQuantity);
    } else if (item instanceof Lab_Test) {
        Lab_Test labTest = (Lab_Test) item;
        System.out.println("Item: " + labTest.getName() + ", Quantity: " + selectedQuantity + ", Date: " + selectedDate + ", Time: " + selectedTime);
    }
}

}