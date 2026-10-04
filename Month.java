public class Month {
    
    private String monthName;
    private int year;

    private int daysIndex;
    private Day[] days;

    private int totalMileage;

    // Constructor 

    public Month(String monthName, int year) {
        this.monthName = monthName;
        this.year = year;
        this.days = new Day[10]; // Empty array instead of null 
        this.totalMileage = 0;
        this.daysIndex = 0;
    }

    // Setters and Getters 

    public void setMonthName(String monthName) { this.monthName = monthName; }
    public String getMonthName() { return monthName; }

    public void setYear(int year) { this.year = year; }
    public int getYear() { return year; }

    public double getTotalMileage() { return totalMileage; }

    // Helper methods

    //// Add a day to the list of days
    
    public boolean addDayToMonth(Day dayToAdd) {
        if (daysIndex < 10) {
            days[daysIndex++] = dayToAdd;
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        String toReturn = "> This is for the month of " + monthName + " year " + year + ": \n";
        for (int i = 0; i < daysIndex; i++) {
            toReturn += days[i].toString();
        }
        toReturn += "\n";
        return toReturn;
    }

}