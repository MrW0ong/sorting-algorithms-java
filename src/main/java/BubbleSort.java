import java.util.List;

public class BubbleSort {

    public void sort(List<Double> list) {


        long startTime = System.nanoTime();
        int comparisons = 0;

        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++ ) {

                comparisons++;

                if (list.get(j) > list.get(j + 1)) {

                    double temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
        long endTime = System.nanoTime();

        long ns = endTime - startTime;
        double ms =  ns / 1000000.0;

        System.out.println("Unoptimized Bubble Sort:");
        System.out.println("Sorted List: " + list);
        System.out.println("Comparison Count: " + comparisons);

        System.out.println("Time Taken: " + ms + "ms.");
    }

    public void sortOptimized(List<Double> list) {
        long startTime = System.nanoTime();
        int comparisons = 0;

        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++ ) {

                comparisons++;

                if (list.get(j) > list.get(j + 1)) {

                    double temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    swapped = true;
                }

            } if (!swapped)  { break; }
        }
        long endTime = System.nanoTime();

        long ns = endTime - startTime;
        double ms =  ns / 1000000.0;

        System.out.println("Optimized Bubble Sort:");
        System.out.println("Sorted List: " + list);
        System.out.println("Comparison Count: " + comparisons);

        System.out.println("Time Taken: " + ms + "ms.");


    }



}
