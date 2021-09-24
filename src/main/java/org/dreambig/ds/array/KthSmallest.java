package org.dreambig.ds.array;

public class KthSmallest{

private static void swap(int [] arr, int p1, int p2){
    int tmp=arr[p1];
    arr[p1]=arr[p2];
    arr[p2]=tmp;
  }


private static  int  partition (int[] arr, int start, int end){
int pivot= arr[end];
int ctr= start;

  for ( int i=start; i <end -1 ; i++){
    // Now comparing each element from start
        if(arr[i]<=pivot){
        // swap i with ctr
          swap( arr, i, ctr);
          ctr++;
        }
    }

    // finally Swap pivot
    swap( arr, ctr, end);
   return  ctr;
}


/***
  Recursive method to find kth smallest
***/
private static int getKthSmallestRecursive(int []arr, int start, int end , int k){

// 1. When k is smaller than element in array partition (since it is recursive)
  if( k >0 && k<=end -start +1 )// +1 to nullify zero convention
  {
    //2. Partition on last element and get position of pivot element
    int pos= partition(arr,start,end);

    if(pos-start == k-1) // if position is same as K
      return arr[pos];

    //3. if position > k need to move left
    if(pos-start>k-1 )
      return getKthSmallestRecursive(arr, start,pos-1,k);

    // else move right
    // this is k from end
    return getKthSmallestRecursive(arr, pos+1, end, k - pos +start -1 );

  }

    return Integer.MAX_VALUE;
}



public static int getKthSmallest(int [] arr,int k){
    int start =0, end = arr.length-1;
    return  getKthSmallestRecursive(arr, start,end,k);
}

 public static void main( String ... args){
  int [] input= {2,4,1,7,9,3};
  System.out.print(getKthSmallest(input,5));

 }



}
