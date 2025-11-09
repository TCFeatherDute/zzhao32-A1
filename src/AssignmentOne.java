//File: AssignmentOne.java
//Using classes and objects (HealthProfessional subclasses)
//Appointment management using ArrayList and polymorphism
//Dependencies:HealthProfessional, GeneralPractitioner, Paediatrician, Appointment

import java.util.ArrayList;

public class AssignmentOne {
    //Static ArrayList collection: stores all reservation records globally, and static decoration ensures the unique collection instance in the whole process
    private static ArrayList<Appointment> appointments = new ArrayList<>();

    //Program entry method
    public static void main(String[] args) {
        //Demonstrate the creation and use of health professional subclasses
        System.out.println("===== Using classes and objects =====");

        //Create 3 general practitioner objects to show the use of different constructors and setters
        GeneralPractitioner gp1 = new GeneralPractitioner(1001, "Dr. xiaohong", 101, true);
        GeneralPractitioner gp2 = new GeneralPractitioner(1002, "Dr. xiaocheng", 102, false);
        GeneralPractitioner gp3 = new GeneralPractitioner();
        gp3.setId(1003);
        gp3.setName("Dr. xiaohuang");
        gp3.setRoomNumber(103);
        gp3.setBulkBilling(true);

        //Create 2 paediatrician objects and use the full parameter constructor to quickly initialize
        Paediatrician p1 = new Paediatrician(2001, "Dr. xiaolu", 201, true);
        Paediatrician p2 = new Paediatrician(2002, "Dr. xiaoqing", 202, false);

        //Print all GP information
        System.out.println("--- General Practitioners ---");
        gp1.printDetails();
        System.out.println("------------------------------");
        gp2.printDetails();
        System.out.println("------------------------------");
        gp3.printDetails();
        System.out.println("------------------------------");
