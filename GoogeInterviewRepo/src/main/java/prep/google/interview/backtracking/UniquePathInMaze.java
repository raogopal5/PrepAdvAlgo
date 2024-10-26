package prep.google.interview.backtracking;

/**
 * ind the total number of unique paths in a maze from source to destination
 * Find the total number of unique paths that the robot can take in a given maze to reach a given destination from a given source.
 *
 * Positions in the maze will either be open or blocked with an obstacle. The robot can only move to positions without obstacles, i.e.,
 * the solution should find paths that contain only open cells. Retracing the one or more cells back and forth is not considered a new path. The set of all cells covered in a
 * single path should be unique from other paths. At any given moment, the robot can only move one step in either of the four
 *
 *
 * Positions in the maze will either be open or blocked with an obstacle. The robot can only move to positions without obstacles, i.e., the solution should find paths that contain only open cells. Retracing the one or more cells back and forth is not considered a new path. The set of all cells covered in a single path should be unique from other paths. At any given moment, the robot can only move one step in either of the four directions. The valid moves are:
 *
 * Go North: (x, y) ——> (x – 1, y)Go West:  (x, y) ——> (x, y – 1)Go South: (x, y) ——> (x + 1, y)Go East:  (x, y) ——> (x, y + 1)
 * For example, consider the following maze in the form of a binary matrix where 0 represents a blocked cell and 1 represents an open cell:
 *
 *   [ 1  1  1  1 ]  [ 1  1  0  1 ]  [ 0  1  0  1 ]  [ 1  1  1  1 ]
 * We have to find the total number of unique paths from source to destination. The above maze contains 4 unique paths (marked in blue color).
 *
 *  [ 1  1  1  1 ]
 *  [ 1  1  1  1 ] [ 1  1  0  1 ]
 *  [ 1  1  0  1 ] [ 0  1  0  1 ]
 *  [ 0  1  0  1 ] [ 1  1  1  1 ]
 *  [ 1  1  1  1 ]  [ 1  1  1  1 ]
 *  [ 1  1  1  1 ] [ 1  1  0  1 ]
 *  [ 1  1  0  1 ] [ 0  1  0  1 ]
 *  [ 0  1  0  1 ] [ 1  1  1  1 ]
 *  [ 1  1  1  1 ]
 *  The robot should search for a path from the starting position to the goal position until it finds one or until it exhausts all possibilities.
 *  We can easily achieve this with the help of Backtracking. We start from the given source cell in the matrix and explore all
 *  four paths possible and recursively check if they will lead to the destination or not. We update the unique path count whenever
 *  the destination cell is reached. If a path doesn’t reach the destination or explored all possible routes from the current cell,
 *  we backtrack. To make sure that the path is simple and doesn’t contain any cycles, keep track of cells involved in the current path in a matrix,
 *  and before exploring any cell, ignore the cell if it is already covered in the current path.
 */
public class UniquePathInMaze {

    // Check if cell (x, y) is valid or not
    private static boolean isValidCell(int x, int y, int N) {
        return !(x < 0 || y < 0 || x >= N || y >= N);
    }

    private static int countPaths(int[][] maze, int i, int j, int x, int y,
                                  boolean visited[][])
    {
        // if destination (x, y) is found, return 1
        if (i == x && j == y) {
            return 1;
        }

        // stores number of unique paths from source to destination
        int count = 0;

        // mark the current cell as visited
        visited[i][j] = true;

        // `N × N` matrix
        int N = maze.length;

        // if the current cell is a valid and open cell
        if (isValidCell(i, j, N) && maze[i][j] == 1)
        {
            // go down (i, j) ——> (i + 1, j)
            if (i + 1 < N && !visited[i + 1][j]) {
                count += countPaths(maze, i + 1, j, x, y, visited);
            }

            // go up (i, j) ——> (i - 1, j)
            if (i - 1 >= 0 && !visited[i - 1][j]) {
                count += countPaths(maze, i - 1, j, x, y, visited);
            }

            // go right (i, j) ——> (i, j + 1)
            if (j + 1 < N && !visited[i][j + 1]) {
                count += countPaths(maze, i, j + 1, x, y, visited);
            }

            // go left (i, j) ——> (i, j - 1)
            if (j - 1 >= 0 && !visited[i][j - 1]) {
                count += countPaths(maze, i, j - 1, x, y, visited);
            }
        }

        // backtrack from the current cell and remove it from the current path
        visited[i][j] = false;

        return count;
    }

    public static int findCount(int[][] maze, int i, int j, int x, int y)
    {
        // base case: invalid input
        if (maze == null || maze.length == 0 || maze[i][j] == 0 || maze[x][y] == 0) {
            return 0;
        }

        // `N × N` matrix
        int N = maze.length;

        // 2D matrix to keep track of cells involved in the current path
        boolean[][] visited = new boolean[N][N];

        // start from source cell (i, j)
        return countPaths(maze, i, j, x, y, visited);
    }

    public static void main(String[] args)
    {
        int[][] maze =
                {
                        { 1, 1, 1, 1 },
                        { 1, 1, 0, 1 },
                        { 0, 1, 0, 1 },
                        { 1, 1, 1, 1 }
                };

        // source cell (0, 0), destination cell (3, 3)
        int count = findCount(maze, 0, 0, 3, 3);

        System.out.println("The total number of unique paths are " + count);
    }
}
