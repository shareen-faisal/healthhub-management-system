import java.util.Arrays;
 class Lab_Test implements Item{

  //Fields
  private String name;
  private boolean SampleRequired;
  private double price;
  private int turnAroundTime;
  private String sample;
  private String category;
  private int quantity;
  private String[] timeSlots = {"9:00", "10:00", "11:00", "12:00","13:00","14:00","15:00","16:00","17:00","18:00","19:00","20:00"};
  private String[] dates = {"1-02", "2-02", "3-02", "4-02", "5-02","6-02","7-02"};

  //Default-Constructor
  public Lab_Test(){
    this.setName("null");
    this.setSampleRequired(true);
    this.setPrice(0.0);
    this.setTurnAroundTime(0);
    this.setSample("null");
    this.setCategory("null");
    this.setQuantity(0);
  }//default-cons 

  //6-Arg-Constructor
  public Lab_Test(String name,boolean SampleRequired,double price,int turnAroundTime,String sample,String category,int quantity){
   this.name = name;
   this.SampleRequired = SampleRequired;
   this.price = price;
   this.turnAroundTime = turnAroundTime;
   this.sample = sample;
   this.category = category;
   this.quantity = quantity;
  }//cons 

  //Setters
  public void setName(String name){
   this.name = name;
  }//setTestName

  public void setSampleRequired(boolean SampleRequired){
   this.SampleRequired = SampleRequired;
  }//setSampleRequired

  public void setPrice(double price){
   this.price = price;
  }//setPrice

  public void setTurnAroundTime(int turnAroundTime){
   this.turnAroundTime = turnAroundTime;
  }//setTurnAroundTime

  public void setSample(String sample){
   this.sample = sample;
  }//setSample

  public void setCategory(String category){
   this.category = category;
  }//setCategory

  public void setQuantity(int quantity){
   this.quantity = quantity;
  }//setQuantity
  
  //Getters
  public String getName(){
   return name;
  }//getTestName

  public boolean getSampleRequired(){
   return SampleRequired;
  }//getSampleRequired

  public double getPrice(){
   return price;
  }//getPrice

  public int getTurnAroundTime(){
   return turnAroundTime;
  }//getTurnAroundTime

  public String getSample(){
   return sample;
  }//getSample

  public String getCategory(){
   return category;
  }//getCategory

  public int getQuantity(){
   return quantity;
  }//getQuantity

  public String[] getTimeSlotsArray() {
    return timeSlots;
  }//getTimeSlotsArray

  public String[] getDatesArray() {
    return dates;
  }//getDatesArray

  //Display
  public void display(){
   System.out.println("TestName: " + getName());
   System.out.println("Price: " + getPrice() + " Rupees");
   System.out.println("TurnAroundTime: " + getTurnAroundTime() + " hours");
   System.out.println("Category : " + getCategory());
   System.out.println("Quantity: " + getQuantity());
   if (getSampleRequired()) {
    System.out.println("Sample is required.");
    System.out.println("Sample Type: " + getSample());
   } else {
    System.out.println("Sample is not required.");
   }//if
  }//display

  //toString
  public String toString(){
    String str = ( "TestName: " + getName() + " , Price: " + getPrice() + " , TurnAroundTime: " + getTurnAroundTime()  + " , Category: "  + getCategory() + "Quantity: " + getQuantity());

    if (getSampleRequired()) {
       str += " hours , Sample is required , Sample Type: " + this.getSample();
    } else {
       str += " hours , Sample is not required.";
    }//if
      
    return str;
  }//toString

}//class