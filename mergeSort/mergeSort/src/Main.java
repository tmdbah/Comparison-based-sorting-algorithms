/**
 * Merge Sort Algorithm == O(n log n)
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
    static void merge(int A[], int start, int midpoint, int end){

        // -----------------------------------------------------[ Declare VARs ]-------- //

        int l_arr_index, r_arr_index, merged_arr_index;

        // Divide

        int seqA = midpoint - start + 1;
        int seqB = end - midpoint;

        // create new temp arrays

        int leftArr[] = new int[seqA];
        int rightArr[] = new int[seqB];

        // Copy Data from input Array A to temp Array's

        for (l_arr_index = 0; l_arr_index < seqA; l_arr_index++) {
            leftArr[l_arr_index] = A[start + l_arr_index];
        }

        for (r_arr_index = 0; r_arr_index < seqB; r_arr_index++) {
            rightArr[r_arr_index] = A[midpoint + 1 + r_arr_index];
        }

        // Set initial index for sub_arrays

        l_arr_index = 0;
        r_arr_index = 0;
        merged_arr_index = start;

        // While sub arrays seqA and seqB are not Empty

        while(l_arr_index < seqA && r_arr_index < seqB){

            if (leftArr[l_arr_index] <= rightArr[r_arr_index]) {
                A[merged_arr_index] = leftArr[l_arr_index];
                l_arr_index++;
            } else {
                A[merged_arr_index] = rightArr[r_arr_index];
                r_arr_index++;
            }
            merged_arr_index++;
        }

        // while sub array seqA is not Empty, add remaining elements

        while(l_arr_index < seqA){
            A[merged_arr_index] = leftArr[l_arr_index];
            l_arr_index++;
            merged_arr_index++;
        }

        // while sub array seqB is not Empty, add remaining elements

        while(r_arr_index < seqB){
            A[merged_arr_index] = rightArr[r_arr_index];
            r_arr_index++;
            merged_arr_index++;
        }
    }

    static void mergeSort(int A[], int start, int end) { // for huge data sets [ > 1M ]
        if(start < end){ // if(p < r)
            int midpoint = (start + end) / 2; // q = ⌊(p + r)/2⌋
            mergeSort(A, start, midpoint); // mergeSort(A, p, q)
            mergeSort(A, midpoint + 1, end); // // mergeSort(A, q + 1, r)
            merge(A, start, midpoint, end); // merge(A, p, q, r)
        }
    } ////////// [ mergeSort(int A[], int start, int end) ** END ** ] ////////

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

        // Populate random and sorted order Array
        for (int i = 0; i < n; i++) {

            // Generate random integers in range 0 to n
            int rand_n = rand.nextInt(n);

            rand_order[i] = rand_n; // Ranging 0 to n
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

       // mergeSort(rand_order,0,n-1);

        long endTimeMili_rand   = System.currentTimeMillis();
        long endTimeNano_rand   = System.nanoTime();
        long totalTimeMili_rand = endTimeMili_rand - startTimeMili_rand;
        long totalTimeNano_rand = endTimeNano_rand - startTimeNano_rand;

        //////////////////// [ Random Order Input Array: TEST 1 - END ] //////////////

        //////////////////// [ Already Sorted Input Array: TEST 1 - START ] //////////////

        long startTimeMili_sorted = System.currentTimeMillis();
        long startTimeNano_sorted = System.nanoTime();

        // mergeSort(sorted_order,0,n-1);

        long endTimeMili_sorted   = System.currentTimeMillis();
        long endTimeNano_sorted   = System.nanoTime();
        long totalTimeMili_sorted = endTimeMili_sorted - startTimeMili_sorted;
        long totalTimeNano_sorted = endTimeNano_sorted - startTimeNano_sorted;

        //////////////////// [ Already Sorted Input Array: TEST 1 - END ] //////////////

        //////////////////// [ Reverse Sorted Input Array: TEST 1 - START ] //////////////

        long startTimeMili_rev_sorted = System.currentTimeMillis();
        long startTimeNano_rev_sorted = System.nanoTime();

        mergeSort(rev_sorted_order, 0,n-1);

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