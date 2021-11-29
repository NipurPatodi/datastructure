package org.dreambig.ds.math.easy;

import org.dreambig.ds.picker.IQuestion;

import java.util.Arrays;
import java.util.List;

public class ComputeSqrt implements IQuestion {
    @Override
    public String getQuestion() {
        return "Example 1:\n" +
                "\n" +
                "Input: x = 4\n" +
                "Output: 2\n" +
                "Example 2:\n" +
                "\n" +
                "Input: x = 8\n" +
                "Output: 2\n" +
                "Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned." +
                "find more details at https://leetcode.com/problems/sqrtx/";
    }

    @Override
    public List<String> getCompanies() {
        return Arrays.asList("linkedin".split(" "));
    }

    @Override
    public String getThingsToRemember() {
        return "Use binary search here and in else case return right instead of mid";
    }


  public  int ComputeSqrt(int x){
      if(x<2)
        return x;

    // Will use BS
    int l=2, r=x/2;
    int pivot=0;
    while(l<=r){
       pivot= l+ (r-l)/2;
       long num= (long) pivot*pivot;

      if(num>x){
        r=pivot-1;
      }
      else if (num<x){
        l=pivot+1;
      }
      else
        return pivot;
    }
    return  r;

  }

  public static void main(String[] args) {
    ComputeSqrt  obj = new ComputeSqrt ();
    System.out.println(obj.ComputeSqrt(35));
  }





}
