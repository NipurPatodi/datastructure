package org.dreambig.ds.string.practice.medium;
import org.dreambig.ds.picker.IQuestion;

import java.util.*;

public class LongestPalindrom implements IQuestion {


    @Override
    public String getQuestion() {
        return "Given a string S, find the longest palindromic substring in S. Substring of string S: S[ i . . . . j ] where 0 ≤ i ≤ j < len(S). Palindrome string: A string which reads the same backwards. More formally, S is palindrome if reverse(S) = S. Incase of conflict, return the substring which occurs first ( with the least starting index).\n" +
                "\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input:\n" +
                "S = \"aaaabbaa\"\n" +
                "Output: aabbaa\n" +
                "Explanation: The longest Palindromic\n" +
                "substring is \"aabbaa\".\n" +
                "Example 2:\n" +
                "\n" +
                "Input: \n" +
                "S = \"abc\"\n" +
                "Output: a\n" +
                "Explanation: \"a\", \"b\" and \"c\" are the \n" +
                "longest palindromes with same length.\n" +
                "The result is the one with the least\n" +
                "starting index.\n" +
                "\n" +
                "Your Task:\n" +
                "You don't need to read input or print anything. Your task is to complete the function longestPalin() which takes the string S as input and returns the longest palindromic substring of S.\n" +
                "\n" +
                "\n" +
                "Expected Time Complexity: O(|S|2).\n" +
                "Expected Auxiliary Space: O(1).\n" +
                "\n";
    }

    @Override
    public List<String> getCompanies() {
        String []c="Accolite Amazon Groupon MakeMyTrip Microsoft Qualcomm Samsung Visa Walmart Zoho Google".split(" ");
        return Arrays.asList(c);
    }

    @Override
    public String getThingsToRemember() {
        return "1. SubString in java (i, j) j is excluded 2. Naive approach takes O(n^3) complexity. 2. Best approach can be by DP. complexity is n^2 and space complexity is 2n" +
                "3. check @ https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/ for more details ";
    }


    public String longestPalinNaive (String s) {
        String res=s.charAt(0)+"";

      for (int i=0; i<s.length();i++){
          for(int j=s.length();j>i;j--){
            String curr =s.substring(i,j);
            if(isPalandrom(curr)){
              if(curr.length()>res.length()){
                res=curr;
              }
            }
          }

      }
        return res;
   }

   private boolean isPalandrom(String str){
     int i=0, j=str.length()-1;
     while(i<j){
      if(str.charAt(i)!=str.charAt(j))
        return false;
      else{
        i++;
        j--;
      }

     }
     return true;
   }



   public String getLargestPalin(String ip){
        // Step 1. create dp of size nXn  n=size of ip
        final int n=ip.length();
        boolean[][]dp= new boolean[n][n];
        // Step 2. set all subString with 1 size as true;
        for (int i=0;i<n;i++) dp[i][i]=true;

        //Step 3. check for All substring with size 2
       int start=0, max=0;
        for(int i=0;i<n-1;i++){
            if(ip.charAt(i)==ip.charAt(i+1)) {
                dp[i][i + 1] = true;
                start=i;
                max=2; // setting it just in case if there is no palindrom
            }
        }

        //Step 4. Final Stroke, check for all String >=3, outer
       // loop for length and inner loop for iteration
       // Please note that max iteration is n - current size
       for( int k=3;k<=n;k++){ // s=n because full string can be palandrom

            for( int i=0;i<n-k+1;i++){
                int j= i+k-1;
                if(dp[i+1][j-1]  && ip.charAt(i)==ip.charAt(j) ){
                    dp[i][j]=true;
                    if(k>max){
                        max=k;
                        start=i;
                    }
                }

            }
       }
        return ip.substring(start,start+max);
   }



   public static void main(String ... args){
   LongestPalindrom lp= new LongestPalindrom();
    System.out.println(lp.longestPalinNaive("geeksoske"));
       System.out.println(lp.getLargestPalin("geeksoske"));


   }




}
