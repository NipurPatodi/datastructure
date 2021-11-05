package org.dreambig.ds.bst.practice.easy;

import org.dreambig.ds.picker.IQuestion;

import java.util.Arrays;
import java.util.List;

public class ArrangeCoin implements IQuestion {
    @Override
    public String getQuestion() {
        return "441. Arranging Coins\n" +
                "Easy\n" +
                "\n" +
                "1629\n" +
                "\n" +
                "928\n" +
                "\n" +
                "Add to List\n" +
                "\n" +
                "Share\n" +
                "You have n coins and you want to build a staircase with these coins. The staircase consists of k rows where the ith row has exactly i coins. The last row of the staircase may be incomplete.\n" +
                "\n" +
                "Given the integer n, return the number of complete rows of the staircase you will build.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "\n" +
                "Input: n = 5\n" +
                "Output: 2\n" +
                "Explanation: Because the 3rd row is incomplete, we return 2.\n" +
                "Please find more details at https://leetcode.com/problems/arranging-coins/";
    }

    @Override
    public List<String> getCompanies() {
        return Arrays.asList("linkedin".split(" "));
    }

    @Override
    public String getThingsToRemember() {
        return "n(n+1) is king with binary search";
    }

    public int arrangeCoins(int n) {
        int l=0, r=n;
        int mid=0,sum;
        while (l<=r){ // this is trick
            mid=l+(r-l)/2; // to prevent over flow
             sum= mid*(mid+1)/2;
            if(sum==n) return  mid;

            if( sum>n)
                r=mid-1;
            else
                l=mid+1;
        }
        return mid;
    }

    public static void main(String[] args) {
        ArrangeCoin ac= new ArrangeCoin();
        System.out.println(ac.arrangeCoins(9));
    }
}
