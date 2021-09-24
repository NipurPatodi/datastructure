package org.dreambig.ds.array;

public class Sort012{

private static void swap(int [] arr, int i, int j){
  int tmp = arr[i];
  arr[i]= arr[j];
  arr[j]=tmp;
}

public static  void sort(int[] arr){
  int n= arr.length;
  int l=0,m=0,h=n-1;

  while(m<=h){
    if(arr[m]==0){
      swap(arr,m,l);
      l++;
      m++;
    }
    else if(arr[m]==2){
      swap(arr,m,h);
      h--;
    }else
      m++;

  }
}




public static void main(String ... args){
int [] ip={0,1,0,1,2,0,1,0,0,0};
  sort(ip);
  for ( int i=0; i<ip.length;i++)
      System.out.print( ip[i]+" ");

}






}
