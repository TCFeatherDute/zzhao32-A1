//File: GeneralPractitioner.java
//Description: Subclass (General Practitioner), inherits from HealthProfessional

public class GeneralPractitioner extends HealthProfessional {

    //Subclass-specific field (encapsulated)
    private boolean bulkBilling;

    //Constructors
    //No-argument constructor: Inherits parent class default values and subclass field default values
    public GeneralPractitioner() {
        super(); //Explicitly call parent class no-argument constructor (initialize id, name, roomNumber)
        this.bulkBilling = false; // Subclass field default: does not provide bulk billing
    }

    // Full-argument constructor: Initialize all parent class fields and subclass-specific fields
    public GeneralPractitioner(int id, String name, int roomNumber, boolean bulkBilling) {
        super(id, name, roomNumber); //Call parent class constructor
        this.bulkBilling = bulkBilling; //Initialize subclass-specific field
    }

    //Getter for bulkBilling field
    public boolean isBulkBilling() {
        return bulkBilling;
    }

    //Setter for bulkBilling field
    public void setBulkBilling(boolean bulkBilling) {
        this.bulkBilling = bulkBilling;
    }


       //Override printDetails method to display both parent and subclass information
       //Calls parent method first, then adds subclass-specific field

    @Override
    public void printDetails() {
        super.printDetails();
        //First call parent method to print common fields (id, name, roomNumber)
        //Supplement with subclass-specific field
        System.out.println("Bulk Billing: " + (bulkBilling ? "Yes" : "No"));
    }


     //Override toString() method for easier debugging and printing
     //Reuses parent class toString() base information and appends subclass field
     //Fixes parent class bracket closure issue

    @Override
    public String toString() {
        //Reuse parent class toString() base information and remove closing bracket
        String parentStr = super.toString().replace("]", "");
        return new StringBuilder(parentStr)
                .append(", bulkBilling=")
                .append(bulkBilling ? "Yes" : "No")
        //Format optimization
                .append("]")
                .toString();
    }

}