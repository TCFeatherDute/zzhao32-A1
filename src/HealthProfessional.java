public class HealthProfessional {
    private int id;
    private String name;
    private int roomNumber;
    public HealthProfessional() {
        this.id = 0;
        this.name = "";
        this.roomNumber = 0;

    }

    public HealthProfessional(int id, String name, int roomNumber) {
        this.id = id;
        this.name = name;
        this.roomNumber = roomNumber;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public int getRoomNumber() {
        return roomNumber;
    }


    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void printInfo() {
        System.out.printf("[HP] id=%d, name=%s, room=%d%n", id, name, roomNumber);
    }

}