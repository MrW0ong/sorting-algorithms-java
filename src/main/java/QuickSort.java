import java.util.Collections;
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

        long endTime = System.nanoTime();
        long ns = endTime - startTime;
        double ms = (double) ns / 1000000.0;

        System.out.println("Quick Sort with first element: ");
        System.out.println("Sorted list : " + list);
        System.out.println("Comparison count: " + comparisons);
        System.out.println("Time Taken: " + ms + "ms.");
    }

    public void sortLast(List<Double> list) {
        long startTime = System.nanoTime();
        comparisons = 0;

        quickSort(list, 0, list.size() - 1, Pivot.LAST);

        long endTime = System.nanoTime();
        long ns = endTime - startTime;
        double ms = (double) ns / 1000000.0;

        System.out.println("Quick Sort with last element: ");
        System.out.println("Sorted list : " + list);
        System.out.println("Comparison count: " + comparisons);
        System.out.println("Time Taken: " + ms + "ms.");
    }

    public void sortRandom(List<Double> list) {
        long startTime = System.nanoTime();
        comparisons = 0;

        quickSort(list, 0, list.size() - 1, Pivot.RANDOM);

        long endTime = System.nanoTime();
        long ns = endTime - startTime;
        double ms = (double) ns / 1000000.0;

        System.out.println("Quick Sort with random element: ");
        System.out.println("Sorted list : " + list);
        System.out.println("Comparison count: " + comparisons);
        System.out.println("Time Taken: " + ms + "ms.");
    }

    private void quickSort(List<Double> list, int low, int high, Pivot pivot) {
        if (low < high) {
            int pivotIndex = partition(list, low, high, pivot);
            quickSort(list, low, pivotIndex - 1, pivot);
            quickSort(list, pivotIndex + 1, high, pivot);
        }
    }

    private int partition(List<Double> list, int low, int high, Pivot pivot) {
        int pivotIndex = switch (pivot) {
            case FIRST -> low;
            case LAST -> high;
            case RANDOM -> low + random.nextInt(high - low + 1);
        };

        double pivotValue = list.get(pivotIndex);
        Collections.swap(list, pivotIndex, high);

        int i = low;
        for (int j = low; j < high; j++) {
            comparisons++;
            if (list.get(j) <= pivotValue) {
                Collections.swap(list, i, j);
                i++;
            }
        }
        Collections.swap(list, i, high);
        return i;
    }

    private void swap(List<Double> list, int i, int j) {
        if (i == j) {
            return;
        }
        double temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
