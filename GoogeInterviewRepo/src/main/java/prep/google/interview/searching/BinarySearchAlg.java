package prep.google.interview.searching;

public class BinarySearchAlg {

    // Returns index of x if it is present in arr[].

    /**
     * Binary search is a search algorithm used to find the position of a target value within a sorted array.
     * It works by repeatedly dividing the search interval in half until the target value is found or the interval is empty.
     * The search interval is halved by comparing the target element with the middle value of the search space.
     *
     * Conditions to apply Binary Search Algorithm in a Data Structure:
     * To apply Binary Search algorithm:
     *
     * The data structure must be sorted.
     * Access to any element of the data structure should take constant time.
     * @param arr
     * @param x
     * @return
     */
    int binarySearch(int arr[], int x)
    {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if x is present at mid
            if (arr[mid] == x)
                return mid;

            // If x greater, ignore left half
            if (arr[mid] < x)
                low = mid + 1;

                // If x is smaller, ignore right half
            else
                high = mid - 1;
        }

        // If we reach here, then element was
        // not present
        return -1;
    }

    // Driver code
    public static void main(String args[])
    {
        BinarySearchAlg ob = new BinarySearchAlg();
        int arr[] = { 2, 3, 4, 10, 40 };
        int n = arr.length;
        int x = 10;
        int result = ob.binarySearch(arr, x);
        if (result == -1)
            System.out.println(
                    "Element is not present in array");
        else
            System.out.println("Element is present at "
                    + "index " + result);
    }
}
