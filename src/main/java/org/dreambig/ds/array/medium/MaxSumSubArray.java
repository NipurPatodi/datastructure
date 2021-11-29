package org.dreambig.ds.array.medium;

public class MaxSumSubArray {

    static long getMaxSumSubArray(int [] arr){
      long maxSoFar= Integer.MIN_VALUE;
      long maxEndHere=0;

      for ( int i =0; i<arr.length;i++){
        maxEndHere+=arr[i]; // tricky
        if(maxSoFar<maxEndHere){
          maxSoFar=maxEndHere;
        }
        if(maxEndHere<0)
          maxEndHere=0;

      }

      return maxSoFar;
      }


      public static void main (String ... arg){

        int []ip={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(getMaxSumSubArray(ip));

      }


}
