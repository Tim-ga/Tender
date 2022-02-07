import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class TenderTest {

    Tender tender;
    Brigade brigade1;
    Brigade brigade2;
    Brigade brigade3;
    Brigade brigade4;

    @Before
    public void initialization() {
        ArrayList<Employee> employeesBrigade1 = new ArrayList<>(); //full cost brigade 8600
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

        ArrayList<Employee> employeesBrigade4 = new ArrayList<>(); //full cost brigade 8400
        brigade4 = new Brigade(employeesBrigade4);
        employeesBrigade4.add(new Employee(EnumSet.of(Skills.ARCHITECT), new BigDecimal("2100")));
        employeesBrigade4.add(new Employee(EnumSet.of(Skills.BRICKLAYER), new BigDecimal("800")));
        employeesBrigade4.add(new Employee(EnumSet.of(Skills.ELECTRICIAN, Skills.BRICKLAYER), new BigDecimal("1200")));
        employeesBrigade4.add(new Employee(EnumSet.of(Skills.BRICKLAYER), new BigDecimal("800")));
        employeesBrigade4.add(new Employee(EnumSet.of(Skills.WELDER), new BigDecimal("750")));
        employeesBrigade4.add(new Employee(EnumSet.of(Skills.PLUMBER), new BigDecimal("800")));
        employeesBrigade4.add(new Employee(EnumSet.of(Skills.PLUMBER, Skills.WELDER), new BigDecimal("1200")));

        tender = new Tender(new ArrayList<>(List.of(brigade1, brigade2, brigade3, brigade4)));
    }

    @Test
    public void validation() {
        Brigade expectedBrigade1 = tender.validation(1, 1, 3, 1, 2, 1, tender);
        Brigade expectedBrigade2 = tender.validation(2, 1, 1, 1, 2, 1, tender);
        Brigade expectedBrigade3 = tender.validation(1, 1, 1, 1, 1, 0, tender);
        Brigade expectedBrigade4 = tender.validation(1, 3, 1, 1, 2, 0, tender);

        Assert.assertEquals(expectedBrigade1, brigade2);
        Assert.assertEquals(expectedBrigade2, brigade1);
        Assert.assertEquals(expectedBrigade3, brigade3);
        Assert.assertEquals(expectedBrigade4, brigade4);
    }

    @Test(expected = SuitableBrigadesExeption.class)
    public void validationExeption() {
        tender.validation(1, 10, 1, 1, 1, 1, tender);
    }
}