//File: Appointment.java
//Description:Represents one appointment between a patient and a HealthProfessional.
//Uses HealthProfessional as the doctor type

public class Appointment {

    //Private field definition
    private String patientName;     //Patientname
    private String patientMobile;   //Patient mobile number (for contact)
    private String timeSlot;        //Appointment period
    private HealthProfessional doctor;  //attending doctor

    //The following is the constructor
    //Parameterless constructor: setting security defaults
    public Appointment() {
        this.patientName = "Unknown";
        this.patientMobile = "Unknown";
        this.doctor = null;  //No doctor by default
        this.timeSlot = "Unknown";
    }

    //Full parameter constructor: directly initialize all fields when creating objects
    public Appointment(String patientName, String patientMobile, String timeSlot, HealthProfessional doctor) {
        this.patientName = patientName;
        this.patientMobile = patientMobile;
        this.doctor = doctor;
        this.timeSlot = timeSlot;
    }


    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientMobile() {
        return patientMobile;
    }

    public void setPatientMobile(String patientMobile) {
        this.patientMobile = patientMobile;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public HealthProfessional getDoctor() {
        return doctor;
    }

    public void setDoctor(HealthProfessional doctor) {
        this.doctor = doctor;
    }

    public void printDetails() {
        System.out.println("Patient Name: " + patientName);
        System.out.println("Patient Mobile: " + patientMobile);
        System.out.println("Time Slot: " + timeSlot);

        if (doctor != null) {
            System.out.println("Doctor Type: " + doctor.getClass().getSimpleName());
            System.out.println("Doctor Name: " + doctor.getName());
            System.out.println("Doctor Room: " + doctor.getRoomNumber());
        } else {
            System.out.println("Doctor: Not Assigned");
        }
    }
}