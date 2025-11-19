import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        DataLoader loader = new DataLoader();

        List<Double> redWine = loader.loadData("src/main/resources/winequality-red.csv");
        List<Double> whiteWine = loader.loadData("src/main/resources/winequality-white.csv");

        Set<Double> uniqueValues = new HashSet<>();
        uniqueValues.addAll(redWine);
        uniqueValues.addAll(whiteWine);
        List<Double> allWines = new ArrayList<>(uniqueValues);

        System.out.println("Unsorted List: " + "\n" + allWines);

        // Insertion sort
        System.out.println("\nUnique alcohol values = " + allWines.size());
        List<Double> shuffled = new ArrayList<>(allWines);
        Collections.shuffle(shuffled, new Random(42L));

        InsertionSort insertion = new InsertionSort();
        insertion.sort(new ArrayList<>(allWines));

        System.out.println("\n--- Insertion Sort on original order ---");
        insertion.sort(new ArrayList<>(allWines));
        System.out.println("\n--- Insertion Sort on shuffled order ---");
        insertion.sort(new ArrayList<>(shuffled));


        // Bubble sort
        BubbleSort bubble = new BubbleSort();
        System.out.println("\n--- Bubble Sort Unoptimized ---");
        bubble.sort(new ArrayList<>(allWines));
        System.out.println("\n--- Bubble Sort Optimized ---");
        bubble.sortOptimized(new ArrayList<>(allWines));

        // Quick sort
        QuickSort quick = new QuickSort();
        System.out.println("\n--- First element as pivot point ---");
        quick.sortFirst(new ArrayList<>(allWines));
        System.out.println("\n--- Last element as pivot point ---");
        quick.sortLast(new ArrayList<>(allWines));
        System.out.println("\n--- Random element as pivot point ---");
        quick.sortRandom(new ArrayList<>(allWines));

        // Merge sort
        MergeSort merge = new MergeSort();
        System.out.println("\n--- Merge Sort on original order ---");
        merge.sort(new ArrayList<>(allWines));
        System.out.println("\n--- Merge Sort on shuffled order ---");
        merge.sort(new ArrayList<>(shuffled));


        List<Double> groundTruth = new ArrayList<>(uniqueValues);
        Collections.sort(groundTruth);
        writeSortedCSV(groundTruth);
        System.out.println("Saved sorted unique alcohol values to unique_alcohol_sorted.csv");

    }

    private static void writeSortedCSV(List<Double> sorted)  {
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get("unique_alcohol_sorted.csv"))) {
            bw.write("alcohol");
            bw.newLine();
            for (Double d : sorted) {
                bw.write(Double.toString(d));
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}






