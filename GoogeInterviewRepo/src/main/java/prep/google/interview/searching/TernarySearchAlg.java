package prep.google.interview.searching;

public class TernarySearchAlg {

    // Function to perform Ternary Search

    /**
     * ernary search is a search algorithm that is used to find the position of a
     * target value within a sorted array. It operates on the principle of dividing the array
     * into three parts instead of two, as in binary search. The basic idea is to narrow down
     * the search space by comparing the target value with elements at two points that divide the array into three equal parts.
     *
     * mid1 = l + (r-l)/3
     * mid2 = r – (r-l)/3
     * When to use Ternary Search:
     * When you have a large ordered array or list and need to find the position of a specific value.
     * When you need to find the maximum or minimum value of a function.
     * When you need to find bitonic point in a bitonic sequence.
     * When you have to evaluate a quadratic expression
     * Working of Ter
     * @param l
     * @param r
     * @param key
     * @param ar
     * @return
     */
    static int ternarySearch(int l, int r, int key, int ar[])
    {
        if (r >= l) {

            // Find the mid1 and mid2
            int mid1 = l + (r - l) / 3;
            int mid2 = r - (r - l) / 3;

            // Check if key is present at any mid
            if (ar[mid1] == key) {
                return mid1;
            }
            if (ar[mid2] == key) {
                return mid2;
            }

            // Since key is not present at mid,
            // check in which region it is present
            // then repeat the Search operation
            // in that region

            if (key < ar[mid1]) {

                // The key lies in between l and mid1
                return ternarySearch(l, mid1 - 1, key, ar);
            }
            else if (key > ar[mid2]) {

                // The key lies in between mid2 and r
                return ternarySearch(mid2 + 1, r, key, ar);
            }
            else {

                // The key lies in between mid1 and mid2
                return ternarySearch(mid1 + 1, mid2 - 1, key, ar);
            }
        }

        // Key not found
        return -1;
    }

    // Driver code
    public static void main(String args[])
    {
        int l, r, p, key;

        // Get the array
        // Sort the array if not sorted
        int ar[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        // Starting index
        l = 0;

        // end element index
        r = 9;

        // Checking for 5

        // Key to be searched in the array
        key = 5;

        // Search the key using ternarySearch
        p = ternarySearch(l, r, key, ar);

        // Print the result
        System.out.println("Index of " + key + " is " + p);

        // Checking for 50

        // Key to be searched in the array
        key = 50;

        // Search the key using ternarySearch
        p = ternarySearch(l, r, key, ar);

        // Print the result
        System.out.println("Index of " + key + " is " + p);
    }
}
