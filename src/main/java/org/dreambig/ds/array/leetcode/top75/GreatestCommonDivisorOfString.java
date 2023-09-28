package org.dreambig.ds.array.leetcode.top75;

/***
 * For two strings s and t, we say "t divides s" if and only if s = t + ... + t (i.e., t is concatenated with itself one or more times).
 *
 * Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
 *
 *
 *
 * Example 1:
 *
 * Input: str1 = "ABCABC", str2 = "ABC"
 * Output: "ABC"
 * Example 2:
 *
 * Input: str1 = "ABABAB", str2 = "ABAB"
 * Output: "AB"
 * Example 3:
 *
 * Input: str1 = "LEET", str2 = "CODE"
 * Output: ""
 *
 * link => https://leetcode.com/problems/greatest-common-divisor-of-strings/?envType=study-plan-v2&envId=leetcode-75
 */
public class GreatestCommonDivisorOfString {
    /**
    this approach is using Euclidean algorithm by subtraction
    link => https://www.geeksforgeeks.org/program-to-find-gcd-or-hcf-of-two-numbers/
    **/
    private int gcd( int a, int b){
      if(a==b)
        return a;
      if(a>b)
          return gcd(a-b, b);
      else
          return gcd(a, b-a);
    }

    /***
      Please note that this is tricky question and need to be revised
    ***/
    public String gcdOfStrings(String str1, String str2) {
      //1.  First we will find if both string are divisible
      if (! (str1+str2).equals(str2+str1))
          return "";
      //2. Lets find GSD of length
      int gcd = gcd( str1.length(), str2.length());
      return str1.substring(0,gcd);

    }

    public static void main(String [] args){
      String a= "abababab";
      String b = "abab";
      GreatestCommonDivisorOfString ins= new GreatestCommonDivisorOfString();
      System.out.println(ins.gcdOfStrings(a,b));
    }
}
