package org.dreambig.ds.array.medium;

import org.dreambig.ds.picker.IQuestion;

import java.util.List;

public class MaxNKSum implements IQuestion {

    public int maxOper(int [] nums, int k, int res){
        if (nums.length <2)
            return res;
        int [] na= new int [nums.length-2];
        int base = nums[0];
        int i=1;
        int j=0;
        boolean match=false;
        while(i<nums.length)
        {
            if(!match){
                boolean tmatch = nums[i]== k-base;
                if(tmatch){
                    match=true;
                   res++;
                   i++;
                   continue;
                }else{
                    na[j]=nums[i];
                    j++;
                    i++;
                }

            }
            na[j]=nums[i];
            j++;
            i++;


        }
        if (match)
            return maxOper(na, k, res);
        else
            return res;
    }


    public int maxOperations(int[] nums, int k) {
        return maxOper(nums, k ,0);
    }

    public static void main(String[] args) {
        MaxNKSum m = new MaxNKSum();
        int [] ip ={3,1,3,4,3};
        System.out.println(m.maxOperations(ip,6));
    }

    @Override
    public String getQuestion() {
        return "You are given an integer array nums and an integer k.\n" +
                "\n" +
                "In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.\n" +
                "\n" +
                "Return the maximum number of operations you can perform on the array.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: nums = [1,2,3,4], k = 5\n" +
                "Output: 2\n" +
                "Explanation: Starting with nums = [1,2,3,4]:\n" +
                "- Remove numbers 1 and 4, then nums = [2,3]\n" +
                "- Remove numbers 2 and 3, then nums = []\n" +
                "There are no more pairs that sum up to 5, hence a total of 2 operations.\n" +
                "Example 2:\n" +
                "\n" +
                "Input: nums = [3,1,3,4,3], k = 6\n" +
                "Output: 1\n" +
                "Explanation: Starting with nums = [3,1,3,4,3]:\n" +
                "- Remove the first two 3's, then nums = [1,4,3]\n" +
                "There are no more pairs that sum up to 6, hence a total of 1 operation.";
    }

    @Override
    public List<String> getCompanies() {
        return null;
    }

    @Override
    public String getThingsToRemember() {
        return null;
    }
}
