package prep.google.interview.stringmanipulation;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DuplicateStringCount {

    public  Map<Character, Integer> printDuplicateString(String s) {
        char character[] = s.toCharArray();
        Map<Character, Integer> countMap = new HashMap<>();
        for (Character c : character) {
            if (countMap.containsKey(c)) {
                countMap.put(c, countMap.get(c) + 1);
            } else {
                countMap.put(c, 1);
            }
        }
        return countMap;
    }


    public  Map<Character, Integer> printDuplicateString1(String word) {
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



    public static void printDuplicateCharacters(String word) {
        char[] characters = word.toCharArray(); //
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        for (Character ch : characters) {
            if (charMap.containsKey(ch)) {
                charMap.put(ch, charMap.get(ch) + 1);
            } else {
                charMap.put(ch, 1);
            }
        }
        Set<Map.Entry<Character, Integer>> entrySet = charMap.entrySet();
        System.out.printf("List of duplicate characters in String '%s' %n", word);
        for (Map.Entry<Character, Integer> entry : entrySet) {
            if (entry.getValue() > 1) {
                System.out.printf("%s : %d %n", entry.getKey(), entry.getValue());
            }
        }
    }



        public static void main (String[]args) {
        DuplicateStringCount duplicateStringCount = new DuplicateStringCount();
            Map<Character, Integer> countMap = duplicateStringCount.printDuplicateString1("GLL");
            for (Map.Entry entry : countMap.entrySet()) {
                System.out.println(entry.getValue() + " " + entry.getKey());
            }
        }
           // printDuplicateCharacters("gopallll");

    }
