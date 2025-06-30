abstract class Medicine implements Item {
    private String name;
    private String manufacturer;
    private double price;
    private double weight;
    private String catagorize;
    private String warning;
    private String description;
    private int quantity;

    public Medicine(String name, String manufacturer, double price, double weight, String catagorize, String warning,
            String description, int quantity) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.weight = weight;
        this.catagorize = catagorize;
        this.warning = warning;
        this.description = description;
        this.quantity = quantity;

    }// constructor

    public abstract void displayInfo();
    // Getter methods

    public String getName() {
        return name;
    }

     public int getQuantity() {
        return quantity;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    public String getCatagorize() {
        return catagorize;
    }

    public String getWarning() {
        return warning;
    }

    public String getDescription() {
        return description;
    }

    // setter methods
    public void setName(String name) {
        this.name = name;
    }

      public void setQuantity(int quantity) {
        this.quantity=quantity;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setCatagorize(String catagorize) {
        this.catagorize = catagorize;
    }

    public void setWarning(String warning) {
        this.warning = warning;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean equals(Object obj) {
        Medicine m = (Medicine) obj;
    if (this.name == m.name) {
        return true; 
    }//if

    return false;
    }//equals

    @Override
    public String toString() {
        return "Medicine{" + "name= " + name + " Description= " + description + warning + "  Warning " + manufacturer
                + " manufacturer" + price + " price" + '}';
    }

}// class