package org.dreambig.ds.dp.easy;

import org.dreambig.ds.picker.IQuestion;

import java.util.List;

public class CoinToss implements IQuestion {
    @Override
    public String getQuestion() {
        return "Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change? The order of coins doesn’t matter.\n" +
                "For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4. For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5." +
                "Please find more details at https://www.geeksforgeeks.org/coin-change-dp-7/";
    }

    @Override
    public List<String> getCompanies() {
        return null;
    }

    @Override
    public String getThingsToRemember() {
        return "DP Problem";
    }

    public int getCoinToss(int [] coin,  int n, int sum){
        // we have one way to get sum ==0 which is return no coin
        if(sum==0) return 1;
        if(n==0) return 0;
        int res = getCoinToss(coin,n-1,sum); // excluding current coin
        if( coin[n-1]<=sum){
            res=res+getCoinToss(coin,n,sum-coin[n-1]); // including current coin
        }
        return  res;
    }

    public int getCoinTossMemorized(int [] coin,  int n, int sum, int[][]mem){

        if(mem[n][sum]==-1) {
            // we have one way to get sum ==0 which is return no coin

            if (sum == 0) return 1;
            if (n == 0) return 0;
            mem[n][sum] = getCoinTossMemorized(coin, n - 1, sum,mem); // excluding current coin
            if (coin[n - 1] <= sum) {
                mem[n][sum] = mem[n][sum] + getCoinTossMemorized(coin, n, sum - coin[n - 1],mem); // including current coin
            }

        }
        return  mem[n][sum];
    }

    public int getCoinToss_TabApr(int []coin, int sum) {
        int n = coin.length;

        int[][] cache = new int[n + 1][sum + 1];
        // so please note that this is count of coin toss
        // not sum

        // So number of ways  to set sum =0 is one (i.e. no coin)
        for (int i = 0; i <= n; i++) {
            cache[i][0] = 1;
        }
        //number of ways to get sum x with coin 0 is zero always
        for (int j = 0; j <= sum; j++) {
            cache[0][j] = 0;
        }

        // Now iterating on all possible case
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                cache[i][j] = cache[i - 1][j]; //excluding current coin
                if (coin[i - 1] <= j) {
                    cache[i][j] += cache[i][j - coin[i - 1]]; // include coin but reduce sum
                }
            }
        }
        return cache[n][sum];
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

    public static void main(String[] args) {
        int [] coins= {2,5,3,6};
        int sum =10;
        CoinToss obj= new CoinToss();
        System.out.println(obj.getCoinToss(coins,coins.length,sum));

        int [] coins2= {1,2,3};
        int sum2 =4;
        int [][]mem= obj.getcache(coins2.length+1,sum2+1);
        System.out.println(obj.getCoinTossMemorized(coins2,coins2.length,sum2,mem));

        System.out.println(obj.getCoinToss_TabApr(coins,sum));
        System.out.println(obj.getCoinToss_TabApr(coins2,sum2));
    }

}
