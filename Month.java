public class Month {
    
    private String monthName;
    private int year;
    private Day[] days;

    private int totalMileage;

    // Constructor 

    public Month(String monthName, int year) {
        this.monthName = monthName;
        this.year = year;
        this.days = new Day[0]; // Empty array instead of null 
        this.totalMileage = 0;
    }

    // Setters and Getters 

    public void setMonthName(String monthName) { this.monthName = monthName; }
    public String getMonthName() { return monthName; }

    public void setYear(int year) { this.year = year; }
    public int getYear() { return year; }

    public double getTotalMileage() { return totalMileage; }



}