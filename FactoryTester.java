package finalexam.task3;

public class FactoryTester {

    public static void main(String[] args) {
        PaperFactory factory = new PaperFactory();

        Person person1 = new Person("John", "Doe", "123456");
        Person person2 = new Person("Jane", "Smith", "654321");

        factory.addPerson(person1);
        factory.addPerson(person2);

        System.out.println("Factory staff after adding persons:");
        factory.printStaff();

        factory.deletePerson(person1);

        System.out.println("Factory staff after deleting a person:");
        factory.printStaff();

        factory.saveStaffList("staff.txt");
        factory.loadStaffList("staff.txt");
        System.out.println("Factory staff after loading from file:");
        factory.printStaff();
    }

}
