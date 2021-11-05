package org.dreambig.ds.string.practice.tricky;

import org.dreambig.ds.picker.IQuestion;

import java.util.List;

public class EditDistance implements IQuestion {
    @Override
    public String getQuestion() {
        return "Given two strings s and t. Return the minimum number of operations required to convert s to t.\n" +
                "The possible operations are permitted:\n" +
                "\n" +
                "Insert a character at any position of the string.\n" +
                "Remove any character from the string.\n" +
                "Replace any character from the string with any other character.\n" +
                "Please find more details at https://www.geeksforgeeks.org/edit-distance-dp-5/";
    }

    @Override
    public List<String> getCompanies() {
        return null;
    }

    @Override
    public String getThingsToRemember() {
        return "Please note that its DP Problem and can be achieve in similar fashion as other DP";
    }


    public int computeEditDistanceOptimized( String a, String b){
        // Since we alway use n-1 row to compute n row we dont need m*n matrix
        // we can achieve it by 2 d array
        // Please not length is of A not be
        int dp[][]= new int [2][a.length()+1];

        for ( int i=1;i<=b.length();i++){ // tricky Loop
            for (int j=0; j<=a.length();j++){ // Tricky Loop
                if(j==0)
                    dp[i%2][j]=i;
                else if( a.charAt(j-1)==b.charAt(i-1)){
                    dp[i%2][j]=dp[(i-1)%2][j-1];
                }
                else{
                    dp[i%2][j]=1+ Math.min(dp[i%2][j-1],
                            Math.min(dp[(i-1)%2][j],
                                    dp[(i-1)%2][j-1])
                            );
                }
            }
        }
        return dp[b.length()%2][a.length()];


    }



    public int computeEditDistance(String a, String b){
    // First create DP matrix for Strings with size +1
    int [][] dp= new int [a.length()+1][b.length()+1];
  ;

        //Now filling valued iteratively
        // Thump rule is as follows
        // #1 if new == prev match


        for ( int i=0;i<=a.length();i++){
            for (int j=0;j<=b.length();j++){
                if(j==0)
                    dp[i][j]=i;
                else if (i==0)
                    dp[i][j]=j;
                else if(a.charAt(i-1)==b.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=1+Math.min(dp[i-1][i], //Remove
                            Math.min(dp[i][j-1], //insert
                                    dp[i-1][j-1] // update
                            ));

                }
            }
        }
        return dp[a.length()][b.length()];
    }

    public static void main(String[] args) {
        EditDistance ed= new EditDistance();
        System.out.println(ed.computeEditDistance("sunday","saturday"));
        System.out.println(ed.computeEditDistanceOptimized("sunday","saturday"));
    }


}
