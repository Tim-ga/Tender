package TenderTests;

import TenderBody.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.EnumSet;

public class BrigadeTest {
    Brigade brigade;

    @Before
    public void initialization() {
        ArrayList<Employee> employeesBrigade = new ArrayList<>();
        brigade = new Brigade(employeesBrigade);
        employeesBrigade.add(new Employee(EnumSet.of(Skills.ARCHITECT), new BigDecimal("1000")));
        employeesBrigade.add(new Employee(EnumSet.of(Skills.BRICKLAYER), new BigDecimal("500")));
        employeesBrigade.add(new Employee(EnumSet.of(Skills.BRICKLAYER), new BigDecimal("500")));
        employeesBrigade.add(new Employee(EnumSet.of(Skills.ELECTRICIAN), new BigDecimal("300")));
    }

    @Test
    public void getBrigadeFullCost() {
        BigDecimal expectedBrigadeFullCost = Brigade.getBrigadeFullCost(brigade);
        BigDecimal actualBrigadeFullCost = new BigDecimal("2300");

        Assert.assertTrue(expectedBrigadeFullCost.equals(actualBrigadeFullCost));
    }

    @Test
    public void getCountOfSpecialists() {
        int expected1 = Brigade.getCountOfSpecialists(brigade, Skills.BRICKLAYER);
        int expected2 = Brigade.getCountOfSpecialists(brigade, Skills.PLUMBER);

        int actual1 = 2;
        int actual2 = 0;

        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
    }
}