package TenderBody;

import java.math.BigDecimal;
import java.util.EnumSet;
import java.util.Objects;

public class Employee {
    private EnumSet<Skills> skills;
    private BigDecimal financialOffer;

    public Employee(EnumSet skills, BigDecimal financialOffer) {
        this.skills = skills;
        this.financialOffer = financialOffer;
    }

    public EnumSet getSkills() {
        return skills;
    }

    public void setSkills(EnumSet skills) {
        this.skills = skills;
    }

    public BigDecimal getFinancialOffer() {
        return financialOffer;
    }

    public void setFinancialOffer(BigDecimal financialOffer) {
        this.financialOffer = financialOffer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(skills, employee.skills) && Objects.equals(financialOffer, employee.financialOffer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(skills, financialOffer);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "skills=" + skills +
                ", financialOffer=" + financialOffer +
                '}';
    }
}
