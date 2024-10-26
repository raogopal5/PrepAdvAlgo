package prep.google.interview.searching;

/**
 * In Linear Search, we iterate over all the elements of the array and check if it the current element is equal to the target element.
 * If we find any element to be equal to the target element, then return the index of the current element
 */
public class LinearSearchAlg {

    public int linearSearch(int a[],int x){

        for (int i=0;i<a.length;i++){
            if(a[i]==x){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LinearSearchAlg linearSearchAlg = new LinearSearchAlg();
        int a[] = {2,7,8,9,4};
        int x =4;
        int find = linearSearchAlg.linearSearch(a,x);
        System.out.println("find alg " +find);
    }
}
