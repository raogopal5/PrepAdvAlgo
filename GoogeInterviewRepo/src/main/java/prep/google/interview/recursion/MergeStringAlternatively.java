package prep.google.interview.recursion;

public class MergeStringAlternatively {

    private static String mergeString(String word1, String word2){
        StringBuilder result = new StringBuilder();

          for(int i=0;i < word1.length() || i < word2.length();i++){
        // First choose ith character of the first string if exist
            if(i < word1.length()){
                result = result.append(word1.charAt(i));
               //Second choose the ith character of second string if exist
                if(i < word2.length()){
                    result = result.append(word2.charAt(i));
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String mergeStringAlternatively = MergeStringAlternatively.mergeString("gopal","adhira");
        System.out.println(mergeStringAlternatively);
    }
}
