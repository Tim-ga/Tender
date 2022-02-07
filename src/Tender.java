import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Objects;

public class Tender {
    private ArrayList<Brigade> brigades;
    private ArrayList<Brigade> brigadesPassed = new ArrayList<>();

    public Tender(ArrayList<Brigade> brigades) {
        this.brigades = brigades;
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

    public Brigade validation(int numberOfArchitect, int numberOfBricklayer, int numberOfElectrician,
                              int numberOfWelder, int numberOfPlumber, int numberOfFitter, Tender tender) {

        int[] neededArray = new int[]{numberOfArchitect, numberOfBricklayer, numberOfElectrician, numberOfWelder, numberOfPlumber, numberOfFitter};
        ArrayList<Brigade> brigades = tender.getBrigades();

        for (int numberBrigade = 0; numberBrigade < brigades.size(); numberBrigade++) {
            int[] checkedArray = Brigade.getNumberOfSpecialists(brigades.get(numberBrigade));
            tender.checkArray(checkedArray, neededArray, numberBrigade);
        }

        Brigade winnerBrigade = tender.selectionLowestPrice(brigadesPassed);
        brigadesPassed.clear();
        return winnerBrigade;
    }

    private void checkArray(int[] checkedArray, int[] neededArray, int numberBrigade) {
        int discrepancy = 0;

        for (int j = 0; j < neededArray.length; j++) {
            if (checkedArray[j] < neededArray[j]) {
                discrepancy++;
            }
        }
        if (discrepancy == 0) {
            brigadesPassed.add(brigades.get(numberBrigade));
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
        return Objects.equals(brigades, tender.brigades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brigades);
    }

    @Override
    public String toString() {
        return "Tender{" +
                "brigades=" + brigades +
                '}';
    }
}

