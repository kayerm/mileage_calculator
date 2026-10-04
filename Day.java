import java.lang.String;

public class Day {

    private String date;
    private String[] mileageEntries;
    private int entryIndex = 0;

    private double mileageForDay;

    static final String PENELOPE_4983 = "Penelope 4983";
    static final String JENNIFER_5340 = "Jennifer 5340";
    static final String SPENCER_7646 = "Spencer 7646";
    static final String EMILY_2074 = "Emily 2074";
    static final String TARA_3736 = "Tara 7646";
    static final String HOTCHNER_BANK = "Hotchner Bank";

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
        this.mileageEntries = new String[10];
    }

    // Setters and getters

    public void setDate(String date) { this.date = date; }
    public String getDate() { return date; }


    // Helper methods

    //// Add the place to the entries of stores

    public boolean addPlace(String stop) {
        switch (stop.toLowerCase()) {
            case "4983":
            case "penelope":
                mileageEntries[entryIndex++] = PENELOPE_4983;
                System.out.printf("%n> %s store added.%n", PENELOPE_4983);
                return false;
            case "5340":
            case "jennifer":
                mileageEntries[entryIndex++] = JENNIFER_5340;
                System.out.printf("%n> %s store added.%n", JENNIFER_5340);
                return false;
            case "7646":
            case "spencer":
                mileageEntries[entryIndex++] = SPENCER_7646;
                System.out.printf("%n> %s store added.%n", SPENCER_7646);
                return false;
            case "2074":
            case "emily":
                mileageEntries[entryIndex++] = EMILY_2074;
                System.out.printf("%n> %s store added.%n", EMILY_2074);
                return false;
            case "3736":
            case "tara":
                mileageEntries[entryIndex++] = TARA_3736;
                System.out.printf("%n> %s store added.%n", TARA_3736);
                return false;
            case "bank":
            case "hotchner":
                mileageEntries[entryIndex++] = HOTCHNER_BANK;
                System.out.printf("%n> %s stop added.%n", HOTCHNER_BANK);
                return false;
            case "done":
                System.out.println(toString());
                return true;
            default:
                System.out.println("\n> Unsure about the store, please try again!");
                return false;
        }
    }

    @Override
    public String toString() {
        String toReturn = "\n> " + date + " entry: ";
        int index = 0;
        while (!(mileageEntries[index] == null)) {
            toReturn += mileageEntries[index] + " ";
            if (mileageEntries[++index] != null) { toReturn += "> ";}
        }
        toReturn += "\n";
        return toReturn;
    }

    //// Calculate the distance between entries 

}