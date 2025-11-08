//File name: Paediatronom.java
//Description: Subclass (Pediatrician), inherited from HealthProfessional

public class Paediatrician extends HealthProfessional {
    private boolean neonatologyFocus;
    public Paediatrician() {
        super();
        this.neonatologyFocus = false;
    }
    public Paediatrician(int id, String name, int roomNumber, boolean neonatologyFocus) {
        super(id, name, roomNumber);
        this.neonatologyFocus = neonatologyFocus;
    }
    public void setNeonatologyFocus(boolean neonatologyFocus) {
        this.neonatologyFocus = neonatologyFocus;
    }
    public boolean isNeonatologyFocus() {
        return neonatologyFocus;
    }
    @Override
    public void printDetails() {
        super.printDetails();

        System.out.println("Neonatology Focus: " + (neonatologyFocus ? "Yes" : "No"));
    }
    @Override
    public String toString() {
        return new StringBuilder()
                .append("Paediatrician [")
                .append("id=").append(getId())
                .append(", name=").append(getName())
                .append(", roomNumber=").append(getRoomNumber())
                .append(", neonatologyFocus=").append(neonatologyFocus ? "Yes" : "No")
                .append("]")
                .toString();
    }
}