package prep.google.interview.stringmanipulation;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeString {


        // Encodes a list of strings to a single string.
        public static String encode(List<String> strs) {
            StringBuilder sb = new StringBuilder();
            for (String str : strs) {
                sb.append(str.length()).append('/').append(str);
            }
            return sb.toString();
        }

        // Decodes a single string to a list of strings.
        public static List<String> decodeM(String s) {
            List<String> res = new ArrayList<>();
            int i = 0;
            while (i < s.length()) {
                int slash = s.indexOf('/', i);
                int size = Integer.valueOf(s.substring(i, slash));
                res.add(s.substring(slash + 1, slash + size + 1));
                i = slash + size + 1;
            }
            return res;
    }

    public static void main(String[] args) {
            List<String> encodeString  = new ArrayList<>();
            encodeString.add("Gopal");
            encodeString.add("Adhira");
            encodeString.add("datastructure");
            String ggg = encode(encodeString);
        System.out.println(ggg);
        String decodeOP = decodeM(ggg).toString();
        System.out.println(decodeOP);
    }
}
