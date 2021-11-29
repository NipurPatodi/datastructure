package org.dreambig.ds.dp.easy;

import org.dreambig.ds.picker.IQuestion;

import java.util.List;

public class EditDistance implements IQuestion {
    @Override
    public String getQuestion() {
        return "Edit Distance | DP-5\n" +
                "Difficulty Level : Medium\n" +
                "Last Updated : 13 Oct, 2021\n" +
                " \n" +
                "Given two strings str1 and str2 and below operations that can performed on str1. Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.  \n" +
                "\n" +
                "Insert\n" +
                "Remove\n" +
                "Replace\n" +
                "All of the above operations are of equal cost. \n" +
                "\n" +
                "Please find more details at https://www.geeksforgeeks.org/edit-distance-dp-5/ ";
    }

    @Override
    public List<String> getCompanies() {
        return null;
    }

    @Override
    public String getThingsToRemember() {
        return " DP Problem";
    }

    /***
     * Recurive Approach
      * @param s1
     * @param s2
     * @param m
     * @param n
     * @return
     */
    int getOpsString (String s1, String s2,int m, int n){

        if(m==0)
            return n;

        if(n==0)
            return m;

        if(s1.charAt(m-1)==s2.charAt(n-1)){
            // there is zero op needed
            return getOpsString(s1, s2,m-1, n-1);
        }
        else{
            return  1+ Math.min(Math.min(getOpsString(s1,s2,m-1,n)// insert on both side
                    ,getOpsString(s1,s2,m,n-1))
                ,getOpsString(s1,s2,m-1,n-1) // replace
            );
        }
    }


    public int getEditDistance_mem_apr(String s1, String s2, int m, int n, int [][]mem){
        if(mem[m][n]==-1){
            if (m==0)
                return n;

            if (n==0)
                return m;

            if( s1.charAt(m-1)==s2.charAt(n-1)){
                mem[m][n]=getEditDistance_mem_apr(s1,s2,m-1,n-1,mem);
            }else{
                mem[m][n]=1+ Math.min(getEditDistance_mem_apr(s1,s2,m-1,n-1,mem),
                        Math.min(getEditDistance_mem_apr(s1,s2,m,n-1,mem),
                                getEditDistance_mem_apr(s1,s2,m-1,n,mem)));
            }

        }
        return mem[m][n];

    }

    public int getEditDistance_tab_apr(String s1, String s2){
        int m=s1.length();
        int n= s2.length();
        int[][] dp= new int[m+1][n+1];

        // Because in any case we need to add and
        // we know if m=0 value is n as so forth.
        for ( int i=0;i<=m;i++)
            dp[i][0]=i;
        for ( int i=0;i<=n;i++)
            dp[0][i]=i;

        for ( int i=1;i<=m;i++){
            for (int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]));
                }

            }
        }
        return dp[m][n];

    }


    private int [][] getCache(int x, int y){
        int [][] mem= new int[x][y];
        for ( int i=0;i<x;i++){
            for (int j=0;j<y;j++){
                mem[i][j]=-1;
            }
        }
        return mem;
    }

    public static void main(String[] args) {
        EditDistance obj = new EditDistance();
        System.out.println( obj.getOpsString("Cat","Cut",3,3));
        String s1="sunday";
        String s2="saturday";

        int [][] mem= obj.getCache(s1.length()+1,s2.length()+1);
        System.out.println(obj.getEditDistance_mem_apr(s1,s2,s1.length(),s2.length(),mem));
        System.out.println(obj.getEditDistance_tab_apr(s1,s2));


        String s3="nipur";
        String s4="neera";
        int [][] mem2= obj.getCache(s3.length()+1,s4.length()+1);
        System.out.println("-----------------");
        System.out.println(obj.getEditDistance_tab_apr(s3,s4));
        System.out.println( obj.getOpsString(s3,s4,s3.length(),s4.length()));
        System.out.println(obj.getEditDistance_mem_apr(s3,s4,s3.length(),s4.length(),mem2));


    }


}
