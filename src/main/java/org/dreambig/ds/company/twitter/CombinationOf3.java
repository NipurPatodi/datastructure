package org.dreambig.ds.company.twitter;
import java.util.*;

public class CombinationOf3 {


  public void printCombination(int[] arr, int sum){
    // Sorting in array
    Arrays.sort(arr);
    for (int a=0;a<arr.length;a++){

      int b=a+1; // just next
      int c=arr.length -1; // last one
      while( b<c){
       if(arr[a]+arr[b]+arr[c]==sum){
        System.out.println(arr[a]+" "+arr[b]+" "+arr[c]);
        b++; // increment B
        c--; // explore other option
       }
       else if(arr[a]+arr[b]+arr[c]>sum) { // reduce c
        c--;
       }
       else if(arr[a]+arr[b]+arr[c]<sum) { // increase B
        b++;
       }
      }
    }
  }

  public static void main(String ... args){
  int [] arr = {-1,0,1,3,2,4,6,7};
  CombinationOf3 obj = new CombinationOf3();
  obj.printCombination(arr, 6);
  System.out.println("------");
  obj.printCombination(arr, 7);
      System.out.println("------");
      obj.printCombination(arr, 0);
  }



}
