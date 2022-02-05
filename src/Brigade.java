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

    protected static BigDecimal getFullFinancialOffer(Brigade brigade) {
        BigDecimal sum = BigDecimal.ZERO;

        for (Employee employee : brigade.getEmployees()) {
            sum = sum.add(employee.getFinancialOffer());
        }
        return sum;
    }

    protected static int[] getNumberOfSpecialists(Brigade brigade) {
        Skills[] skills = Skills.values();
        int[] numberOfSpecialists = new int[skills.length];

        for (Employee employee : brigade.getEmployees()) {
            numberOfSpecialists[0] += Collections.frequency(employee.getSkills(), skills[0]);
            numberOfSpecialists[1] += Collections.frequency(employee.getSkills(), skills[1]);
            numberOfSpecialists[2] += Collections.frequency(employee.getSkills(), skills[2]);
            numberOfSpecialists[3] += Collections.frequency(employee.getSkills(), skills[3]);
            numberOfSpecialists[4] += Collections.frequency(employee.getSkills(), skills[4]);
            numberOfSpecialists[5] += Collections.frequency(employee.getSkills(), skills[5]);
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
