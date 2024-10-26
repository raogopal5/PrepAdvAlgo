package prep.google.interview.recursion;

public class PlacetoFlowerPot {

    //Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty,
    // and an integer n, return if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers
//Complexity
//The time complexity of the optimized solution is O(n), where n is the length of the flowerbed array.
// This is because we only need to iterate through the array once, and each iteration either checks one or two plots.
// Since we skip over some plots, the worst-case scenario is when all the plots in the flowerbed are empty,
// and we need to check every other plot. In this case, we check n/2 plots, which gives us O(n) time complexity.
//Space complexity:
//The space complexity of the optimized solution is O(1), which is constant space. We are only using a fixed
// number of variables to keep track of the count of planted flowers and the index of the current plot,
// and we are not creating any new data structures or arrays.
// Therefore, the space used by the algorithm does not depend on the size of the input, and it is constant.

    ///solution is The plot is empty (has a value of 0).
    //The plot is not adjacent to any other occupied plot (either the previous or next plot is also empty).
    //If a plot satisfies these conditions, we can plant a new flower in that plot and increment the count variable.
    // We should also skip over the next plot, since we know that it cannot be used for planting.
    //
    //Once we have checked all the plots in the flowerbed array, we can return true if we have planted at least n flowers, and false otherwise.
    public static boolean canPlaceFlower(int flow[],int n){
        int counter =0;
        for(int i=0; i<flow.length;i +=2){
            if(flow[i]==0){
         if(i==flow.length-1 || flow[i+1]==0){
             counter++;
         }
            }
            if(counter>=n){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int flowerPet[] =  {1,0,0,0,1};
        int n=1;
        boolean result =canPlaceFlower(flowerPet,n);
        System.out.println(result);
    }
}
