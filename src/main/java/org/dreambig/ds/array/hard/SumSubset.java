package org.dreambig.ds.array.hard;

public class SumSubset {

    private  static  void printSumSubset(int [] set, int n , int sum){
        // Create binary array for all possible subset
        int []ba= new int[set.length];
        int j=set.length-1;
        //populating array
        while(n>0){
            ba[j]=n%2;
            n=n/2;
            j--;
        }
        int currSum=0;
        for ( int i=0;i<ba.length;i++ ){
            if(ba[i]!=0){
                currSum+=set[i];
            }
        }
        if(currSum==sum){
            System.out.print("{ ");
            boolean isFirst=true;
            for ( int i=0;i<ba.length;i++ ){
                if(ba[i]!=0){
                    if(isFirst) {
                        System.out.print(set[i]);
                        isFirst=false;
                    }
                    else
                        System.out.print(" ,"+set[i]);

                }
            }
            System.out.println(" }");
        }

    }

    public static void findSubsets(int[] arr, int K)
    {
        // Calculate the total no. of subsets
        int x = (int)Math.pow(2, arr.length);

        // Run loop till total no. of subsets
        // and call the function for each subset
        for (int i = 1; i < x; i++)
            printSumSubset(arr, i, K);
    }
    public static void main(String[] args) {
        int arr[] = { 5, 10, 12, 13, 15, 18 };
        int K = 30;

        findSubsets(arr, K);
    }
}
