import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.EnumSet;

import static org.junit.Assert.*;

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
    public void getNumberOfSpecialists() {
        int[] expectedArray = Brigade.getNumberOfSpecialists(brigade);
        int[] actualArray = new int[]{1, 2, 1, 0, 0, 0};

        Assert.assertArrayEquals(expectedArray, actualArray);
    }
}