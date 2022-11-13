/**
 * Insertion Sort Algorithm == 0(n^2)
 *
 * Case 1: Random Order
 * Case 2: Sorted Order
 * Case 3: Reverse Sorted Order
 *
 * n == Sample Size
 *
 * @author TJ Bah & Ria Banerjee
 */

package com.insertionSort;

import java.util.Random;

public class Main {

    public static int[] insertionSort(int[] A){ // for small data sets [ < 1K ]

        // -----------------------------------------------------[ Declare VARs ]-------- //

        int n = A.length;
        int i;
        int current;

        for(int j=1; j < n; j++){
                current = A[j];
                      i = j-1;

            while(i >= 0 && A[i] > current){
                A[i+1] = A[i];
                     i = i-1;
            }
            A[i+1] = current;
        }
        return A;
    } ////////// [ insertionSort(int[] A) ** END ** ] ////////

    public static void main(String[] args) {

        ///////////////////// [ Sample SIZE - START ] ///////////

        int n = 100; // SAMPLE_SIZE_n_HERE
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

        insertionSort(rand_order);

        long endTimeMili_rand   = System.currentTimeMillis();
        long endTimeNano_rand   = System.nanoTime();
        long totalTimeMili_rand = endTimeMili_rand - startTimeMili_rand;
        long totalTimeNano_rand = endTimeNano_rand - startTimeNano_rand;

        //////////////////// [ Random Order Input Array: TEST 1 - END ] //////////////

        //////////////////// [ Already Sorted Input Array: TEST 1 - START ] //////////////

        long startTimeMili_sorted = System.currentTimeMillis();
        long startTimeNano_sorted = System.nanoTime();

        insertionSort(sorted_order);

        long endTimeMili_sorted   = System.currentTimeMillis();
        long endTimeNano_sorted   = System.nanoTime();
        long totalTimeMili_sorted = endTimeMili_sorted - startTimeMili_sorted;
        long totalTimeNano_sorted = endTimeNano_sorted - startTimeNano_sorted;

        //////////////////// [ Already Sorted Input Array: TEST 1 - END ] //////////////

        //////////////////// [ Reverse Sorted Input Array: TEST 1 - START ] //////////////

        long startTimeMili_rev_sorted = System.currentTimeMillis();
        long startTimeNano_rev_sorted = System.nanoTime();

        insertionSort(rev_sorted_order);

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