//File name：HealthProfessional.java
//Explanation: The base class (parent class) represents the commonality of all health professionals
//This class defines the basic attributes and behaviors of health professionals and serves as the parent class for other specific medical professionals
public class HealthProfessional {

    //Field
    //Use the private modifier to implement encapsulation and protect data security

    private int id;           //Health professional number (unique identifier)
    private String name;      //name
    private int roomNumber;   //The room number for work

    //The following is the constructor
    //Parameterless constructor: Provides default initial values. This constructor is used when no parameters are provided when creating an object
    public HealthProfessional() {
        this.id = 0;          //Default number (0 indicates unassigned)
        this.name = "Unknown";//Default name (unknown)
        this.roomNumber = 0;  //Default room number (0 indicates unassigned)
    }

    //Use this constructor when providing all parameters when creating an object

    public HealthProfessional(int id, String name, int roomNumber) {
        this.id = id;
        this.name = name;
        this.roomNumber = roomNumber;
    }

    //Get the health professional number, @return returns the id value
    public int getId() {
        return id;
    }

    //Set the health professional number, @param id The number to set
    public void setId(int id) {
        //'this.id' is a member variable and 'id' is a parameter
        this.id = id;
    }

    //Get the name, @return returns the name value

    public String getName() {
        return name;
    }

    //Set name, @ param name Name to set
    public void setName(String name) {
        this.name = name;
    }

    //Get the room number, @return returns the roomNumber value

    public int getRoomNumber() {
        return roomNumber;
    }

    //Set the room number, @param roomNumber Room number to set

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    //Display object details and print object details to the console

    public void printDetails() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Room Number: " + roomNumber);
    }
    //Override the toString method of the Object class to return the string representation of the object for printing and debugging. @ return contains the string of all field information of the object

    @Override
    public String toString() {
    //Use StringBuilder to optimize string splicing
        return new StringBuilder()
                .append("HealthProfessional [id=")
                .append(id)
                .append(", name=")
                .append(name)
                .append(", roomNumber=")
                .append(roomNumber)
                .append("]")
                .toString();
    //Convert StringBuilder object to String
    }

}