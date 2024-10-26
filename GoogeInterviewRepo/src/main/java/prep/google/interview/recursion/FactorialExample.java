package prep.google.interview.recursion;

public class FactorialExample {
//Recursion is a process in which a function calls itself directly
// or indirectly is called recursion and the corresponding function is called a recursive function
    static int fact(int n)
    {
        if (n <= 1) // base case
            return 1;
        else
            return n*fact(n-1);
    }

    public static void main(String[] args) {
        int f = FactorialExample.fact(3);
        System.out.println(f);

    }
}
