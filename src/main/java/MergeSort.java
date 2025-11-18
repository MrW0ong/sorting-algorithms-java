import java.util.List;
import java.util.ArrayList;

public class MergeSort {

    private long mergeOps;
    private long mergeComparisons;

    public void sort(List<Double> list) {
        mergeOps = 0;
        mergeComparisons = 0;

        long startTime = System.nanoTime();

        List<Double> sorted = mergeSort(new ArrayList<>(list));

        list.clear();
        list.addAll(sorted);

        long endTime = System.nanoTime();
        long ns = endTime - startTime;
        double ms = ns / 1_000_000.0;

        System.out.println("Merge Sort:");
        System.out.println("Sorted List: " + list);
        System.out.println("Merge operations (calls to merge): " + mergeOps);
        System.out.println("Merge comparisons (element comparisons inside merges): " + mergeComparisons);
        System.out.println("Time Taken: " + ms + " ms.");
    }

    private List<Double> mergeSort(List<Double> arr) {
        int n = arr.size();
        if (n <= 1) {
            return arr;
        }
        int mid = n / 2;
        List<Double> left = mergeSort(new ArrayList<>(arr.subList(0, mid)));
        List<Double> right = mergeSort(new ArrayList<>(arr.subList(mid, n)));
        return merge(left, right);
    }

    private List<Double> merge(List<Double> left, List<Double> right) {
        mergeOps++;
        List<Double> merged = new ArrayList<>(left.size() + right.size());
        int i = 0, j = 0;
        while (i < left.size() && j < right.size()) {
            mergeComparisons++;
            if (left.get(i) <= right.get(j)) {
                merged.add(left.get(i++));
            } else {
                merged.add(right.get(j++));
            }
        }
        while (i < left.size()) merged.add(left.get(i++));
        while (j < right.size()) merged.add(right.get(j++));
        return merged;

    }
}
