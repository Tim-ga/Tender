package TenderTests;

import TenderBody.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.math.BigDecimal;
import java.util.*;

public class TenderTest {

    Tender tender1;
    Tender tender2;
    Tender tender3;
    Tender tender4;
    Tender tender5;
    Brigade brigade1;
    Brigade brigade2;
    Brigade brigade3;
    Brigade brigade4;

    @Before
    public void initialization() {
        ArrayList<Employee> employeesBrigade1 = new ArrayList<>(); //full cost brigade 7800
        brigade1 = new Brigade(employeesBrigade1);
        employeesBrigade1.add(new Employee(EnumSet.of(Skills.ARCHITECT), new BigDecimal("1200")));
        employeesBrigade1.add(new Employee(EnumSet.of(Skills.ARCHITECT, Skills.BRICKLAYER), new BigDecimal("2500")));
        employeesBrigade1.add(new Employee(EnumSet.of(Skills.ELECTRICIAN, Skills.PLUMBER), new BigDecimal("800")));
        employeesBrigade1.add(new Employee(EnumSet.of(Skills.FITTER, Skills.BRICKLAYER), new BigDecimal("1000")));
        employeesBrigade1.add(new Employee(EnumSet.of(Skills.ELECTRICIAN), new BigDecimal("500")));
        employeesBrigade1.add(new Employee(EnumSet.of(Skills.PLUMBER, Skills.WELDER, Skills.FITTER), new BigDecimal("1800")));

        ArrayList<Employee> employeesBrigade2 = new ArrayList<>(); //full cost brigade 7900
        brigade2 = new Brigade(employeesBrigade2);
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

        ArrayList<Employee> employeesBrigade3 = new ArrayList<>(); //full cost brigade 7250
        brigade3 = new Brigade(employeesBrigade3);
        employeesBrigade3.add(new Employee(EnumSet.of(Skills.ARCHITECT), new BigDecimal("1900")));
        employeesBrigade3.add(new Employee(EnumSet.of(Skills.BRICKLAYER), new BigDecimal("600")));
        employeesBrigade3.add(new Employee(EnumSet.of(Skills.ELECTRICIAN), new BigDecimal("600")));
        employeesBrigade3.add(new Employee(EnumSet.of(Skills.ELECTRICIAN, Skills.PLUMBER), new BigDecimal("800")));
        employeesBrigade3.add(new Employee(EnumSet.of(Skills.WELDER), new BigDecimal("700")));
        employeesBrigade3.add(new Employee(EnumSet.of(Skills.PLUMBER), new BigDecimal("700")));
        employeesBrigade3.add(new Employee(EnumSet.of(Skills.PLUMBER, Skills.FITTER), new BigDecimal("1100")));
        employeesBrigade3.add(new Employee(EnumSet.of(Skills.FITTER), new BigDecimal("850")));

        ArrayList<Employee> employeesBrigade4 = new ArrayList<>(); //full cost brigade 7650
        brigade4 = new Brigade(employeesBrigade4);
        employeesBrigade4.add(new Employee(EnumSet.of(Skills.ARCHITECT), new BigDecimal("2100")));
        employeesBrigade4.add(new Employee(EnumSet.of(Skills.BRICKLAYER), new BigDecimal("800")));
        employeesBrigade4.add(new Employee(EnumSet.of(Skills.ELECTRICIAN, Skills.BRICKLAYER), new BigDecimal("1200")));
        employeesBrigade4.add(new Employee(EnumSet.of(Skills.BRICKLAYER), new BigDecimal("800")));
        employeesBrigade4.add(new Employee(EnumSet.of(Skills.WELDER), new BigDecimal("750")));
        employeesBrigade4.add(new Employee(EnumSet.of(Skills.PLUMBER), new BigDecimal("800")));
        employeesBrigade4.add(new Employee(EnumSet.of(Skills.PLUMBER, Skills.WELDER), new BigDecimal("1200")));

        Map<Skills, Integer> neededSpecialists1 = new HashMap<>();
        neededSpecialists1.put(Skills.ARCHITECT, 1);
        neededSpecialists1.put(Skills.BRICKLAYER, 1);
        neededSpecialists1.put(Skills.ELECTRICIAN, 3);
        neededSpecialists1.put(Skills.WELDER, 1);
        neededSpecialists1.put(Skills.PLUMBER, 2);
        neededSpecialists1.put(Skills.FITTER, 1);

        Map<Skills, Integer> neededSpecialists2 = new HashMap<>();
        neededSpecialists2.put(Skills.ARCHITECT, 2);
        neededSpecialists2.put(Skills.BRICKLAYER, 1);
        neededSpecialists2.put(Skills.ELECTRICIAN, 1);
        neededSpecialists2.put(Skills.WELDER, 1);
        neededSpecialists2.put(Skills.PLUMBER, 2);
        neededSpecialists2.put(Skills.FITTER, 1);

        Map<Skills, Integer> neededSpecialists3 = new HashMap<>();
        neededSpecialists3.put(Skills.ARCHITECT, 1);
        neededSpecialists3.put(Skills.BRICKLAYER, 1);
        neededSpecialists3.put(Skills.ELECTRICIAN, 1);
        neededSpecialists3.put(Skills.WELDER, 1);
        neededSpecialists3.put(Skills.PLUMBER, 1);
        neededSpecialists3.put(Skills.FITTER, 0);

        Map<Skills, Integer> neededSpecialists4 = new HashMap<>();
        neededSpecialists4.put(Skills.ARCHITECT, 1);
        neededSpecialists4.put(Skills.BRICKLAYER, 3);
        neededSpecialists4.put(Skills.ELECTRICIAN, 1);
        neededSpecialists4.put(Skills.WELDER, 1);
        neededSpecialists4.put(Skills.PLUMBER, 2);
        neededSpecialists4.put(Skills.FITTER, 0);

        Map<Skills, Integer> neededSpecialists5 = new HashMap<>();
        neededSpecialists5.put(Skills.ARCHITECT, 0);
        neededSpecialists5.put(Skills.BRICKLAYER, 0);
        neededSpecialists5.put(Skills.ELECTRICIAN, 10);
        neededSpecialists5.put(Skills.WELDER, 0);
        neededSpecialists5.put(Skills.PLUMBER, 0);
        neededSpecialists5.put(Skills.FITTER, 0);

        ArrayList<Brigade> brigades = new ArrayList<>(List.of(brigade1, brigade2, brigade3, brigade4));

        tender1 = new Tender(neededSpecialists1, brigades);
        tender2 = new Tender(neededSpecialists2, brigades);
        tender3 = new Tender(neededSpecialists3, brigades);
        tender4 = new Tender(neededSpecialists4, brigades);
        tender5 = new Tender(neededSpecialists5, brigades);
    }

    @Test
    public void validation() {
        Brigade expectedBrigade1 = tender1.validation(tender1);
        Brigade expectedBrigade2 = tender2.validation(tender2);
        Brigade expectedBrigade3 = tender3.validation(tender3);
        Brigade expectedBrigade4 = tender4.validation(tender4);

        Assert.assertEquals(expectedBrigade1, brigade2);
        Assert.assertEquals(expectedBrigade2, brigade1);
        Assert.assertEquals(expectedBrigade3, brigade3);
        Assert.assertEquals(expectedBrigade4, brigade4);
    }

    @Test(expected = SuitableBrigadesExeption.class)
    public void validationExeption() {
        System.out.println(tender5.validation(tender5));
    }
}