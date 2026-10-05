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

    //// Show the overview of days 

    public String toString() {
        String toReturn = "\n> This is for the month of " + monthName + " year " + year + ": \n";
        for (int i = 0; i < daysIndex; i++) {
            toReturn += days[i].toString();
        }
        toReturn += "\n";
        return toReturn;
    }

    //// Delete a day to the list 
    
    public boolean deleteDay(String dateToDelete) {
        dateToDelete = dateToDelete.toLowerCase();
        for (int i = 0; i < daysIndex; i++) {
            if (days[i].getDate().equals(dateToDelete)) {
                if (i == 0 && daysIndex > 0) {
                    deleteDayHelper(i);
                } else if(i == 0) {
                    days[i] = null;
                }
                else {
                    deleteDayHelper(i);
                }
                daysIndex -= 1;
                return true;
            }
        }
        return false;
    }

    public void deleteDayHelper(int index) {
        for (int k = index; k < daysIndex; k++) {
            days[k] = days[k+1];
        }
    }

}