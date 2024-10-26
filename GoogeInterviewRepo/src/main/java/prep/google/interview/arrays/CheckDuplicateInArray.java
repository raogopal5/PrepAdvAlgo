package prep.google.interview.arrays;

import java.util.HashMap;
import java.util.Map;

public class CheckDuplicateInArray {
    /**
     * Time Complexity:  O(N), where N is the length of the array. As searching hash_set takes O(1)
     *
     * Space Complexity: O(N), Where N is the number of elements stored in the se
     * @param word
     * @return
     */
    public static Map<Character, Integer> printDuplicateString1(String word) {
        char[] characters = word.toCharArray();
        Map<Character, Integer> countMap = new HashMap<Character, Integer>();
        for (Character ch : characters) {
            if (countMap.containsKey(ch)) {
                countMap.put(ch, countMap.get(ch) + 1);
            } else {
                countMap.put(ch, 1);
            }
        }
        return countMap;
    }

    public static boolean checkDuplicate(String word){
        Map<Character,Integer> countMap = printDuplicateString1(word);
        for(Map.Entry<Character,Integer> m : countMap.entrySet()){
            if(m.getValue() > 1){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean check = checkDuplicate("GLL");
        System.out.println(check);

    }

}
