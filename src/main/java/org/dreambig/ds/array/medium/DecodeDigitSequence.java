package org.dreambig.ds.array.medium;

import org.dreambig.ds.picker.IQuestion;

import java.util.Arrays;
import java.util.List;

public class DecodeDigitSequence implements IQuestion {
    @Override
    public String getQuestion() {
        return "Count Possible Decodings of a given Digit Sequence\n" +
                "Difficulty Level : Medium\n" +
                "Last Updated : 31 Mar, 2021\n" +
                "Let 1 represent ‘A’, 2 represents ‘B’, etc. Given a digit sequence, count the number of possible decodings of the given digit sequence. \n" +
                "\n" +
                "Examples: " +
                "Input:  digits[] = \"121\"\n" +
                "Output: 3\n" +
                "// The possible decodings are \"ABA\", \"AU\", \"LA\"\n" +
                "\n" +
                "Input: digits[] = \"1234\"\n" +
                "Output: 3\n" +
                "// The possible decodings are \"ABCD\", \"LCD\", \"AWD\"\n" +
                "An empty digit sequence is considered to have one decoding. It may be assumed that the input contains valid digits from 0 to 9 and there are no leading 0’s, no extra trailing 0’s, and no two or more consecutive 0’s." +
                "Please find more details at https://www.geeksforgeeks.org/count-possible-decodings-given-digit-sequence/";
    }

    @Override
    public List<String> getCompanies() {
        return Arrays.asList("linkedin.md".split(" "));
    }

    @Override
    public String getThingsToRemember() {
        return null;
    }


    /**
    Recurive Method to return  count of decoding possible for char array
    **/
    public int getDecodingCountRecursive(char [] ip , int n){
      // Base case
      if(n==0|| n==1){
        return 1;
      }
      //Invalid String case
      if(ip[0]=='0')
        return 0;
      int count=0 ;
      //1. if last char is valid
      if(ip[n-1]>'0'  && ip[n-1]<'9'){
        count=getDecodingCountRecursive(ip,n-1);
      }
      //2. if last 2 combination is also good

      if(ip[n-2]=='1'  ||  (ip[n-2]=='2' &&  (ip[n-1]<'7'))){
        count+=getDecodingCountRecursive(ip,n-2);
      }

      return count;
    }

    public int getDecodingCountDP(char [] ip , int n){
      // Base case
      if(n==0|| n==1){
        return 1;
      }
      //Invalid String case
      if(ip[0]=='0')
        return 0;

        int []dp= new int [n+1];
        // base cases
        dp[0]=1;
        dp[1]=1;

        for ( int i=2;i<=n;i++){
          if(ip[n-1]>'0'  && ip[n-1]<'9'){
            dp[i]=dp[i-1];
          }
          //2. if last 2 combination is also good

          if(ip[n-2]=='1'  ||  (ip[n-2]=='2' &&  (ip[n-1]<'7'))){
            dp[i]+=dp[i-2];
          }
        }
        return dp[n];

    }



    public int countWay(char[] ip,int n){
      if(n==0)
          return 1;
      if (ip[0]=='0' && n==1)
        return 0;

      return getDecodingCountRecursive(ip,n);

    }
    public static void main(String[] args) {
      DecodeDigitSequence obj= new DecodeDigitSequence();

      System.out.println(obj.countWay("1234".toCharArray(),4));

      System.out.println(obj.getDecodingCountDP("121".toCharArray(),3));

    }
}
