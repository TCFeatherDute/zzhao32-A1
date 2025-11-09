//File: AssignmentOne.java
//Using classes and objects (HealthProfessional subclasses)
//Appointment management using ArrayList and polymorphism
//Dependencies:HealthProfessional, GeneralPractitioner, Paediatrician, Appointment

import java.util.ArrayList;

public class AssignmentOne {
    //Static ArrayList collection: store all reservation records globally, and use static decoration to ensure that there is a unique collection instance in the whole process
    private static ArrayList<Appointment> appointments = new ArrayList<>();

    public static void main(String[] args) {
        //Demonstrate the creation and use of health professional subclasses
        System.out.println("=Part 3 – Using classes and objects=");

        //1.Create 3 general practitioner objects to show the use of different constructors and setters
        GeneralPractitioner gp1 = new GeneralPractitioner(1001, "Dr. xiaoming", 101, true);
        GeneralPractitioner gp2 = new GeneralPractitioner(1002, "Dr. xiaohong", 102, false);
        GeneralPractitioner gp3 = new GeneralPractitioner();
        gp3.setId(1003);
        gp3.setName("Dr. xiaohei");
        gp3.setRoomNumber(103);
        gp3.setBulkBilling(true);

        //2.Create 2 paediatrician objects and use the full parameter constructor to quickly initialize
        Paediatrician p1 = new Paediatrician(2001, "Dr. xiaolong", 201, true);
        Paediatrician p2 = new Paediatrician(2002, "Dr. xiaofei", 202, false);

        //3.Print all GP information
        System.out.println("--- General Practitioners ---");
        gp1.printDetails();
        System.out.println("------------------------------");
        gp2.printDetails();
        System.out.println("------------------------------");
        gp3.printDetails();
        System.out.println("------------------------------");

        //4. Print all pediatrician information
        System.out.println("\n--- Paediatricians ---");
        p1.printDetails();
        System.out.println("------------------------------");
        p2.printDetails();
        System.out.println("------------------------------");
        //This is the overall split line
        System.out.println("------------------------------");
