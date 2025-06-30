class Tablet extends Medicine {
    private int dosage;

    public Tablet(String name, String manufacturer, double price, double weight, String catagorize,String warning, String description,int quantity, int dosage) {
        super(name, manufacturer, price, weight, catagorize ,description, warning,quantity);
        this.dosage = dosage;

    }// constructor

    // getter

    public int getDosage() {
        return dosage;
    }

    // setter methods

    public void setDosage(int dosage) {
        this.dosage = dosage;
    }

    @Override
    public void displayInfo() {
        System.out.println("Tablet: " + getName());
        System.out.println("Manufacture: " + getManufacturer());
        System.out.println("Price: " + getPrice());
         if (getQuantity()==0) {
            System.out.println("Out of Stock");
        } else {
        System.out.println("In stock"); 
        }
        System.out.println("Dosage: " + dosage + " mg");
        System.out.println("Description: "+getDescription());
        System.out.println("Warning: "+getWarning());
        System.out.println();
    }

    @Override
    public String toString() {
        return "Tablet{" + "name='" + getName() + '\'' + ", manufacturer='" + getManufacturer() + '\'' + ", price="
                + getPrice() + ", dosage=" + dosage +" Warning: " + getWarning()  + " Description: " +getDescription() + '}';
    }
}// class
