package org.dreambig.ds.string.learning.tricky.hard;
/***
WAP to find Lexographic Rank of String if orderes in sorted Way
ip=BAC
op=3
explaination
ABC
ACB
BAC <- 3 position
BCA
CAB
CBA

*/
public class LexoGrapicRank{
// Idea is to find all factorial of char on right which are smaller than
// current and  add +1 to
//  B -1*2!
// A ->1*0!
// 1*2+1*0 =2
// Res = 2+1 =3
//*******************************
// WAP to find value in N time complexity

  private static int  factorial(int ip){
    int res=1;
    while (ip >1){
      res*=ip;
      ip--;
    }
    return res;
  }

    /***
     *  Solution when string contains distinct element
     * @param ip: String input
     * @return position in sorted sequence
     * Please watch https://practice.geeksforgeeks.org/tracks/DSASP-Strings/?batchId=154  in case of confusion
     */
  public static int calculateLexRank(String ip){
   int res=0;
   // Step 1 : Calculate Factorial of ip.length
    int fact= factorial(ip.length());
    // Step 2: Mark String found in fix size array
    int [] tkns= new int [256];
    for ( char c:ip.toCharArray()){
      tkns[c]++;
    }

    //Step 3. Find cumulative sum of each
    for ( int i=1; i<256;i++){
        tkns[i]+=tkns[i-1];
    }
    int f=factorial(ip.length());

    //step 4. Most Tricky part
    for ( int i=0; i<ip.length();i++){
        f=f/(ip.length()-i); // Updating factorial by dividing largest number
        res=res+ tkns[ip.charAt(i)-1]*f; //get the last token idx value and multiply it by factorial
        // Reducing left out
        for (int j=ip.charAt(i);j<256;j++){ // reduce every thing by 1 since this was cumulative sum array
            tkns[j]--;
        }
    }

  return  res +1 ;
  }


    public static void main(String[] args) {
        System.out.println(calculateLexRank("STRING"));
    }




}
