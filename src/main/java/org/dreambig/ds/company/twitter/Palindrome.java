package org.dreambig.ds.company.twitter;

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
  int[] lps = new int[pattern.length()];  //LPS array is alway equal to pattern


  int i=0;
  int j=1;

  lps[0]=0; // zero is always zero
  char[]token=pattern.toCharArray(); // String to array

  while (j< token.length){
    if (token[i]!=token[j] ){ // if previous and current are not same
      if(i==0){ // if prev was zero , make current zero and increment
        lps[j]=0;
        j++;
      }else{
        i=lps[i-1]; // else move previous to lps[i-1] //
          // this is tricky , now  j is not incremented
          // Please note that lps idx variable is not j but i
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
    String payload= sb.toString()+"$"+sb.reverse().toString(); // appending String to itself with delimiter
    int [] lps= computeLps(payload);  // lps of this string
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



