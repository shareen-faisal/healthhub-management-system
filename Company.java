import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Calendar;
import java.time.format.DateTimeFormatter;
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.lang.StringBuffer;



public class Company {
    private DoublyLinkedList medicines;
    private ArrayList<Order<Item>>  orders ;
    private BinaryTree bt;
    private double tax;
    private double discount;
    private ArrayList<Lab_Test> labTest;
    private ArrayList<Customer> customers;
    private ArrayList<ArrayList<Doctor> >doctors ;
    private Admin admin;


    public Company(DoublyLinkedList medicines,ArrayList<ArrayList<Doctor>> a1, ArrayList<Customer> c,String[] values, String[] s, Admin admin) {
        //this.medicines = medicines;
        this.medicines = (medicines != null) ? medicines : new DoublyLinkedList();
        this.labTest = new ArrayList<>();
        this.orders = new ArrayList<Order<Item>>();
        this.tax  = 0.05;
        this.discount = 0.1;
        //this.doctors=a1;
        //this.customers= c;
        this.doctors = (a1 != null) ? a1 : new ArrayList<>();
        this.customers = (c != null) ? c : new ArrayList<>();

       this.bt = new BinaryTree(values,s);
        //this.admin=admin;
        //this.bt = (values != null && s != null) ? new BinaryTree(values, s) : new BinaryTree();
        this.admin = (admin != null) ? admin : new Admin();
    }//Constructor

    public void runAdmin(){

        Scanner key=new Scanner(System.in);

        int input = 0;

        int check = -99;



        while(check == -99){

        System.out.println("1. Medicine");
        System.out.println("2. Lab test");
        System.out.println("3. Doctor Consultation");
        System.out.println("4. View balacne");
        System.out.println("5. View Orders");
        System.out.println("6. Exit");
        
        System.out.println("Enter input(1,2,3,4,5,6)");
        input=0;
        //  input=key.nextInt();

        // while(input<1 || input >6){
        //     System.out.println("Enter correct input");
        //     input=key.nextInt();
        // }//while

         while (input < 1 || input > 6) {
            try {

                input = key.nextInt();
                if (input < 1 || input > 6) {
                    System.out.println("Invalid input. Please enter (1, 2, 3, 4, 5, 6)");
                }//if
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                key.nextLine(); // Consume the invalid input
            }//try-catch

        }//while

        System.out.println();

        if (input==6) {
            check=-99;
            break;
        } else if (input == 3) {

              boolean flag = false;

        while(!flag){
            
            runAdminDoctor();
            System.out.println("Do you want to go to main menu. Enter 1 for main menu, 2 to remain here.");
             int in =0;

            // while(in<1 || in >2){
            // System.out.println("Enter correct input");
            // in=key.nextInt();
            // }//while 

        while (in < 1 || in > 2) {
            try {

                in = key.nextInt();
                if (in < 1 || in > 2 ) {
                    System.out.println("Invalid input. Please enter (1, 2)");
                }//if
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                key.nextLine(); // Consume the invalid input
            }//try-catch

        }//while

            if (in ==1) {

                flag = true;
            } else {
                flag = false;
            }//if

        }//while

        }else if(input == 2) {
              boolean flag = false;

            flag = false;
            //labtest

             while(!flag){
             

             runAdminLabTest();
            System.out.println("Do you want to go to main menu. Enter 1 for main menu, 2 to remain here.");
            int in=0;
            // int in=key.nextInt();

            // while(in<1 || in >2){
            // System.out.println("Enter correct input");
            // in=key.nextInt();
            // }//while 

             while (in < 1 || in > 2) {
            try {

                in = key.nextInt();
                if (in < 1 || in > 2 ) {
                    System.out.println("Invalid input. Please enter (1, 2)");
                }//if
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                key.nextLine(); // Consume the invalid input
            }//try-catch

        }//while

            if (in ==1) {
                flag = true;
            }//if

            }//while
        } else if (input==1) {

            boolean flag = false;

            flag = false;

             while(!flag){
             

             runAdminMedicine();
            System.out.println("Do you want to go to main menu. Enter 1 for main menu, 2 to remain here.");
            // int in=key.nextInt();
            int in=0;

            // while(in<1 || in >2){
            // System.out.println("Enter correct input");
            // in=key.nextInt();
            // }//while 

             while (in < 1 || in > 2) {
            try {

                in = key.nextInt();
                if (in < 1 || in > 2 ) {
                    System.out.println("Invalid input. Please enter (1, 2)");
                }//if
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                key.nextLine(); // Consume the invalid input
            }//try-catch

        }//while

            if (in ==1) {
                flag = true;
            }//if

            }//while

        } else if (input==4) {
            
        
            boolean flag = false;

              if( admin.getAccountBalance() == 0.0){
                System.out.println("Your balace is: Rs. " + admin.getAccountBalance());
               }else{
                System.out.println("Your balace is: Rs. " + admin.getAccountBalance());
               }//inner-if
          
            System.out.println("Enter 1 for main menu.");
            int in=0;
            //  int in=key.nextInt();

            // while(in<1 || in >2){
            //     System.out.println("Enter correct input");
            //     in=key.nextInt();
            // }//inner-while

             while (in < 1 || in > 1) {
            try {

                in = key.nextInt();
                if (in < 1 || in > 1 ) {
                    System.out.println("Invalid input. Please enter (1)");
                }//if
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                key.nextLine(); // Consume the invalid input
            }//try-catch

        }//while

            if (in==1) {
                flag =true;
            }//if


        } else if (input==5) {
            ViewOrders();

        }//if

        }//while

}//runAdmin()

    public void ViewOrders(){

        if (!orders.isEmpty()) {
            
        

        for (Order o : orders) {
           o.displayOrder(); 
        }//for

        } else {
            System.out.println("No orders yet.");
        }//if

    }//displayOrders

public void adminLogIn(){

        Scanner key = new Scanner(System.in);

        boolean flag = false;
    
        System.out.println("Enter your Name:");
        String input = key.nextLine();


        while (flag == false) {

        System.out.println("Enter your password:");
        String password = key.nextLine();
    
            if (admin.getPassword().equals(password)) {
                flag=true;
              
                System.out.println("--------Successfully Logged In.----------");
                break;
            }//if

            if (flag == false) {
                System.out.println("Invalid Password.Please enter again.");
            }//if
        }//while
        
    }//adminLogIn()


public void runAdminMedicine(){

    Scanner key=new Scanner(System.in);

    System.out.println("1. View Medicines ");
        System.out.println("2. Add Medicine");
        System.out.println("3. Remove Medicine");
        System.out.println("4. Analyse Medicine");

        
        System.out.println("Enter input(1,2,3,4)");
        int input=0;
        // int input=key.nextInt();

        // while(input<1 || input >4){
        //     System.out.println("Enter correct input");
        //     input=key.nextInt();
        // }//while 

         while (input < 1 || input > 4) {
            try {

                input = key.nextInt();
                if (input < 1 || input > 4 ) {
                    System.out.println("Invalid input. Please enter (1, 2, 3, 4)");
                }//if
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                key.nextLine(); // Consume the invalid input
            }//try-catch

        }//while

            if (input == 1) {
            
             displayMedicines();

            }else if (input ==2) {
            addMedicine();
            }else if (input==3) {
                removeMedicine();
            } else {
                analyzeMedicines();
            }//if
    
}//runAdminMedicine

public void runAdminLabTest(){

    Scanner key=new Scanner(System.in);
    
        System.out.println("1. View Labtests ");
        System.out.println("2. Add Labtests");
        System.out.println("3. Remove Labtests");
        
        System.out.println("Enter input(1,2,3)");
        int input=0;
        // int input=key.nextInt();

        // while(input<1 || input >3){
        //     System.out.println("Enter correct input");
        //     input=key.nextInt();
        // }//while 

         while (input < 1 || input > 3) {
            try {

                input = key.nextInt();
                if (input < 1 || input > 3 ) {
                    System.out.println("Invalid input. Please enter (1, 2, 3)");
                }//if
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                key.nextLine(); // Consume the invalid input
            }//try-catch

        }//while

            if (input == 1) {
            
             displayTests();

            }else if (input ==2) {
            addLabTest();
            }else{
                removeLabTest();
            }//if


 }//runAdminLabTest()

public void runAdminDoctor(){

    Scanner key=new Scanner(System.in);

 System.out.println("1. View Doctors ");
        System.out.println("2. Add Doctors");
        System.out.println("3. Remove Docotrs");
        System.out.println("4. View Appointments");
        
        System.out.println("Enter input(1,2,3,4)");
        int input=0;
        // int input=key.nextInt();

        // while(input<1 || input >4){
        //     System.out.println("Enter correct input");
        //     input=key.nextInt();
        // }//while 

         while (input < 1 || input > 4) {
            try {

                input = key.nextInt();
                if (input < 1 || input > 4 ) {
                    System.out.println("Invalid input. Please enter (1, 2, 3, 4)");
                }//if
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                key.nextLine(); // Consume the invalid input
            }//try-catch

        }//while

            if (input == 1) {
            
              displayDoctors();

            }else if (input ==2) {
            addDoctor();
            }else if(input==3){
                removeDoctor();
            }else{
                System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
                System.out.println("APPOINTMENTS");
                System.out.println("-----------------------------------------------------------------------------------------------------------------------------");

                for (int i=0;i<doctors.size() ; i++) {
                    
                    for (int j=0; j<doctors.get(i).size(); j++) {
                        System.out.println("Doctor: " + doctors.get(i).get(j).getName());
                        System.out.println("To be conducted:");
                        doctors.get(i).get(j).getPriorityQueue().display();
                        System.out.println("Conducted:");
                        if (doctors.get(i).get(j).getAppList().size()==0) {
                            System.out.println("No appointments conducted yet.");
                        }else{
                         System.out.println(doctors.get(i).get(j).getAppList());
                        }
                        System.out.println("----------------------------");
                        System.out.println();
                    }//inner-for
                }//outer-for
            }//if

 }//runAdminDoctor()

    public void addMedicine() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the medicine:");
        String name = scanner.nextLine();

        // Check if the medicine already exists
        if (medicineExists(name)) {
            System.out.println("Medicine already exists. Cannot add.");
            return;
        }

        System.out.println("Is it a tablet or syrup? (Enter 'tablet' or 'syrup')");
        String type = scanner.nextLine().toLowerCase();

        while(!type.equals("tablet") && !type.equals("syrup") ){

             System.out.println("(Enter 'tablet' or 'syrup')");
             type = scanner.nextLine().toLowerCase();

        }//while

        if ("tablet".equals(type)) {
            addTablet(name);
        } else if ("syrup".equals(type)) {
            addSyrup(name);
        } else {
            System.out.println("Invalid medicine type. Please enter 'tablet' or 'syrup'.");
        }
    }

    public void addTablet(String name) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the manufacturer:");
        String manufacturer = scanner.nextLine();

        System.out.println("Enter the quantity:");
        int quantity = scanner.nextInt();

        System.out.println("Enter the dosage:");
        int dosage = scanner.nextInt();

        System.out.println("Enter the catagorize:");
        String catagorize = scanner.nextLine();

        while(!medicineCategoryCheck(catagorize)){
             System.out.println("Enter the catagorize:");
             catagorize = scanner.nextLine();
        }//while

        scanner.nextLine();

        System.out.println("Enter the price:");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Enter the weigth:");
        double weight = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Enter the description:");
        String description = scanner.nextLine();

        System.out.println("Enter the warning:");
        String warning = scanner.nextLine();

        medicines.add(new Tablet(name, manufacturer, price, weight, catagorize, warning, description, quantity, dosage));
        System.out.println(name + " tablet has been added successfully.");
    }

    public void addSyrup(String name) {
        Scanner scanner = new Scanner(System.in);

         System.out.println("Enter the catagorize:");
        String catagorize = scanner.nextLine();

        while(!medicineCategoryCheck(catagorize)){
             System.out.println("Enter the catagorize:");
             catagorize = scanner.nextLine();
        }//while

        System.out.println("Enter the manufacturer:");
        String manufacturer = scanner.nextLine();

        System.out.println("Enter the price:");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        System.out.println("Enter the flavor:");
        String flavor = scanner.nextLine();

        System.out.println("Enter the mL:");
        int mL = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.println("Enter the description:");
        String description = scanner.nextLine();

        System.out.println("Enter the warning:");
        String warning = scanner.nextLine();

        // Create and add the syrup
        medicines.add(new Syrup(name, manufacturer, price, 0.0, catagorize, description, warning, 0, flavor, mL));
        System.out.println(name + " syrup has been added successfully.");
    }

    public boolean medicineExists(String name) {
        Node current = medicines.getHead();

        while (current != null) {
            if (current.getData().getName().equalsIgnoreCase(name)) {
                return true;
            }
            current = current.getNext();
        }

        return false;
    }

     public boolean medicineCategoryCheck(String name) {
        Node current = medicines.getHead();

        while (current != null) {
            if (current.getData().getCatagorize().equalsIgnoreCase(name)) {
                return true;
            }
            current = current.getNext();
        }

        return false;
    }

     public void removeMedicine() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the medicine:");
        String name = scanner.nextLine();


        Node current = medicines.getHead();
    
        while (current != null && !current.getData().getName().equalsIgnoreCase(name)) {
            current = current.getNext();
        }
    
        if (current != null) {
            // Medicine found, remove it
            Medicine medicineToRemove = current.getData();
            medicines.remove(medicineToRemove);
            System.out.println(name + " has been removed successfully.");
        } else {
            // Medicine not found
            System.out.println("No medicine available with the name: " + name);
        }
    }


     public void displayMedicines() {
        Node current = medicines.getHead();
        while (current != null) {
            current.getData().displayInfo();
            current = current.getNext();
        }
    }

    public void addLabTest() {

        Scanner key = new Scanner(System.in);
    
    System.out.println("Enter the name of the lab test:");
    String name=key.nextLine();

     if (labTestExists(name)) {

            System.out.println("Lab test with the same name already exists. Cannot add duplicate test.");

           
        } else {
            
    

    System.out.println("Is sample required for the test?");
    String sampleRequired=key.nextLine();

     boolean sampleReq= true;
    if(sampleRequired.equals("true")){
        sampleReq=true;
    }else{
        sampleReq=false;
    }//if


    System.out.println("Enter the price of the test");
    double price = key.nextDouble();

    System.out.println("Enter Turn around time :");
    int time = key.nextInt();

    key.nextLine();

    System.out.println("Enter the sample type of the lab test:");
    String sample=key.nextLine();

    System.out.println("Enter the category of the lab test");
    String category=key.nextLine();

    while(!labTestCategoryExists(category)){
         System.out.println("Enter the correct category of the lab test");
         category=key.nextLine();

    }//while

     Lab_Test newLabTest = new Lab_Test(name, sampleReq, price, time, sample, category,1);
            labTest.add(newLabTest);
            System.out.println("Lab test added successfully!");

    }//if
       
    }//addLabTest()

    // Method to check if a lab test already exists
    private boolean labTestExists(String name) {
        for (Lab_Test labTest : labTest) {
            if (labTest.getName().equalsIgnoreCase(name)) {
                return true;
            }//if
        }//for
        return false;
    }//labTestExists()

     private boolean labTestCategoryExists(String name) {
        for (Lab_Test labTest : labTest) {
            if (labTest.getCategory().equalsIgnoreCase(name)) {
                return true;
            }//if
        }//for
        return false;
    }//labTestExists()

    public void displayTests(){

    System.out.println("Lab Tests:");
    for (int i=0; i<labTest.size() ; i++) {
        labTest.get(i).display();
        System.out.println();
    }//for

 }//displayTests


    //Remove a LabTest
    public void removeLabTest(){

    Scanner key = new Scanner(System.in);

    System.out.println("Enter the name of the Lab test to rmeove");
    String name = key.nextLine();

    System.out.println("Enter the price of the Lab test to remove");
    double price =key.nextDouble();

    boolean flag = false;

    for (int i=0 ; i<labTest.size(); i++) {
       if(labTest.get(i).getPrice() == price && labTest.get(i).getName().equalsIgnoreCase(name)){
            labTest.remove(i);
            System.out.println("LabTest removed successfully.");
            flag = true;
        }//if 

    }//for

    if (flag == false) {
        System.out.println("Lab Test not found. Lab test not removed");
    }//if
    
    }//removeLabTest

    public void addDoctor(){

        Scanner key = new Scanner(System.in);

        System.out.println("Enter Docotrs name:");
        String name = key.nextLine();

        System.out.println("Enter phone number");
        String number = key.nextLine();

        number = checkPhoneNumber(number);

        System.out.println("Enter address");
        String address= key.nextLine();

        System.out.println("Enter password");
        String password = key.nextLine();

        password=checkPassword(password);

        System.out.println("Enter gender");
        String gender = key.nextLine();

        gender = checkGender(gender);

        System.out.println("Enter doctor's experience:");
        int ex = key.nextInt();

        key.nextLine();


        System.out.println("Enter category");
        String category=key.nextLine();


        System.out.println("Enter account number");
        String accNum=key.nextLine();

        Doctor doc = new Doctor(name, number,address, password, gender, ex, category, accNum);

        boolean flag = false, cat=false;
        int index=0;

        for (int i=0 ;i<doctors.size() && flag == false; i++) {
            if (doc.getCategory().equalsIgnoreCase(doctors.get(i).get(0).getCategory()) ) {
                     index = i;
                    cat=true;
                for (int j=0 ; j<doctors.get(i).size() && flag == false; j++) {
                    if (doctors.get(i).get(j).getName().equalsIgnoreCase(doc.getName()) &&  doctors.get(i).get(j).getPhoneNumber().equals(doc.getPhoneNumber()) ) {
                        
                        System.out.println("Doctor already exists.");
                       
                        flag = true;
                    }//if
                }//inner-for
            }//if
        }//for

        if (cat==true && flag==false) {
            doctors.get(index).add(doc);
            System.out.println("Doctor successfully added!");
        }else{

            doctors.add(new ArrayList<Doctor>());
           
            doctors.get(doctors.size()-1).add(doc);
            System.out.println("New category " + doc.getCategory() + " added. Doctor successfully added!");
        
        }//if

    }//addDoctor()


    public void removeDoctor(){

        Scanner key=new Scanner(System.in);


        Doctor doc= null;
        boolean flag= false;
        System.out.println("Enter the ID of the doctor that you want to remove");
        int id=key.nextInt();

        key.nextLine();

        System.out.println("Enter the category of the doctor that you want to remove");
        String cat=key.nextLine();

        for (int i=0; i<doctors.size() && flag== false; i++) {
            if (doctors.get(i).get(0).getCategory().equalsIgnoreCase(cat)) {
                for (int j=0; i<doctors.get(i).size() && flag == false; j++) {
                    if (doctors.get(i).get(j).getID()==id) {
                         doc = doctors.get(i).get(j);
                         System.out.println("Doctor Category: " + doctors.get(i).get(0).getCategory() + ", ID: " + doctors.get(i).get(j).getID() +" successfully removed.");
                         doctors.get(i).remove(doc);
                         flag= true;
                    }//if
                }//for
            }//if
        }//outer-for

        if (flag== false) {
           System.out.println("Doctor not found. Cannot be removed."); 
        }//if
        
    }// removeDoctor()

    public void displayDoctors(){

        for (int i=0;i<doctors.size() ;i++ ) {
            System.out.println(doctors.get(i).get(0).getCategory());

            for (int j=0 ; j<doctors.get(i).size();j++ ) {
                doctors.get(i).get(j).displayInfo();
                System.out.println();
            }///inner-for
        }//for

    }// displayDoctors()



    public ArrayList<Order<Item>> getOrders() {
        return orders;
    }

    public void displayAllMedicines() {
        System.out.println("1. Eye, Nose, Ear Medicines:");
        System.out.println("2. Gastrointestinal Tract Medicines:");
        System.out.println("3. Cardiovascular System Medicines:");
        System.out.println("4. Central Nervous System Medicines:");

    }// display

    public ArrayList<Medicine> displayCategoryMedicines(String str) {

        ArrayList<Medicine> temp = new ArrayList<>();

        Node current = medicines.getHead();
        int count = 1;
        while (current != null) {
            if (current.getData().getCatagorize().equals(str)) {
                temp.add(current.getData());
                System.out.println(count + "\t" + current.getData().getName() + "\t\t\t" + current.getData().getPrice());
                count++;
            } // if

            current = current.getNext();

        } // while

        if (temp.isEmpty()) {
            System.out.println("No available medicines.");
        }//if

        return temp;
    }// displayCategoryMedicines

    public ArrayList<Medicine> displayMedicinesByCategory(int categoryChoice) {

        switch (categoryChoice) {

            case 1:
                System.out.println("Eye, Nose, Ear Medicines:");
                return displayCategoryMedicines("Eye, Nose, Ear Medicines");

            case 2:
                System.out.println("Gastrointestinal Tract Medicines:");
                return displayCategoryMedicines("Gastrointestinal Tract Medicines");

            case 3:
                System.out.println("Cardiovascular System Medicines:");
                return displayCategoryMedicines("Cardiovascular System Medicines");

            case 4:
                System.out.println("Central Nervous System Medicines:");
                return displayCategoryMedicines("Central Nervous System Medicines");

            default:
                return null;
        }
    }

    public int selection(Customer c) {
        Scanner scanner = new Scanner(System.in);
        int check= 1; int exit =0;

        while(check==1){

        // Display categories
        displayAllMedicines();

        // Take user input for category

        System.out.println();
        System.out.println("Enter your choice (1, 2, 3, 4): ");
        int input = scanner.nextInt();
        while (input < 1 || input > 4) {
            System.out.println("Enter your choice (1, 2, 3, 4): ");
            input = scanner.nextInt();
        }
        // Display medicines based on user choice
        ArrayList<Medicine> selected = displayMedicinesByCategory(input);

        if (selected.isEmpty()) {

            System.out.println();
            check=0;
          
            selection(c);
        } else {

        check = method(selected,c);   // return -1 to go to main menu, 0 to view cart and 1 to select again

        if (check==-1) {
            exit=1;
        }//if

         if (check==0) {
            int ans;
            int result = payment(c);            // -2 to go to main , -1 for cancelled , 0 to continue , 1 for booked order

            if (result==-1 || result==1) {
                
               // if (result==-1) {  // cancel order
                    clearCart(c);
               // }//if
                
                System.out.println("Press 1 to continue shopping and 2 to go to main menu.");
                ans = scanner.nextInt();

                while(ans<1 || ans >2){
                    System.out.println("Press 1 to continue shopping and 2 go to main menu.");
                    ans = scanner.nextInt();
                }//while

                if (ans==2) {
                    result= -2;
                    exit=1;
                } else {
                    result= 0; 
                }//if

            }//if

            if (result==0) {
                check=1;
            }//if

        }//if

        }//if

        }//while



       return exit;

    }//selection

    public int method(ArrayList<Medicine> selected, Customer c){
        Scanner scanner = new Scanner(System.in);
         int sel=0,number=1;

        System.out.println();
        System.out.println("Enter your the medicine number");
        sel = scanner.nextInt();
        while (sel < 1 || sel > selected.size()) {
            System.out.println("Enter your the medicine number as above");
            sel = scanner.nextInt();
        } // while
        selected.get(sel - 1).displayInfo();

        System.out.println("Do you want to add this to cart. Press 1 for YES and 2 for NO.");
        int input = scanner.nextInt();
        while(input<1 || input>2){
            System.out.println("Do you want to add this to cart. Press 1 for YES and 2 for NO.");
            input = scanner.nextInt();
        }//while

        if (input==1) {

            if (addToCart(c,selected.get(sel - 1),null,null)==-1) {
                System.out.println("Medicine is out of stock.");
            }//if
           
            
        } else {

            if (c.getCart().size()==0) {        //if user wants to exit when nothing is in cart

                 System.out.println("Press 1 to select another medicine and 2 to go to  main menu.");
                input = scanner.nextInt();

              while(input<1 || input>2){
                        System.out.println("Press 1 to select another medicine and 2 go to main menu.");
                        input = scanner.nextInt();
                 }//while
                 
            
            if (input==2) {     
            return -1;          //to go to main menu
            } else {
                return 1;       //to select another medicine
            }//if

            }//if

        }//if

            if (!c.getCart().isEmpty()) {
                
            
            System.out.println("Press 1 to select another medicine and 2 to view cart.");
             input = scanner.nextInt();

              while(input<1 || input>2){
                        System.out.println("Press 1 to select another medicine and 2 to view cart.");
                        input = scanner.nextInt();
                 }//while
            
            if (input==2) {
            return 0;           //to view cart
            }//if

        }

        return 1;           //to select another medicine

    }//method


    public int addToCart(Customer c, Item i, String selectedDate, String selectedTime) {

        Scanner scanner = new Scanner(System.in);

        if (i instanceof Medicine) {

            Medicine m = (Medicine) i;
            
        System.out.println("Enter the quantity you want to buy:");
        int quantity = scanner.nextInt();

        int verificationResult = verify(quantity, m);
        if (verificationResult == 1) {

            if (c.getCart().contains(new Cart<Item>(m,0))) {
                int index = c.getCart().indexOf(new Cart<Item>(m,0));
                c.getCart().get(index).setSelectedQuantity(c.getCart().get(index).getSelectedQuantity() + quantity);
            } else {
           
            c.add(quantity, m,null, null);

            }//if

            return 1;
        } else if (verificationResult == -1) {
            return -1;
        } else {
            System.out.println("Available quantity is " + m.getQuantity() + ". Please enter a valid quantity.");
            return addToCart(c, m, null, null);
        }//if

        } else {

            Lab_Test l = (Lab_Test) i;

            c.add(1, l, selectedDate, selectedTime);                                        // as only 1 test  can be ordered
            return 1;

        }//if

    }//addToCart

    public void clearCart(Customer c){
        Medicine m;
        for (Cart temp : c.getCart()) {

            if (temp.getItem() instanceof Medicine) {
                 m = (Medicine) temp.getItem();
                m.setQuantity( m.getQuantity() + temp.getSelectedQuantity() );
            }//if
        }//for
        c.getCart().clear();
    }//clearCart

    public int verify(int quantity, Medicine m) {
        if (quantity > m.getQuantity() && m.getQuantity()!=0 ) {
            return 0;
        } else if (quantity <= m.getQuantity()) {
            m.setQuantity(m.getQuantity()-quantity);
            return 1;
        } else {
            return -1;
        }//if

    }//verify    
    
   
    public int payment(Customer c) {
        System.out.println();
        
    double totalAmount = displayCart(c);

    // Ask user if they want to confirm the order
    Scanner scanner = new Scanner(System.in);
   
    System.out.println("Do you want to confirm the order? (yes/no)");
    String confirm = scanner.nextLine();

    while(!confirm.equalsIgnoreCase("yes") && !confirm.equalsIgnoreCase("no")){
         System.out.println("Do you want to confirm the order? (yes/no)");
         confirm = scanner.nextLine();
    }//while

    if (confirm.equalsIgnoreCase("yes")) {
        // Check if the customer has enough money in their account
        if (c.getAccount().getBalance() >= totalAmount) {
            double paidAmount = 0;

            // Ask user to enter the payment amount until it matches the total amount
            while (paidAmount != totalAmount) {
                // Ask user to enter the payment amount
                System.out.println("Enter the exact amount to confirm the order: ");
                paidAmount = scanner.nextDouble();
                scanner.nextLine(); // Consume newline character

                // Validate the entered amount
                if (paidAmount != totalAmount) {
                    System.out.println("Payment amount does not match the total amount. Please enter again.");
                }//if
            }//while

            // Deduct the payment amount from the customer's account
            c.deductBalance(totalAmount);

            //add money into admins account
            admin.setAccountBalance(admin.getAccountBalance() + totalAmount);

            System.out.println("Order confirmed. Payment successful.");
            Order<Item> o = addOrder(c);
            generateBill(c,o);

            suggestHealthPlan(o);

            cancelOrder(o);
        
            return 1;           //returns 1 when order is booked

        } else {
            // Display customer's balance and ask if they want to cancel the order or remove items from the cart
            System.out.println("Insufficient balance. Your current balance is: " + c.getAccount().getBalance());
            System.out.println("Do you want to add balance into your account or cancel the order or remove items from the cart? (add/cancel/remove)");
            String action = scanner.nextLine();

            while(!action.equalsIgnoreCase("cancel") && !action.equalsIgnoreCase("remove") && !action.equalsIgnoreCase("add")){
                   System.out.println("Do you want to add balance into your account cancel the order or remove items from the cart? (add/cancel/remove)");
                   action = scanner.nextLine();
            }//while

            if (action.equalsIgnoreCase("add")) {

                while(c.getAccount().getBalance()<totalAmount){
                    c.getAccount().addBalance();
                     
                }//while

                 System.out.println("Order confirmed. Payment successful.");
                    c.deductBalance(totalAmount);

                    admin.setAccountBalance(admin.getAccountBalance() + totalAmount);

                    Order<Item> o = addOrder(c);
                    generateBill(c,o);
                    suggestHealthPlan(o);
                    cancelOrder(o);

                    return 1;                   //1 for booked order      
                
            } else if (action.equalsIgnoreCase("cancel")) {

                System.out.println("Order cancelled.");
                return-1;                                       //-1 for cancelled

            } else if (action.equalsIgnoreCase("remove")) {
                // Remove items from the cart
                while (!c.getCart().isEmpty()) {
                    displayCart(c);
                    System.out.println("Which item do you want to remove? Enter the item number: ");

                    int itemNumber;

                    do {
                        // Validate the input
                        while (!scanner.hasNextInt()) {
                            System.out.println("Invalid input. Please enter a valid item number.");
                            scanner.next();
                        }//while
                        System.out.println("Invalid input. Please enter a valid item number.");

                        itemNumber = scanner.nextInt();
                        scanner.nextLine(); // Consume newline character

                    } while (itemNumber < 1 || itemNumber > c.getCart().size());

                    c.getCart().remove(itemNumber - 1);

                    System.out.println("Item removed from the cart.");
                    displayCart(c);
                    System.out.println();

                    if (c.getCart().isEmpty()) {
                        //System.out.println("Cart is empty.");
                        break;
                    }

                    System.out.println("Do you want to remove more items? (yes/no)");
                    String removeMore = scanner.nextLine();

                    while(!removeMore.equalsIgnoreCase("yes") && !removeMore.equalsIgnoreCase("no")){
                        System.out.println("Do you want to remove more items? (yes/no)");
                        removeMore = scanner.nextLine();
                    }//while

                    if (removeMore.equalsIgnoreCase("no")) {
                        //break;
                        return payment(c);
                    }//if 

                }//if

                // If cart is empty, ask if the user wants to continue shopping
                if (c.getCart().isEmpty()) {
                    System.out.println("Cart is empty. Do you want to go to main menu or continue shopping? (menu/continue)");
                    String choice = scanner.nextLine();

                    while(!choice.equalsIgnoreCase("exit") && !choice.equalsIgnoreCase("continue")){
                         System.out.println("Cart is empty. Do you want to go to main menu or continue shopping? (menu/continue)");
                         choice = scanner.nextLine();
                    }//while

                    if (choice.equalsIgnoreCase("menu")) {

                        return -2;                  //-2 to go to main

                    } else if (choice.equalsIgnoreCase("continue")) {

                        return 0;                   //0 to continue shopping 
                      
                    }//if

                }//if

                return 1;

            }
            return 1;
        }
    } else {
        System.out.println("Order cancelled.");
        return -1;
    }

        
     }//payment

     public void suggestHealthPlan(Order<Item> o){
        ArrayList<String> types = new ArrayList<>();

        Medicine m;

        for (Cart temp : o.getList()) {

            if (temp.getItem() instanceof Medicine) {
                m = (Medicine) temp.getItem();

                if (!types.contains( m.getCatagorize() ) ) {
                    types.add( m.getCatagorize() );
                }//if

             }//if

        }//for

        if (!types.isEmpty()) {

            System.out.println("Suggesting health plan based on the medicines you order:");

        String str = "";
        if (types.contains("Eye, Nose, Ear Medicines")) {
            str+="A";
        }//if

        if (types.contains("Gastrointestinal Tract Medicines")) {
            str+="B";
        }//if

        if (types.contains("Cardiovascular System Medicines")) {
            str+="C";
        }//if

        if (types.contains("Central Nervous System Medicines")) {
            str+="D";
        }//if

        System.out.println( bt.suggest(bt.getRoot(),str,0) );

        }//if

        System.out.println();

     }//suggestHealthPlan

     public Order<Item> addOrder(Customer c){
        ArrayList<Cart<Item>> temp = new ArrayList<>();
            int i=0;
            for (Cart<Item> t : c.getCart()) {
                temp.add(c.getCart().get(i));
                ++i;
            }//for
            Order<Item> o = new Order<Item>(c.getId(),temp);
            orders.add(o);

            return o;
     }//addOrder

    public double generateBill(Customer c, Order o) {
        System.out.println();
         System.out.println("==========================================================================================================");

        System.out.println("Order Summary:");

        System.out.println("Order number: " + o.getOrderNumber());
        System.out.println("Ordering Date: " + o.getOrderingDate().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")) + "\t\tOrdering Time: " + o.getOrderingTime().format(DateTimeFormatter.ofPattern("HH:mm:ss")));

        // System.out.println("Order number: " + o.getOrderNumber());
        // System.out.println("Ordering Date: " + o.getOrderingDate() + "\t\tOrdering Time: " + o.getOrderingTime());
        System.out.println();
        c.display();
        double t = displayCart(c);
        return t;
    }//generate bill

     public double displayCart(Customer c) {
        System.out.println("==========================================================================================================");
    System.out.println("Cart Details:");
    
    if (c.getCart() == null || c.getCart().isEmpty()) {
        System.out.println("Your cart is empty.");
    } else {
        System.out.println("   Item\t\tQuantity\tPrice per quantity");
        double total = 0;
        int number=1;
        for (Cart temp : c.getCart()) {

            if (temp.getItem() instanceof Medicine) {
                System.out.println(number+" "+temp.getItem().getName() + "\t\t" + temp.getSelectedQuantity() + "\t\t" + temp.getItem().getPrice());

                ++number;
            } else {
                System.out.println(number+" "+temp.getItem().getName() + "\t\t" + "1" + "\t\t" + temp.getItem().getPrice() + "\t\tSelected Date:" + temp.getSelectedDate() + "\t\tSelected Time:" + temp.getSelectedTime()); 
                ++number;
            }//if

        }//for
        System.out.println();
        double t = calculateTotal(c);
        System.out.println("==========================================================================================================");

        return t;
        
    }//if

    System.out.println();

    return 0.0;

    }//displayCart




public double calculateTotal(Customer c) {
    System.out.println("======== 10% DISCOUNT ON ALL ORDERS ABOVE 5000 ===========");
    System.out.println("Bill Summary:");
    double total = 0.0;

    for (Cart temp : c.getCart()) {
        double itemTotal = temp.getItem().getPrice() * temp.getSelectedQuantity();
        total += itemTotal;
        System.out.printf("%d x %.2f = %.2f\n", temp.getSelectedQuantity(), temp.getItem().getPrice(), itemTotal);
    }

    double calculatedTax = total * 0.10;
    total += calculatedTax;
    System.out.printf("Tax (10%%): %.2f\n", calculatedTax);

    if (total > 5000) {
        double calculatedDiscount = total * 0.10; // Calculate discount based on total including tax
        total -= calculatedDiscount;
        System.out.printf("Discount (10%% on orders above Rs.5000): %.2f\n", calculatedDiscount);
    }

    DecimalFormat df = new DecimalFormat("#.##"); // Define DecimalFormat
    String formattedTotal = df.format(total); // Format total value
    System.out.printf("Total (including tax and discount if applicable): %s\n", formattedTotal);

    System.out.println();

    return Double.parseDouble(formattedTotal); // Return formatted total value
}



    public void cancelOrder(Order<Item> o){
       
    Scanner scanner = new Scanner(System.in);

    // Ask the user if they want to cancel the order
    System.out.print("Do you want to cancel the order? (yes/no): ");
    String choice = scanner.nextLine().toLowerCase();

    while(!choice.equals("yes") && !choice.equals("no")){

        System.out.print("Do you want to cancel the order? (yes/no): ");
        choice = scanner.nextLine().toLowerCase();

    }//while

    if (choice.equals("yes")) {
        // Iterate through the items in the order's cart
        ArrayList<Cart<Item>> orderItems = o.getList();
        for (int i = 0; i < orderItems.size(); i++) {
            Cart<Item> cartItem = orderItems.get(i);
            Item item = cartItem.getItem();

            if (item instanceof Medicine) {
                // If the item is a medicine, update its quantity
                Medicine medicine = (Medicine) item;
                medicine.setQuantity(medicine.getQuantity() + cartItem.getSelectedQuantity());
            }

            // Remove the cart item from the order's cart
            orderItems.remove(i);
            i--; // Adjust index after removal
        }

        // Remove the order from the company's order list
        orders.remove(o);

        // Display success message
        System.out.println("Order successfully removed.");
    } else {
        // User chose not to cancel the order
        System.out.println("Order cancellation canceled by the user.");
    }

    }//cancelOrder


    public ArrayList<Medicine> searchMed(String query) {
        ArrayList<Medicine> results = new ArrayList<>();
    
        Node current = medicines.getHead();
    
        while (current != null) {
            if (current.getData() instanceof Tablet) {
                Tablet tablet = (Tablet) current.getData();
                if (tablet.getName().toLowerCase().startsWith(query.toLowerCase())) {
                    results.add(tablet);
                }
            } else if (current.getData() instanceof Syrup) {
                Syrup syrup = (Syrup) current.getData();
                if (syrup.getName().toLowerCase().startsWith(query.toLowerCase())) {
                    results.add(syrup);
                }
            }
            current = current.getNext();
        }
    
        return results;
    }//search med
 

public int doSearch(Customer c) {
    Scanner scan = new Scanner(System.in);
    boolean b=true;
    int exit=0;
    while (b) {
        System.out.print("Search Medicine : ");
        String value = scan.nextLine();

        ArrayList<Medicine> searchResults = searchMed(value);

        if (searchResults.isEmpty()) {
            System.out.println("No medicine found with the given search criteria.");

            // Prompt user for exit or search again
            System.out.print("Do you want to go to main menu or search again? (menu/search): ");
            String choice = scan.nextLine().toLowerCase();

            while (!choice.equals("menu") && !choice.equals("search")) {
                System.out.print("Invalid choice. Please enter 'menu' or 'search': ");
                choice = scan.nextLine().toLowerCase();
            }

            if (choice.equals("menu")) {
                exit=1;
                b=false;
            }//if

        }else {
            // Print the search results
            System.out.println("Search Results:");
            int count=1;
            for (Medicine result : searchResults) {
                System.out.println(count +" "+result.getName() + "\t\t" + result.getPrice());
                ++count;
            }//for

            int check = method(searchResults,c);

            if(check==1){
                doSearch(c);
            }//if

             if (check==0) {
               
            int ans;
            int result = payment(c);

            if (result==-1 || result==1) {
                
                clearCart(c);
                System.out.println("Press 1 to continue shopping and 2 to go to main menu.");
                ans = scan.nextInt();

                while(ans<1 || ans >2){
                    System.out.println("Press 1 to continue shopping and 2 to go to main menu.");
                    ans = scan.nextInt();
                }//while

                if (ans==2) {
                    result= -2;
                    exit=1;
                } else {
                    result= 0; 
                }//if

            }//if

            if (result==0) {
                check=1;
            }//if
              
             }//if

            b=false;

        }//if
        
    }//while

    System.out.println();

    return exit;

}//doSearch

    public int runMedicine(Customer c){
         int exit=0;
          while(exit==0){



        Scanner key = new Scanner(System.in);
        System.out.println("1. View Categories\n2. Search\nEnter (1 or 2)");
        int input = key.nextInt();

        while(input<1 || input>2){
            System.out.println("1. View Categories\n2. Search\nEnter (1 or 2)");
            input = key.nextInt();
        }//while

        if (input==1) {
            exit = selection(c);            
        } else {
           exit =  doSearch(c);
        }//if

        }//while

        return exit;   // 1 for main menu

    }//runMedicine




//============================================================ LABTEST ===========================================================================================================


  public void runLabTest(Customer c){
    System.out.println("--------------------------");
    System.out.println("1. View Categories");
    System.out.println("2.Search a Lab Test");
    System.out.println("--------------------------");
    System.out.println("Press 1 to view categories, press 2 to search a Lab test");

    Scanner keyword = new Scanner(System.in);
    int input = keyword.nextInt();  

    while(input < 1 || input > 2){
        System.out.println("Please enter correct input");
        input = keyword.nextInt();
    }//while

    if (input ==1 ) {
        displayCategory(c);
    }else{
        searchAndDisplayLabTests(labTest, c);
    }//if

  }//runLabTest()

  public void addSorted(Lab_Test newTest) {
        if(labTest.size() == 0){
          labTest.add(newTest);
        }//if
        else {
        //Binary search for insertion point
        int low = 0;
        int high = labTest.size() - 1;

        

        while(low <= high){
          int mid = (low + high) / 2;
          int comparisonResult = newTest.getName().compareToIgnoreCase(labTest.get(mid).getName());

          if(comparisonResult > 0){
              low = mid + 1;
          }else if(comparisonResult < 0){
              high = mid - 1;
          }else {
           // If names are equal, insert at this point
            labTest.add(mid, newTest);
            return;
          }//else
        }//while

        // Insert at low index if not found
        labTest.add(low, newTest);
    }//else
    }//addSorted

  //DisplayCategory
  public void displayCategory(Customer c){
    System.out.println("--------------------");
   System.out.println("1.Blood Test: ");
   System.out.println("2.Diabetes Tests: ");
   System.out.println("3.Heart Health Tests: ");
   System.out.println("4.Thyroid Tests: "); 
    System.out.println("--------------------");

   selectCategory(c);

  }//displayCategory

  //SelectCategory
  public void selectCategory(Customer c){
   Scanner keyword = new Scanner(System.in);
   System.out.println();

   System.out.println("Enter the Categories(1,2,3,4): ");
   int categoryNumber = keyword.nextInt();

    while(categoryNumber <1 || categoryNumber > 4){
     System.out.println("Enter correct desired category(1,2,3,4) withing the range: ");
     categoryNumber = keyword.nextInt();
    }//while
   displayTestsInCategory(categoryNumber, c);

  }//selectCategory

  //displayTestsInCategory
  public void displayTestsInCategory(int categoryNumber, Customer c) {

    ArrayList<Lab_Test> selectedTests = new ArrayList<>();
    System.out.println("\nDisplaying Tests for Category " + categoryNumber + ":");
    if(categoryNumber == 1){
        int count = 1;
       for(int i = 0; i < labTest.size(); i++){
        if(labTest.get(i).getCategory().equals("Blood")){
         System.out.println(count + ". " +labTest.get(i).getName());
         selectedTests.add(labTest.get(i));
         count++;
        }//if
       }//for 
    }else if(categoryNumber == 2){
       int count = 1;
       for(int i = 0; i < labTest.size(); i++){
        if(labTest.get(i).getCategory().equals("DiabetesTests")){
        System.out.println(count + ". " +labTest.get(i).getName());
         count++;
         selectedTests.add(labTest.get(i));
        }//if
       }//for  
    }else if (categoryNumber == 3){
        int count = 1;
       for(int i = 0; i < labTest.size(); i++){
        if(labTest.get(i).getCategory().equals("HeartHealth")){
         System.out.println(count + ". " + labTest.get(i).getName());
         count++;
         selectedTests.add(labTest.get(i));
        }//if
       }//for  
    }else if(categoryNumber == 4){
        int count = 1;
       for(int i = 0; i < labTest.size(); i++){
        if(labTest.get(i).getCategory().equals("Thyroid")){
         System.out.println(count + ". " +labTest.get(i).getName());
         count++;
         selectedTests.add(labTest.get(i));
        }//if
       }//for 
    }//if

    if (selectedTests.isEmpty()) {
        System.out.println("No available test.");
        System.out.println();
        displayCategory(c);
        
    } else {

    Scanner keyword = new Scanner(System.in);
    System.out.println("\nEnter the Test Number to display details:");
    int selectedTestNumber = keyword.nextInt();

    while(selectedTestNumber <1 || selectedTestNumber > selectedTests.size()){
     System.out.println("\nEnter the correct Test Number to display details:");
     selectedTestNumber = keyword.nextInt();
    }//while

   // if(selectedTestNumber >= 1 && selectedTestNumber <= selectedTests.size()){
     Lab_Test selectedTest = selectedTests.get(selectedTestNumber - 1);
     System.out.println();
      selectedTest.display();

        System.out.println("\nDo you want to add this to cart? Press 1 for YES, 2 for NO");
                    int input = keyword.nextInt();
                    int result= -99;

                    while(input <1 || input > 2){
                         System.out.println("Enter correct input(1,2)");
                        input = keyword.nextInt();
                    }//while


                    if (input ==1) {
                    System.out.println();
                     System.out.println("Dates:");
                     String[] array =  selectedTest.getDatesArray(); 
                     String[] array2 =  selectedTest.getTimeSlotsArray(); 

                     for (String str: array) {
                       System.out.print(str + ", ");
                     }

                    
                     System.out.println("\n\nTime Slots:");
                      for (String str: array2) {
                       System.out.print(str + ", ");
                     }
                     String date=getUserInputDate(selectedTest);
                     String time=getUserInputTime(selectedTest);
                     System.out.println();

                      addToCart(c, selectedTest, date, time);

                       System.out.println("\n-----Do you want to select another Lab test or view cart? Press 1 for Lab Test , 2 for Viewing cart------");
                      input = keyword.nextInt();

                      while(input<1 || input > 2){
                            System.out.println("Enter correct input.");
                            input=keyword.nextInt();
                        }//while

                        if (input==1) {
                            runLabTest(c);
                        }else{
                           
                                result =  payment(c);

                                if (result==1) {
                                    clearCart(c);
                                }//if

                               if (result==0) {
                                runLabTest(c);
                                   
                               }//if
                               if (result==-1) {
                                clearCart(c);
                                   
                               }//if

                               if (result==-2) {
                                   runCompany(c);
                               }//if

                           
                        }//if

                    } //if

                    if (input==2 || result==-1 || result==-2) {

                        if (result!=-2) {
                            
                        System.out.println("-------Do you want to select another lab test or go to main menu? Press 1 to select another lab test, Press 2 for go to Main Menu------");
                        input = keyword.nextInt();

                        while(input<1 || input > 2){
                            System.out.println("Enter correct input.");
                            input=keyword.nextInt();
                        }//while

                        if (input==1) {
                            runLabTest(c);
                        }else{

                            runCompany(c);

                        }//if

                        } else {
                            runCompany(c);
                        }//if


                    }//if
    }//if
   
  }//displayTestsInCategory

       public ArrayList<Lab_Test> searchByPrefix(String prefix) {
        ArrayList<Lab_Test> result = new ArrayList<>();

        // Binary search for leftmost occurrence of prefix
        int low = 0;
        int high = labTest.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            String testName = labTest.get(mid).getName();

            if (testName.toLowerCase().startsWith(prefix)) {
                high = mid - 1; // Search for leftmost occurrence
            } else if (prefix.compareToIgnoreCase(testName.toLowerCase()) < 0) {
                high = mid - 1; // Search in the left half
            } else {
                low = mid + 1; // Search in the right half
            }//else
        }//while

        // Linear scan for matching elements
        for (int i = low; i < labTest.size() && labTest.get(i).getName().toLowerCase().startsWith(prefix); i++) {
            result.add(labTest.get(i));
        }//for

        return result;
    }//searchByPrefix

 

public void searchAndDisplayLabTests(ArrayList<Lab_Test> labTests, Customer c) {
    Scanner keyword = new Scanner(System.in);
    boolean continueSearching = true;

    while (continueSearching) {
        System.out.println();
        System.out.print("Search for a lab test (enter 'menu' to go to main menu): ");
        String searchTerm = keyword.nextLine().toLowerCase();

        if (searchTerm.equals("menu")) {
            runCompany(c);
        } else {

        //boolean found = false;
         ArrayList<Lab_Test> results = searchByPrefix(searchTerm);   
        System.out.println("Search Results for: " + searchTerm);
        for (Lab_Test labTest : results) {
            
                System.out.println("Name: " + labTest.getName() + ", Price: " + labTest.getPrice());
               
            
        }

        if(results.isEmpty()) {
            System.out.println("No test available for the entered query.");
        } else {
            System.out.print("\nEnter the name of the test for details:\n ");
            String selectedTest = keyword.nextLine().toLowerCase();
            boolean testFound = false;

            for (Lab_Test labTest : results) {
                if (labTest.getName().toLowerCase().equals(selectedTest)) {
                    System.out.println("\nTest Details: ");
                    labTest.display();

                    int result=-99;

                    System.out.println("------Do you want to add this to cart? Press 1 for YES, 2 for NO--------");
                    int input = keyword.nextInt();

                    while(input <1 || input > 2){
                         System.out.println("Enter correct input(1,2)");
                        input = keyword.nextInt();
                    }//while


                    if (input ==1) {
                           System.out.println();
                     System.out.println("Dates:");
                     String[] array =  labTest.getDatesArray(); 
                     String[] array2 =  labTest.getTimeSlotsArray(); 

                     for (String str: array) {
                       System.out.print(str + ", ");
                     }//for
                    
                     System.out.println("\n\nTime Slots:");
                      for (String str: array2) {
                       System.out.print(str + ", ");
                     }//for
                     String date =  getUserInputDate(labTest);
                    String time = getUserInputTime(labTest);

                     addToCart(c,labTest,date,time);

                     System.out.println("-------Do you want to select another Lab test or view cart? Press 1 for Lab Test , 2 for Viewing cart--------");
                      input = keyword.nextInt();

                      while(input<1 || input > 2){
                            System.out.println("Enter correct input.");
                            input=keyword.nextInt();
                        }//while

                        if (input==1) {
                            runLabTest(c);
                        }else{

                            result =  payment(c);

                               if (result==1) {
                                    clearCart(c);
                                }//if

                               if (result==0) {
                                runLabTest(c);   
                               }//if

                               if (result==-1) {
                                clearCart(c); 
                               }//if

                               if (result==-2) {
                                   //exit
                               }//if

                        }//if

                    }else{

                        if (input==2 || result==-1 || result==-2) {

                        if (result!=-2) {
                            
                        System.out.println("Do you want to select another lab test or go to main menu? Press 1 for LabTest, 2 to go to main menu");
                        input = keyword.nextInt();

                        while(input<1 || input > 2){
                            System.out.println("Enter correct input.");
                            input=keyword.nextInt();
                        }//while

                        if (input==1) {
                            runLabTest(c);
                        }else{
                            runCompany(c);
                        }//if

                        } else {
                            runCompany(c);
                        }//if


                        }//if

                    }//if

                 
                    testFound = true;
                    break;
                }
            }
            if (!testFound) {
                System.out.println("Selected test not found.");
            } else {
                continueSearching = false; // Stop searching if test details are displayed
            }//if
        }
    }

    }//if

     
}//


public String getUserInputDate(Lab_Test lb) {
  Scanner keyword = new Scanner(System.in);
    System.out.println();
    System.out.println("Enter the date (DD-MM): ");
    String inputDate = keyword.nextLine();

    while (!isValidDate(inputDate, lb)) {
        System.out.println("Invalid date. Please enter a valid date (DD-MM): ");
        inputDate = keyword.nextLine();
    }
    return inputDate;
}

public boolean isValidDate(String date, Lab_Test lb) {

    String[] validDates = lb.getDatesArray();
    for (String validDate : validDates) {
        if (validDate.equals(date)) {
            return true;
        }
    }
    return false;
}

public String getUserInputTime(Lab_Test lb) {
  Scanner keyword = new Scanner(System.in);
    System.out.println("Enter the time: ");
    String inputTime = keyword.nextLine();

    while (!isValidTime(inputTime, lb)) {
        System.out.println("Invalid time. Please enter a valid time : ");
        inputTime = keyword.nextLine();
    }
    return inputTime;
}

public boolean isValidTime(String time, Lab_Test lb) {

    String[] valid = lb.getTimeSlotsArray();
    for (String validDate : valid) {
        if (validDate.equals(time)) {
            return true;
        }
    }
    return false;
}


//=========================================== Doctor =====================================================================================================


public void runConsultation(Customer c){
        displayDoctorCategory(c);

        Scanner key=new Scanner(System.in);

         System.out.println("Press 1 to book another appointment, press 2 to for Main Menu");
       int input=key.nextInt();

      while(input <1 || input > 3){

        System.out.println("Enter correct input(1 or 2)");
         input=key.nextInt();
      }//while

      if (input == 1) {
        runConsultation(c);
      }else if(input ==2 ){
        runCompany(c);
      }


    }//runConsultattion()

     public void adminComission(int doctorInput, int number){

        // Get the rate of the doctor
        double rate = doctors.get(number - 1).get(doctorInput - 1).getRate();

        // Calculate 20% of the rate
        double adminCommission = 0.2 * rate;

        // Add 20% of the rate to the admin's existing balance
        double adminBalance = admin.getAccountBalance();
        admin.setAccountBalance(adminBalance + adminCommission);

        // Add the rest of the money to the doctor's existing balance
        double doctorBalance = doctors.get(number - 1).get(doctorInput - 1).getAccountBalance();
        doctors.get(number - 1).get(doctorInput - 1).setAccountBalance(doctorBalance + (rate - adminCommission));
    }//adminCommission()


    public void runDoctor(){
        Scanner key = new Scanner(System.in);

        System.out.println("---------------Doctor----------------");

        System.out.println("1.Login");

        System.out.println("\nPress 1 for Login");
        int input=0;

        // int input=key.nextInt();

        // while(input != 1){
        //     System.out.println("Enter within the specified range");
        //     input=key.nextInt();
        // }//while

        while (input < 1 || input > 1) {
            try {

                input = key.nextInt();
                if (input < 1 || input > 1) {
                    System.out.println("Invalid input. Please enter (1)");
                }//if
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                key.nextLine(); // Consume the invalid input
            }//try-catch

        }//while

            Doctor doc = logIn();

            if (doc != null) {
                
            

            boolean flag= false;

            while(flag == false){

            System.out.println("\n1. View Appointments");
            System.out.println("2. View Balance");

            System.out.println("\nPress 1 to view your appointments, Press 2 to view your balance.");
            // int in = key.nextInt();
            int in=0;

            // while(in<1 || in >2){

            //     System.out.println("Enter correct input");
            //     in=key.nextInt();
            // }//while

            while (in < 1 || in > 2) {
            try {

                in = key.nextInt();
                if (in < 1 || in > 2) {
                    System.out.println("Invalid input. Please enter (1, 2)");
                }//if
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                key.nextLine(); // Consume the invalid input
            }//try-catch

        }//while

            if (in ==1 ) {
                doc.displayPriorityQueue();
                System.out.println();

            }else if (in ==2 ) {
               if( doc.getAccountBalance() == 0.0){
                System.out.println("Your balace is: Rs. " + doc.getAccountBalance());
               }else{
                System.out.println("Your balace is: Rs. " + doc.getAccountBalance());
               }//inner-if
            }//outer-if
            System.out.println("Press 1 remain here, press 2 to exit");
            //  in=key.nextInt();
            in=0;

            // while(in<1 || in >2){
            //     System.out.println("Enter correct input");
            //     in=key.nextInt();
            // }//inner-while

            while (in < 1 || in > 2) {
            try {

                in = key.nextInt();
                if (in < 1 || in > 2) {
                    System.out.println("Invalid input. Please enter (1, 2)");
                }//if
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                key.nextLine(); // Consume the invalid input
            }//try-catch

        }//while

            if (in==1) {
                flag =false;
            }else{
                flag = true;
            }//if

        }//outer-while

    }else{
        System.out.println("Invalid Docotr!\n");
    }//if

    }//runDoctor()



        public Doctor logIn(){

        Scanner key = new Scanner(System.in);

        boolean flag = false;
        Doctor doc = null;

        System.out.println("Enter your Name:");
        String input = key.nextLine();


        while (flag == false) {

        System.out.println("Enter your ID");
        int id = key.nextInt();

        key.nextLine();

        System.out.println("Enter your password:");
        String password = key.nextLine();

        for ( int i=0; i<doctors.size(); i++ ) {

          for (int j=0 ; j<doctors.get(i).size() ; j++ ) {

            if (doctors.get(i).get(j).getID()==id && doctors.get(i).get(j).getPassword().equals(password)) {
                flag=true;
                doc=doctors.get(i).get(j);
                System.out.println("--------Successfully Logged In.----------");
                break;
            }//if

        }//inner-for
         }//for

            if (flag == false) {
                System.out.println("Invalid ID or Password.\n Do you want to input again. press 1 to re enter, 2 to top");
                int in=key.nextInt();

                while(in<1 || in>2){
                    System.out.println("Enter correct input");
                    in=key.nextInt();
                }//while

                if (in==1) {
                    flag=false;
                }else{
                    flag=true;
                }//if

            }//if

        }//while

        return doc;
        

    }//login()

    
    public void displayDoctorCategory(Customer c){
        if (doctors.size() != 0) {
            
        System.out.println();
        System.out.println("--------------------------");
        System.out.println("Categories:");
        int count=1;

        System.out.println("--------------------------");
        for (int i=0 ;i<doctors.size() ; i++) {
            
                System.out.println(count + ". " + doctors.get(i).get(0).getCategory());
                count++;
        }//for
        System.out.println("--------------------------");
        selectDoctorCategory(c);
        }else{
            System.out.println("No Caegories available.\nGoing to Main Menu\n");
            runCompany(c);
        }//if

    }//displayCategory()

    public void selectDoctorCategory(Customer c){

        Scanner key = new Scanner(System.in);
        System.out.println();
        System.out.println("Enter your desired category number (1,2..): ");
        int input = key.nextInt();

        while(input <1 || input > doctors.size()){
            System.out.println("Enter correct desired category number (1,2..) withing the range: ");
            input = key.nextInt();
        }//while

        System.out.println();

        displayDoctorsInCategory(input, c);

    }//selectCategory()

    public void displayDoctorsInCategory(int number, Customer c){

        Scanner keyborad = new Scanner(System.in);
        int count=0;
        
            System.out.println();
            System.out.println( "---------"+ doctors.get(number-1).get(0).getCategory() + "---------");
           
            for (int i=0 ;i <doctors.get(number-1).size() ; i++) {
               System.out.print(count+1 + ". ");
                doctors.get(number-1).get(i).displayDoctorInfo();
                count++;
                System.out.println();
            }//for


        if (doctors.get(number-1).size() == 0) {
            System.out.println("No available doctors in this category.");
            System.out.println("Press 1 to choose another category, press 2 to return to main menu");

            int input=keyborad.nextInt();

            while(input<1 || input >2){
                System.out.println("Enter correct input(1 or 2)");
                input=keyborad.nextInt();
            }//while

            if (input ==1) {
                displayCategory(c);
            }else{
                runCompany(c);
            }//if

        }else{

        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println("Do you want to filter the doctors on the basis of ratings.(Press 1 for Yes, 2 to select without filteration)");
        System.out.println("------------------------------------------------------------------------------------------------------------");
        int answer = keyborad.nextInt();

        while(answer <1 || answer >2){
            System.out.println("Please enter a valid input");
            answer=keyborad.nextInt();
        }//while

        if (answer == 1) {
            filterDoctors(number, c);
        }else{
            selectDoctor(number, c);
        }//if

        }//if

    }//displayCardiologist()

    public void selectDoctor(int number, Customer c){
        Scanner key = new Scanner(System.in);
        System.out.println();

        System.out.println("Select a doctor(Enter 1,2,...):");
        int doctorInput = key.nextInt();

        while(doctorInput <= 0 || doctorInput > doctors.get(number-1).size()){
            System.out.println("Select a doctor within the range:");
            doctorInput = key.nextInt();
            System.out.println();
        }//while

        System.out.println();


        displaySlots(doctorInput, number, c);

    }//selectDoctor()

    public  void displaySlots(int doctorInput, int number  , Customer c){

        String[][] array = doctors.get(number-1).get(doctorInput-1).get2Array();
        

        System.out.println("Schedule of Doctor:" + doctors.get(number-1).get(doctorInput-1).getName());
        System.out.println("\n---------------------------------------------------------------------------------------");
        for (int i=0 ; i<array.length ; i++) {
            for (int j=0 ; j<array[i].length ; j++) {
                System.out.print(String.format("%-4s |   ",  array[i][j]));

            }//inner
             System.out.println("\n---------------------------------------------------------------------------------------");
            System.out.println();
        }//outer
        
        bookAppointment(doctorInput,number, c);

    }//displaySlots()


    public void bookAppointment(int doctorInput, int number, Customer c){

      Scanner key = new Scanner(System.in);
      System.out.println();

      LocalDate currentDate = LocalDate.now();

      String dateString = currentDate.toString();


      LocalDate futureDate;
       String future="";
       String fdate = "";
       String fmonth = "";

        String current="";

        futureDate = currentDate.plusDays(9);
        fmonth = futureDate.getMonthValue() + "";
        fdate = futureDate.getDayOfMonth() + "";
        future= fmonth + "/" + fdate;

      
        fmonth = currentDate.getMonthValue() + "";
        fdate = currentDate.getDayOfMonth() + "";
        current= fmonth+"/"+fdate;
           

        System.out.println("Enter prefferd date:");
        String date = key.nextLine();

        if (future.length()==3) {
            future= insertCharAtIndex(future,2,'0');
        }//if

        while(convert(date) < convert(current) || convert(date) > convert(future)){

            System.out.println("Enter prefferd date within the correct range/format:");
            date = key.nextLine();
        }//while


        System.out.println();

        System.out.println("Enter prefferd time:");
        String time = key.nextLine();

        while( (convert(time) >= 900 && convert(time) <= 1940) && (time.length() !=4 ) ){
            System.out.println("Enter prefferd time  correct format:");
            time = key.nextLine();
        }//while

        while(convert(time) < 900 || convert(time) > 1940){

            System.out.println("Enter prefferd time within the correct range:");
            time = key.nextLine();
        }//while

            if(check(date, time, doctorInput, number)){

                    System.out.println("Press 1 to confirm booking, Press 2 to return to main menu");
                int input=key.nextInt();

                while(input<1 || input >2){
                    System.out.println("Enter correct input(1 or 2)");
                    input=key.nextInt();;
                }//while

                if (input ==1) {

                    int result=paymentDoctor(doctors.get(number-1).get(doctorInput-1),c);

                        if (result == 1){

                            adminComission(doctorInput,number);

                            Appointment app = new Appointment( time, date, c , doctors.get(number-1).get(doctorInput-1));
                            System.out.println("-----------------------------------------");
                            System.out.println("APPOINTMENT SUMMARY");
                            System.out.println("-----------------------------------------");
                            System.out.println("Customer: " + c.getName());
                            System.out.println("Your appointment is booked for \nDate:" + date + "\nTime:" + time);
                            System.out.println("Doctor: " + doctors.get(number-1).get(doctorInput-1).getName() + "\nCategory: " + doctors.get(number-1).get(doctorInput-1).getCategory() + "\nPrice: " + doctors.get(number-1).get(doctorInput-1).getRate());
                            System.out.println("-----------------------------------------");
                            doctors.get(number-1).get(doctorInput-1).getPriorityQueue().enqueue(app);

                        }//if

                }else{
                        System.out.println("Exited from Doctor Consultion Successfully\n");
                        runCompany(c);//
                        //return -1;
                }//if
            
            }else{
                System.out.println("Slot unavailable");
                bookAppointment(doctorInput, number,c);
            }//if
  
                
        System.out.println();

       // return 1;

    }//bookAppointment()

     public static String insertCharAtIndex(String originalString, int index, char charToAdd) {
        if (index > originalString.length()) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for string of length " + originalString.length());
        }

        String newString = originalString.substring(0, index) + charToAdd + originalString.substring(index);
        return newString;
    }

       public void removeAppointment(){
        
         for (int i=0 ;i<doctors.size() ; i++) {
        for (int j=0; j<doctors.get(i).size(); j++) {
      NodeA current = doctors.get(i).get(j).getPriorityQueue().getHead();
      if (doctors.get(i).get(j).getPriorityQueue().getSize() !=0 ) {
           doctors.get(i).get(j).appointmentHeld(current.data);
           
      }//if
      }//for
      break;
    }//for


     }//

    public boolean check(String date, String time,int doctorInput, int number){

        String[][] array = doctors.get(number-1).get(doctorInput-1).get2Array();

        for (int i=1 ; i<array.length; i++) {
            if (array[i][0].trim().equals(date.trim())) {                                                    //trim() removes space in a String
                for (int j=1 ; j<array[i].length ; j++) {
                    if (array[0][j].trim().equals(time.trim()) && array[i][j].equals("O")) {
                        array[i][j] = "X";
                        return true;
                    }//inner-if
                }//inner-for
            }//outer-if
        }//for

        return false;
    }//check()

    public int convert(String input){

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

    }//convert()

    public int paymentDoctor(Doctor doc, Customer c){

        Scanner key= new Scanner(System.in);

        if (doc.getRate() > c.getAccount().getBalance()) {
            System.out.println("---------------------------------------");
            System.out.println("Your balance is Rs. " +  c.getAccount().getBalance() + "\nYour balance is insufficient.");

            System.out.println("\nDo you want to add balance into your account. Press 1 for YES and 2 for No.");

            int input=key.nextInt();

            while(input<1 || input >2){
                System.out.println("Enter correct inpput(1 or 2)");
                input=key.nextInt();
            }//while

            if (input ==1 ) {
                c.getAccount().addBalance();

                while(doc.getRate() > c.getAccount().getBalance()) {
                    c.getAccount().addBalance();

                }//while

                return 1;

            }else{
                return 0;
            }//if


        }else{

            System.out.println("You have sufficient balance.\n");
            return 1;
        }

        
    }//paymentDoctor()

    public void filterDoctors(int number, Customer c){

        System.out.println("-----------------------");
        System.out.println("Filter by Ratings");
        System.out.println("-----------------------");
        System.out.println("Choose a range to filter");
        System.out.println("1.  1 to 1.9");
        System.out.println("2.  2 to 2.9");
        System.out.println("3.  3 to 3.9");
        System.out.println("4.  4 to 5");

        Scanner keyborad = new Scanner(System.in);
        int input = keyborad.nextInt();

        while(input <1 || input > 4){
            System.out.println("Enter the correct input(1,2,3,4)");
            input=keyborad.nextInt();
        }//while

        boolean flag = false;
        int count=1;
        ArrayList<Doctor> filtered = new ArrayList<Doctor>();
        System.out.println("-------------------------------------");

        if (input == 1 ) {
            
            for (int i=0 ; i<doctors.get(number-1).size() ; i++) {
                if (doctors.get(number-1).get(i).getRating() >=1 && doctors.get(number-1).get(i).getRating() <=1.9) {
                    System.out.print(count + ". ");
                    doctors.get(number-1).get(i).displayDoctorInfo();
                    filtered.add(doctors.get(number-1).get(i));
                    count++;
                    flag = true;
                    System.out.println();
                }//if
            }//for
        }else if (input == 2 ) {
           for (int i=0 ; i<doctors.get(number-1).size() ; i++) {
                if (doctors.get(number-1).get(i).getRating() >=2 && doctors.get(number-1).get(i).getRating() <=2.9) {
                    System.out.print(count + ". ");
                    doctors.get(number-1).get(i).displayDoctorInfo();
                    filtered.add(doctors.get(number-1).get(i));
                    count++;
                    flag = true;
                    System.out.println();
                }//if
            }//for
        }else if (input == 3 ) {
            for (int i=0 ; i<doctors.get(number-1).size() ; i++) {
                if (doctors.get(number-1).get(i).getRating() >=3 && doctors.get(number-1).get(i).getRating() <=3.9) {
                    System.out.print(count + ". ");
                    doctors.get(number-1).get(i).displayDoctorInfo();
                    filtered.add(doctors.get(number-1).get(i));
                    count++;
                    flag = true;
                    System.out.println();
                }//if
            }//for

        }else{
            for (int i=0 ; i<doctors.get(number-1).size() ; i++) {
                if (doctors.get(number-1).get(i).getRating() >=4 && doctors.get(number-1).get(i).getRating() <=5) {
                    System.out.print(count + ". ");
                    doctors.get(number-1).get(i).displayDoctorInfo();
                    filtered.add(doctors.get(number-1).get(i));
                    count++;
                    flag = true;
                    System.out.println();
                }//if
            }//for

        }//if

         System.out.println("--------------------------------------");

        if (!flag) {
            System.out.println("No doctors available in this range.");
            System.out.println("\nPress 1 to filter again , press 2 to select another category");
            int in = keyborad.nextInt();
            while(in < 1 || in > 2){
                System.out.println("Enter a valid input");
                in = keyborad.nextInt();
            }//while

            if (in ==1 ) {

                filterDoctors(number,c);

            }else{
               
                displayDoctorCategory(c);
                
            }//if

        }else{                                                                                                                               //doctors available in range

            System.out.println("\nPress 1 to choose doctor from the filtered results, 2 to filter again, 3 to choose another category");
            int in=keyborad.nextInt();

             while(in < 1 || in > 3){
                System.out.println("Enter a valid input");
                in = keyborad.nextInt();
            }//while

        if (in ==1) {

            System.out.println("Select a doctor(1,2,...)");
                 input=keyborad.nextInt();

                while(input <1 || input >filtered.size()){
                    System.out.println("Enter correct input");
                    input= keyborad.nextInt();
                }//while
                
                int index=binarySearch(filtered,number, input);


                 //input -selected doctor number from filtered list
                
                displaySlots(index+1, number, c);

        }else if(in == 2){
            filterDoctors(number,c);
        }else{
            displayDoctorCategory(c);
        }//if

        }//if
            

    }//filter()
  


    public int binarySearch(ArrayList<Doctor> filtered, int number, int input){

        int low =0, high=doctors.get(number-1).size() -1, mid;


                while(low<=high){
                    mid=(low+high)/2;

                    if (doctors.get(number-1).get(mid).getID()< filtered.get(input-1).getID()) {
                        low=mid+1;
                    }else if (doctors.get(number-1).get(mid).getID() > filtered.get(input-1).getID()) {
                        high=mid-1;
                    }else{
                        return mid;
                    }//if
                } //while  

                return -1;
    }//binarySearch()



//=================================================================================================================================================
   

    public void runCompany(Customer c){

        Scanner key = new Scanner(System.in);
 
        int exit=0;
        System.out.println("----------------------------------------");
        System.out.println("Main Menu");
        System.out.println("----------------------------------------");

        System.out.println("1. Order Medicines\n2. Book Lab Tests\n3. Book Doctor Consultation\n4.My Blood Pressure Records.\nEnter 0 to exit\nEnter (0,1,2,3,4)");
        System.out.println("----------------------------------------");
        // int input = key.nextInt();
        int input=-1;

        // while(input<0 || input>4){
        //     System.out.println("Enter correctly from (0,1,2,3,4)");
        //     input = key.nextInt();
        // }//while

        while (input < 0 || input > 4) {
            try {

                input = key.nextInt();
                if (input < 0 || input > 4) {
                    System.out.println("Invalid input. Please enter (0, 1, 2, 3, 4)");
                }//if
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                key.nextLine(); // Consume the invalid input
            }//try-catch

        }//while



        System.out.println();

        if (input!=0) {


        if (input==1) {
            exit =  runMedicine(c);
        } else if (input==2) {
            runLabTest(c);
        } else if (input==3) {
            runConsultation(c);
        } else if (input==4) {
            try{

                 exit = c.runningBloodTestFeature();

             } catch(IOException e){
                System.out.println( "Error message: "+e.getMessage() );
            }//try

        }//if

        if (exit==1) {
            runCompany(c);
        }//if

        }//if

    }//run company

    public boolean checkUserName(String str){
        for (Customer c : customers) {
            if (c.getUserName().equalsIgnoreCase(str)) {
                return false;
            }//if
        }//for
        return true;
    }//checkUserName

     public void enterCredentials(Customer c){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your user name: ");
        String userName = scanner.nextLine();

        while(!checkUserName(userName)){

            System.out.println("This user name already exists enter your user name again: ");
            userName = scanner.nextLine();

        }//while

         System.out.println("Enter your password (at least 8 characters with at least one digit and one special character): ");
     String password = scanner.nextLine();

   while (!isValidPassword(password)) {
    System.out.println("Password must be at least 8 characters with at least one digit and one special character: ");
    password = scanner.nextLine();
    }//while
       

        System.out.println("Enter your phone number (11 digits only): ");
        String phoneNumber = scanner.nextLine();

       String number=  checkPhoneNumber(phoneNumber);

    System.out.println("Enter your address: ");
    String address = scanner.nextLine();

    System.out.println("Enter your gender (Male/Female): ");
    String gender = scanner.nextLine();

    String g = checkGender(gender);
   
    

     System.out.println("Enter your account number: ");
        String accountNumber = scanner.nextLine();

        System.out.println("Enter your balance: ");
        double balance = scanner.nextDouble();

        while(balance<0){

            System.out.println("Enter your balance greater than zero: ");
            balance = scanner.nextDouble();

        }//while


        Account ac = new Account(accountNumber,balance);

        c.setAccount(ac);
        c.setPhoneNumber(number);
        c.setAddress(address);
        c.setPassword(password);
        c.setGender(g);

        customers.add(c);

        System.out.println();

     }//enterCredentials



      public boolean isValidPassword(String password) {
    // Password must be at least 8 characters long
    if (password.length() < 8) {
        return false;
    }

    // Check if the password contains at least one digit
    boolean hasDigit = false;
    for (char c : password.toCharArray()) {
        if (Character.isDigit(c)) {
            hasDigit = true;
            break;
        }
    }
    if (!hasDigit) {
        return false;
    }

    // Check if the password contains at least one special character
    String specialCharacters = "!@#$%^&*()_+{}:\"<>?|[];',./~`";
    boolean hasSpecialCharacter = false;
    for (char c : password.toCharArray()) {
        if (specialCharacters.contains(Character.toString(c))) {
            hasSpecialCharacter = true;
            break;
        }
    }
    if (!hasSpecialCharacter) {
        return false;
    }

    // Password meets all criteria
    return true;
   }//isnalid

   public String checkPassword(String pass){
    Scanner scanner=new Scanner(System.in);
    String password = pass;
   while (!isValidPassword(password)) {
    System.out.println("Password must be at least 8 characters with at least one digit and one special character: ");
    password = scanner.nextLine();
    }//while

    return password;
   }//checkPassword()


   public String checkPhoneNumber(String number){

    Scanner scanner=new Scanner(System.in);
    String phoneNumber=number;
   
      while ( phoneNumber.length() != 11 || !phoneNumber.matches("0\\d{10}") ) {
        System.out.println("Please enter a 11-digit phone number: ");
        phoneNumber = scanner.nextLine();
     }//while

         return phoneNumber;
   }//check

   public String checkGender(String gen){
    Scanner scanner=new Scanner(System.in);

    while (!gen.equalsIgnoreCase("Male") && !gen.equalsIgnoreCase("Female")) {
        System.out.println("Please enter Male or Female: ");
        gen = scanner.nextLine();
    }//while
   
    return gen;
   
   }//checkPassword()


     public Customer customerLogIn(Customer c){

        Scanner key = new Scanner(System.in);

        if (c==null) {
            return null;
        }//if

        boolean flag = false;

        while (flag == false) {

        System.out.println("Enter your user name:");
        String input = key.nextLine();

        System.out.println("Enter your password:");
        String password = key.nextLine();

        for ( Customer temp : customers ) {

            if (temp.getUserName().equals(input) && temp.getPassword().equals(password)) {
                flag=true;
                System.out.println("--------Username: " + temp.getUserName() + " Successfully Logged In.----------");
                 return temp;
            }//if

        }//for

            if (flag == false) {
                System.out.println("Invalid user name or Password. Do you want to log in again or signup?\nEnter 1 to login again and 2 to signup.");
                int ans = key.nextInt();

                if (ans==2) {
                    flag=true;
                    enterCredentials(c);
                }//if

                key.nextLine();

            }//if

        }//while

        return null;

     }//

     public Customer runCustomer(Customer c){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Login (If you are already a user)\n2. Signup (If you are a new user)\nEnter (1,2)");
        int input=0;
        // int input = scanner.nextInt();

        // while(input!=1 && input!=2){
        //     System.out.println("Enter 1 to login and 2 to signup.");
        //     input = scanner.nextInt();
        // }//while

          while (input < 1 || input > 2) {
            try {

                input = scanner.nextInt();
                if (input < 1 || input > 2) {
                    System.out.println("Invalid input. Please enter (1, 2)");
                }//if
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Consume the invalid input
            }//try-catch

        }//while

        if (input==1) {
            return customerLogIn(c); 
            
        } else {
            enterCredentials(c);
            return c;

        }//if

     }//checkCustomer

     public void analyzeMedicines() {
        // Get the current date
        LocalDate currentDate = LocalDate.now();
        
        // Calculate the date seven days ago
        LocalDate sevenDaysAgo = currentDate.minusDays(7);    

        // Determine medicines currently out of stock and frequently sold medicines
        ArrayList<Medicine> outOfStockMedicines = new ArrayList<>();
        ArrayList<Medicine> frequentlySoldMedicines = new ArrayList<>();
        int frequentMinimum = 10; // Set any counter minimum as needed

        // Iterate over orders to count medicines
        for (Order<Item> order : orders) {
            if (order.getOrderingDate().isAfter(sevenDaysAgo)) {
                ArrayList<Cart<Item>> items = order.getList();
                for (Cart<Item> cart : items) {
                    Item item = cart.getItem();
                    int quantity = cart.getSelectedQuantity();
                    if (item instanceof Medicine) {
                        Medicine medicine = (Medicine) item;
                        if (quantity == 0) {
                            outOfStockMedicines.add(medicine);
                        } else if (quantity > frequentMinimum) {
                            frequentlySoldMedicines.add(medicine);
                        }
                    }
                }
            }
        }

        // Print the results
        System.out.println("Medicines currently out of stock:");
        for (Medicine medicine : outOfStockMedicines) {
            System.out.println(medicine.getName());
        }

        System.out.println("Frequently sold medicines in the last seven days:");
        for (Medicine medicine : frequentlySoldMedicines) {
            System.out.println(medicine.getName());
        }
    }


}// class
