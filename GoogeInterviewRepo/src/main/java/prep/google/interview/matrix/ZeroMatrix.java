package prep.google.interview.matrix;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * iven a matrix if an element in the matrix is 0 then you will have to set its entire column and row to 0 and then return the matrix.
 *
 * Examples
 * Examples 1:
 * Input:
 *  matrix=[[1,1,1],[1,0,1],[1,1,1]]
 *
 * Output:
 *  [[1,0,1],[0,0,0],[1,0,1]]
 *
 * Explanation:
 *  Since matrix[2][2]=0.Therfore the 2nd column and 2nd row wil be set to 0.
 *  Time Complexity: O(2*(N*M)), where N = no. of rows in the matrix and M = no. of columns in the matrix.
 * Reason: We are traversing the entire matrix 2 times and each traversal is taking O(N*M) time complexity.
 *
 * Space Complexity: O(N) + O(M), where N = no. of rows in the matrix and M = no. of columns in the matrix.
 * Reason: O(N) is for using the row array and O(M) is for using the col array.
 */

public class ZeroMatrix {

    static ArrayList<ArrayList<Integer>> zeroMatrix(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        int[] row = new int[n]; // row array
        int[] col = new int[m]; // col array

        // Traverse the matrix:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == 0) {
                    // mark ith index of row wih 1:
                    row[i] = 1;

                    // mark jth index of col wih 1:
                    col[j] = 1;
                }
            }
        }

        // Finally, mark all (i, j) as 0
        // if row[i] or col[j] is marked with 1.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrix.get(i).set(j, 0);
                }
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 0, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));

        int n = matrix.size();
        int m = matrix.get(0).size();

        ArrayList<ArrayList<Integer>> ans = zeroMatrix(matrix, n, m);

        System.out.println("The Final matrix is: ");
        for (ArrayList<Integer> row : ans) {
            for (Integer ele : row) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}
