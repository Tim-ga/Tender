package TenderBody;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class Tender {
    private Map<Skills, Integer> neededSpecialists;
    private ArrayList<Brigade> brigades;
    private ArrayList<Brigade> brigadesPassed = new ArrayList<>();

    public Tender(Map<Skills, Integer> neededSpecialists, ArrayList<Brigade> brigades) {
        this.neededSpecialists = neededSpecialists;
        this.brigades = brigades;
    }

    public Map<Skills, Integer> getNeededSpecialists() {
        return neededSpecialists;
    }

    public void setNeededSpecialists(Map<Skills, Integer> neededSpecialists) {
        this.neededSpecialists = neededSpecialists;
    }

    public ArrayList<Brigade> getBrigades() {
        return brigades;
    }

    public void setBrigades(ArrayList<Brigade> brigades) {
        this.brigades = brigades;
    }

    public ArrayList<Brigade> getBrigadesPassed() {
        return brigadesPassed;
    }

    public void setBrigadesPassed(ArrayList<Brigade> brigadesPassed) {
        this.brigadesPassed = brigadesPassed;
    }

    public Brigade validation(Tender tender) {

        for (int i = 0; i < brigades.size(); i++) {
            Brigade checkedBrigade = tender.brigades.get(i);
            tender.checkBrigade(checkedBrigade, tender);
        }
        Brigade winnerBrigade = tender.selectionLowestPrice(brigadesPassed);
        brigadesPassed.clear();
        return winnerBrigade;
    }

    private void checkBrigade(Brigade checkedBrigade, Tender tender) {
        int discrepancy = 0;

        for (int j = 0; j < Skills.values().length; j++) {
            for (Skills skills : Skills.values()) {
                if (Brigade.getCountOfSpecialists(checkedBrigade, skills) < tender.getNeededSpecialists().get(skills)) {
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
            BigDecimal minFullCostBrigade = Brigade.getBrigadeFullCost(brigadesPassed.get(0));

            for (int i = 0; i < brigadesPassed.size(); i++) {
                minFullCostBrigade = Brigade.getBrigadeFullCost(brigadesPassed.get(i)).min(minFullCostBrigade);
                if (Brigade.getBrigadeFullCost(brigadesPassed.get(i)).equals(minFullCostBrigade)) {
                    winnerBrigade = brigadesPassed.get(i);
                }
            }
        }
        return winnerBrigade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tender tender = (Tender) o;
        return Objects.equals(neededSpecialists, tender.neededSpecialists) && Objects.equals(brigades, tender.brigades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(neededSpecialists, brigades);
    }

    @Override
    public String toString() {
        return "Tender{" +
                "neededSpecialists=" + neededSpecialists +
                ", brigades=" + brigades +
                '}';
    }
}

