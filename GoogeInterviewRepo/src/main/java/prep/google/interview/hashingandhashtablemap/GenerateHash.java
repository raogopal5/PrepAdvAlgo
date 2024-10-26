package prep.google.interview.hashingandhashtablemap;

public class GenerateHash {

    public static void main(String[] args) {
        Integer i = new Integer(5);
        int hashValue = i.hashCode();
        System.out.println(hashValue);
        String str = "hello";
        int hash = str.hashCode();
        System.out.println(hash);
    }
}
