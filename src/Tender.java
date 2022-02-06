import java.util.ArrayList;
import java.util.Objects;

public class Tender {
    private ArrayList<Brigade> brigades;
    ArrayList<Brigade> brigadesPassed1 = new ArrayList<>();

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



            tender.validation2(neededArray);


    }


    public void validation2(int[] neededArray) {
        int i = 0;
        int[] checkedArray = Brigade.getNumberOfSpecialists(brigades.get(1));

        for (int j = 0; j < neededArray.length; j++) {
            if (checkedArray[j] < neededArray[j]) {
                i++;
            }
        }
            if (i == 0) {
                brigadesPassed1.add(brigades.get(1));
            }
        System.out.println(i);
        System.out.println(brigadesPassed1);
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

