package finalexam.task4;

public class Guard {
    String name;
    String surname;
    String personalNumber;

    public Guard(String name, String surname, String personalNumber) {
        this.name = name;
        this.surname = surname;
        this.personalNumber = personalNumber;
    }

    @Override
    public String toString() {
        return "Guard [Name=" + name + ", Surname=" + surname + ", Personal Number=" + personalNumber + "]";
    }
}
