import java.util.ArrayList;
import java.util.Objects;

public class Tender {
    private ArrayList<Brigade> brigades;
    ArrayList<Brigade> brigadesPassed = new ArrayList<>();

    public Tender(ArrayList<Brigade> brigades) {
        this.brigades = brigades;
    }

    public ArrayList<Brigade> getBrigades() {
        return brigades;
    }

    public void setBrigades(ArrayList<Brigade> brigades) {
        this.brigades = brigades;
    }

    public int[] conductingATender(int numberOfArchitect, int numberOfBricklayer, int numberOfElectrician,
                                   int numberOfWelder, int numberOfPlumber, int numberOfFitter) {
        int[] requiredNumberOfSpecialists = new int[]{numberOfArchitect, numberOfBricklayer, numberOfElectrician, numberOfWelder, numberOfPlumber, numberOfFitter};
        return requiredNumberOfSpecialists;
    }

    public void validation(int numberOfArchitect, int numberOfBricklayer, int numberOfElectrician,
                           int numberOfWelder, int numberOfPlumber, int numberOfFitter, Tender tender) {
        int[] neededArray = tender.conductingATender(numberOfArchitect, numberOfBricklayer, numberOfElectrician, numberOfWelder, numberOfPlumber, numberOfFitter);
        ArrayList<Brigade> brigades = tender.getBrigades();


        for (int i = 0; i < brigades.size(); i++) {
            tender.validation2(Brigade.getNumberOfSpecialists(brigades.get(i)), neededArray, brigades);
        }

        System.out.println(brigadesPassed);
    }


    public void validation2(int[] checkedArray, int[] neededArray, ArrayList<Brigade> brigades) {

        for (int j = 0; j < neededArray.length; j++) {
            if (checkedArray[j] < neededArray[j]) {
                break;
            } else {
                brigadesPassed.add(brigades.get(j));
                break;
            }
        }
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

