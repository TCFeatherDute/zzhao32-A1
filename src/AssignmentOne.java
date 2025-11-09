//File: AssignmentOne.java
//Using classes and objects (HealthProfessional subclasses)
//Appointment management using ArrayList and polymorphism
//Dependencies:HealthProfessional, GeneralPractitioner, Paediatrician, Appointment

import java.util.ArrayList;

public class AssignmentOne {
    //Static ArrayList collection: store all reservation records globally, and use static decoration to ensure that there is a unique collection instance in the whole process
    private static ArrayList<Appointment> appointments = new ArrayList<>();