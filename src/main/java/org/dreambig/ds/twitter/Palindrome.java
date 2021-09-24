package org.dreambig.ds.twitter;

public class Palindrome {


   private static int[] computeLPSArray(String pat) {
       int M = pat.length();
       int[] lps = new int[M ];
       // length of the previous longest prefix suffix
       int len = 0;
       int i = 1;
       lps[0] = 0; // lps[0] is always 0

       // the loop calculates lps[i] for i = 1 to M-1
       while (i < M) {
           if (pat.charAt(i) == pat.charAt(len)) {
               len++;
               lps[i] = len;
               i++;
           } else // (pat[i] != pat[len])
           {
               // This is tricky. Consider the example.
               // AAACAAAA and i = 7. The idea is similar
               // to search step.
               if (len != 0) {
                   len = lps[len - 1];

                   // Also, note that we do not increment
                   // i here
               } else // if (len == 0)
               {
                   lps[i] = len;
                   i++;
               }
           }

       }
       return lps;
   }



  private static  int [] computeLps(String pattern){
  int[] lps = new int[pattern.length()];
  int i=0;
  int j=1;
  lps[0]=0;
  char[]token=pattern.toCharArray();
  while (j< token.length){
    if (token[i]!=token[j] ){
      if(i==0){
        lps[j]=0;
        j++;
      }else{
        i=lps[i-1];
      }
    }
    else { // if both match
      lps[j]=i+1;
      j++;
      i++;
    }

  }
  return lps;
}

public static String convertToPalindrome(String input){
    StringBuilder sb= new StringBuilder(input);
    String payload= sb.toString()+"$"+sb.reverse().toString(); // n
    int [] lps= computeLps(payload);  //n
    int maxPrefix = input.length() - lps[lps.length-1];
    StringBuilder res=new StringBuilder();
    char[]tokens= input.toCharArray();
    for (int i=1; i <=maxPrefix;i++){
      res.append(tokens[tokens.length-i]); //n
    }
    res.append(input);
    return res.toString();
  }

    public static void main(String[] args) {
        int [] res0=computeLps("abbbbba");
        int [] res=computeLPSArray("abbbbba");

        System.out.println(convertToPalindrome("apple"));
    }


 }



