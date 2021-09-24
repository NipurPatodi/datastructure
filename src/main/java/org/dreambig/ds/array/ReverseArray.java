package org.dreambig.ds.array;

public class ReverseArray {

public static int[] reverse(int [] arr){
    // will use front and back pointer
    if(arr.length<=1)
      return arr;
    int i=0, j=arr.length-1;
    while( i<=j){
    int tmp =arr[i];
    arr[i]=arr[j];
    arr[j]=tmp;
      i++;
      j--;
    }
  return arr;
  }

public static void print (int [] arr){
  for (int i=0; i<arr.length;i++){
    System.out.print(arr[i]+" ");
  }
}


public static void main (String ... arg){
  int [] arr={1,2,-1,1};
  arr = reverse(arr);
  print(arr);

}



}
