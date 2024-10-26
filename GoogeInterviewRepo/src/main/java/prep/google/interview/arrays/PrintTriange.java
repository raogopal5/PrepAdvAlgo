package prep.google.interview.arrays;

public class PrintTriange {
    public static void print(int rows){
    for (int i = 1; i <= rows; i++) {

        // loop to print the number of spaces before the star
        for (int j = rows; j >= i; j--) {
            System.out.print(" ");
        }

        // loop to print the number of stars in each row
        for (int j = 1; j <= i; j++) {
            System.out.print("* ");
        }

        // for new line after printing each row
        System.out.println();
    }
}

    public static void printStars(int n)
    {
        int i, j;

        // outer loop to handle number of rows
        //  n in this case
        for(i=0; i<n; i++)
        {

            //  inner loop to handle number of columns
            //  values changing acc. to outer loop
            for(j=0; j<=i; j++)
            {
                // printing stars
                System.out.print("* ");
            }

            // ending line after each row
            System.out.println();
        }
    }
    public static void printPyramid(int n)
    {
        int i, j;

        // outer loop to handle number of rows
        //  n in this case
        for(i=0; i<n; i++)
        {

            //  inner loop to handle number of columns
            //  values changing acc. to outer loop
            for(j=0; j<=i; j++)
            {
                // printing stars
                System.out.print("* ");
            }

            // ending line after each row
            System.out.println();
        }
    }

    static void printRectangle(int n, int m)
    {
        int i, j;
        for (i = 1; i <= n; i++)
        {
            for (j = 1; j <= m; j++)
            {
                if (i == 1 || i == n ||
                        j == 1 || j == m)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        print(6);
        printPyramid(6);
        printRectangle(7,20);
    }
}
