import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List; 
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.InputMismatchException;

class RunCompany {

	 public static void main(String[] args){

      

      Admin admin = new Admin("Ali", "0300444000", "Alipur chowk", "adminxyz1$", "Male", "AC101",0);
      DoublyLinkedList medicines = new DoublyLinkedList();



         medicines.add(new Tablet("Panadol", "Manufacturer by GSK", 30.99, 6.00, "Eye, Nose, Ear Medicines", "the practices and procedures used for the prevention, treatment, or relief of symptoms of diseases or abnormal conditions.", "Keep away from the reach of Childern", 5, 500));
        medicines.add(new Tablet("Hevert",  "Manufacturer by GSK", 78.99, 6.00, "Eye, Nose, Ear Medicines", "the practices and procedures used for the prevention, treatment, or relief of symptoms of diseases or abnormal conditions.", "Keep away from the reach of Childern", 5, 450));
        medicines.add(new Tablet("debrox",  "Manufacturer by GSK", 123.99, 6.00, "Eye, Nose, Ear Medicines","the practices and procedures used for the prevention, treatment, or relief of symptoms of diseases or abnormal conditions.", "Keep away from the reach of Childern", 5, 410));
        medicines.add(new Tablet("Azhtiromycin","Manufacturer by GSK", 35.99, 6.00, "Eye, Nose, Ear Medicines","the practices and procedures used for the prevention, treatment, or relief of symptoms of diseases or abnormal conditions.", "Keep away from the reach of Childern", 5, 223));

        medicines.add(new Syrup("Harker", "Manufacturer by GSK", 245.99, 200.0, "Eye, Nose, Ear Medicines","the practices and procedures used for the prevention, treatment, or relief of symptoms of diseases or abnormal conditions.", "Keep away from the reach of Childern", 5, "Honey", 1.25));
        medicines.add(new Syrup("Floradix", "Manufacturer by GSK", 160.99, 200.0, "Eye, Nose, Ear Medicines","the practices and procedures used for the prevention, treatment, or relief of symptoms of diseases or abnormal conditions.", "Keep away from the reach of Childern" ,5, "Herbal", 1.25));
        medicines.add(new Syrup("T-Day",  "Manufacturer by GSK", 150.99, 200.0, "Eye, Nose, Ear Medicines","the practices and procedures used for the prevention, treatment, or relief of symptoms of diseases or abnormal conditions.", "Keep away from the reach of Childern", 5, "Orange", 1.25));
        medicines.add(new Syrup("Azee", "Manufacturer by GSK", 145.99, 200.0, "Eye, Nose, Ear Medicines","the practices and procedures used for the prevention, treatment, or relief of symptoms of diseases or abnormal conditions.", "Keep away from the reach of Childern", 5, "peppermit", 1.25));

        medicines.add(new Tablet("Gesto tablet", "Manufacturer by GSK", 290.99, 3.44, "Gastrointestinal Tract Medicines","the practices and procedures used for the prevention, treatment, or relief of symptoms of diseases or abnormal conditions.", "Keep away from the reach of Childern", 5, 300));
        medicines.add(new Tablet("Gutain", "Manufacturer by GSK" ,140.99, 3.44, "Gastrointestinal Tract Medicines","the practices and procedures used for the prevention, treatment, or relief of symptoms of diseases or abnormal conditions.", "Keep away from the reach of Childern", 5, 340));
        medicines.add(new Tablet("Caborin", "Manufacturer by GSK", 257.99, 3.44, "Gastrointestinal Tract Medicines","the practices and procedures used for the prevention, treatment, or relief of symptoms of diseases or abnormal conditions.", "Keep away from the reach of Childern", 5, 220));
        medicines.add(new Tablet("Ulsin",  "Manufacturer by GSK", 185.99, 3.44, "Gastrointestinal Tract Medicines", "the practices and procedures used for the prevention, treatment, or relief of symptoms of diseases or abnormal conditions.", "Keep away from the reach of Childern", 5, 380));

        medicines.add(new Syrup("maxolan", "Manufacturer by GSK", 245.99, 200.0, "Gastrointestinal Tract Medicines", "the practices and procedures used for the prevention, treatment, or relief of symptoms of diseases or abnormal conditions.", "Keep away from the reach of Childern", 5, "Honey", 1.25));
        medicines.add(new Syrup("Domel", "Manufacturer B", 265.99, 200.0, "Gastrointestinal Tract Medicines","the practices and procedures used for the prevention, treatment, or relief of symptoms of diseases or abnormal conditions.", "Keep away from the reach of Childern", 5, "herba", 1.25));
        medicines.add(new Syrup("Colic", "Manufacturer B", 145.99, 200.0, "Gastrointestinal Tract Medicines","the practices and procedures used for the prevention, treatment, or relief of symptoms of diseases or abnormal conditions.", "Keep away from the reach of Childern", 5, "Honey", 1.25));
        medicines.add(new Syrup("Zygest", "Manufacturer B", 225.99, 200.0, "Gastrointestinal Tract Medicines", "the practices and procedures used for the prevention, treatment, or relief of symptoms of diseases or abnormal conditions.", "Keep away from the reach of Childern", 5, "orange", 1.25));

        medicines.add(new Tablet("Cardiovas", "Manufacturer by GSK", 256.99, 250.0, "Cardiovascular System Medicines","the practices and procedures used for the prevention, treatment, or relief of symptoms of diseases or abnormal conditions.", "Keep away from the reach of Childern", 5, 300));
        medicines.add(new Tablet("Neo cardio", "Manufacturer by GSK", 367.99, 250.0, "Cardiovascular System Medicines", "the practices and procedures used for the prevention, treatment, or relief of symptoms of diseases or abnormal conditions.", "Keep away from the reach of Childern", 5, 300));
        medicines.add(new Tablet("Cardiac", "Manufacturer by GSK", 350.99, 250.0, "Cardiovascular System Medicines","the practices and procedures used for the prevention, treatment, or relief of symptoms of diseases or abnormal conditions.", "Keep away from the reach of Childern", 5, 300));
        medicines.add(new Tablet("Cardia fit", "Manufacturer by GSK", 170.99, 250.0, "Cardiovascular System Medicines","the practices and procedures used for the prevention, treatment, or relief of symptoms of diseases or abnormal conditions.", "Keep away from the reach of Childern", 5, 300));

        medicines.add(new Syrup("Cardicus", "Manufacturer by GSK", 245.99, 200.0, "Cardiovascular System Medicines","the practices and procedures used for the prevention, treatment, or relief of symptoms of diseases or abnormal conditions.", "Keep away from the reach of Childern", 5, "Honey", 1.25));
        medicines.add(new Syrup("Nucal Z", "Manufacturer by GSK", 265.99, 200.0, "Cardiovascular System Medicines", "the practices and procedures used for the prevention, treatment, or relief of symptoms of diseases or abnormal conditions.", "Keep away from the reach of Childern", 5, "herba", 1.25));
        medicines.add(new Syrup("Cipzer", "Manufacturer B", 145.99, 200.0, "Cardiovascular System Medicines","the practices and procedures used for the prevention, treatment, or relief of symptoms of diseases or abnormal conditions.", "Keep away from the reach of Childern", 5, "Honey", 1.25));
        medicines.add(new Syrup("Rugstrol",  "Manufacturer by GSK", 225.99, 200.0, "Cardiovascular System Medicines","the practices and procedures used for the prevention, treatment, or relief of symptoms of diseases or abnormal conditions.", "Keep away from the reach of Childern", 5, "orange", 1.25));

        medicines.add(new Tablet("Lepti", "Manufacturer by GSK", 414.99, 400.9, "Central Nervous System Medicines","the practices and procedures used for the prevention, treatment, or relief of symptoms of diseases or abnormal conditions.", "Keep away from the reach of Childern", 5, 400));
        medicines.add(new Tablet("DV lapram", "Manufacturer by GSK", 314.99, 400.9, "Central Nervous System Medicines","the practices and procedures used for the prevention, treatment, or relief of symptoms of diseases or abnormal conditions.", "Keep away from the reach of Childern", 5, 460));
        medicines.add(new Tablet("DV Clanoz", "Manufacturer by GSK", 214.99, 400.9, "Central Nervous System Medicines","the practices and procedures used for the prevention, treatment, or relief of symptoms of diseases or abnormal conditions.", "Keep away from the reach of Childern", 5, 490));
        medicines.add(new Tablet("Sert", "Manufacturer by GSK", 114.99, 400.9, "Central Nervous System Medicines","the practices and procedures used for the prevention, treatment, or relief of symptoms of diseases or abnormal conditions.", "Keep away from the reach of Childern", 5, 500));

        medicines.add(new Syrup("Dsris", "Manufacturer by GSK", 245.99, 200.0, "Central Nervous System Medicines","the practices and procedures used for the prevention, treatment, or relief of symptoms of diseases or abnormal conditions.", "Keep away from the reach of Childern", 5, "Honey", 1.25));
        medicines.add(new Syrup("Novamin", "Manufacturer by GSK", 160.99, 200.0, "Central Nervous System Medicines","the practices and procedures used for the prevention, treatment, or relief of symptoms of diseases or abnormal conditions.", "Keep away from the reach of Childern", 5, "Herbal", 1.25));
        medicines.add(new Syrup("Brufin",  "Manufacturer by GSK", 150.99, 200.0, "Central Nervous System Medicines","the practices and procedures used for the prevention, treatment, or relief of symptoms of diseases or abnormal conditions.", "Keep away from the reach of Childern", 5, "Orange", 1.25));


          String[] values = {"A", "B", "C", "D", "L"};

          String[] str = {"Focus on a well-rounded diet that includes a variety of nutrient-dense foods from all food groups to support overall health and well-being. Incorporate plenty of fruits, vegetables, whole grains, lean proteins, and healthy fats into your meals.", 
          "Include foods rich in omega-3 fatty acids, such as fatty fish, flaxseeds, and chia seeds, to support brain health and cognitive function. Consume a variety of fruits and vegetables rich in antioxidants to protect brain cells from oxidative stress.",
           "Emphasize a diet rich in fruits, vegetables, whole grains, lean proteins, and healthy fats like olive oil, nuts, and seeds to support heart health. Limit sodium intake and opt for low-sodium alternatives to support heart health and blood pressure regulation.", 
           "Focus on a Mediterranean-style diet rich in fruits, vegetables, whole grains, lean proteins, and healthy fats to support heart health and brain health. Include foods high in antioxidants like dark chocolate, berries, and green leafy vegetables to promote overall cardiovascular and nervous system health.", 
           "Focus on easily digestible foods like bananas, rice, applesauce, and toast (BRAT diet) to soothe the digestive system. Incorporate probiotic-rich foods like yogurt, kefir, and kombucha to promote gut health" , 
           "Incorporate easily digestible foods like bananas, rice, applesauce, and toast (BRAT diet) to soothe the digestive system while supporting overall brain health. Include foods rich in magnesium, such as nuts, seeds, leafy greens, and whole grains, to support both digestive and nervous system function." , 
           "Emphasize a diet rich in fiber from fruits, vegetables, whole grains, and legumes to support digestive health and heart health. Include foods that help reduce inflammation, such as fatty fish, olive oil, nuts, seeds, and colorful fruits and vegetables." , 
           "Incorporate a Mediterranean-style diet featuring olive oil, nuts, seeds, whole grains, fish, and plenty of fruits and vegetables to support digestive health, heart health, and brain health. Include fermented foods like sauerkraut and kimchi to support gut health and promote overall well-being." , 
           "Consume a variety of colorful fruits and vegetables rich in vitamins A, C, and E to support eye health. Include foods high in omega-3 fatty acids, such as fatty fish, flaxseeds, and walnuts, to support overall eye health." , 
           "Focus on foods that support brain health and cognitive function, such as fatty fish rich in omega-3 fatty acids, blueberries, and walnuts. Include foods high in vitamin B12, such as meat, fish, eggs, and dairy, to support nervous system health." , 
           "Include foods rich in antioxidants like berries, citrus fruits, and leafy greens to support eye health and heart health. Incorporate heart-healthy fats from sources like fatty fish, nuts, seeds, and avocado." , 
           "Emphasize a diet rich in colorful fruits and vegetables, nuts, seeds, and fatty fish to support eye health, heart health, and brain health. Include foods high in fiber and antioxidants to promote gastrointestinal health and overall well-being." , 
           "Consume foods rich in vitamin A and beta-carotene, such as carrots, sweet potatoes, and dark leafy greens, to support eye health. Incorporate probiotic-rich foods like yogurt, kefir, and sauerkraut to promote gastrointestinal health." , 
           "Focus on a diet that includes probiotic-rich foods like yogurt and fermented vegetables to support gut health and overall well-being. Incorporate foods high in omega-3 fatty acids, such as salmon and chia seeds, to support brain health and cognitive function." , 
          "Consume foods rich in antioxidants, such as berries, to support eye health, digestive health, and heart health. Include fiber-rich foods like beans, lentils, and whole grains to promote gastrointestinal health and cardiovascular health." , 
           "Emphasize a balanced diet rich in fruits, vegetables, whole grains, lean proteins, and healthy fats to support overall health and well-being. Include foods with a variety of nutrients, such as vitamins A, C, E, B vitamins, omega-3 fatty acids, antioxidants, and fiber."
       };


                                                         

        
       ArrayList<Customer> c = new ArrayList<Customer>(Arrays.asList( new Customer("nadiaa","Nadia Ali","03237800012","DC Colony","nadia123#","Female","ACCOUNT98765",500.99) , 
       	new Customer("ikhan","Irum Khan","03222543987","Civil Lines","khan1234#","Female","ACCOUNT32145",899976.99) , 
       	new Customer("sBUTT","Saad Butt","03226061234","DC Road","butt9999#","Male","ACCOUNT76123",239.99) , 
       	new Customer("ShaAli","Shahid Ali","03234311123","City Housing","sa987hl1$","Male","ACCOUNT87123",10.87) ));


       ArrayList<ArrayList<Doctor>> doctor = new ArrayList<ArrayList<Doctor>>(Arrays.asList(   new ArrayList<Doctor>(Arrays.asList(new Doctor("Alisha Riaz","03115057777", "Cantt", "Stringpassword", "Female", 8, 4.5, 1800, "Cardiologist","",99.99),
                                                                    new Doctor("Haris Ahmad","03059999911", "address", "password", "Male", 10, 4,  1500, "Cardiologist","",99.99),
                                                                    new Doctor("Alia Nadeem","03001111111", "Rah Wali", "alia123", "Female", 5, 4, 1100, "Cardiologist","",99.99), 
                                                                    new Doctor( "Babar Riaz","0322111444", "Sialkot", "babar1", "Male", 2,3.9, 1200, "Cardiologist","",99.99))) ,  
                                                                     new ArrayList<Doctor>(Arrays.asList(new Doctor("Anna","phoneNumber", "address", "String password", "Female", 2,3, 1500,  "Dermatologist","",99.99),
                                                                     new Doctor("Ali Shah","03059999911", "Cantt", "password", "Male", 6, 3, 1500, "Dermatologist","",99.99),
                                                                    new Doctor( "Amna","phoneNumber", "address", "String password", "String gender", 2,3.9, 4, "Dermatologist","",99.99))),  
                                                                    new ArrayList<Doctor>(Arrays.asList(new Doctor( "Sahil Khan","03225598000", "DC Road", "sahil123", "Male", 5,4.7, 1400, "Physician","",99.99),
                                                                    new Doctor( "Riaz Ali Shah","0322699004", "Warirabad", "noPassword", "Male", 15,4.5, 1500, "Physician","",99.99),
                                                                    new Doctor( "Lina","03007001222", "Garden Town", "String password", "String gender", 2,3, 4, "Physician","",99.99))),  
                                                                    new ArrayList<Doctor>(Arrays.asList(  new Doctor( "Lina","03007001222", "Garden Town", "String password", "String gender", 2,3, 4, "Neurologist","",99.99) ))  ));

     
       Scanner scanner = new Scanner(System.in);

        Company company = new Company(medicines,doctor,c,values,str, admin);

        // Adding lab tests in a sorted manner
        company.addSorted(new Lab_Test("Blood Sugar", false, 300.0, 2, "Blood Sample", "Blood", 1));
        company.addSorted(new Lab_Test("CBC", true, 430.0, 2, "Blood Sample", "Blood", 1));
        company.addSorted(new Lab_Test("CBC-2", true, 50.0, 1, "Blood Sample", "Blood", 1));
        company.addSorted(new Lab_Test("Calcium", true, 50.0, 1, "Blood Sample", "Blood", 1));

        company.addSorted(new Lab_Test("Insulin Test", true, 2550.0, 1, "Blood Sample", "Diabetes", 1));
        company.addSorted(new Lab_Test("HbA1c", true, 2550.0, 4, "Blood Sample", "Diabetes", 1));
        company.addSorted(new Lab_Test("CDC", true, 50.0, 3, "Blood Sample", "Diabetes", 1));

        company.addSorted(new Lab_Test("TBH", true, 1550.0, 7, "Blood Sample", "Thyroid", 1));
        company.addSorted(new Lab_Test("TBC", true, 1550.0, 8, "Blood Sample", "Thyroid", 1));
        company.addSorted(new Lab_Test("TBIC", true, 1650.0, 8, "Blood Sample", "Thyroid", 1));
        company.addSorted(new Lab_Test("Urea", true, 1030.0, 6, "Urine Sample", "Thyroid", 1));
        company.addSorted(new Lab_Test("Uric acid", true, 850.0, 7, "Urine Sample", "Thyroid", 1));
        company.addSorted(new Lab_Test("Cholesterol", true, 1750.0, 1, "Blood Sample", "Thyroid", 1));

        company.addSorted(new Lab_Test("FOBT", true, 2050.0, 12, "Blood Sample", "HeartHealth", 1));
        company.addSorted(new Lab_Test("HCV", true, 350.0, 10, "Blood Sample", "HeartHealth", 1));
        company.addSorted(new Lab_Test("FBC-2", true, 50.0, 12, "Blood Sample", "HeartHealth", 1));
        company.addSorted(new Lab_Test("FBC", true, 2250.0, 10, "Blood Sample", "HeartHealth", 1));

        int count =1;



        Customer customer5 = new Customer();
        boolean flag = true;
        int input = 0; 

          
        while(flag){

        // System.out.println("1. Are you a Customer?\n2. Are you a Doctor\n3. Are you a admin.\n4. Exit\n Enter (1,2,3,4)");
        // int input = scanner.nextInt();

        // while(input<1 || input>4){
        //   System.out.println("Enter (1,2,4)");
        //   input = scanner.nextInt();

        // }//while

       System.out.println("1. Are you a Customer?\n2. Are you a Doctor?\n3. Are you an Admin?\n4. Exit\nEnter (1, 2, 3, 4)");
       input=0;

        while (input < 1 || input > 4) {
            try {
                //System.out.println("1. Are you a Customer?\n2. Are you a Doctor?\n3. Are you an Admin?\n4. Exit\nEnter (1, 2, 3, 4)");
                input = scanner.nextInt();
                if (input < 1 || input > 4) {
                    System.out.println("Invalid input. Please enter (1, 2, 3, 4)");
                }//if
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Consume the invalid input
            }//try-catch

        }//while

        System.out.println();


        if (input==1) {

          Customer temp =  company.runCustomer(customer5);

          if (temp!=null) {
            
          System.out.println();
     
          company.runCompany(temp);

          if (count==1) {
            company.removeAppointment();
            
          }//if
          ++count;

          } else {
            System.out.println("No customer found.");
          }//if
          
        } else if (input==2) {

           company.runDoctor();
          
        } else if (input==3) {

          if (admin==null) {
            System.out.println("No admin found.");
          } else {
          
          company.adminLogIn();
          company.runAdmin();

          }

        } else {
          flag=false;
        }//if

      }//while

  
    

    }//main
	
}//class