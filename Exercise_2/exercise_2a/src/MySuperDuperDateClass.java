// making sure no relation problems occur
public class MySuperDuperDateClass {
	int year;
	int month;
	int day;
	// This is the __init__ in python
	public MySuperDuperDateClass(int year, int month, int day){
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public int getYear(){
		return year;
	}

	public int getMonth(){
		return month;
	}

	public int getDay() {
		return day;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public void setDay(int day) {
		this.day = day;
	}
}