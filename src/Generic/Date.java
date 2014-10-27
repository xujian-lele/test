package Generic;

public class Date implements Comparable<Date>{
	public int year;
	public int month;
	public int day;
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}
	/**
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}
	/**
	 * @param month the month to set
	 */
	public void setMonth(int month) {
		this.month = month;
	}
	/**
	 * @return the day
	 */
	public int getDay() {
		return day;
	}
	/**
	 * @param day the day to set
	 */
	public void setDay(int day) {
		this.day = day;
	}
	public Date(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public int compareTo(Date data) {
		// TODO Auto-generated method stub
		if(this.getYear()>data.getYear())
			return 1;
		else if(this.getYear()==data.getYear())
		{
			return 0;
		}else{
			return -1;
		}
	}
	
	public String toString(){
		return this.getYear()+"--"+this.getMonth()+"--"+this.getDay();
	}

}
