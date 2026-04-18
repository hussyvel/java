package entities;

public class EmployeeTest {

    public static void main(String[] args) {
        testNetSalary();
        testIncreaseSalaryAppliesOnlyToGross();
        testTaxUnchangedAfterIncrease();
        testIncreaseSalaryZeroPercent();
        System.out.println("All tests passed.");
    }

    static void testNetSalary() {
        Employee emp = new Employee("Alex", 6000.0, 1000.0);
        assert emp.netSalary() == 5000.0 : "netSalary should be grossSalary - tax";
    }

    static void testIncreaseSalaryAppliesOnlyToGross() {
        Employee emp = new Employee("Alex", 6000.0, 1000.0);
        emp.increaseSalary(10.0);
        assert Math.abs(emp.getGrossSalary() - 6600.0) < 0.001 : "Gross salary should be 6600.00 after 10% increase";
        assert Math.abs(emp.netSalary() - 5600.0) < 0.001 : "Net salary should be 5600.00 after 10% increase";
    }

    static void testTaxUnchangedAfterIncrease() {
        Employee emp = new Employee("Alex", 6000.0, 1000.0);
        emp.increaseSalary(50.0);
        assert emp.getTax() == 1000.0 : "Tax must not change after salary increase";
    }

    static void testIncreaseSalaryZeroPercent() {
        Employee emp = new Employee("Alex", 6000.0, 1000.0);
        emp.increaseSalary(0.0);
        assert emp.getGrossSalary() == 6000.0 : "0% increase should not change salary";
    }
}
