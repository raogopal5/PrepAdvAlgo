package prep.google.interview.backtracking;

import java.util.Arrays;

/**
 * Print all possible Knight’s tours on a chessboard
 * Given a chessboard, print all sequences of moves of a knight on a chessboard such that the knight visits every square only once.
 *
 * For example, for the standard 8 × 8 chessboards, below is one such tour. We have started the tour from the top-leftmost of the board (marked as 1), and the next number represents the knight’s consecutive moves.
 *
 *  1  50  45  62  31  18   9
 *  6446  61  32  49  10  63
 *  30  1751   2  47  44  33  28  19
 *  860  35  42  27  48  11  16  2941  52
 *  3  34  43  24   7  2036  59  38  55
 *  26  21  12  1553  40  57   4  23  14
 *  25   658  37  54  39  56   5  22  13
 */
public class PrintAllPossibleKnightToursOnChessBoard {

    // `N × N` chessboard
    public static final int N = 5;

    // Below arrays detail all eight possible movements for a knight.
    // Don't change the sequence of the below arrays
    public static final int[] row = { 2, 1, -1, -2, -2, -1, 1, 2, 2 };
    public static final int[] col = { 1, 2, 2, 1, -1, -2, -2, -1, 1 };

    // Check if `(x, y)` is valid chessboard coordinates.
    // Note that a knight cannot go out of the chessboard
    private static boolean isValid(int x, int y)
    {
        if (x < 0 || y < 0 || x >= N || y >= N) {
            return false;
        }

        return true;
    }

    private static void print(int[][] visited)
    {
        for (int[] r: visited) {
            System.out.println(Arrays.toString(r));
        }
        System.out.println();
    }

    // Recursive function to perform the knight's tour using backtracking
    public static void knightTour(int[][] visited, int x, int y, int pos)
    {
        // mark the current square as visited
        visited[x][y] = pos;

        // if all squares are visited, print the solution
        if (pos >= N*N)
        {
            print(visited);
            // backtrack before returning
            visited[x][y] = 0;
            return;
        }

        // check for all eight possible movements for a knight
        // and recur for each valid movement
        for (int k = 0; k < 8; k++)
        {
            // get the new position of the knight from the current
            // position on the chessboard
            int newX = x + row[k];
            int newY = y + col[k];

            // if the new position is valid and not visited yet
            if (isValid(newX, newY) && visited[newX][newY] == 0) {
                knightTour(visited, newX, newY, pos + 1);
            }
        }

        // backtrack from the current square and remove it from the current path
        visited[x][y] = 0;
    }

    public static void main(String[] args)
    {
        // `visited[][]` serves two purposes:
        // 1. It keeps track of squares involved in the knight's tour.
        // 2. It stores the order in which the squares are visited.
        int[][] visited = new int[N][N];
        int pos = 1;

        // start knight tour from corner square `(0, 0)`
        knightTour(visited, 0, 0, pos);
    }

}
