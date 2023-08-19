package org.dreambig.ds.array.medium;

import org.dreambig.ds.picker.IQuestion;

import java.util.List;

public class FindProductExceptSelf implements IQuestion {
    @Override
    public String getQuestion() {
        return "238. Product of Array Except Self\n" +
                "Medium\n" +
                "19.2K\n" +
                "1.1K\n" +
                "company\n" +
                "Amazon\n" +
                "company\n" +
                "Apple\n" +
                "company\n" +
                "Bloomberg\n" +
                "Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].\n" +
                "\n" +
                "The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.\n" +
                "\n" +
                "You must write an algorithm that runs in O(n) time and without using the division operation.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: nums = [1,2,3,4]\n" +
                "Output: [24,12,8,6]\n" +
                "Example 2:\n" +
                "\n" +
                "Input: nums = [-1,1,0,-3,3]\n" +
                "Output: [0,0,9,0,0]";
    }

    @Override
    public List<String> getCompanies() {
        return null;
    }

    @Override
    public String getThingsToRemember() {
        return null;
    }

    static public int[] findProductExceptSelf(int[] arr){
        int [] ans = new int [arr.length];
        int prod =1;
        for (int i=0; i<arr.length;i++){
            if (i==0)
                ans[i]= prod;
            else
                ans[i]=prod*arr[i-1];
            prod=ans[i];
        }
        prod=1;
        for (int j=arr.length-1 ; j >=0;j--){
            if (j==arr.length-1)
                ans[j]=ans[j]*prod;
            else
                prod= prod*arr[j+1];
                ans[j]=ans[j]*prod;

        }
        return ans;
    }


    public static void main(String[] args) {
        int [] ip= {1,2,3,4};
        int[] res= findProductExceptSelf(ip);
        for (int r :res){
            System.out.print(r);
            System.out.print(" ");
        }
    }
}
