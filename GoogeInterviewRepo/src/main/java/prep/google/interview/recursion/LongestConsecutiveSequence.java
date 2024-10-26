package prep.google.interview.recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestConsecutiveSequence {
// Consecutive elements means every next item should be greater or smaller to the previous element in the sequence
    private static int findLongestConsecutiveElement(int numbers[]){

        Arrays.sort(numbers);

        ArrayList<Integer> numList = new ArrayList<>();
        numList.add(10);
        int ans=0;int count =0;

        // Insert repeated elements only once in the vector
        for(int i=1;i<numbers.length;i++){
            if(numbers[i] != numbers[i-1]){
                    numList.add(numbers[i]);
            }
        }

        for(int i=0;i<numList.size();i++){
            // Check if the current element is equal to previous element +1
            if(i>0 && numList.get(i)==numList.get(i)-1 +1){
                count++;
            }else{
                count =1;
            }
        }
        return  ans = Math.max(ans,count);

    }

    static int findLongestConsequenceNum(int arr[])
    {

        // Sort the array
        Arrays.sort(arr);

        int ans = 0, count = 0;

        ArrayList<Integer> v = new ArrayList<Integer>();
        v.add(10);

        // Insert repeated elements
        // only once in the vector
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1])
                v.add(arr[i]);
        }

        // Find the maximum length
        // by traversing the array
        for (int i = 0; i < v.size(); i++) {

            // Check if the current element is
            // equal to previous element +1
            if (i > 0 && v.get(i) == v.get(i - 1) + 1)
                count++;
            else
                count = 1;

            // Update the maximum
            ans = Math.max(ans, count);
        }
        return ans;
    }

    public static void main(String[] args) {
        int numbers[] =  {100,4,200,1,3,2};
        int numbers1[] =  {0,3,7,2,5,8,4,6,0,1};
        int arr[] = { 1, 9, 3, 10, 4, 20, 2 };
        int ans1 = LongestConsecutiveSequence.findLongestConsequenceNum(numbers);
        int ans2 = LongestConsecutiveSequence.findLongestConsequenceNum(numbers1);
        int ans3 = LongestConsecutiveSequence.findLongestConsequenceNum(arr);
        System.out.println("ans1 " +ans1);
        System.out.println("ans2 " +ans2);
        System.out.println("ans3 " + ans3);
    }
}
