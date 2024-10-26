package prep.google.interview.stringmanipulation;

public class CountNoOfChar {

    public static int countString(String s,char input){
        int count=0;
        char character [] =s.toCharArray();
        for(int i=0;i< character.length;i++){

            if(character[i] ==input){
                count ++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int count = countString("gopall",'l');
        System.out.println(count);
    }
}
