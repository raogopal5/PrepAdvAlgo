package prep.google.interview.sorting;

public class MergeSortAlg {

    public static void main(String[] args) {
        int a[]= {91,52,83,23,62,15};
        int n=a.length;

        //calling the function to sort the array
        mergesort(a,0,n-1);
        for(int e:a)
            System.out.print(e+" ");

    }

    static void mergesort(int a[],int l,int r) {

        if(l<r) {
            int mid = l + (r-l)/2;

            //sorting the left half
            mergesort(a,l,mid);

            //sorting the right half
            mergesort(a,mid+1,r);

            //merging both the halves
            merge(a,l,mid,r);
        }
    }

    private static void merge(int[] a, int l, int mid, int r) {
        int a1[] = new int[mid-l+1];
        int a2[] = new int[r-mid];

  /*
    Populating the left
    range elements in the
    a1 array.
  */
        for(int i=l;i<=mid;i++){
            a1[i-l] = a[i];
        }

  /*
    Populating the right
    range elements in the
    a1 array.
  */
        for(int i=mid+1;i<=r;i++){
            a2[i-mid-1] = a[i];
        }

        int i = 0,j = 0,k = l;

        //merging the elements of both the ranges.
        while(i<a1.length && j<a2.length) {
            if(a1[i]<=a2[j]) a[k++] = a1[i++];
            else a[k++] = a2[j++];
        }

        //checking if any of the elements are left.
        while(i<a1.length) a[k++] = a1[i++];
        while(j<a2.length) a[k++] = a2[j++];
    }
}
