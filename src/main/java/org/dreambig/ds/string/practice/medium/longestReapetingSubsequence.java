package org.dreambig.ds.string.practice.medium;
import org.dreambig.ds.picker.IQuestion;

import java.util.*;

public class longestReapetingSubsequence implements IQuestion {
  @Override
  public String getQuestion(){
    return "Given a string str, find the length of the longest repeating subsequence such that it can be found twice in the given string. The two identified subsequences A and B can use the same ith character from string str if and only if that ith character has different indices in A and B.\n" +
            "\n" +
            "Example 1:\n" +
            "\n" +
            "Input:\n" +
            "str = \"axxxy\"\n" +
            "Output: 2\n" +
            "Explanation:\n" +
            "The given array with indexes looks like\n" +
            "a x x x y \n" +
            "0 1 2 3 4\n" +
            "\n" +
            "The longest subsequence is \"xx\". \n" +
            "It appears twice as explained below.\n" +
            "\n" +
            "subsequence A\n" +
            "x x\n" +
            "0 1  <-- index of subsequence A\n" +
            "------\n" +
            "1 2  <-- index of str \n" +
            "\n" +
            "\n" +
            "subsequence B\n" +
            "x x\n" +
            "0 1  <-- index of subsequence B\n" +
            "------\n" +
            "2 3  <-- index of str \n" +
            "\n" +
            "We are able to use character 'x' \n" +
            "(at index 2 in str) in both subsequences\n" +
            "as it appears on index 1 in subsequence A \n" +
            "and index 0 in subsequence B.\n" +
            "Example 2:\n" +
            "\n" +
            "Input:\n" +
            "str = \"aab\"\n" +
            "Output: 1\n" +
            "Explanation: \n" +
            "The longest reapting subsequenece is \"a\".\n" +
            "\n" +
            "Your Task:\n" +
            "You don't need to read or print anything. Your task is to complete the LongestRepeatingSubsequence() which takes str as input parameter and returns the length of the longest repeating subsequnece.\n" +
            "\n" +
            "\n" +
            "Expected Time Complexity: O(n2)\n" +
            "Expected Space Complexity: O(n2)";
  }
  @Override
  public  List<String> getCompanies() {
    String []c=" Amazon Google".split(" ");
    return Arrays.asList(c);
  }

  @Override
  public String getThingsToRemember() {
      return "1. SubString in java (i, j) j is excluded 2. Naive approach takes O(n^3) complexity. 2. Best approach can be by DP. complexity is n^2 and space complexity is 2n" +
              "3. check @ https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/ for more details ";
  }



  public int longestRepeatingSub(String ip){

  int n=ip.length();
  int [][] tab= new int [n+1][n+1];

  for ( int i=0;i<=n;i++){
    for( int j=0; j<=n; j++){
        if(i==0||j==0)  tab[i][j]=0;
        else if(ip.charAt(i-1)==ip.charAt(j-1) && i!=j){
            tab[i][j]=1+tab[i-1][j-1];
          }
          else{
          tab[i][j]=Math.max(tab[i-1][j], tab[i][j-1]);
          }
    }

  }
  return tab[n][n];

  }




  public static void main(String[] args){
    longestReapetingSubsequence lrs= new longestReapetingSubsequence();
    System.out.println(lrs.longestRepeatingSub("aaba"));
  }




}
