package finalexam.task4;

public class SecurityCompanyTester {

    public static void main(String[] args) {
        SecurityCompany company = new SecurityCompany("123 Main St", "VAT123456");

        Guard guard1 = new Guard("John", "Doe", "123456");
        Guard guard2 = new Guard("Jane", "Smith", "654321");

        company.addGuard(guard1);
        company.addGuard(guard2);

        System.out.println("Company address: " + company.getAddress());
        System.out.println("Company VAT number: " + company.getVatNumber());

        System.out.println("Guards list after adding guards:");
        company.printGuards();

        company.deleteGuard(guard1);

        System.out.println("Guards list after deleting a guard:");
        company.printGuards();

        company.saveGuardsList("guards.txt");
        company.loadGuardsList("guards.txt");
        System.out.println("Guards list after loading from file:");
        company.printGuards();
    }
}
