import java.util.List;

public class BubbleSort {

    public void sort(List<Double> list) {


        long startTime = System.nanoTime(); // Start timer, we're using nanoTime for the most accurate time results
        int comparisons = 0; // Comparison counter

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
        long endTime = System.nanoTime(); // Stop timer

        long ns = endTime - startTime;
        double ms =  ns / 10000000.0;

        System.out.println("Unoptimized Bubble Sort:");
        System.out.println("Sorted List: " + list);
        System.out.println("Comparison Count: " + comparisons);

        System.out.println("Time Taken: " + ms + "ms.");
    }



}
    /*  Explanation of Bubble Sort Algorithm
    Bubble Sort is a sorting algorithm where the lower value elements should be on the left side of the array,
    while the higher value elements should end up on the right side of the array.
    The algorithm always compares a number with the number on the right side of it.
    If the number on the left side is higher than the right side, then they swap places. If not, then nothing changes. And the algorithm move on to the next values.
    This process is repeated until the whole array is sorted in ascending order.
    */