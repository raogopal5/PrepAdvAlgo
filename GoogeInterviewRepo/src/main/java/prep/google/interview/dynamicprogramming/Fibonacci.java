package prep.google.interview.dynamicprogramming;
//Identify Subproblems: Divide the main problem into smaller, independent subproblems.
//Store Solutions: Solve each subproblem and store the solution in a table or array.
//Build Up Solutions: Use the stored solutions to build up the solution to the main problem.
//Avoid Redundancy: By storing solutions, DP ensures that each subproblem is solved only once, reducing computation time.
public class Fibonacci {

    static int fib(int n)
    {
        int a = 0, b = 1, c;
        if (n == 0)
            return a;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String args[])
    {
        int n = 9;
        System.out.println(fib(n));
    }
}
