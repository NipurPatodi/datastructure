package org.dreambig.ds.company.twitter;

import org.dreambig.ds.picker.IQuestion;

import java.util.Arrays;
import java.util.List;

public class LonelyElement implements IQuestion {

  public static int findLonelyElement(int [] input){

    Integer res=input[0];
    for ( int i=1;i<input.length;i++){
        res=res^input[i]; // XOR
    }
    return res;
  }
public static void main(String[] args) {
  int[] list={1,2,3,234,3,2,1};
  System.out.println(findLonelyElement(list));
}


  @Override
  public String getQuestion() {
    return "Given an array of integers, where all elements but one occur twice, find the unique element.\n" +
            "\n" +
            "Example\n" +
            "\n" +
            "The unique element is .\n" +
            "\n" +
            "Function Description\n" +
            "\n" +
            "Complete the lonelyinteger function in the editor below.\n" +
            "\n" +
            "lonelyinteger has the following parameter(s):\n" +
            "\n" +
            "int a[n]: an array of integers\n" +
            "Returns\n" +
            "\n" +
            "int: the element that occurs only once\n" +
            "Input Format\n" +
            "\n" +
            "The first line contains a single integer, , the number of integers in the array.\n" +
            "The second line contains  space-separated integers that describe the values in .\n" +
            "\n" +
            "Constraints\n" +
            "\n" +
            "It is guaranteed that  is an odd number and that there is one unique element.\n" +
            "Please find more details at https://www.hackerrank.com/challenges/lonely-integer/problem";
  }

  @Override
  public List<String> getCompanies() {
    return Arrays.asList("twitter".split(" "));
  }

  @Override
  public String getThingsToRemember() {
    return "Simple question if used XOR";
  }
}
