package org.dreambig.ds.company.twitter;

public class LonelyElement {

  public static int findLonelyElement(int [] input){

    Integer res=input[0];
    for ( int i=1;i<input.length;i++){
        res=res^input[i];
    }
    return res;
  }
public static void main(String[] args) {
  int[] list={1,2,3,234,3,2,1};
  System.out.println(findLonelyElement(list));
}


}
