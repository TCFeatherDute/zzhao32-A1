//File: AssignmentOne.java
//Description:
//Entry point for the assignment.
//Demonstrates:
//  Part 3: Using classes and objects (HealthProfessional subclasses)
//  Part 5: Appointments Collection using ArrayList and polymorphism
//Dependencies:
//  HealthProfessional, GeneralPractitioner, Paediatrician, Appointment

import java.util.ArrayList;

public class AssignmentOne {

    // Stores all appointment records created during program execution.
    // Static: one shared list for the entire application.
    private static final ArrayList<Appointment> appointments = new ArrayList<>();

    public static void main(String[] args) {

        // ============================
        // Part 3 - Using classes and objects
        // ============================
        System.out.println("===== Part 3 - Using classes and objects =====");

        // Create 3 GeneralPractitioner objects
        // (demonstrates use of overloaded constructors and setters)
        GeneralPractitioner gp1 = new GeneralPractitioner(1001, "Dr. xiaohong", 101, true);
        GeneralPractitioner gp2 = new GeneralPractitioner(1002, "Dr. xiaocheng", 102, false);
        GeneralPractitioner gp3 = new GeneralPractitioner();
        gp3.setId(1003);
        gp3.setName("Dr. xiaohuang");
        gp3.setRoomNumber(103);
        gp3.setBulkBilling(true);

        // Create 2 Paediatrician objects using the full-argument constructor
        Paediatrician p1 = new Paediatrician(2001, "Dr. xiaolu", 201, true);
        Paediatrician p2 = new Paediatrician(2002, "Dr. xiaoqing", 202, false);

        // Print all GeneralPractitioner details
        System.out.println("--- General Practitioners ---");
        gp1.printDetails();
        System.out.println("------------------------------");
        gp2.printDetails();
        System.out.println("------------------------------");
        gp3.printDetails();
        System.out.println("------------------------------");

        // Print all Paediatrician details
        System.out.println("\n--- Paediatricians ---");
        p1.printDetails();
        System.out.println("------------------------------");
        p2.printDetails();
        System.out.println("------------------------------");

        // Separator to mark the end of Part 3 output
        System.out.println("------------------------------");

        // ============================
        // Part 5 - Appointments Collection
        // ============================
        System.out.println("\n===== Part 5 - Appointments Collection =====");
        System.out.println("------------------------------");

        // Create 4 appointments:
        // 2 with GeneralPractitioners and 2 with Paediatricians
        // Using HealthProfessional (parent type) to demonstrate polymorphism
        createAppointment("Dwight", "0000000001", "07:00", gp1);
        createAppointment("Lion",   "0000000002", "08:00", gp2);
        createAppointment("Bill",   "0000000003", "09:00", p1);
        createAppointment("Tom",    "0000000004", "10:00", p2);

        // Print all existing appointments
        System.out.println("\n--- Existing Appointments ---");
        printExistingAppointments();

        // Cancel one booking by mobile number
        System.out.println("\n--- Cancel one booking (by mobile) ---");
        cancelBooking("0000000002");

        // Print appointments again to show the updated collection
        System.out.println("\n--- Appointments After Cancellation ---");
        printExistingAppointments();
    }

    /**
     * Creates a new appointment and adds it to the appointments list.
     * All parameters are validated; if any required value is missing,
     * the appointment will not be created.
     *
     * @param patientName   patient's full name (must not be blank)
     * @param patientMobile patient's mobile number (must not be blank)
     * @param timeSlot      appointment time slot (must not be blank)
     * @param doctor        assigned health professional (must not be null)
     */
    public static void createAppointment(String patientName,
                                         String patientMobile,
                                         String timeSlot,
                                         HealthProfessional doctor) {

        // Basic validation: ensure all required fields are provided
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

        // Create the appointment and add it to the shared list
        Appointment appointment = new Appointment(patientName, patientMobile, timeSlot, doctor);
        appointments.add(appointment);

        // Confirm creation (demonstrates polymorphism via doctor.getClass().getSimpleName())
        System.out.printf(
                "Created appointment for %s with %s %s at %s%n",
                patientName,
                doctor.getClass().getSimpleName(),
                doctor.getName(),
                timeSlot
        );
    }

    /**
     * Prints all existing appointments.
     * If there are no appointments, prints an appropriate message.
     */
    public static void printExistingAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No existing appointments.");
            return;
        }

        for (Appointment appointment : appointments) {
            System.out.println("------------------------------");
            appointment.printDetails();
        }
    }

    /**
     * Cancels the first appointment that matches the given mobile number.
     * If no appointment is found, prints an appropriate message.
     *
     * @param mobile patient mobile number used to search for the booking
     */
    public static void cancelBooking(String mobile) {
        if (mobile == null || mobile.isBlank()) {
            System.out.println("Invalid mobile number: cannot be empty.");
            return;
        }

        boolean isCancelled = false;

        // Use index-based loop so we can safely remove by index
        for (int i = 0; i < appointments.size(); i++) {
            Appointment appointment = appointments.get(i);

            if (mobile.equals(appointment.getPatientMobile())) {
                appointments.remove(i);
                System.out.println("Appointment for mobile " + mobile + " has been cancelled.");
                isCancelled = true;
                break; // Cancel only the first matching booking
            }
        }

        if (!isCancelled) {
            System.out.println("No appointment found for mobile: " + mobile);
        }
    }
}
