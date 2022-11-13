/**
 * In Place Quick Sort Algorithm == O(n log n)
 *
 * Case 1: Random Order
 * Case 2: Sorted Order
 * Case 3: Reverse Sorted Order
 *
 * n == Sample Size
 *
 * @author TJ Bah & Ria Banerjee
 */

import java.util.Random;

public class Main {
    public static int[] quickSort(int A[]){
        quickSort(A, 0, A.length - 1);

        return A;
    }

    /*
     * The partition Method will use the last element as pivot,then partitions the array around the pivot
     * (smaller elements to the left of the pivot and larger to the right).
     * It places the pivot value where it belongs and finally returns the index of the pivots last position.
     */

    static int partition(int A[], int left, int right){

        // -----------------------------------------------------[ Declare VARs ]-------- //

        int n = A.length;

        // create instance of Random class
        Random rand = new Random();

        // Generate random integers in range 0 to n
        int rand_n = rand.nextInt(n);

        int pivot = A[rand_n]; // Use rand_n as Pivot Element Chose Randomly | Takes more time than using right or left as pivot on small input sizes for Special Cases ( Already or Reversely Sorted Input )
        // Random Pivot performs better on large inputs

        int i = left - 1;

        /*
         * int i keeps track of the "Tail" of elements less than pivot section
         *
         * We will place the pivot between the less than and greater than sections
         *
         * int j scans from array from left to right - 1 to check if the values are greater than or less than pivot
         *
         */

        for (int j = left; j < right ; j++) {

            // if the current element is smaller than the pivot

            if(A[j] < pivot){
                i++; // increment "Tail"
                swapElements(A, i, j);
            }
        }

        swapElements(A, i + 1, right);

        return i + 1; // returns the index of the pivots last position
    }

    /*
     * Method to Implement quickSort
     * int A[] = Array to be sorted
     * left = Starting index
     * right = ending index
     */

    static void quickSort(int A[], int left, int right){

        if(left < right){
            int pivotsLastPosition = partition(A, left, right); // Find Position of Pivot | index of partition

            // call left and right subarray to the pivot, recursively
            quickSort(A, left, pivotsLastPosition - 1);
            quickSort(A, pivotsLastPosition + 1, right);
        }

    }

    // Helper method used to swap elements @ two diff array indices

    static void swapElements(int swap[], int A, int B){

        // -----------------------------------------------------[ Declare VARs ]-------- //
        int temp = swap[A];

        swap[A] = swap[B];
        swap[B] = temp;
    }

    public static void main(String[] args) {

        ///////////////////// [ Sample SIZE - START ] ///////////

        int n = 1000000; // SAMPLE_SIZE_n_HERE
        // Small: 1K 2K 4K 5K | Medium: 10K 20K 40K 50K | Large: 60K 80K 100K 1M | Extra Large: 2M 5M 10M 50M


        // Create Array of sample size n
        int[] rand_order = new int[n];
        int[] sorted_order = new int[n];
        int[] rev_sorted_order = new int[n];

        // create instance of Random class
        Random rand = new Random(5);

        // Populate random (Unique Random Input) and sorted order Array
        for (int i = 0; i < n; i++) {

            // Generate random integers in range 0 to n
            int rand_n = rand.nextInt(n);

            rand_order[i] = rand_n; // (Unique Random Input) Ranging 0 to n
            sorted_order[i] = i; // Sorted Order Input 0 to n-1

        }

        // Populate reverse sorted array
        for (int j = 0; j < n; j++) {
            for (int i = n-1; i >0; i--) {
                rev_sorted_order[j++] = i; // Reversely Sorted Order Input n-1 to 0
            }
        }

        ///////////////////// [ Sample SIZE - END ] ///////////

        //////////////////// [ Random Order Input Array: TEST 1 - START ] //////////////

        long startTimeMili_rand = System.currentTimeMillis();
        long startTimeNano_rand = System.nanoTime();

       // quickSort(rand_order, 0, rand_order.length-1);

        long endTimeMili_rand   = System.currentTimeMillis();
        long endTimeNano_rand   = System.nanoTime();
        long totalTimeMili_rand = endTimeMili_rand - startTimeMili_rand;
        long totalTimeNano_rand = endTimeNano_rand - startTimeNano_rand;

        //////////////////// [ Random Order Input Array: TEST 1 - END ] //////////////

        //////////////////// [ Already Sorted Input Array: TEST 1 - START ] //////////////

        long startTimeMili_sorted = System.currentTimeMillis();
        long startTimeNano_sorted = System.nanoTime();

        // quickSort(sorted_order, 0, sorted_order.length-1);

        long endTimeMili_sorted   = System.currentTimeMillis();
        long endTimeNano_sorted   = System.nanoTime();
        long totalTimeMili_sorted = endTimeMili_sorted - startTimeMili_sorted;
        long totalTimeNano_sorted = endTimeNano_sorted - startTimeNano_sorted;

        //////////////////// [ Already Sorted Input Array: TEST 1 - END ] //////////////

        //////////////////// [ Reverse Sorted Input Array: TEST 1 - START ] //////////////

        long startTimeMili_rev_sorted = System.currentTimeMillis();
        long startTimeNano_rev_sorted = System.nanoTime();

        quickSort(rev_sorted_order, 0, rev_sorted_order.length-1);

        long endTimeMili_rev_sorted   = System.currentTimeMillis();
        long endTimeNano_rev_sorted   = System.nanoTime();
        long totalTimeMili_rev_sorted = endTimeMili_rev_sorted - startTimeMili_rev_sorted;
        long totalTimeNano_rev_sorted = endTimeNano_rev_sorted - startTimeNano_rev_sorted;

        //////////////////// [ Reverse Sorted Input Array: TEST 1 - END ] //////////////

        System.out.println("");
        System.out.println("n = " + n);
        System.out.println("");
        System.out.println("Random Order Input Array:");
        System.out.println("");
        System.out.println("Execution time in milliseconds : " + totalTimeMili_rand);
        System.out.println("Execution time in nanoseconds  : " + totalTimeNano_rand);
        System.out.println("");
        System.out.println("------------------------------------------");
        System.out.println("");
        System.out.println("n = " + n);
        System.out.println("");
        System.out.println("Already Sorted Input Array: ");
        System.out.println("");
        System.out.println("Execution time in milliseconds : " + totalTimeMili_sorted);
        System.out.println("Execution time in nanoseconds  : " + totalTimeNano_sorted);
        System.out.println("");
        System.out.println("------------------------------------------");
        System.out.println("");
        System.out.println("n = " + n);
        System.out.println("");
        System.out.println("Reversely Sorted Input Array: ");
        System.out.println("");
        System.out.println("Execution time in milliseconds : " + totalTimeMili_rev_sorted);
        System.out.println("Execution time in nanoseconds  : " + totalTimeNano_rev_sorted);
        System.out.println("");
        System.out.println("------------------------------------------");


    }
}