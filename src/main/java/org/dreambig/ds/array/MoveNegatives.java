package org.dreambig.ds.array;

public class MoveNegatives{

  private static void swap(int []arr, int i , int j){
  int t=arr[i];
  arr[i]=arr[j];
  arr[j]=t;
  }

  public static void move(int [] arr){
    int s=0,e=arr.length-1;
    while(s<=e){
      if(arr[s]>-1){
        swap(arr,s,e);
        e--;
      }else{
        s++;
      }
    }
  }

public static void main(String ... arg){

    int [] ip= {1,-1,-4,6,-7,-3};
    move(ip);

    for ( int i =0; i <ip.length;i++)
      System.out.print(ip[i]+" ");


}


}
