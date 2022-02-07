import java.math.BigDecimal;
import java.util.*;

public class Brigade {
    private ArrayList<Employee> employees;

    public Brigade(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    protected static BigDecimal getBrigadeFullCost(Brigade brigade) {
        BigDecimal sum = BigDecimal.ZERO;

        for (Employee employee : brigade.getEmployees()) {
            sum = sum.add(employee.getFinancialOffer());
        }
        return sum;
    }

    protected static int[] getNumberOfSpecialists(Brigade brigade) {
        Skills[] skills = Skills.values();
        int[] numberOfSpecialists = new int[skills.length];

        for (int i = 0; i < skills.length; i++) {
            for (Employee employee : brigade.getEmployees()) {
                numberOfSpecialists[i] += Collections.frequency(employee.getSkills(), skills[i]);
            }
        }
        return numberOfSpecialists;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brigade brigade = (Brigade) o;
        return Objects.equals(employees, brigade.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employees);
    }

    @Override
    public String toString() {
        return "Brigade{" +
                "employees=" + employees +
                '}';
    }
}
