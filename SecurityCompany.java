package finalexam.task4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SecurityCompany implements LegalEntity {
    private String address;
    private String vatNumber;
    private List<Guard> guards = new ArrayList<>();

    public SecurityCompany(String address, String vatNumber) {
        this.address = address;
        this.vatNumber = vatNumber;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String getVatNumber() {
        return vatNumber;
    }

    public void addGuard(Guard guard) {
        guards.add(guard);
    }

    public boolean deleteGuard(Guard guard) {
        return guards.remove(guard);
    }

    public void printGuards() {
        for (Guard guard : guards) {
            System.out.println(guard);
        }
    }

    public void saveGuardsList(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Guard guard : guards) {
                writer.println(guard.name + "," + guard.surname + "," + guard.personalNumber);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while saving the guards list.");
            e.printStackTrace();
        }
    }

    public void loadGuardsList(String filename) {
        guards.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    guards.add(new Guard(parts[0], parts[1], parts[2]));
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while loading the guards list.");
            e.printStackTrace();
        }
    }
}
