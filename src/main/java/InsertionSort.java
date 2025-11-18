import java.util.List;
import java.util.ArrayList;

public class InsertionSort {
    public void sort(List<Double> list) {
        long startTime = System.nanoTime();

        long comparisons = 0;
        long shifts = 0;

        ArrayList<Double> a = new ArrayList<>(list);
        int n = a.size();

        for (int i = 1; i < n; i++) {
            Double key = a.get(i);
            int j = i - 1;
            while (j >= 0) {
                comparisons++;
                if (a.get(j) > key) {
                    a.set(j + 1, a.get(j));
                    shifts++;
                    j--;
                } else {
                    break;
                }
            }
            a.set(j + 1, key);
        }

        list.clear();
        list.addAll(a);

        long endTime = System.nanoTime();
        long ns = endTime - startTime;
        double ms = ns / 1_000_000.0;

        System.out.println("Insertion Sort:");
        System.out.println("Sorted List: " + list);
        System.out.println("Comparison Count: " + comparisons);
        System.out.println("Time Taken: " + ms + " ms.");
    }
}
