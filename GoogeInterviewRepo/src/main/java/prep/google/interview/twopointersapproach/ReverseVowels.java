package prep.google.interview.twopointersapproach;

public class ReverseVowels {

    public static boolean isVowels(char c){
        return  (c =='a' || c =='A' || c =='e' || c=='E' || c =='i' || c =='I' || c =='o' || c=='O' || c =='u' || c=='U');
    }

    //first store the all vovwels after scan and then reverse the string

    public static String reverseVowels(String input){
        String vowel ="";
        char [] inputChar =  input.toCharArray();
        int counter =0;
        for(int i=0;i<inputChar.length;i++){
            if(isVowels(inputChar[i])){
                counter++;
                vowel += inputChar[i];
            }
        }
//   placing the vowels in reverse
        for(int i=0;i<inputChar.length;i++){
            if(isVowels(inputChar[i])){
                inputChar[i] = vowel.charAt(--counter);
            }
        }
        return String.valueOf(inputChar);
    }

    public static void main(String[] args) {
        String  result = reverseVowels("hello world");
        System.out.println(result);
    }
}
