import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class BloodPressureRecord {
	private LocalDate date;
	private LocalTime time;
	private int systolicMMHG;
	private int diastolicMMHG;
	private int warning;

	public BloodPressureRecord(int systolicMMHG, int diastolicMMHG, int warning){
		this.systolicMMHG=systolicMMHG;
		this.diastolicMMHG=diastolicMMHG;
		this.date= LocalDate.now();				
		this.time= LocalTime.now();	
		this.warning = warning;				
	}//constructor

	public BloodPressureRecord(int systolicMMHG, int diastolicMMHG, LocalDate d, LocalTime t, int warning){
		this.systolicMMHG=systolicMMHG;
		this.diastolicMMHG=diastolicMMHG;
		this.date= d;				
		this.time= t;	
			this.warning = warning;					
	}//constructor

	public int getWarning() {
            return warning;
    }
    
    public void setWarning(int warning) {
            this.warning = warning;     
    }

	public int getSystolicMMHG() {
	  return systolicMMHG;
    }//getSystolic

    public void setSystolicMMHG(int systolicMMHG) {
        this.systolicMMHG = systolicMMHG;
    }//setSystolic

    public int getDiastolicMMHG() {
        return diastolicMMHG;
    }//getDiastolic

    public void setDiastolicMMHG(int diastolicMMHG) {
        this.diastolicMMHG = diastolicMMHG;
    }//setDiastolic

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }


     public String toString() {
        return "Systolic: " + systolicMMHG + " mmHg, Diastolic: " + diastolicMMHG + " mmHg" +
               ", Date: " + date + ", Time: " + time;
    }

	public void display(){
		System.out.print("Systolic Reading: " + this.getSystolicMMHG() + " mmHg	Diastolic Reading: " + this.getDiastolicMMHG() + " mmHg");
		if (this.warning==1) {
			System.out.println("\tWarning: HIGH");
		} else if (this.warning==0) {
				System.out.println("\tWarning: MEDIUM");
		} else if (this.warning==-1) {
			System.out.println("\tWarning: LOW");
		}//if
		System.out.println(" Date: " + this.date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "	\tTime: " + this.time.format(DateTimeFormatter.ofPattern("HH:mm")) );
	}//display

	public boolean equals(Object b){
		BloodPressureRecord bp = (BloodPressureRecord) b;
		return ( this.getSystolicMMHG()==bp.getSystolicMMHG()  && this.getDiastolicMMHG()==bp.getDiastolicMMHG() );
	}//compare



}//blood pressure record