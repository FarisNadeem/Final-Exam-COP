package finalexam.task3;

public class Person {
    String name;
    String surname;
    String personalNumber;

    public Person(String name, String surname, String personalNumber) {
        this.name = name;
        this.surname = surname;
        this.personalNumber = personalNumber;
    }

    @Override
    public String toString() {
        return "Person [Name=" + name + ", Surname=" + surname + ", Personal Number=" + personalNumber + "]";
    }
}
