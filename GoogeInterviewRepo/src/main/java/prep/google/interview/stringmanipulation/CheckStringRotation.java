package prep.google.interview.stringmanipulation;

public class CheckStringRotation {
    public static boolean checkRotatation(String original, String rotation) {
        if (original.length() != rotation.length()) {
            return false;
        }
        String concatenated = original + original;
        if (concatenated.indexOf(rotation) != -1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        boolean s = checkRotatation("gopal","gopal");
        System.out.println(s);
    }

}
