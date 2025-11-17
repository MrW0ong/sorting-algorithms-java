import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class QuickSort {
    private final Random random = new Random();
    private int comparisons;

    private enum Pivot {
        FIRST, LAST, RANDOM
    }

    public void sortFirst(List<Double> list) {
        long startTime = System.nanoTime();
        comparisons = 0;

        quickSort(list, 0, list.size() - 1, Pivot.FIRST);
    }

    private void quickSort(List<Double> list, int low, int high, Pivot pivot) {
        if (low < high) {
            int pivotIndex = partition(list, low, high, pivot);
        }
    }

    private int partition(List<Double> list, int low, int high, Pivot pivot) {
        int pivotIndex;
        switch (pivot) {
            case FIRST:
                pivotIndex = low;
                break;


        }
    }
}
