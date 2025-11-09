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

        //Print all pediatrician information
        System.out.println("\n--- Paediatricians ---");
        p1.printDetails();
        System.out.println("------------------------------");
        p2.printDetails();

        System.out.println("------------------------------");


        //Demonstrate the reservation management function, combining ArrayList and polymorphism features
        System.out.println("\n===== Appointment Management =====");
        System.out.println("------------------------------");

        //Create 4 appointments and assign them to general practitioners and pediatricians respectively (polymorphism: sub class objects are assigned to parent class references)
        createAppointment("Dwight", "0000000001", "07:00", gp1);
        createAppointment("Lion", "0000000002", "08:00", gp2);
        createAppointment("Bill", "0000000003", "09:00", p1);
        createAppointment("Tom", "0000000004", "10:00", p2);

        //Print all currently valid appointments
        System.out.println("\n--- Existing Appointments ---");
        printExistingAppointments();

        //Cancel the appointment according to the mobile number
        System.out.println("\n--- Cancel one booking (by mobile) ---");
        cancelBooking("0000000002");

        //Print the cancelled appointment list and verify the cancellation function
        System.out.println("\n--- Appointments After Cancellation ---");
        printExistingAppointments();
    }

    //Create an appointment and add it to the collection
    //@param patientName
    //@param patientMobile
    //@param timeSlot
    //@param doctor

    public static void createAppointment(String patientName,
                                         String patientMobile,
                                         String timeSlot,
                                         HealthProfessional doctor) {
        //Strict parameter verification
        if (patientName == null || patientName.isBlank()) {
            System.out.println("Failed to create appointment: patient name cannot be empty.");
            return;
        }
        if (patientMobile == null || patientMobile.isBlank()) {
            System.out.println("Failed to create appointment: patient mobile cannot be empty.");
            return;
        }
        if (timeSlot == null || timeSlot.isBlank()) {
            System.out.println("Failed to create appointment: time slot cannot be empty.");
            return;
        }
        if (doctor == null) {
            System.out.println("Failed to create appointment: doctor cannot be null.");
            return;
        }

        //Create an appointment object and add it to the static collection
        Appointment appointment = new Appointment(patientName, patientMobile, timeSlot, doctor);
        appointments.add(appointment);

        //Output appointment success prompt, and obtain specific types of doctors through polymorphism
        System.out.printf("Created appointment for %s with %s %s at %s%n",
                patientName,
                doctor.getClass().getSimpleName(),
                doctor.getName(),
                timeSlot);
    }


        //Print all current appointment records
        //If the set is empty, there is no reservation; Otherwise, print reservation details one by one

    public static void printExistingAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No existing appointments.");
            return;
        }

        //Enhanced for loop traversal of collections
        for (Appointment appointment : appointments) {
            System.out.println("------------------------------");
            appointment.printDetails();
        }
    }

        //Cancel the appointment according to the patient's mobile number
        //@param mobile
    public static void cancelBooking(String mobile) {
        // 校验手机号参数有效性
        if (mobile == null || mobile.isBlank()) {
            System.out.println("Invalid mobile number: cannot be empty.");
            return;
        }

        boolean isCancelled = false;
        //Index traverses the collection, which is easy to delete after finding the target
        for (int i = 0; i < appointments.size(); i++) {
            Appointment appointment = appointments.get(i);
            //Match mobile phone number
            if (mobile.equals(appointment.getPatientMobile())) {
                appointments.remove(i);
                System.out.println("Appointment for mobile " + mobile + " has been cancelled.");
                isCancelled = true;
                break;
                //Cancel only the first matching record to avoid repeated cancellation
            }
        }

        //Prompt when no matching appointment is found
        if (!isCancelled) {
            System.out.println("No appointment found for mobile: " + mobile);
        }
    }
}