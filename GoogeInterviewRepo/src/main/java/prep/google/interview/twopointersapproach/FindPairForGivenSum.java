package prep.google.interview.twopointersapproach;

public class FindPairForGivenSum {

    private static int findPairForSum(int a[],int givenSum){
      // nested loop iteration
        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
                if(a[i]==a[j]){
                    continue;
                }
                if(a[i]+a[j]==givenSum){
                    return i;
                }
                if(a[i]+a[j]>givenSum){
                    break;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int a[] = { 2, 3, 5, 8, 9, 10, 11 };
        int result = findPairForSum(a,8);
        System.out.println(result);
    }
}
