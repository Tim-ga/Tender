package TenderBody;

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
