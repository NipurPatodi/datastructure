
package org.dreambig.ds.array;

public class MaxMinInArray{

static void printMinMaxOfArray (int [] arr){
  int min=Integer.MAX_VALUE;
  int max=Integer.MIN_VALUE;
  for ( int i =0; i<arr.length;i++){
    min = Math.min( min, arr[i]);
    max= Math.max(max,arr[i]);
  }
  System.out.println ("Max = "+max +" Min="+min);

}

public static void main (String ... arg){
int [] ip ={1,2,3,4,57,-12};
printMinMaxOfArray(ip);

}


}
