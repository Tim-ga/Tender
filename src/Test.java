import java.math.BigDecimal;
import java.util.*;


public class Test {
    public static void main(String[] args) {

        ArrayList<Employee> employeesBrigade1 = new ArrayList<>(); //8600
        Brigade brigade1 = new Brigade(employeesBrigade1);
        employeesBrigade1.add(new Employee(EnumSet.of(Skills.ARCHITECT), new BigDecimal("1200")));
        employeesBrigade1.add(new Employee(EnumSet.of(Skills.ARCHITECT, Skills.BRICKLAYER), new BigDecimal("2500")));
        employeesBrigade1.add(new Employee(EnumSet.of(Skills.ELECTRICIAN, Skills.PLUMBER), new BigDecimal("800")));
        employeesBrigade1.add(new Employee(EnumSet.of(Skills.FITTER, Skills.BRICKLAYER), new BigDecimal("1000")));
        employeesBrigade1.add(new Employee(EnumSet.of(Skills.ELECTRICIAN), new BigDecimal("500")));
        employeesBrigade1.add(new Employee(EnumSet.of(Skills.PLUMBER, Skills.WELDER, Skills.FITTER), new BigDecimal("1800")));

        ArrayList<Employee> employeesBrigade2 = new ArrayList<>(); //7900
        Brigade brigade2 = new Brigade(employeesBrigade2);
        employeesBrigade2.add(new Employee(EnumSet.of(Skills.ARCHITECT), new BigDecimal("1800")));
        employeesBrigade2.add(new Employee(EnumSet.of(Skills.BRICKLAYER), new BigDecimal("700")));
        employeesBrigade2.add(new Employee(EnumSet.of(Skills.BRICKLAYER), new BigDecimal("700")));
        employeesBrigade2.add(new Employee(EnumSet.of(Skills.ELECTRICIAN), new BigDecimal("600")));
        employeesBrigade2.add(new Employee(EnumSet.of(Skills.ELECTRICIAN), new BigDecimal("600")));
        employeesBrigade2.add(new Employee(EnumSet.of(Skills.ELECTRICIAN), new BigDecimal("600")));
        employeesBrigade2.add(new Employee(EnumSet.of(Skills.WELDER), new BigDecimal("700")));
        employeesBrigade2.add(new Employee(EnumSet.of(Skills.PLUMBER), new BigDecimal("800")));
        employeesBrigade2.add(new Employee(EnumSet.of(Skills.PLUMBER), new BigDecimal("800")));
        employeesBrigade2.add(new Employee(EnumSet.of(Skills.FITTER), new BigDecimal("600")));

        ArrayList<Employee> employeesBrigade3 = new ArrayList<>(); //7250
        Brigade brigade3 = new Brigade(employeesBrigade3);
        employeesBrigade3.add(new Employee(EnumSet.of(Skills.ARCHITECT), new BigDecimal("1900")));
        employeesBrigade3.add(new Employee(EnumSet.of(Skills.BRICKLAYER), new BigDecimal("600")));
        employeesBrigade3.add(new Employee(EnumSet.of(Skills.ELECTRICIAN), new BigDecimal("600")));
        employeesBrigade3.add(new Employee(EnumSet.of(Skills.ELECTRICIAN, Skills.PLUMBER), new BigDecimal("800")));
        employeesBrigade3.add(new Employee(EnumSet.of(Skills.WELDER), new BigDecimal("700")));
        employeesBrigade3.add(new Employee(EnumSet.of(Skills.PLUMBER), new BigDecimal("700")));
        employeesBrigade3.add(new Employee(EnumSet.of(Skills.PLUMBER, Skills.FITTER), new BigDecimal("1100")));
        employeesBrigade3.add(new Employee(EnumSet.of(Skills.FITTER), new BigDecimal("850")));

        ArrayList<Employee> employeesBrigade4 = new ArrayList<>(); //8400
        Brigade brigade4 = new Brigade(employeesBrigade4);
        employeesBrigade4.add(new Employee(EnumSet.of(Skills.ARCHITECT), new BigDecimal("2100")));
        employeesBrigade4.add(new Employee(EnumSet.of(Skills.BRICKLAYER), new BigDecimal("800")));
        employeesBrigade4.add(new Employee(EnumSet.of(Skills.ELECTRICIAN, Skills.BRICKLAYER), new BigDecimal("1200")));
        employeesBrigade4.add(new Employee(EnumSet.of(Skills.BRICKLAYER), new BigDecimal("800")));
        employeesBrigade4.add(new Employee(EnumSet.of(Skills.WELDER), new BigDecimal("750")));
        employeesBrigade4.add(new Employee(EnumSet.of(Skills.PLUMBER), new BigDecimal("800")));
        employeesBrigade4.add(new Employee(EnumSet.of(Skills.PLUMBER, Skills.WELDER), new BigDecimal("1200")));
        employeesBrigade4.add(new Employee(EnumSet.of(Skills.FITTER), new BigDecimal("750")));

        Tender tender = new Tender(new ArrayList<>(List.of(brigade1, brigade2, brigade3, brigade4)));

        tender.validation(2, 1, 2, 1, 1, 1, tender);
    }



}

