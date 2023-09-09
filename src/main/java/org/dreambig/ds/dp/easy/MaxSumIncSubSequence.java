package org.dreambig.ds.dp.easy;

import org.dreambig.ds.picker.IQuestion;

import java.util.List;

public class MaxSumIncSubSequence implements IQuestion {
    @Override
    public String getQuestion() {
        return "WAP to find max increasing subsequence of array " +
                "Please find more details at https://practice.geeksforgeeks.org/tracks/DSASP-DP/?batchId=154&tab=1 ";
    }

    @Override
    public List<String> getCompanies() {
        return null;
    }

    @Override
    public String getThingsToRemember() {
        return null;
    }

    int getMaxSumOfLst(int [] nums){
        int [] lis=new int [nums.length];
        lis[0]=nums[0];
        for (int i=1;i<nums.length;i++){
            int maxSum=Integer.MIN_VALUE;
            for (int j=i-1;j>=0;j--){
                if(nums[j]<=nums[i]){
                    maxSum=Math.max(lis[j],maxSum );
                }
            }
            lis[i]=nums[i]+maxSum;
        }
        int maxSum=Integer.MIN_VALUE;
        for (int li : lis) {
            maxSum = Math.max(maxSum, li);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] ip={3,20,4,6,7,30};
        MaxSumIncSubSequence obj = new MaxSumIncSubSequence();
        System.out.println(obj.getMaxSumOfLst(ip));
        int []ip22={500,10,20};
        System.out.println(obj.getMaxSumOfLst(ip22));

    }

}
