package org.dreambig.ds.string.practice.medium;

import org.dreambig.ds.picker.IQuestion;

import java.util.Arrays;
import java.util.List;

public class LongestCommonSub implements IQuestion {
    @Override
    public String getQuestion(){
        return "WAP to find longest common SubSequnce Examples: \n" +
                "LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3. \n" +
                "LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4. \n" +
                "\n";
    }
    @Override
    public List<String> getCompanies() {
        String []c=" Amazon Hike".split(" ");
        return Arrays.asList(c);
    }

    @Override
    public String getThingsToRemember() {
        return "Very Important problem based on DP and memorization... Must be revisited";
    }


    public int computeLongestSubseq(String a, String b){
        int n= a.length();
        int m=b.length();
        // We would use use memorization and DP
        // 1. create matrix to hold result
        int [][] tab=new int[n+1][m+1];

         for (int i=0;i<=n;i++){
             for (int j=0;j<=m;j++){

                 //2. if any of this is idx 0 , its value should be zero
                 if(i==0 || j==0){
                     tab[i][j]=0;
                 }
                 //3. if char at i == j pick diagonal and add
                 else if(a.charAt(i-1)==b.charAt(j-1)){
                     tab[i][j]=1+tab[i-1][j-1];
                 }
                 //else pick max from left or up
                 else{
                     tab[i][j]=Math.max(tab[i-1][j],tab[i][j-1]);

                 }

             }
         }

         return tab[n][m];
    }


    public static void main(String[] args) {
        String a="AGGTAB";
        String b="GXTXAYB";
        LongestCommonSub lcs= new LongestCommonSub();
        System.out.println(lcs.computeLongestSubseq(a,b));
    }

}
