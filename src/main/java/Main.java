import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Updated code
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        DataLoader loader = new DataLoader();

        // Load CSV both files
        List<Double> redWine = loader.loadData("src/main/resources/winequality-red.csv");
        List<Double> whiteWine = loader.loadData("src/main/resources/winequality-white.csv");

        // Combine the CSV files
        Set<Double> uniqueValues = new HashSet<>();
        uniqueValues.addAll(redWine);
        uniqueValues.addAll(whiteWine);
        List<Double> allWines = new ArrayList<>(uniqueValues);


        System.out.println("Unsorted List: " + allWines);

        BubbleSort sorter = new BubbleSort();
        sorter.sort(new ArrayList<>(allWines));

    }
}






