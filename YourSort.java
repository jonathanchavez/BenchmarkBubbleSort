interface SortInterface {
    void recursiveSort(int[] list);
    void iterativeSort(int[] list);
    int getCount();
    long getTime();



}




public class YourSort implements SortInterface {

    int count = 0;
    long totalTime = 0;
    YourSort(){
    }


    //recursive version of bubble sort
    @Override
    public void recursiveSort(int[] list) {
        count = 0;
        totalTime = 0;

        long start = System.nanoTime();
        bubbleSort(list, list.length);
        long end = System.nanoTime();

        totalTime = end - start;

        try {
            isSorted(list);
        }
        catch (UnsortedException ex){
            System.out.println(ex.getMessage());
        }

    }


    //iterative version of bubble sort
    @Override
    public void iterativeSort(int[] list) {
        count = 0;
        totalTime = 0;

        long startTime = System.nanoTime();
        for (int k = 0; k < list.length - 1; k++)
        {
            // last k items are already sorted, so inner loop can
            // avoid looking at the last k items
            for (int i = 0; i < list.length - 1 - k; i++) {
                if (list[i] > list[i + 1]) {
                    count++;
                    swap(list, i, i + 1);
                }
            }
        }

        long stopTime = System.nanoTime();
        totalTime = stopTime - startTime;
        try {
            isSorted(list);
        }
        catch (UnsortedException ex){
            System.out.println(ex.getMessage());
        }


    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public long getTime() {
        return totalTime;
    }

    void bubbleSort(int arr[], int n)
    {
        // Base case
        if (n == 1)
            return;

        for (int i=0; i<n-1; i++)
            if (arr[i] > arr[i+1])
            {
                count++;
                // swap arr[i], arr[i+1]
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }

        // Largest element is fixed
        bubbleSort(arr, n-1);
    }

    // Utility function to swap values at two indices in the array
    public static void swap(int arr[], int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public boolean isSorted(int[] arr) throws UnsortedException{
        for (int i = 1; i < arr.length; i++)

            // Unsorted pair found, throws expception
            if (arr[i - 1] > arr[i])
                throw new UnsortedException("This array is unsorted.");

        // No unsorted pair found
        return true;
    }




}


