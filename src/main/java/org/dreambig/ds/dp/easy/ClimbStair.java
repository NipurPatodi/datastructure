package org.dreambig.ds.dp.easy;

import org.dreambig.ds.picker.IQuestion;

import java.util.Arrays;
import java.util.List;

public class ClimbStair implements IQuestion {
    @Override
    public String getQuestion() {
        return "70. Climbing Stairs\n" +
                "Easy\n" +
                "\n" +
                "8929\n" +
                "\n" +
                "266\n" +
                "\n" +
                "Add to List\n" +
                "\n" +
                "Share\n" +
                "You are climbing a staircase. It takes n steps to reach the top.\n" +
                "\n" +
                "Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?\n" +
                "\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: n = 2\n" +
                "Output: 2\n" +
                "Explanation: There are two ways to climb to the top.\n" +
                "1. 1 step + 1 step\n" +
                "2. 2 steps\n" +
                "Example 2:\n" +
                "\n" +
                "Input: n = 3\n" +
                "Output: 3\n" +
                "Explanation: There are three ways to climb to the top.\n" +
                "1. 1 step + 1 step + 1 step\n" +
                "2. 1 step + 2 steps\n" +
                "3. 2 steps + 1 step\n" +
                "" +
                "find more details @ https://leetcode.com/problems/climbing-stairs/";
    }

    @Override
    public List<String> getCompanies() {
        return Arrays.asList("linked".split(" "));
    }

    @Override
    public String getThingsToRemember() {
        return "dp makes life easy as but you need to understand it";
    }

    private int climbStairRecursive(int i, final int n ){
        if( i>n)
            return 0;
        if( i==n)
            return  1;

        return climbStairRecursive(i+1, n)+climbStairRecursive(i+2, n);
    }
    public  int climbStairRecursive(final int n ){
      return   climbStairRecursive(0,n);
    }

    public  int climbStairRecursiveOptimized(final int n ){
        int [] bt= new  int [n+1];
        return   climbStairRecursiveOpt(0,n, bt);
    }

    public int climbStairRecursiveOpt (int i, final int n, int [] bt ){
        if(i>n)
            return 0;
        if(i==n){
            return 1;
        }
        // if bt is set use it else populate it
        if (bt[i]>0)
            return  bt[i];
        // Setting bt
        bt[i]= climbStairRecursiveOpt(i+1,n , bt)+ climbStairRecursiveOpt(i+2,n , bt);
        return  bt[i];
    }

    public  int climbStair( final  int n){
        int []dp = new int [n+1];

        dp[1]=1;
        dp[2]=2;
        for (int i =3; i<=n ; i++ ){
            dp [i]=dp[i-1]+dp[i-2];
        }
        return  dp[n];
    }




    public static void main(String[] args) {
        ClimbStair obj = new ClimbStair();

        System.out.println(obj.climbStairRecursive(6));
        System.out.println(obj.climbStairRecursiveOptimized(5));
        System.out.println(obj.climbStair(5));
    }

}
