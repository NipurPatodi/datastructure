package org.dreambig.ds.array.easy;

import org.dreambig.ds.picker.IQuestion;

import java.util.Arrays;
import java.util.List;

public class MoveAllZeros implements IQuestion {
    @Override
    public String getQuestion() {
        return "Move all zeroes to end of array\n" +
                "Difficulty Level : Easy\n" +
                "Last Updated : 19 Jul, 2021\n" +
                "Given an array of random numbers, Push all the zero’s of a given array to the end of the array. For example, if the given arrays is {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0}, it should be changed to {1, 9, 8, 4, 2, 7, 6, 0, 0, 0, 0}. The order of all other elements should be same. Expected time complexity is O(n) and extra space is O(1).\n" +
                "Example: \n" +
                " \n" +
                "\n" +
                "Input :  arr[] = {1, 2, 0, 4, 3, 0, 5, 0};\n" +
                "Output : arr[] = {1, 2, 4, 3, 5, 0, 0, 0};\n" +
                "\n" +
                "Input : arr[]  = {1, 2, 0, 0, 0, 3, 6};\n" +
                "Output : arr[] = {1, 2, 3, 6, 0, 0, 0};";
    }

    @Override
    public List<String> getCompanies() {
        return Arrays.asList("linked".split(" "));
    }

    @Override
    public String getThingsToRemember() {
        return "Trick is to move variable by using count of non empty variable";
    }

    public int[] moveZeroToEnd(int []arr){
      int n = arr.length;
      int ctr=0;
      for ( int i=0;i<n;i++){
          //looping all
            if(arr[i]!=0){
              arr[ctr]=arr[i];
              ctr++;
            }
      }
      while(ctr<n) {
          arr[ctr] = 0;
          ctr++;
      }
      return arr;
    }

    public static void main(String ... arg){
      MoveAllZeros  obj= new MoveAllZeros ();
      int []ip={1,2,3,0,0,5,0,7,0,0,9};
      int [] res=obj.moveZeroToEnd(ip);
      for ( int i : ip){
        System.out.print(i+" ");
      }
      System.out.println("");
    }


}
