package prep.google.interview.stringmanipulation;

public class LongestCharRepeatingReplacement {

    public static int characterReplacement(String s, int k) {
        int[] cnt = new int[26];
        int l = 0, mx = 0;
        int n = s.length();
        for (int r = 0; r < n; ++r) {
            mx = Math.max(mx, ++cnt[s.charAt(r) - 'A']);
            if (r - l + 1 - mx > k) {
                --cnt[s.charAt(l++) - 'A'];
            }
        }
        return n - l;
    }

    public static void main(String[] args) {
        String input ="ABAB";
        int op = characterReplacement(input,2);
        System.out.println(op);
    }
}
