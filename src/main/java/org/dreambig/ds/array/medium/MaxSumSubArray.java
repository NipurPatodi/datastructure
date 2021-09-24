package org.dreambig.ds.array.medium;

public class MaxSumSubArray {

    static long getMaxSumSubArray(int [] arr){
      long maxSoFar= Integer.MIN_VALUE;
      long maxEndHere=0;

      for ( int i =0; i<arr.length;i++){
        maxEndHere+=arr[i];
        if(maxSoFar<maxEndHere){
          maxSoFar=maxEndHere;
        }
        if(maxEndHere<0)
          maxEndHere=0;

      }

      return maxSoFar;
      }


      public static void main (String ... arg){

        int []ip={1,2,3,4,-4,0,10};
        System.out.println(getMaxSumSubArray(ip));

      }


}
