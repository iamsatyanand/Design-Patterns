package SOLIDPrinciples.SingleResponsibilityPrinciple.Question2;

public class PayRollCalculator {

    public Double calculatePay(Employee employee){
        double basePay = employee.getSalary();
        double bonus = calculateBonus(employee);
        double deductions = calculateDeductions(employee);
        return basePay + bonus - deductions;
    }

    private double calculateDeductions(Employee employee) {
        return employee.getSalary() * 0.2;
    }

    private double calculateBonus(Employee employee) {
        return employee.getSalary() * 0.1;
    }

}
