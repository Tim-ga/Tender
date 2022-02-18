package TenderBody;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class Tender {
    private Map<Skills, Integer> neededSpecialists;
    private ArrayList<Brigade> tenderBrigades;
    private ArrayList<Brigade> brigadesPassed = new ArrayList<>();

    public Tender() {
    }

    public Map<Skills, Integer> getNeededSpecialists() {
        return neededSpecialists;
    }

    public void setNeededSpecialists(Map<Skills, Integer> neededSpecialists) {
        this.neededSpecialists = neededSpecialists;
    }

    public ArrayList<Brigade> getTenderBrigades() {
        return tenderBrigades;
    }

    public void setTenderBrigades(ArrayList<Brigade> tenderBrigades) {
        this.tenderBrigades = tenderBrigades;
    }

    public ArrayList<Brigade> getBrigadesPassed() {
        return brigadesPassed;
    }

    public void setBrigadesPassed(ArrayList<Brigade> brigadesPassed) {
        this.brigadesPassed = brigadesPassed;
    }

    public Brigade validation(Map<Skills, Integer> neededSpecialists, ArrayList<Brigade> tenderBrigades) {

        for (int i = 0; i < tenderBrigades.size(); i++) {
            Brigade checkedBrigade = tenderBrigades.get(i);
            checkBrigade(checkedBrigade, neededSpecialists);
        }
        Brigade winnerBrigade = selectionLowestPrice(brigadesPassed);
        brigadesPassed.clear();
        return winnerBrigade;
    }

    private void checkBrigade(Brigade checkedBrigade, Map<Skills, Integer> neededSpecialists) {
        int discrepancy = 0;

        for (int j = 0; j < Skills.values().length; j++) {
            for (Skills skills : Skills.values()) {
                if (getCountOfSpecialists(checkedBrigade, skills) < neededSpecialists.get(skills)) {
                    discrepancy++;
                }
            }
        }
        if (discrepancy == 0) {
            brigadesPassed.add(checkedBrigade);
        }
    }

    private Brigade selectionLowestPrice(ArrayList<Brigade> brigadesPassed) throws SuitableBrigadesExeption{
        Brigade winnerBrigade = new Brigade(null);

        if (brigadesPassed.size() == 0) {
            throw new SuitableBrigadesExeption("Нет подходящих бригад. Проект строительства закрыт!");
        }
        if (brigadesPassed.size() == 1) {
            winnerBrigade = brigadesPassed.get(0);
        }
        if (brigadesPassed.size() > 1) {
            BigDecimal minFullCostBrigade = getBrigadeFullCost(brigadesPassed.get(0));

            for (int i = 0; i < brigadesPassed.size(); i++) {
                minFullCostBrigade = getBrigadeFullCost(brigadesPassed.get(i)).min(minFullCostBrigade);
                if (getBrigadeFullCost(brigadesPassed.get(i)).equals(minFullCostBrigade)) {
                    winnerBrigade = brigadesPassed.get(i);
                }
            }
        }
        return winnerBrigade;
    }

    private BigDecimal getBrigadeFullCost(Brigade brigade) {
        BigDecimal sum = BigDecimal.ZERO;

        for (Employee employee : brigade.getEmployees()) {
            sum = sum.add(employee.getFinancialOffer());
        }
        return sum;
    }

    private int getCountOfSpecialists(Brigade brigade, Skills skill) {
        int countOfSpecialists = 0;

        for (Employee employee : brigade.getEmployees()) {
            countOfSpecialists += Collections.frequency(employee.getSkills(), skill);
        }
        return countOfSpecialists;
    }

    @Override
    public String toString() {
        return "Tender{}";
    }
}

