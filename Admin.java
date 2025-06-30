import java.util.ArrayList;

class Admin extends User {
    private String name;
    private String phoneNumber;
    private String address;
    private String password;
    private String gender;

    public Admin(){
        super();
    }//Default-Cnnstructo
    

    public Admin(String name, String phoneNumber, String address, String password, String gender,String accNo, double balance) {
        super(name, phoneNumber, address, password, gender,accNo,balance);
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.password = password;
        this.gender = gender;
        
    }//


    public void displayInfo(){  

    }//admin

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }

    public String getGender() {
        return gender;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGender(String gender) {
        this.gender = gender;

    }
}