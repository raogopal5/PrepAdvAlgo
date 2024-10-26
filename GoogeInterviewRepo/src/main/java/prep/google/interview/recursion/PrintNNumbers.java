package prep.google.interview.recursion;

public class PrintNNumbers {

    public static void printNumber(int n){
        System.out.println(n);
        //It will gain itself with different value
        printNumber(n+1);
    }

    public static void main(String[] args) {
        PrintNNumbers.printNumber(5);
    }
}
