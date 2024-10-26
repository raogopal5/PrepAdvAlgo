package prep.google.interview.sorting;

public class BubbleSortAlg {

     void bubbleSort(int arr[], int n)
    {
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {

                    // Swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were
            // swapped by inner loop, then break
            if (swapped == false)
                break;
        }
    }

    public static void main(String[] args) {
        BubbleSortAlg bubbleSortAlg = new BubbleSortAlg();
        int arr[] = { 64, 34, 25, 12, 22, 11, 90 };
        bubbleSortAlg.bubbleSort(arr,arr.length);
        for (int i=0;i<arr.length;i++){
            System.out.print("After sorting"  + arr[i]);

        }
    }
}
