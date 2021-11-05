package org.dreambig.ds.array.medium;

import org.dreambig.ds.picker.IQuestion;

import java.util.Arrays;
import java.util.List;

public class TopLeftBottomRight implements IQuestion {
    @Override
    public String getQuestion() {
        return "Count all possible paths from top left to bottom right of a mXn matrix\n" +
                "Difficulty Level : Easy\n" +
                "Last Updated : 24 Aug, 2021\n" +
                "The problem is to count all the possible paths from top left to bottom right of a mXn matrix with the constraints that from each cell you can either move only to right or down\n" +
                "Examples : \n" +
                " \n" +
                "\n" +
                "Input :  m = 2, n = 2;\n" +
                "Output : 2\n" +
                "There are two paths\n" +
                "(0, 0) -> (0, 1) -> (1, 1)\n" +
                "(0, 0) -> (1, 0) -> (1, 1)\n" +
                "\n" +
                "Input :  m = 2, n = 3;\n" +
                "Output : 3\n" +
                "There are three paths\n" +
                "(0, 0) -> (0, 1) -> (0, 2) -> (1, 2)\n" +
                "(0, 0) -> (0, 1) -> (1, 1) -> (1, 2)\n" +
                "(0, 0) -> (1, 0) -> (1, 1) -> (1, 2)" +
                "Please find more detail at https://www.geeksforgeeks.org/count-possible-paths-top-left-bottom-right-nxm-matrix/";
    }

    @Override
    public List<String> getCompanies() {
        return Arrays.asList("linkedin.md".split(" "));
    }

    @Override
    public String getThingsToRemember() {
        return "It is very easy by DP but works well with recursion";
    }

    public int getPossiblePathRecursive( int n,  int m){

            if(m==1 ||n==1) // trick is increment is any of them is 1
                return 1;

        return  getPossiblePathRecursive(n,m-1)+ getPossiblePathRecursive(n-1,m);
    }

    public  int getPossiblePathDp(int n, int m){
        int[][] dp=new int[m][n];

        for (int i=0;i<m;i++) // fill all edged with one
            dp[i][0]=1;
        for (int i=0;i<n;i++)
            dp[0][i]=1;

        for ( int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    public int getPossiblePathMath(int m, int n){
        /*
        There exist mathematical approach to solve this
        m+n-2 C n-1= (m+n-2) !/ (n-1)!(m-1)!
        */
        int path = 1;
        for (int i = n; i < (m + n - 1); i++) {
            path *= i;
            path /= (i - n + 1);
        }
        return path;

    }

    public static void main(String[] args) {
        TopLeftBottomRight obj = new TopLeftBottomRight();
        System.out.println(obj.getPossiblePathRecursive(3,2));
        System.out.println(obj.getPossiblePathDp(2,2));
        System.out.println(obj.getPossiblePathMath(3,2));

    }

}
