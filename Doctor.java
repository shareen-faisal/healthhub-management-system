import java.util.ArrayList;
import java.util.Scanner;
import java.util.LinkedList;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


class Doctor extends User {
    private int id = 0;
    private static int count = 0;
    private int experience;
    private double rating;
    private double rate;
    private String category;
    private ArrayList<Appointment> appointment;
    private PriorityQueue priorityQueue;
     private String[][] slots;

     Doctor(){
        super();
        count++;
        id = count;
        slots = new String[10][10];
    }//Doctor

    Doctor(String name,String number,String address,String password,String gender,int ex,String category,String accNum){
        super(name, number, address, password, gender, accNum, 0);
        this.experience=ex;
        this.category=category;
          count++;
        id = count;
        this.appointment = new ArrayList<Appointment>();
        this.priorityQueue = new PriorityQueue();
        slots = new String[10][10];
        fill2DArray();
    }//Doctor()

     Doctor( String name, String phoneNumber, String address, String password, String gender, int experience, double rating, double rate, String category,String accNo,double amount) {
        super(name, phoneNumber, address, password, gender,accNo,amount);
        count++;
        this.id = count;
        this.experience = experience;
        this.rating = rating;
        this.rate = rate;
        this.category = category;
        this.appointment = new ArrayList<Appointment>();
        this.priorityQueue = new PriorityQueue();
        slots = new String[10][10];
        fill2DArray();
    }//Constructor

    public void fill2DArray(){

        LocalDate currentDate = LocalDate.now();

        // Convert LocalDate to String
        String dateString = currentDate.toString();

       LocalDate futureDate;
       String date = "";
       String month = "";
       int monthInt = 0;
       int dateInt = 0;

       LocalTime nextSlot;
       String formattedSlot = "";

        LocalTime currentTime = LocalTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        // Format the current time
        String formattedTime = currentTime.format(formatter);

        
        String[] array = {"0900", "0920", "0940", "1000","1020", "1040", "1900" , "1920", "1940" };

        slots[0][0] ="D/T";

        for (int i=1;  i<slots.length ; i++) {

                futureDate = currentDate.plusDays(i-1);
                monthInt = futureDate.getMonthValue();
                month = monthInt + "";
                dateInt = futureDate.getDayOfMonth();
                date = dateInt + "";
                String current=month+ "/" + date;

                if (current.length()==3) {
                current= insertCharAtIndex(current,2,'0');
             }//if
                slots[i][0] = current;
            
           int a =0;
        for (int j=1 ; j<slots[i].length ; j++ ) {
            
            slots[0][j] = array[a];
            a++;

            if (j>=0 ) {
                slots[i][j] = "O";

                if (converting(formattedTime) >  converting(slots[0][j]) ) {
                slots[1][j] = "X";
                }//if

            }//if
               
         }//for

        }//for
        

    }//fill2DArray()

     public int converting(String input){

        char c = ' ';
        String str = "";
        for (int i =0 ; i<input.length() ; i++) {
            c = input.charAt(i);
            if (Character.isDigit(c)) {
                str += c;
            }//if
        }//for

        int num = Integer.parseInt(str);

        return num;

    }//converting()



    public void appointmentHeld(Appointment app){
         System.out.println("----------------------");
        System.out.println("APPOINTMENT HELD");
        System.out.println("----------------------");
        System.out.println("\nTime is: " + app.getTime());
        System.out.println("\nDate: " + app.getDate());
        //appointment.setState("cancel");

        //appointment.add(app);

        System.out.println("It is the turn of:" + app.getCustomer().getName());

        LocalTime currentTime = LocalTime.now();

        LocalTime newTime = currentTime.plusMinutes(20);

        System.out.println("It is "+ newTime + ".\nYour time is up.");
        Appointment passed = priorityQueue.dequeue();
        appointment.add(passed);
        System.out.println("---------------------------------------------------------");

    }//appointmentHeld()

     public static String insertCharAtIndex(String originalString, int index, char charToAdd) {
        if (index > originalString.length()) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for string of length " + originalString.length());
        }

        String newString = originalString.substring(0, index) + charToAdd + originalString.substring(index);
        return newString;
    }




    @Override
    public void displayInfo() {
        System.out.println("Doctor Information:");
        System.out.println("ID: " + getID());
        System.out.println("Name: " + getName());
        System.out.println("Phone Number: " + getPhoneNumber());
        System.out.println("Address: " + getAddress());
        System.out.println("Gender: " + getGender());
        System.out.println("Experience: " + getExperience() + " years");
        System.out.println("Rating: " + getRating());
        System.out.println("Rate: " + getRate());
    }//

     public void displayDoctorInfo() {
        System.out.println("Doctor Information:");
        System.out.println("Name: " + getName());
        System.out.println("Category: " + getCategory());
        System.out.println("Phone Number: " + getPhoneNumber());
        //System.out.println("Address: " + getAddress());
        //System.out.println("Gender: " + getGender());
        System.out.println("Experience: " + getExperience() + " years");
        System.out.println("Rating: " + getRating());
        System.out.println("Rate: " + getRate());
    }//

    public int getID(){
        return id;
    }

    public int getExperience() {
        return experience;
    }

    // Getter methods for rating
    public double getRating() {
        return rating;
    }

    public double getRate() {
        return rate;
    }

     public String getCategory() {
        return category;
    }

    public PriorityQueue getPriorityQueue(){
        return priorityQueue;
    }

    public void setID(int id){
        this.id = id;
    }

    public void setExperience(int experience){
        this.experience = experience;
    }

    public void setRate(double rate){
        this.rate= rate;
    }

    public void setRating(double rating){
        this.rating =  rating;
    }

    public String toString(){

        return "Name: " + getName() + ", Category: " + getCategory() + ", Phone Number: " + getPhoneNumber()  + ", Address: " + getAddress() + ", Gender: " + getGender() + ", Experience: " + getExperience() + ", Rating: " + getRating() + ", Rate: $" + getRate(); 
    }

    public String[][] get2Array(){

        return slots;
    }//

    public ArrayList<Appointment> getAppList(){
        return appointment;
    }//



    public void displayPriorityQueue(){

        System.out.println("Appointments that have passed:");

        if (appointment.size() != 0 ) {
             
            for (int i=0 ; i<appointment.size();i++ ) {
            appointment.get(i).displayApp();
            }//for

        }else{

            System.out.println("\nNo appointments have passed yet.");
        }//if

        //System.out.println("\nTodays appointments to be conducted:");
        if (priorityQueue.getSize() !=0 ) {
             LocalDate today = LocalDate.now();

         //String todayStrindayg = today.toString();
    
            int date =0 ;
            int month = 0;

            String current="";

            month = today.getMonthValue() ;
            date = today.getDayOfMonth() ;
            current= month + "/" + date;

            NodeA temp=priorityQueue.getHead();

            // while(temp !=null){
            //   // if (temp.getdata().getDate().equals(current)) {
            //         temp.getdata().displayApp();
            //     //}//if
            //     temp= temp.getnext();
            // }//whie

            System.out.println("Appointments to be conducted:");
         priorityQueue.display();

        }else{
            System.out.println("No appointments to be conducted for today.");
        }//if
        


    }//method

public boolean equals(Object obj){

        Doctor doc = (Doctor)obj;
        if (this.getName().equals(doc.getName()) && this.getPassword().equals(doc.getPassword()) && this.getID()==doc.getID() && this.getRating()==doc.getRating() && this.getExperience()==doc.getExperience()) {
            return true;
        }else{
            return false;
        }//if
    }//equals()

}//Doctor