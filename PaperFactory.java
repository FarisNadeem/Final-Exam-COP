package finalexam.task3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PaperFactory {
    private List<Person> staff = new ArrayList<>();

    public void addPerson(Person p) {
        staff.add(p);
    }

    public boolean deletePerson(Person p) {
        return staff.remove(p);
    }

    public void printStaff() {
        for (Person person : staff) {
            System.out.println(person);
        }
    }

    public void saveStaffList(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Person person : staff) {
                writer.println(person.name + "," + person.surname + "," + person.personalNumber);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while saving the staff list.");
            e.printStackTrace();
        }
    }

    public void loadStaffList(String filename) {
        staff.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    staff.add(new Person(parts[0], parts[1], parts[2]));
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while loading the staff list.");
            e.printStackTrace();
        }
    }
}
