import java.lang.String;

public class Day {

    private String date;
    private int[] mileageEntries;
    private int entryIndex = 0;

    private double mileageForDay;

    static final int PENELOPE_4983 = 0;
    static final int JENNIFER_5340 = 1;
    static final int SPENCER_7646 = 2;
    static final int EMILY_2074 = 3;
    static final int TARA_3736 = 4;
    static final int HOTCHNER_BANK = 5;

    private double[][] cost = {
        // P0, P1, P2, P3, P4, P5
        { 0, 3.5, 5, 7, 7.35, 6.98},        // from 4983
        { 3.5, 0, 5.7, 7.7, 8.05, 7.68},    // from 5340
        { 5, 5.7, 0, 2, 2.35, 1.98},        // from 7646
        { 7, 7.7, 2, 0, 0.35, 0.02},        // from 2074
        { 7.35, 8.05, 2, 0.35, 0, 0.37},    // from 3736
        { 6.98, 7.68, 1.98, 0.02, 0.37, 0}  // bank
    };
    
    // Constructor 

    public Day(String date) {
        this.date = date;
        this.mileageForDay = 0; 
        this.mileageEntries = new int[10];
    }

    // Setters and getters

    public void setDate(String date) { this.date = date; }
    public String getDate() { return date; }


    // Helper methods

    //// Add the place to the entries of stores

    public boolean addPlace(String stop) {
        switch (stop.toLowerCase()) {
            case "4983":
                mileageEntries[entryIndex++] = PENELOPE_4983;
                return false;
            case "5340":
                mileageEntries[entryIndex++] = JENNIFER_5340;
                return false;
            case "7646":
                mileageEntries[entryIndex++] = SPENCER_7646;
                return false;
            case "2074":
                mileageEntries[entryIndex++] = EMILY_2074;
                return false;
            case "3736":
                mileageEntries[entryIndex++] = TARA_3736;
                return false;
            case "bank":
                mileageEntries[entryIndex++] = HOTCHNER_BANK;
                return true;
            default:
                System.out.println("> Unsure about the store, please try again!");
                return false;
        }
    }

    //// Calculate the distance between entries 

}