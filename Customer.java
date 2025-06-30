import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter; 
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Locale;
import java.io.FileNotFoundException;
import java.time.format.DateTimeParseException;

class Customer extends User {
    private int id;
    private String userName;
    private static int count=0;
    private  ArrayList<BloodPressureRecord> BpList;
    private  ArrayList<BloodPressureRecord> warningSortedBpList; 
    private boolean isSorted;
    private int advisedSystolic;
    private int advisedDiastolic;
    private ArrayList<Cart<Item>> cart;

    public Customer(){
        super();
        ++count;
        this.id=count;
        this.BpList = new ArrayList<>();
        this.cart= new ArrayList<Cart<Item>>();

    }//default


    public Customer(String userName ,String name, String phoneNumber, String address, String password, String gender,String accNo, double amount) {
        super(name, phoneNumber, address, password, gender,accNo,amount);
        ++count;
        this.id=count;
        this.userName=userName;
        this.BpList = new ArrayList<>();
        this.cart= new ArrayList<Cart<Item>>();
        this.isSorted=false;
        
        
    }//constructor
    // this is a conflict comment!!!!

     public String getUserName() {
        return userName;
    }

    // Setter method for userName
    public void setUserName(String userName) {
        this.userName = userName;
    }

    

    public ArrayList<Cart<Item>> getCart() {
        return cart;
    }

    public void setCart(ArrayList<Cart<Item>> cart) {
        this.cart = cart;
    }

    public int getId() {
        return id;
    }//getId

    public void setId(int id) {
        this.id = id;
    }//setId

    public int getAdvisedSystolic() {
        return advisedSystolic;
    }//getAdvisedSystolic

    public void setAdvisedSystolic(int advisedSystolic) {
        this.advisedSystolic = advisedSystolic;
    }//setAdvisedSystolic

    public int getAdvisedDiastolic() {
        return advisedDiastolic;
    }//getAdvisedDiastolic

    public void setAdvisedDiastolic(int advisedDiastolic) {
        this.advisedDiastolic = advisedDiastolic;
    }//setAdvisedDiastolic

    @Override
    public void displayInfo() {
        System.out.println("Customer Information:");
        System.out.println("Name: " + getName());
        System.out.println("Phone Number: " + getPhoneNumber());
        System.out.println("Address: " + getAddress());
        System.out.println("Gender: " + getGender());
        System.out.println();
    }//displayInfo

    public void personalization(){ 
        Scanner keyboard = new Scanner(System.in);
       

        System.out.println("Enter your doctor advised (normal) systolic pressure reading: ");

        int advised = keyboard.nextInt();

        while(advised<=0){

            System.out.println("Enter your docotr advised (normal) systolic pressure reading greater than zero: ");
            advised = keyboard.nextInt();

        }//while
        
        this.setAdvisedSystolic(advised);

        System.out.println("Enter your doctor advised (normal) diastolic pressure reading: ");

        advised = keyboard.nextInt();

         while(advised<=0){

            System.out.println("Enter your docotr advised (normal) diastolic pressure reading greater than zero: ");
            advised = keyboard.nextInt();

        }//while
        
        this.setAdvisedDiastolic(advised);

        System.out.println();

    }//personalization

    

    public void addBpRecord(){

        Scanner keyboard = new Scanner(System.in);
        

        System.out.println("Enter systolic pressure reading: ");
        int systolic = keyboard.nextInt();

        while(systolic<=0){

            System.out.println("Enter systolic pressure reading greater than zero: ");
            systolic = keyboard.nextInt();

        }//while

        System.out.println("Enter diastolic pressure reading: ");
        int diastolic = keyboard.nextInt();

        while(diastolic<=0){

             System.out.println("Enter diastolic pressure reading greater than zero: ");
              diastolic = keyboard.nextInt();

        }//while

        int warning = checkWarning(systolic,diastolic);

        BpList.add(new BloodPressureRecord(systolic,diastolic,warning));
        isSorted=false;
        System.out.println("Record Successfully Added.");
        displayBpRecords();

        System.out.println();
    }//add

    public void removeBpRecord(){  

        Scanner keyboard = new Scanner(System.in);

        if (!BpList.isEmpty()) {

        int number = 0;
        while(number<=0 || number>BpList.size()){

              System.out.println("Enter the record number you want to remove ( from 1 to " + BpList.size() + " ):" );
              number = keyboard.nextInt();

        }//while

        if (!BpList.remove( this.getBpRecord(number-1) ) ) {
            System.out.println("Failed to remove. Entered record does not exist.");
        } else {
            System.out.println("Successfully removed.");

        }//if

        displayBpRecords();


        } else {
            System.out.println("There are no added records. Kindly add a record first.");
        }//if
        System.out.println();

    }//remove

    public BloodPressureRecord getBpRecord(int index){ 

        if (index>=0 && index < BpList.size() ) {
             return BpList.get(index);
        }//if

        return null;
    }//get record

    public void updateBpRecord(){      
       
        if (BpList.size()!=0) {
             System.out.println("Existing Records:");
            displayBpRecords();

        Scanner keyboard = new Scanner(System.in);

        int number = 0;
        while(number<=0 || number>BpList.size()){

              System.out.println("Enter the record number you want to update ( from 1 to " + BpList.size() + " ):" );
              number = keyboard.nextInt();

        }//while

        System.out.println("Enter the updated systolic pressure reading: ");
        int sys = keyboard.nextInt();

        while(sys<=0){

            System.out.println("Enter the updated systolic pressure reading greater than zero: ");
            sys = keyboard.nextInt();

        }//while

        getBpRecord(number-1).setSystolicMMHG(sys);

        System.out.println("Enter the updated diastolic pressure reading: ");
        int dia = keyboard.nextInt();

        while(dia<=0){

             System.out.println("Enter the updated diastolic pressure reading greater than zero: ");
              dia = keyboard.nextInt();

        }//while
       
        getBpRecord(number-1).setDiastolicMMHG(dia);

        int war = checkWarning(getBpRecord(number-1).getSystolicMMHG(), getBpRecord(number-1).getDiastolicMMHG() );
        getBpRecord(number-1).setWarning(war);


        System.out.println("Record Successfully Updated.");
        displayBpRecords();

        System.out.println();

        } else {
            System.out.println("You cannot update any record as there are no existing records. Kindly add a record first.");
        }//if
        System.out.println();

    }//update bp record

    public void analyseRecords(){

        if (BpList.size()!=0) {

        Scanner keyboard = new Scanner(System.in);

        int sumSys=0;int sumDia=0;int count=0;
        boolean exit=false;
        String d;
        LocalDate givenDate;

        while(sumSys==0 && sumDia==0 && !exit){

            System.out.println("Enter correct date for which which you want to analyse your records. (Press E to exit)");
             d = keyboard.nextLine();

            if (!d.equalsIgnoreCase("e")) {
                
        try{

         givenDate = LocalDate.parse(d);
         int startingIndex = binarySearch(givenDate);

         if (startingIndex>=0) {

            for (int i = startingIndex; i < BpList.size(); ++i) {
                    if (BpList.get(i).getDate().equals(givenDate)) {
                            sumSys += BpList.get(i).getSystolicMMHG();
                            sumDia += BpList.get(i).getDiastolicMMHG();
                            ++count;
                    } else {
                             break; 
                    }//if
            }//for

        } else{

        }//if
     
         }catch(DateTimeParseException e){
            System.out.println("Error Invalid Format.");
        }//try-catch

            } else {
                exit=true;
            }//if

        }//while


         if (count == 0) {
            System.out.println("No records found for the given date.");
        } else if (sumSys!=0 && sumDia!=0) {
            
        int averageSys = sumSys/count;
        int averageDia = sumDia/count; 

        System.out.println("Average Systolic Reading: " + averageSys);
        System.out.println("Average Diastolic Reading: " + averageDia);

        } else{
            System.out.println("Exited Successfully from analysis of records.");
        }//if

        } else {
            System.out.println("There are no added records. To analyse your records, kindly first add a record.");
        }//if

        System.out.println();

      
    }//analyse


    public int binarySearch(LocalDate givenDate){
        int low= 0, high = BpList.size()-1;
        int mid=0, index=-1;

        while(low<=high){

            mid = (low+high)/2;
            BloodPressureRecord temp = BpList.get(mid);

            if (temp.getDate().equals(givenDate)) {
                index=mid;
                high=mid-1;
            } else if (temp.getDate().isAfter(givenDate)) {
                high = mid-1;
            } else {
                low = mid +1;
            }//if

        }//while

        return index;
    }//binarySearch

    public void readFromFile(String fileName) throws IOException{

        File file = new File(fileName);

        if (!file.exists()) {
    
            if (file.createNewFile()) {
               // System.out.println("New file created: " + fileName);
            } else {
                System.out.println("Failed to create new file.");
                return;
            }//if

        }//if
          
        Scanner sc = new Scanner(file);   
        int c=0; 

        while (sc.hasNextLine()){
            String line = sc.nextLine();

            if (!line.isEmpty()) {

                
            String[] spliting = line.split(",");

            if (spliting.length==2 && c==0) {
                this.setAdvisedSystolic(Integer.parseInt(spliting[0]));
                this.setAdvisedDiastolic(Integer.parseInt(spliting[1]));  
                ++c;  

            } else if (spliting.length==5 && c!=0) {

               try{ 
                

                 BloodPressureRecord bp = new BloodPressureRecord(Integer.parseInt(spliting[0]) , Integer.parseInt(spliting[1]) , LocalDate.parse(spliting[2]) , LocalTime.parse(spliting[3]) , Integer.parseInt(spliting[4]));

                 BpList.add(bp);

                }catch(NumberFormatException e){
                    System.out.println("Error line: " + line + " , " + e);
                }catch(DateTimeParseException e){
                    System.out.println("Error line: " + line + " , " + e);
                }//catch

            } else {
                System.out.println("Invalid Format.");
            }//if

            } else {
                System.out.println("Line empty.");
            }//if

        }//while

        sc.close();

    }//readFromFile

    public void writeToFile(String fileName) throws IOException{

        try(FileWriter fw = new FileWriter(fileName) ){

            fw.write(this.getAdvisedSystolic() + "," + this.getAdvisedDiastolic());
            fw.write("\r\n"); 

        for (BloodPressureRecord temp : BpList) {
            fw.write(temp.getSystolicMMHG()  + "," + temp.getDiastolicMMHG() + "," + temp.getDate() + "," + temp.getTime() + "," + temp.getWarning());
            fw.write("\r\n");       //to move to next line
        }//for

        }//try   

    }//writeToFile

    public int checkWarning(int systolic, int diastolic){
        System.out.println();

         int advisedSystolic = this.getAdvisedSystolic();
         int advisedDiastolic = this.getAdvisedDiastolic();

   
        if (advisedSystolic == 0 || advisedDiastolic == 0) {
            return -2; 
        }//if

        int warningLevel = -2; 

  
        int systolicDiff = Math.abs(systolic - advisedSystolic);
        int diastolicDiff = Math.abs(diastolic - advisedDiastolic);

    
        if ((systolicDiff >= 20 && diastolicDiff <= 20) || (systolicDiff <= 20 && diastolicDiff >= 20) ) {
            warningLevel = 1; 
        } else {
        
        if (systolicDiff <= 10 && diastolicDiff <= 10) {
            warningLevel = -1; 
        } else {
            
           // if (systolicDiff > 10 || diastolicDiff > 10) {
                warningLevel = 0; 
           // }//if

        }//if

        }//if

    return warningLevel;

    }//checkWarning


    public ArrayList<BloodPressureRecord> mergeSort(ArrayList<BloodPressureRecord> arr) {
    if (arr.size() <= 1) {
        return arr; 
    }//if

    int mid = arr.size() / 2;

    ArrayList<BloodPressureRecord> left = new ArrayList<>(arr.subList(0, mid));
    ArrayList<BloodPressureRecord> right = new ArrayList<>(arr.subList(mid, arr.size()));

    left = mergeSort(left); 
    right = mergeSort(right); 

    return merge(left, right); 
    }//mergesort

    public ArrayList<BloodPressureRecord> merge(ArrayList<BloodPressureRecord> left, ArrayList<BloodPressureRecord> right) {
    ArrayList<BloodPressureRecord> result = new ArrayList<>();

    int leftIndex = 0, rightIndex = 0;

    
    while (leftIndex < left.size() && rightIndex < right.size()) {
        if (left.get(leftIndex).getWarning() <= right.get(rightIndex).getWarning()) {
            result.add(left.get(leftIndex++));
        } else {
            result.add(right.get(rightIndex++));
        }//if
    }//while

    
    while (leftIndex < left.size()) {
        result.add(left.get(leftIndex++));
    }//while

   
    while (rightIndex < right.size()) {
        result.add(right.get(rightIndex++));
    }//while

    return result;

    }//merge


    public void displayHighWarningRecords(){
        System.out.println();

        if (!isSorted) {

             warningSortedBpList = mergeSort(BpList);
             isSorted = true;
        }//if

        if (warningSortedBpList.isEmpty() && BpList.isEmpty()) {
        System.out.println("No records available.");
        } else if (warningSortedBpList.isEmpty() ) {
            System.out.println("Blood pressure records are not sorted yet.");
        } else {

             System.out.println("High warning records.");

        int i = warningSortedBpList.size() - 1;
        while (i >= 0 && warningSortedBpList.get(i).getWarning() == 1) {
            warningSortedBpList.get(i).display();
            System.out.println();
            i--;
        }//while

        }//if

    }//method



    public void displayBpRecords(){
        if (BpList.size()!=0) {
            
        int count=1;
        for (BloodPressureRecord temp  : BpList) {
            System.out.println("Record#" + count);
            temp.display();
            ++count;
            System.out.println();
        }//for

        } else {
            System.out.println("You have no added records.");
        }//if
        System.out.println();
    }//display

    public int runningBloodTestFeature() throws IOException {

        this.readFromFile(this.getId()+"ID.txt");
        Scanner keyboard = new Scanner(System.in);

        int input;

        if (this.getAdvisedSystolic()==0 && this.getAdvisedDiastolic()==0) {

        System.out.println("BLOOD PRESSURE RECORD:\nDo you want to enter doctor advised blood pressure readings? Press 1 for YES and 2 for NO.");
         input = keyboard.nextInt();

        while(input!=1 && input!=2){
            System.out.println("Press 1 for Yes and 2 for NO.");
            input = keyboard.nextInt();
        }//while
        System.out.println();

        if (input==1) {
        this.personalization();   
        }//if

        } else {

            System.out.println("BLOOD PRESSURE RECORD:\nDo you want to update doctor advised blood pressure readings?\nSystolic: "+ this.getAdvisedSystolic()+ "\tDiastolic: " +this.getAdvisedDiastolic() +"\nPress 1 for YES and 2 for NO.");
            input = keyboard.nextInt();

             while(input!=1 && input!=2){
                System.out.println("Press 1 for Yes and 2 for NO.");
                input = keyboard.nextInt();
            }//while

            System.out.println();

        if (input==1) {
        this.personalization();   
        }//if

        }//if


        this.displayBpRecords();

        boolean exit=false;
        int ans=-1;

        while(!exit){

        System.out.println("1. Add new record.\n2. Update existing record.\n3. Remove existing record.\n4. Get analysis of records for a specific date.\n5. View high warning records\nEnter 0 to go to main menu.");
        input = keyboard.nextInt();


         while(input<0 || input>5){
            System.out.println("Enter correct value between 1 and 4 again.");
            input = keyboard.nextInt();
        }//while

        System.out.println();

        if (input==0) {
            exit=true;
            System.out.println("Exited Successfully from Blood Pressure Record.");
            ans=1;
        }//if

        if (input==1) {
         this.addBpRecord();  
        }//if

        if (input==2) {
         this.updateBpRecord();
        }//if

        if (input==3) {
         this.removeBpRecord(); 
        }//if

        if (input==4) {
         this.analyseRecords();
        }//if 

        if (input==5) {
             this.displayHighWarningRecords(); 
        }//if  

        }//while     

        this.writeToFile(this.getId()+"ID.txt");

        System.out.println();

        this.BpList.clear();

        return ans;

    }//runningBloodTestFeature

    public void add(int quantity, Item i, String date, String time){
        //cart.add(new Cart(i,quantity, date, time));
        cart.add(new Cart<Item>(i, quantity, date, time));
        System.out.println("Successfully Added.");
        System.out.println();
    }//add

    public void display() {
        System.out.println("Customer Details:");
        System.out.println("Name: " + getName());
        System.out.println("Phone Number: " + getPhoneNumber());
        System.out.println("Address: " + getAddress());
        System.out.println();
    }//display

    public void deductBalance(double amount){
        getAccount().setBalance(getAccount().getBalance() - amount);
    }


}//customer