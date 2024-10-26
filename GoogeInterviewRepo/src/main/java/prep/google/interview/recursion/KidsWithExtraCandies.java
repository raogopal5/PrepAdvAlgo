package prep.google.interview.recursion;

import java.util.ArrayList;
import java.util.List;

public class KidsWithExtraCandies {


    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
    List<Boolean> ans = new ArrayList<Boolean>();
    int minValue =  Integer.MIN_VALUE;
    for(int i=0;i<candies.length;i++){
        if (candies[i] > minValue) {
            minValue = candies[i];
        }
        }
        for(int i=0;i<candies.length;i++){
            if(candies[i] +extraCandies >=minValue){
                ans.add(i,true);
            }else{
                ans.add(i,false);
            }
        }
        return ans;
    }

    //Time complexity:
    //O(N)
    //
    //Space complexity:
    //O(1)

    public static void main(String[] args) {
        int candies [] = {2,3,5,1,3};
        int extraCandies = 3 ;

       List<Boolean> result = kidsWithCandies(candies,extraCandies);
        System.out.println(result);
    }
}
