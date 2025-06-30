class Syrup extends Medicine {
    private String flavor;
    private double mL;

    public Syrup(String name, String manufacturer, double price, double weight, String catagorize, String warning, String description,int quantity, String flavor,double mL) {
        super(name, manufacturer, price, weight, catagorize, description, warning, quantity);
        this.flavor = flavor;
        this.mL = mL;

    }// constructor

    // getter
    public String getFlavor() {
        return flavor;
    }

    // setter methods
    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }
    public double getMl() {
        return mL;
    }

    // setter methods
    public void setMl(double mL) {
        this.mL = mL;
    }

    @Override
    public void displayInfo() {
        System.out.println("Syrup: " + getName());
        System.out.println("Manufacture: " + getManufacturer());
        System.out.println("Price: " + getPrice());
        if (getQuantity()==0) {
            System.out.println("Out of Stock");
        } else {
        System.out.println("In stock"); 
        }
       
        System.out.println("Flavor: " + getFlavor());
        System.out.println("mL: " + getMl());
        System.out.println("Description: "+getDescription());
        System.out.println("Warning: "+getWarning());
        System.out.println();
    }

    // toString method
    @Override
    public String toString() {
        return "Syrup{" + "name= " + getName() + " , manufacturer= " + getManufacturer() + " , price= "
                + getPrice() + " Milliliters: " + mL +" , flavor= " + flavor + " Warning: " + getWarning()  + " Description: " +getDescription() +"}";
    }
}// class