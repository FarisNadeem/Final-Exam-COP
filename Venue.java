package finalexam.task1;

public class Venue {

    private String name;
    private String location;
    private int capacity;

    public Venue(String name, String location, int capacity) {
        this.name = name;
        this.location = location;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Venue [Name=" + name + ", Location=" + location + ", Capacity=" + capacity + "]";
    }

    public void displayVenueDetails() {
        System.out.println(this.toString());
    }

}
