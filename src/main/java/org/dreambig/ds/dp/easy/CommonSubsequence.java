package org.dreambig.ds.dp.easy;

import org.dreambig.ds.picker.IQuestion;

import java.util.List;

public class CommonSubsequence implements IQuestion {
    @Override
    public String getQuestion() {
        return "Find Largest Common Subsequence of two String";
    }

    @Override
    public List<String> getCompanies() {
        return null;
    }

    @Override
    public String getThingsToRemember() {
        return null;
    }

    // We will start from last and keep matching until we reach zero
    public int getLCS (String s1, String s2, int m, int n){
        if(m==-1|| n==-1)
            return  0;

        if(s1.charAt(m)==s2.charAt(n)){
            return 1+ getLCS(s1,s2, m-1, n-1);
        }else
        {
            return Math.max( getLCS(s1,s2,m-1,n ),getLCS(s1,s2,m,n-1 ));
        }

    }

    // DP Approach

    // We will start from last and keep matching until we reach zero
    public int getLCSbyMemoization(String s1, String s2, int m, int n, int [][]mem){
        if (m == -1 || n == -1)
            return 0;

        if(mem[m][n]==-1) {

            if (s1.charAt(m) == s2.charAt(n)) {
                mem[m][n]= 1 + getLCS(s1, s2, m - 1, n - 1);
            } else {
                mem[m][n]= Math.max(getLCSbyMemoization(s1, s2, m - 1, n,mem), getLCSbyMemoization(s1, s2, m, n - 1,mem));
            }
        }
        return  mem[m][n];
    }

    public int getLCSbyTabulation(String s1, String s2){
        int m=s1.length();
        int n=s2.length();
        int [][] tab= new int [m+1][n+1];

        // Please note that index i,j is not idx of string
        // but in fact max common sub string till i length of s1 and j length of s2
        // so if one idx is 0 max substring should be zero for sure

        for ( int i=0;i<=n;i++ ){
            tab[0][i]=0;
        }
        // similarly
        for ( int i=0;i<=m;i++ ){
            tab[i][0]=0;
        }
       for ( int i=1;i<=m;i++){
           for(int j=1;j<=n;j++) {
               if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                   tab[i][j] = 1 + tab[i - 1][j - 1];

               } else {
                   tab[i][j] = Math.max(tab[i][j - 1], tab[i - 1][j]);
               }
           }
       }


    return tab[m][n];
    }



    private int [][] getcache(int x, int y){
        int [][] mem= new int[x][y];
        for ( int i=0;i<x;i++){
            for (int j=0;j<y;j++){
                mem[i][j]=-1;
            }
        }
        return mem;
    }

    int getMaxSubSequence( String s1, String s2, int m ,int n, int[][] cache){
        // We will iterate on reverse order
        // Base condition
        if(m==-1||n==-1){
            return 0;
        }

        if(cache[m][n]==-1){ // not precomputed
            if(s1.charAt(m)==s2.charAt(n))
                cache[m][n]=1+getMaxSubSequence(s1,s2,m-1,n-1,cache);
            else // we will iterate on all possible and find max
                cache[m][n]=Math.max(getMaxSubSequence(s1,s2,m,n-1,cache),getMaxSubSequence(s1,s2,m-1,n,cache));
        }
        return cache[m][n];
    }

    int getMaxSubSequence( String s1, String s2){
        // Remember that this is bottom up solution which means we need to reconstruct  for smallest
        // Please not m and n are not index but length
        int m=s1.length(), n=s2.length();
        int [][] cache = new int[m+1][n+1];// we take addition size because we want to consider empty string also
        for (int i=0;i<=m;i++)
            cache[i][0]=0; // fill last column

        for (int i=0;i<=n;i++)
            cache[0][i]=0; // fill last row

        for  (int i=1; i<=m;i++){
            for(int j=1;j<=n;j++){
                if (s1.charAt(i-1)==s1.charAt(j-1)){
                    cache[i][j] =1+cache[i-1][j-1];
                }else{
                    cache[i][j] = Math.max(cache[i][j-1], cache[i-1][j]);
                }
            }
        }
        return cache[m][n];
    }

    public static void main(String[] args) {
        CommonSubsequence obj = new CommonSubsequence();
        String s1="ABCDGH",s2="AEDFH";
        //System.out.println(obj.getLCS(s1,s2,s1.length()-1,s2.length()-1));
        int[][] mem= obj.getcache(s1.length()+1,s2.length()+1);
        System.out.println(obj.getMaxSubSequence(s1,s2));
        //System.out.println(obj.getMaxSubSequence(s1,s2,s1.length()-1,s2.length()-1,mem));
        //System.out.println(obj.getLCSbyMemoization(s1,s2,s1.length()-1,s2.length()-1,mem));

        //System.out.println(obj.getLCSbyTabulation("nipur","Nira"));
        //System.out.println(obj.getLCSbyTabulation("ritu","moksh"));
    }
}
