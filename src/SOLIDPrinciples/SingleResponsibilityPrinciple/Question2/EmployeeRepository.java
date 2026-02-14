package SOLIDPrinciples.SingleResponsibilityPrinciple.Question2;

public class EmployeeRepository {

    public void save(Employee employee){
        // db operations
        System.out.println("Saving employee"+ employee.getName());
    }

    public Employee findByName(){
        // db logic
        return new Employee("Satya", 150000.0, "IT");
    }
}
