import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class InsertionSortMain {
    public static void main(String[] args) throws Exception {
        DataLoader loader = new DataLoader();

        String redPath = "src/main/resources/winequality-red.csv";
        String whitePath = "src/main/resources/winequality-white.csv";

        List<Double> redWine = loader.loadData(redPath);
        List<Double> whiteWine = loader.loadData(whitePath);

        Set<Double> uniqueValues = new LinkedHashSet<>();
        uniqueValues.addAll(redWine);
        uniqueValues.addAll(whiteWine);
        List<Double> allWines = new ArrayList<>(uniqueValues);

        System.out.println("n (unique alcohol values) = " + allWines.size());

        List<Double> shuffled = new ArrayList<>(allWines);
        Collections.shuffle(shuffled, new Random(42L));

        InsertionSort insertion = new InsertionSort();

        System.out.println("\n--- Insertion Sort on original order ---");
        insertion.sort(new ArrayList<>(allWines));

        System.out.println("\n--- Insertion Sort on shuffled order ---");
        insertion.sort(new ArrayList<>(shuffled));

        List<Double> groundTruth = new ArrayList<>(uniqueValues);
        Collections.sort(groundTruth);
        writeSortedCSV(groundTruth, "unique_alcohol_sorted.csv");
        System.out.println("Saved sorted unique alcohol values to unique_alcohol_sorted.csv");
    }

    private static void writeSortedCSV(List<Double> sorted, String outPath) {
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(outPath))) {
            bw.write("alcohol");
            bw.newLine();
            for (Double d : sorted) {
                bw.write(Double.toString(d));
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Failed to write CSV: " + e.getMessage());
        }
    }
}
