import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class Appointment  {
	
	private String time;
	private  String date;
	private Customer c;
    private Doctor doctor;

	Appointment(String time, String date, Customer c, Doctor d){
		this.time = time;
		this.date = date;
		this.c = c;
        this.doctor=d;
	}//constructor

	public String getTime() {
        return time;
    }

    // Setter for time
    public void setTime(String time) {
        this.time = time;
    }

    // Getter for date
    public String getDate() {
        return date;
    }

    // Setter for date
    public void setDate(String date) {
        this.date = date;
    }

    // Getter for customer
    public Customer getCustomer() {
        return c;
    }

    // Setter for customer
    public void setCustomer(Customer c) {
        this.c = c;
    }

    public void displayApp() {

        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        // Format the current time using the custom format
        String formattedTime = currentTime.format(formatter);

        System.out.println("\nAppointment details: \t\t\t Current Time:" + formattedTime);
        System.out.println("Date: " + date);
        System.out.println("Time: " + time);
        System.out.println("Doctor: " + doctor.getName());
        System.out.println("\nCustomer: " + c.getName());
       
        System.out.println("\n");
    }//displayApp()

    public String toString(){

        return "Time:"+ getTime() + "\nDate:" + getDate() + "\nDoctor:" + doctor.getName() + "\nCustomer:" + c.getName();
    }//



}//Appointment class