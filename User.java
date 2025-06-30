import java.util.Scanner;

abstract class User {
    private Account account;
    private String name;
    private String phoneNumber;
    private String address;
    private String password;
    private String gender;

    public User(){
        this.account = new Account();

    }//Default Constructor

    public User(String name, String phoneNumber, String address, String password, String gender,String accNo,double balance) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.password = password;
        this.gender = gender;
        this.account = new Account(accNo,balance);
    }//constructor 

    public abstract void displayInfo();

   

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
               "Phone Number: " + phoneNumber + "\n" +
               "Address: " + address + "\n" +
               "Gender: " + gender;
    }

      public Account getAccount() {
        return account;
    }

    // Setter method for account
    public void setAccount(Account account) {
        this.account = account;
    }

    public void setAccountBalance(double balance){
        this.account.setBalance(balance);
    }

       public double getAccountBalance(){
        return  this.account.getBalance();
    }


     public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

     public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}//User
