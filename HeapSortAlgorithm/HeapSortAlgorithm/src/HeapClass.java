import java.util.Random;

public class HeapClass {
    public void heapBuilder(){
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

        long startTimeMili_rand = System.currentTimeMillis();
        long startTimeNano_rand = System.nanoTime();
        heapSort(rand_order);
        long endTimeMili_rand   = System.currentTimeMillis();
        long endTimeNano_rand   = System.nanoTime();
        long totalTimeMili_rand = endTimeMili_rand - startTimeMili_rand;
        long totalTimeNano_rand = endTimeNano_rand - startTimeNano_rand;
        //////////////////// [ Random Order Input Array: TEST 1 - END ] //////////////

        //////////////////// [ Already Sorted Input Array: TEST 1 - START ] //////////////

        long startTimeMili_sorted = System.currentTimeMillis();
        long startTimeNano_sorted = System.nanoTime();
        heapSort(sorted_order);
        long endTimeMili_sorted   = System.currentTimeMillis();
        long endTimeNano_sorted   = System.nanoTime();
        long totalTimeMili_sorted = endTimeMili_sorted - startTimeMili_sorted;
        long totalTimeNano_sorted = endTimeNano_sorted - startTimeNano_sorted;
        //////////////////// [ Already Sorted Input Array: TEST 1 - END ] //////////////

        //////////////////// [ Reverse Sorted Input Array: TEST 1 - START ] //////////////

        long startTimeMili_rev_sorted = System.currentTimeMillis();
        long startTimeNano_rev_sorted = System.nanoTime();
        heapSort(rev_sorted_order);
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
    public void heapSort(int arr[]){
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
//        printArray(arr);
    }
    void heapify(int arr[], int n, int i)
    {
        int largest = i;  // Initialize largest as root
        int l = 2*i + 1;  // left = 2*i + 1
        int r = 2*i + 2;  // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);

        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    // Driver program
//    public static void main(String args[])
//    {
//        int arr[] = {12, 11, 13, 5, 6, 7};
//        int n = arr.length;
//
//        HeapSort ob = new HeapSort();
//        ob.sort(arr);
//
//        System.out.println("Sorted array is");
//        printArray(arr);
//    }
}


